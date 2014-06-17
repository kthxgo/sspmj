/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "partei")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partei.findAll", query = "SELECT p FROM Partei p"),
    @NamedQuery(name = "Partei.findByIdpartei", query = "SELECT p FROM Partei p WHERE p.idpartei = :idpartei"),
    @NamedQuery(name = "Partei.findByKuerzung", query = "SELECT p FROM Partei p WHERE p.kuerzung = :kuerzung"),
    @NamedQuery(name = "Partei.findByName", query = "SELECT p FROM Partei p WHERE p.name = :name"),
    @NamedQuery(name = "Partei.findByParteichef", query = "SELECT p FROM Partei p WHERE p.parteichef = :parteichef"),
    @NamedQuery(name = "Partei.findByFraktion", query = "SELECT p FROM Partei p WHERE p.fraktion = :fraktion"),
    @NamedQuery(name = "Partei.findByFraktionsvorsitzender", query = "SELECT p FROM Partei p WHERE p.fraktionsvorsitzender = :fraktionsvorsitzender"),
    @NamedQuery(name = "Partei.findByWappen", query = "SELECT p FROM Partei p WHERE p.wappen = :wappen"),
    @NamedQuery(name = "Partei.findByMitgliederzahl", query = "SELECT p FROM Partei p WHERE p.mitgliederzahl = :mitgliederzahl")})
public class Partei implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpartei")
    private Integer idpartei;
    @Size(max = 45)
    @Column(name = "kuerzung")
    private String kuerzung;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "parteichef")
    private String parteichef;
    @Size(max = 5)
    @Column(name = "fraktion")
    private String fraktion;
    @Size(max = 255)
    @Column(name = "fraktionsvorsitzender")
    private String fraktionsvorsitzender;
    @Size(max = 255)
    @Column(name = "wappen")
    private String wappen;
    @Column(name = "mitgliederzahl")
    private Integer mitgliederzahl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parteiID")
    private Collection<Abgeordneter> abgeordneterCollection;

    public Partei() {
    }

    public Partei(Integer idpartei) {
        this.idpartei = idpartei;
    }

    public Integer getIdpartei() {
        return idpartei;
    }

    public void setIdpartei(Integer idpartei) {
        this.idpartei = idpartei;
    }

    public String getKuerzung() {
        return kuerzung;
    }

    public void setKuerzung(String kuerzung) {
        this.kuerzung = kuerzung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParteichef() {
        return parteichef;
    }

    public void setParteichef(String parteichef) {
        this.parteichef = parteichef;
    }

    public String getFraktion() {
        return fraktion;
    }

    public void setFraktion(String fraktion) {
        this.fraktion = fraktion;
    }

    public String getFraktionsvorsitzender() {
        return fraktionsvorsitzender;
    }

    public void setFraktionsvorsitzender(String fraktionsvorsitzender) {
        this.fraktionsvorsitzender = fraktionsvorsitzender;
    }

    public String getWappen() {
        return wappen;
    }

    public void setWappen(String wappen) {
        this.wappen = wappen;
    }

    public Integer getMitgliederzahl() {
        return mitgliederzahl;
    }

    public void setMitgliederzahl(Integer mitgliederzahl) {
        this.mitgliederzahl = mitgliederzahl;
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
        hash += (idpartei != null ? idpartei.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partei)) {
            return false;
        }
        Partei other = (Partei) object;
        if ((this.idpartei == null && other.idpartei != null) || (this.idpartei != null && !this.idpartei.equals(other.idpartei))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Partei[ idpartei=" + idpartei + " ]";
    }
    
}
