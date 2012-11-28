/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundless.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "PLAYER_TEAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlayerAssignment.findAll", query = "SELECT p FROM PlayerAssignment p"),
    @NamedQuery(name = "PlayerAssignment.findByPlayerId", query = "SELECT p FROM PlayerAssignment p WHERE p.playerAssignmentPK.playerId = :playerId"),
    @NamedQuery(name = "PlayerAssignment.findByTeamId", query = "SELECT p FROM PlayerAssignment p WHERE p.playerAssignmentPK.teamId = :teamId"),
    @NamedQuery(name = "PlayerAssignment.findByLeagueId", query = "SELECT p FROM PlayerAssignment p WHERE p.leagueId = :leagueId"),
    @NamedQuery(name = "PlayerAssignment.findByActive", query = "SELECT p FROM PlayerAssignment p WHERE p.active = :active")})
public class PlayerAssignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlayerAssignmentPK playerAssignmentPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LEAGUE_ID")
    protected int leagueId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVE")
    private short active;

    public PlayerAssignment() {
    }

    public PlayerAssignment(PlayerAssignmentPK playerAssignmentPK) {
        this.playerAssignmentPK = playerAssignmentPK;
    }

    public PlayerAssignment(PlayerAssignmentPK playerAssignmentPK, int leagueId, short active) {
        this.playerAssignmentPK = playerAssignmentPK;
        this.leagueId = leagueId;
        this.active = active;
    }

    public PlayerAssignment(Player p, Team t, League l, short act) {
        this.playerAssignmentPK = new PlayerAssignmentPK(p.getId(), t.getId());
        this.leagueId = l.getId();
        this.active = act;
    }
    
    public PlayerAssignment(int playerId, int teamId) {
        this.playerAssignmentPK = new PlayerAssignmentPK(playerId, teamId);
    }

    public PlayerAssignmentPK getPlayerAssignmentPK() {
        return playerAssignmentPK;
    }

    public void setPlayerAssignmentPK(PlayerAssignmentPK playerAssignmentPK) {
        this.playerAssignmentPK = playerAssignmentPK;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playerAssignmentPK != null ? playerAssignmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayerAssignment)) {
            return false;
        }
        PlayerAssignment other = (PlayerAssignment) object;
        if ((this.playerAssignmentPK == null && other.playerAssignmentPK != null) || (this.playerAssignmentPK != null && !this.playerAssignmentPK.equals(other.playerAssignmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boundless.entities.PlayerAssignment[ playerAssignmentPK=" + playerAssignmentPK + " ]";
    }
    
}
