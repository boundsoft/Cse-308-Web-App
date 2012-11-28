/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.managedbeans;

import boundless.ejb.*;
import boundless.scheduler.*;
import java.util.*;
import boundless.entities.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.ejb.*;

/**
 * Manages a draft for a single League
 * @author hendrikdekock
 */
@Named("draft")
@ManagedBean
@RequestScoped
public class DraftBean {
    
    @EJB
    RequestBean dbAccess;
    
    League leagueToDraft;
    
    /**
     * Creates a new instance of DraftBean
     */
    public DraftBean(League l) {
        leagueToDraft = l;
    }
    
    

    /**
     * Searches for a player with a name matching the key.  For now, only works given the player's exact name
     * @param key : Search Key 
     * @return : The list of players whose name matches the key.  Usually only one
     */
    public List<Player> searchPlayer(String key) {
        return dbAccess.getPlayerByName(key);
        
    }
    
    /**
     * Searches for a player with a particular role whose name matches the key.  For now only works given the player's exact name
     * @param key : Search key
     * @param r : The role to search
     * @return : The list of players whose name matches the key.  Usually only one.
     */
    public List<Player> searchPlayer(String key, PlayPosition r) {
        return dbAccess.getPlayerByNameAndPosition(key, r);
    }
    
    /**
     * Assigns an individual player entity to an individual team entity  Called only to make post-assignment edits.
     * Should not for now be accessible from Facelets
     * @param p : The player to assign
     * @param t : The team to assign them to
     */
    public void assignPlayer(Player p, Team t, short active) {
        dbAccess.assignPlayerToTeam(p, t, leagueToDraft, active);
        
    }
    
    /**
     * Assigns all players in the draft form to a given team.  Called once to draft a team.
     * @param plist
     * @param t 
     */
    public void assignTeam(List<Player> activePlayerList, List<Player> benchedPlayerList, Team t) {
        for (int i = 0; i < activePlayerList.size(); i++) {
            dbAccess.assignPlayerToTeam(activePlayerList.get(i), t, leagueToDraft, (short) 1);
        }
        for (int i = 0; i < benchedPlayerList.size(); i++) {
            dbAccess.assignPlayerToTeam(benchedPlayerList.get(i), t, leagueToDraft, (short) 0);
        }
    }
    
    /**
     * Validates that a team follows all NFL roster rules.  If it returns true, the team can then be assigned.
     * Any further changes in team composition requires another validation.  Note that numbers don't have to be
     * evaluated because they are enforced at the Facelet level, so we only need to check for double-assigned players.
     * @param plist
     * @param t 
     */
    public boolean validateTeam(List<Player> playerList,  Team t) {
        //Ensure that no two players are the same, both within the Team and the league
        HashMap<String, Player> names = new HashMap<String, Player>();
        //HashMap<Integer, Integer> positionCounts = new HashMap<Integer, Integer>();
        for (int i = 0; i < playerList.size(); i++) {
            Player curPlayer = playerList.get(i);
            if (names.containsValue(curPlayer)) {
                return false;
            }
            if (dbAccess.isPlayerAssignedToLeague(curPlayer, leagueToDraft)) {
                return false;
            }
            
            /*int curPosId = curPlayer.getPlayPosition();
            if (positionCounts.containsKey(curPosId)) {
                positionCounts.put(curPosId, positionCounts.get(curPosId) + 1);
            }
            else {
                 positionCounts.put(curPosId, 1);
            }*/
        }
        return true;
        /*for (int i = 0; i < benchedPlayerList.size(); i++) {
            Player curPlayer = benchedPlayerList.get(i);
            if (names.containsValue(curPlayer)) {
                return false;
            }
            if (dbAccess.isPlayerAssignedToLeague(curPlayer, leagueToDraft)) {
                return false;
            }
        }*/
        
        
    }
    
    /**
     * Called when all teams are drafted.  Creates a schedule for the league
     */
    public void createSchedule() {
        /*
         * Formla for Double Round robin:
         * Give teams numbers.  
         * For first round, assign team 1 to team 2.
         * For each unassigned team, find the lowest team number to which they have not yet fought.  
         * That will be teh assignement for that week.
         * Double at end.
         */
        List<Team> allTeams = dbAccess.getAllTeamsInLeague(leagueToDraft);
        Scheduler s = new Scheduler(dbAccess.getNumTeamsInLeague(leagueToDraft));
        HashMap<Pair, Integer> schedule = s.createSchedule();
        HashMap<Integer, ArrayList<TeamPair>> completedSchedule = new HashMap<Integer, ArrayList<TeamPair>>();
        Set<Pair> schedules = schedule.keySet();    
        for (Pair p : schedules) {
            //Reverse the relationship of the map to make it easier on the DB accessor
            int week = schedule.get(p);
            TeamPair weeksPair = new TeamPair(allTeams.get(p.first()), allTeams.get(p.second()));
            if(!completedSchedule.containsKey(week)) {
                completedSchedule.put(week, new ArrayList<TeamPair>());
            }
            completedSchedule.get(week).add(weeksPair);
            
        }
        dbAccess.makeSchedule(leagueToDraft, completedSchedule);
  
        
    }    
}
