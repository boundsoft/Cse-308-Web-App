/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.ejb;

import javax.ejb.Stateful;
import javax.ejb.LocalBean;

/**
 * Represents a single user's session in Boundless Fantasy.  Calls methods for its given user.
 * @author hendrikdekock
 */
@Stateful
@LocalBean
public class NavigationBean {

    User curuser;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    /*
     * Calls the logout method for this NavigationBean's current user
     */
    public void logout() {
        
    }

}
