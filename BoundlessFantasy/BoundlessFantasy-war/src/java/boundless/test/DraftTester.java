/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.test;

import boundless.ejb.*;
import boundless.managedbeans.*;
import boundless.entities.*;
import java.util.*;

/**
 *
 * @author hendrikdekock
 */
public class DraftTester {
    
    public static void start(RequestBean rb) {
        
        DraftBean db = new DraftBean(rb.getLeague(1));
        
        List<Player> testSearch = db.searchPlayer("AB");
                
        
        
    }
    
}
