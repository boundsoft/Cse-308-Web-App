/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.managedbeans;

import boundless.ejb;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 * Manages a draft for a single League
 * @author hendrikdekock
 */
@Named("draft")
@ManagedBean
@SessionScoped
public class DraftBean {
    
    League leagueToDraft;
    
    /**
     * Creates a new instance of DraftBean
     */
    public DraftBean() {
    }
    
    
    /**
     * Searches for a player with a name matching the key
     * @param key : Search Key 
     */
    public void searchPlayer(String key) {
        
    }
    
    /**
     * Searches for a player with a particular role whose name matches the key
     * @param key : Search key
     * @param r : The role to search
     */
    public void searchPlayer(String key, Role r) {
        
        
    }
    
    /**
     * Assigns an individual player entity to an individual team entity  Called only to make post-assignment edits.
     * @param p : The player to assign
     * @param t : The team to assign them to
     */
    public void assignPlayer(Player p, Team t) {
        
        
    }
    
    /**
     * Assigns all players in the draft form to a given team.  Called once to draft a team.
     * @param plist
     * @param t 
     */
    public void assignTeam(List<Player> plist, Team t) {
        
    }
    
    /**
     * Called when all teams are drafted.  Creates a schedule for the league
     */
    public void createSchedule() {
        
    }    
}
