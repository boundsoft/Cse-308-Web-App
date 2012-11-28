/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hendrikdekock
 */
@Entity
@Table(name = "NUMTEAMSPERLEAGUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Numteamsperleague.findAll", query = "SELECT n FROM Numteamsperleague n"),
    @NamedQuery(name = "Numteamsperleague.findByLeague", query = "SELECT n FROM Numteamsperleague n WHERE n.league = :league"),
    @NamedQuery(name = "Numteamsperleague.findByNumteams", query = "SELECT n FROM Numteamsperleague n WHERE n.numteams = :numteams")})
public class Numteamsperleague implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LEAGUE")
    @Id
    private int league;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMTEAMS")
    private int numteams;

    public Numteamsperleague() {
    }

    public int getLeague() {
        return league;
    }

    public void setLeague(int league) {
        this.league = league;
    }

    public int getNumteams() {
        return numteams;
    }

    public void setNumteams(int numteams) {
        this.numteams = numteams;
    }
    
}
