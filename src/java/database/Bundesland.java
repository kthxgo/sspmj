/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jeff
 */
@Entity
@Table(name = "bundesland")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bundesland.findAll", query = "SELECT b FROM Bundesland b"),
    @NamedQuery(name = "Bundesland.findByIdbundesland", query = "SELECT b FROM Bundesland b WHERE b.idbundesland = :idbundesland"),
    @NamedQuery(name = "Bundesland.findByName", query = "SELECT b FROM Bundesland b WHERE b.name = :name"),
    @NamedQuery(name = "Bundesland.findByKurzname", query = "SELECT b FROM Bundesland b WHERE b.kurzname = :kurzname"),
    @NamedQuery(name = "Bundesland.findByHauptstadt", query = "SELECT b FROM Bundesland b WHERE b.hauptstadt = :hauptstadt"),
    @NamedQuery(name = "Bundesland.findByWappen", query = "SELECT b FROM Bundesland b WHERE b.wappen = :wappen")})
public class Bundesland implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbundesland")
    private Integer idbundesland;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 5)
    @Column(name = "kurzname")
    private String kurzname;
    @Size(max = 45)
    @Column(name = "hauptstadt")
    private String hauptstadt;
    @Size(max = 255)
    @Column(name = "wappen")
    private String wappen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bundeslandID")
    private Collection<Abgeordneter> abgeordneterCollection;

    public Bundesland() {
    }

    public Bundesland(Integer idbundesland) {
        this.idbundesland = idbundesland;
    }

    public Integer getIdbundesland() {
        return idbundesland;
    }

    public void setIdbundesland(Integer idbundesland) {
        this.idbundesland = idbundesland;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKurzname() {
        return kurzname;
    }

    public void setKurzname(String kurzname) {
        this.kurzname = kurzname;
    }

    public String getHauptstadt() {
        return hauptstadt;
    }

    public void setHauptstadt(String hauptstadt) {
        this.hauptstadt = hauptstadt;
    }

    public String getWappen() {
        return wappen;
    }

    public void setWappen(String wappen) {
        this.wappen = wappen;
    }

    @XmlTransient
    public Collection<Abgeordneter> getAbgeordneterCollection() {
        return abgeordneterCollection;
    }

    public void setAbgeordneterCollection(Collection<Abgeordneter> abgeordneterCollection) {
        this.abgeordneterCollection = abgeordneterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbundesland != null ? idbundesland.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        Bundesland b = (Bundesland) object;
        if(Objects.equals(idbundesland, b.getIdbundesland())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "database.Bundesland[ idbundesland=" + idbundesland + " ]";
    }
    
}
