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
public class PlayerAssignmentPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLAYER_ID")
    private int playerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEAM_ID")
    private int teamId;

    public PlayerAssignmentPK() {
    }

    public PlayerAssignmentPK(int playerId, int teamId) {
        this.playerId = playerId;
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) playerId;
        hash += (int) teamId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayerAssignmentPK)) {
            return false;
        }
        PlayerAssignmentPK other = (PlayerAssignmentPK) object;
        if (this.playerId != other.playerId) {
            return false;
        }
        if (this.teamId != other.teamId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boundless.entities.PlayerAssignmentPK[ playerId=" + playerId + ", teamId=" + teamId + " ]";
    }
    
}
