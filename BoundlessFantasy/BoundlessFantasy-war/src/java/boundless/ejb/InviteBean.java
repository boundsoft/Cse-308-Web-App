/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.ejb;

import boundless.entities.*;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *  Single gateway through which all invitation operations pass through
 * @author hendrikdekock
 */
@Singleton
@LocalBean
public class InviteBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /**
     * Respond to an invitation to join a league
     * @param sender : The user who sent the invitation
     * @param league : The league the invitation is to
     * @param accept : Whether an invitaiton is accepted or rejected
     */
    public void respondToInvite(Account sender, League league, boolean accept) {
        
    }
    
    /**
     * Cancels an invitation that was sent via email which has not been responded to
     * @param sender : The user who sent the invitation.
     * @param email : The email to which the invitaion was sent.
     * @param league : The league to which the email address owner was invited
     */
    public void cancelEmailInvite(Account sender, String email, League league) {
        
    }
    
    /**
     * Cancels an unanswered invitation
     * @param sender : The user who sent the invitation
     * @param invitee : The invited user
     * @param league  : The league to which they were invited
     */
    public void cancelUserInvite(Account sender, Account invitee, League league) {
        
    }
    
    /**
     * Sends an invitation to a league via email
     * @param sender : The user who sends the invitation
     * @param email : The email to send it to
     * @param league : The league to invite the email address to
     */
    public void inviteEmail(Account sender, String email, League league) {
        
    }
    
    /**
     * Sends an invitation to a league via User Entity
     * @param sender : The sender of the invitation
     * @param invitee : The user who is invited
     * @param league  : The league they are invited to
     */
    public void inviteUser(Account sender, Account invitee, League league) {
        
    }
}
