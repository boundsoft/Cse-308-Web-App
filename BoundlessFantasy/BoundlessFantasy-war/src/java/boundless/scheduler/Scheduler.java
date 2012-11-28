/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.scheduler;

import java.util.*;

/**
 * Removed this class from the main draft bean because it acts much more abstractly, working only with numbers
 * NOTE: Week's are 1-indexed, teams are 0-indexed
 * @author hendrikdekock
 */
public class Scheduler {
   HashMap<Pair, Integer> scheduledGames;

   int numTeams;
   /**
    * Creates a new scheduler
    * @param num : The number of teams to schedule.
    */
   public Scheduler(int num) {
       scheduledGames = new HashMap<Pair, Integer>();
       numTeams = num;
   }
   
   /**
    * Creates and returns a new double round robin schedule for the selected number of teams
    * @return 
    */
   public HashMap<Pair, Integer> createSchedule() {
       for (int i = 1; i < numTeams; i++) {
           scheduleWeek(i);
       }
       return scheduledGames;
   }
   
   private void scheduleWeek(int w) {
       System.out.println("Scheduling week " + w);
       boolean[] scheduled = new boolean[numTeams];
       for (int i = 0; i < scheduled.length; i++) {
           if (!scheduled[i]) {
               System.out.println("Scheduling team " + i);
               int otherTeam = findLowestUnassigned(i, scheduled);
               if (scheduledGames.put(new Pair(i, otherTeam), w) != null)
                   throw new RuntimeException("Double value!");
               scheduled[i] = true;
               scheduled[otherTeam] = true;
           }
       }
   }
   
   /**
    * Finds the lowest index to which the current index has yet to be defined.
    * Author's note: We can brute force this, as you'll never have more than 20 indices in the first place
    * @param myTeam : The index of my team
    * @return : The lowest index to which this index has yet to be assigned; -1 on some bizarre failure.
    */
   private int findLowestUnassigned(int myTeam, boolean[] isScheduled) {
       for (int i = 0; i < numTeams; i++) {
           System.out.println("Matching up team " + myTeam + " against " + i);
           if (i != myTeam && !isScheduled[i]) {
               if(!scheduledGames.containsKey(new Pair(myTeam, i))) {
                   return i;
               }
           }
       }
       return -1;
   }

   
}
