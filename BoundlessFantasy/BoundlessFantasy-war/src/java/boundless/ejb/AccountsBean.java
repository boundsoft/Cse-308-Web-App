/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.ejb;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author hendrikdekock
 */
@Singleton
@LocalBean
public class AccountsBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

        /*
         * Queries the database for the given username and password combination for a match.
         *  @username: Username
         *  @password: The password to query
         */
       void login(String username, String password) {
          
       }
       
       
       /* Logs out a given user
        * @userid: The integer user id
        */
       void logout(int userid) {
       }
       
       
    
}
