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
@Table(name = "PLAY_POSITION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlayPosition.findAll", query = "SELECT p FROM PlayPosition p"),
    @NamedQuery(name = "PlayPosition.findById", query = "SELECT p FROM PlayPosition p WHERE p.id = :id"),
    @NamedQuery(name = "PlayPosition.findByMinOnTeam", query = "SELECT p FROM PlayPosition p WHERE p.minOnTeam = :minOnTeam"),
    @NamedQuery(name = "PlayPosition.findByMaxOnTeam", query = "SELECT p FROM PlayPosition p WHERE p.maxOnTeam = :maxOnTeam"),
    @NamedQuery(name = "PlayPosition.findByName", query = "SELECT p FROM PlayPosition p WHERE p.name = :name")})
public class PlayPosition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MIN_ON_TEAM")
    private int minOnTeam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MAX_ON_TEAM")
    private int maxOnTeam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;

    public PlayPosition() {
    }

    public PlayPosition(Integer id) {
        this.id = id;
    }

    public PlayPosition(Integer id, int minOnTeam, int maxOnTeam, String name) {
        this.id = id;
        this.minOnTeam = minOnTeam;
        this.maxOnTeam = maxOnTeam;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMinOnTeam() {
        return minOnTeam;
    }

    public void setMinOnTeam(int minOnTeam) {
        this.minOnTeam = minOnTeam;
    }

    public int getMaxOnTeam() {
        return maxOnTeam;
    }

    public void setMaxOnTeam(int maxOnTeam) {
        this.maxOnTeam = maxOnTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns whether a given number of players of this position is compliant with NFL Rules.
     * @param num : The number of players
     * @return : True if number is valid, false otherwise
     */
    public boolean isValidNumber(int num) {
        if (num < minOnTeam)
            return false;
        if (num > maxOnTeam)
            return false;
        return true;
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
        if (!(object instanceof PlayPosition)) {
            return false;
        }
        PlayPosition other = (PlayPosition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boundless.entities.PlayPosition[ id=" + id + " ]";
    }
    
}
