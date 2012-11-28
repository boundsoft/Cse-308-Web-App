/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author hendrikdekock
 */
@Embeddable
public class GameHistoryPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEAM1_ID")
    private int team1Id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEAM2_ID")
    private int team2Id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WEEK")
    private int week;

    public GameHistoryPK() {
    }

    public GameHistoryPK(int team1Id, int team2Id, int week) {
        this.team1Id = team1Id;
        this.team2Id = team2Id;
        this.week = week;
    }

    public int getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(int team1Id) {
        this.team1Id = team1Id;
    }

    public int getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(int team2Id) {
        this.team2Id = team2Id;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) team1Id;
        hash += (int) team2Id;
        hash += (int) week;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameHistoryPK)) {
            return false;
        }
        GameHistoryPK other = (GameHistoryPK) object;
        if (this.team1Id != other.team1Id) {
            return false;
        }
        if (this.team2Id != other.team2Id) {
            return false;
        }
        if (this.week != other.week) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boundless.entities.GameHistoryPK[ team1Id=" + team1Id + ", team2Id=" + team2Id + ", week=" + week + " ]";
    }
    
}
