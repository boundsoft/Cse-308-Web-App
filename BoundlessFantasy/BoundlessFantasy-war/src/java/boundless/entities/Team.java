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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hendrikdekock
 */
@Entity
@Table(name = "FANTASY_TEAMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t"),
    @NamedQuery(name = "Team.findById", query = "SELECT t FROM Team t WHERE t.id = :id"),
    @NamedQuery(name = "Team.findByOwnerId", query = "SELECT t FROM Team t WHERE t.ownerId = :ownerId"),
    @NamedQuery(name = "Team.findByName", query = "SELECT t FROM Team t WHERE t.name = :name"),
    @NamedQuery(name = "Team.findByWin", query = "SELECT t FROM Team t WHERE t.win = :win"),
    @NamedQuery(name = "Team.findByLose", query = "SELECT t FROM Team t WHERE t.lose = :lose"),
    @NamedQuery(name = "Team.findByTie", query = "SELECT t FROM Team t WHERE t.tie = :tie"),
    @NamedQuery(name = "Team.findByLeague", query = "SELECT t FROM Team t WHERE t.league = :league"),
    @NamedQuery(name = "Team.findByBye", query = "SELECT t FROM Team t WHERE t.bye = :bye"),
    @NamedQuery(name = "Team.findByPowerLevel", query = "SELECT t FROM Team t WHERE t.powerLevel = :powerLevel")})
public class Team implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OWNER_ID")
    private int ownerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WIN")
    private int win;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOSE")
    private int lose;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIE")
    private int tie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LEAGUE")
    private int league;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BYE")
    private int bye;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POWER_LEVEL")
    private int powerLevel;

    public Team() {
    }

    public Team(Integer id) {
        this.id = id;
    }

    public Team(Integer id, int ownerId, String name, int win, int lose, int tie, int league, int bye, int powerLevel) {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.win = win;
        this.lose = lose;
        this.tie = tie;
        this.league = league;
        this.bye = bye;
        this.powerLevel = powerLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getTie() {
        return tie;
    }

    public void setTie(int tie) {
        this.tie = tie;
    }

    public int getLeague() {
        return league;
    }

    public void setLeague(int league) {
        this.league = league;
    }

    public int getBye() {
        return bye;
    }

    public void setBye(int bye) {
        this.bye = bye;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boundless.entities.Team[ id=" + id + " ]";
    }
    
}
