/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.scheduler;

/**
 *
 * @author hendrikdekock
 */
public class Pair {
     /**
    * Convenience class that gives a pair of two integers.  Smallest one must always be first.
    */
       private int[] vals;
       
       public Pair(int i1, int i2) {
           int first = Math.min(i1, i2);
           int second = Math.max(i1, i2);
           vals = new int[2];
           vals[0] = first;
           vals[1] = second;
       }
       
       public int first() {
           return vals[0];
       }
       public int second() {
           return vals[1];
       }
       
       public String toString() {
           return "<" + vals[0] + ", " + vals[1] + ">";
       }
       
    public int hashCode() {
        return vals[0] * 100 + vals[1] * 10;
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Pair))
            return false;
        Pair other = (Pair) o;
        if (other.vals[0] == this.vals[0] & other.vals[1] == this.vals[1])
            return true;
        return false;
    }
}
