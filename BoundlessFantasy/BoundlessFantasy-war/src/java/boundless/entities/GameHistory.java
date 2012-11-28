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
@Table(name = "GAME_HISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GameHistory.findAll", query = "SELECT g FROM GameHistory g"),
    @NamedQuery(name = "GameHistory.findByTeam1Id", query = "SELECT g FROM GameHistory g WHERE g.gameHistoryPK.team1Id = :team1Id"),
    @NamedQuery(name = "GameHistory.findByTeam2Id", query = "SELECT g FROM GameHistory g WHERE g.gameHistoryPK.team2Id = :team2Id"),
    @NamedQuery(name = "GameHistory.findByWeek", query = "SELECT g FROM GameHistory g WHERE g.gameHistoryPK.week = :week"),
    @NamedQuery(name = "GameHistory.findByScore1", query = "SELECT g FROM GameHistory g WHERE g.score1 = :score1"),
    @NamedQuery(name = "GameHistory.findByScore2", query = "SELECT g FROM GameHistory g WHERE g.score2 = :score2"),
    @NamedQuery(name = "GameHistory.findByLeague", query = "SELECT g FROM GameHistory g WHERE g.league = :league")})
public class GameHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GameHistoryPK gameHistoryPK;
    @Column(name = "SCORE1")
    private Integer score1;
    @Column(name = "SCORE2")
    private Integer score2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LEAGUE")
    private int league;

    public GameHistory() {
    }

    public GameHistory(GameHistoryPK gameHistoryPK) {
        this.gameHistoryPK = gameHistoryPK;
    }

    public GameHistory(GameHistoryPK gameHistoryPK, int league) {
        this.gameHistoryPK = gameHistoryPK;
        this.league = league;
    }

    public GameHistory(int team1Id, int team2Id, int week) {
        this.gameHistoryPK = new GameHistoryPK(team1Id, team2Id, week);
    }

    public GameHistory(int team1Id, int team2Id, int week, int league) {
        this.gameHistoryPK = new GameHistoryPK(team1Id, team2Id, week);
        this.league = league;
    }
    
    public GameHistoryPK getGameHistoryPK() {
        return gameHistoryPK;
    }

    public void setGameHistoryPK(GameHistoryPK gameHistoryPK) {
        this.gameHistoryPK = gameHistoryPK;
    }

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

    public int getLeague() {
        return league;
    }

    public void setLeague(int league) {
        this.league = league;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gameHistoryPK != null ? gameHistoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameHistory)) {
            return false;
        }
        GameHistory other = (GameHistory) object;
        if ((this.gameHistoryPK == null && other.gameHistoryPK != null) || (this.gameHistoryPK != null && !this.gameHistoryPK.equals(other.gameHistoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boundless.entities.GameHistory[ gameHistoryPK=" + gameHistoryPK + " ]";
    }
    
}
