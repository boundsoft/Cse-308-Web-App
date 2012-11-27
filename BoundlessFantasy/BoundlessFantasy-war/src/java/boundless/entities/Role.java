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
@Table(name = "ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findById", query = "SELECT r FROM Role r WHERE r.id = :id"),
    @NamedQuery(name = "Role.findByMinOnTeam", query = "SELECT r FROM Role r WHERE r.minOnTeam = :minOnTeam"),
    @NamedQuery(name = "Role.findByMaxOnTeam", query = "SELECT r FROM Role r WHERE r.maxOnTeam = :maxOnTeam"),
    @NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.name = :name")})
public class Role implements Serializable {
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

    public Role() {
    }

    public Role(Integer id) {
        this.id = id;
    }

    public Role(Integer id, int minOnTeam, int maxOnTeam, String name) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boundless.entities.Role[ id=" + id + " ]";
    }
    
}
