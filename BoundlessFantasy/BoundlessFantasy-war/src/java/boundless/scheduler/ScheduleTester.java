/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.scheduler;

import java.util.*;
/**
 *
 * @author hendrikdekock
 */
public class ScheduleTester {
    
    public static void main(String[] args) {
        Scheduler st = new Scheduler(8);
        HashMap<Pair, Integer> theGames = st.createSchedule();
        Set<Pair> schedules = theGames.keySet();
        for (Pair p : schedules) {
            int week = theGames.get(p);
            System.out.println("Game " + p + " on week " + week);
        }
    }
    
}
