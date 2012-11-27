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
@Table(name = "PLAYER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
    @NamedQuery(name = "Player.findById", query = "SELECT p FROM Player p WHERE p.id = :id"),
    @NamedQuery(name = "Player.findByTeam", query = "SELECT p FROM Player p WHERE p.team = :team"),
    @NamedQuery(name = "Player.findByInjured", query = "SELECT p FROM Player p WHERE p.injured = :injured"),
    @NamedQuery(name = "Player.findByRole", query = "SELECT p FROM Player p WHERE p.role = :role"),
    @NamedQuery(name = "Player.findByName", query = "SELECT p FROM Player p WHERE p.name = :name")})
public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEAM")
    private int team;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INJURED")
    private short injured;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLE")
    private int role;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "NAME")
    private String name;

    public Player() {
    }

    public Player(Integer id) {
        this.id = id;
    }

    public Player(Integer id, int team, short injured, int role, String name) {
        this.id = id;
        this.team = team;
        this.injured = injured;
        this.role = role;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public short getInjured() {
        return injured;
    }

    public void setInjured(short injured) {
        this.injured = injured;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boundless.entities.Player[ id=" + id + " ]";
    }
    
}
