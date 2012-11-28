/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.managedbeans;

import boundless.entities.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
/**
 *Used to access League editing operations
 * @author hendrikdekock
 */
@Named("League")
@ManagedBean
@SessionScoped
public class LeagueBean {

    boolean inviteOnly;
    
    /**
     * Creates a new instance of LeagueBean
     */
    public LeagueBean() {
    }
    
    /**
     * Sends a notification to the user that they must create a team in this league
     * @param u : The user to accept.
     */
    public void acceptJoinRequest(User u) {
        
    }
    
    /**
     * Removes a request from User u to join this league from the table
     * @param u : The user to decline
     */
    public void declineJoinRequest(User u) {
        
    }
    
    /**
     * Invites the person with the given email address.  If an account with that email exists,
     * that account is invited, otherwise an email is sent to the address with an invitation to join
     * Boundless Fantasy
     * @param email : The email address of the user to invite
     */
    public void inviteByEmail(String email) {
    
    }
    

    /**
     * Invites a user with an account given its account entity.
     * @param u : The user to send an invitation to
     */
    public void inviteByAccout(User u) {
        
    }
    
    /*Begins the Draft.
     * First checks to ensure the preconditions for beginning a draft have been met.  Opens the draft facelet
     */
    public void beginDraft() {
        
    }
    
    /**
     * Changes the permissions of the league--whether it is private or public to the opposite of what it is
     */
    public void togglePermissions() {
        
    }
}
