/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.scheduler;

import boundless.entities.Team;
/**
 *
 * @author hendrikdekock
 */
public class TeamPair {
    
    private Team[] vals;
       
       public TeamPair(Team t1, Team t2) {
           vals = new Team[2];
           vals[0] = t1;
           vals[1] = t2;
       }
       
       public Team first() {
           return vals[0];
       }
       public Team second() {
           return vals[1];
       }
    
}
