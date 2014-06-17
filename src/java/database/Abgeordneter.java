/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jeff
 */
@Entity
@Table(name = "abgeordneter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Abgeordneter.findAll", query = "SELECT a FROM Abgeordneter a"),
    @NamedQuery(name = "Abgeordneter.findByIdabgeordneter", query = "SELECT a FROM Abgeordneter a WHERE a.idabgeordneter = :idabgeordneter"),
    @NamedQuery(name = "Abgeordneter.findByVorname", query = "SELECT a FROM Abgeordneter a WHERE a.vorname = :vorname"),
    @NamedQuery(name = "Abgeordneter.findByNachname", query = "SELECT a FROM Abgeordneter a WHERE a.nachname = :nachname"),
    @NamedQuery(name = "Abgeordneter.findByBild", query = "SELECT a FROM Abgeordneter a WHERE a.bild = :bild"),
    @NamedQuery(name = "Abgeordneter.findByGeschlecht", query = "SELECT a FROM Abgeordneter a WHERE a.geschlecht = :geschlecht"),
    @NamedQuery(name = "Abgeordneter.findByKonfession", query = "SELECT a FROM Abgeordneter a WHERE a.konfession = :konfession"),
    @NamedQuery(name = "Abgeordneter.findByFamilienstand", query = "SELECT a FROM Abgeordneter a WHERE a.familienstand = :familienstand"),
    @NamedQuery(name = "Abgeordneter.findByKinder", query = "SELECT a FROM Abgeordneter a WHERE a.kinder = :kinder"),
    @NamedQuery(name = "Abgeordneter.findByWahlkreis", query = "SELECT a FROM Abgeordneter a WHERE a.wahlkreis = :wahlkreis"),
    @NamedQuery(name = "Abgeordneter.findByBundesland", query = "SELECT a FROM Abgeordneter a WHERE a.bundesland = :bundesland"),
    @NamedQuery(name = "Abgeordneter.findByPartei", query = "SELECT a FROM Abgeordneter a WHERE a.partei = :partei"),
    @NamedQuery(name = "Abgeordneter.findByFraktion", query = "SELECT a FROM Abgeordneter a WHERE a.fraktion = :fraktion"),
    @NamedQuery(name = "Abgeordneter.findByGeburtsdatum", query = "SELECT a FROM Abgeordneter a WHERE a.geburtsdatum = :geburtsdatum"),
    @NamedQuery(name = "Abgeordneter.findByAktuellerberuf", query = "SELECT a FROM Abgeordneter a WHERE a.aktuellerberuf = :aktuellerberuf"),
    @NamedQuery(name = "Abgeordneter.findByAddbundestag", query = "SELECT a FROM Abgeordneter a WHERE a.addbundestag = :addbundestag"),
    @NamedQuery(name = "Abgeordneter.findByAddwahlkreis", query = "SELECT a FROM Abgeordneter a WHERE a.addwahlkreis = :addwahlkreis"),
    @NamedQuery(name = "Abgeordneter.findByEmail", query = "SELECT a FROM Abgeordneter a WHERE a.email = :email"),
    @NamedQuery(name = "Abgeordneter.findByWebsite", query = "SELECT a FROM Abgeordneter a WHERE a.website = :website")})
public class Abgeordneter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idabgeordneter")
    private Integer idabgeordneter;
    @Size(max = 255)
    @Column(name = "vorname")
    private String vorname;
    @Size(max = 255)
    @Column(name = "nachname")
    private String nachname;
    @Size(max = 255)
    @Column(name = "bild")
    private String bild;
    @Size(max = 1)
    @Column(name = "geschlecht")
    private String geschlecht;
    @Size(max = 255)
    @Column(name = "konfession")
    private String konfession;
    @Size(max = 255)
    @Column(name = "familienstand")
    private String familienstand;
    @Column(name = "kinder")
    private Integer kinder;
    @Size(max = 255)
    @Column(name = "wahlkreis")
    private String wahlkreis;
    @Size(max = 5)
    @Column(name = "bundesland")
    private String bundesland;
    @Size(max = 3)
    @Column(name = "partei")
    private String partei;
    @Size(max = 5)
    @Column(name = "fraktion")
    private String fraktion;
    @Size(max = 10)
    @Column(name = "geburtsdatum")
    private String geburtsdatum;
    @Size(max = 255)
    @Column(name = "aktuellerberuf")
    private String aktuellerberuf;
    @Lob
    @Size(max = 65535)
    @Column(name = "berufe")
    private String berufe;
    @Size(max = 255)
    @Column(name = "addbundestag")
    private String addbundestag;
    @Size(max = 255)
    @Column(name = "addwahlkreis")
    private String addwahlkreis;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "website")
    private String website;
    @JoinColumn(name = "bundeslandID", referencedColumnName = "idbundesland")
    @ManyToOne(optional = false)
    private Bundesland bundeslandID;
    @JoinColumn(name = "parteiID", referencedColumnName = "idpartei")
    @ManyToOne(optional = false)
    private Partei parteiID;

    public Abgeordneter() {
    }

    public Abgeordneter(Integer idabgeordneter) {
        this.idabgeordneter = idabgeordneter;
    }

    public Integer getIdabgeordneter() {
        return idabgeordneter;
    }

    public void setIdabgeordneter(Integer idabgeordneter) {
        this.idabgeordneter = idabgeordneter;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getBild() {
        return bild;
    }

    public void setBild(String bild) {
        this.bild = bild;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getKonfession() {
        return konfession;
    }

    public void setKonfession(String konfession) {
        this.konfession = konfession;
    }

    public String getFamilienstand() {
        return familienstand;
    }

    public void setFamilienstand(String familienstand) {
        this.familienstand = familienstand;
    }

    public Integer getKinder() {
        return kinder;
    }

    public void setKinder(Integer kinder) {
        this.kinder = kinder;
    }

    public String getWahlkreis() {
        return wahlkreis;
    }

    public void setWahlkreis(String wahlkreis) {
        this.wahlkreis = wahlkreis;
    }

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }

    public String getPartei() {
        return partei;
    }

    public void setPartei(String partei) {
        this.partei = partei;
    }

    public String getFraktion() {
        return fraktion;
    }

    public void setFraktion(String fraktion) {
        this.fraktion = fraktion;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getAktuellerberuf() {
        return aktuellerberuf;
    }

    public void setAktuellerberuf(String aktuellerberuf) {
        this.aktuellerberuf = aktuellerberuf;
    }

    public String getBerufe() {
        return berufe;
    }

    public void setBerufe(String berufe) {
        this.berufe = berufe;
    }

    public String getAddbundestag() {
        return addbundestag;
    }

    public void setAddbundestag(String addbundestag) {
        this.addbundestag = addbundestag;
    }

    public String getAddwahlkreis() {
        return addwahlkreis;
    }

    public void setAddwahlkreis(String addwahlkreis) {
        this.addwahlkreis = addwahlkreis;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Bundesland getBundeslandID() {
        return bundeslandID;
    }

    public void setBundeslandID(Bundesland bundeslandID) {
        this.bundeslandID = bundeslandID;
    }

    public Partei getParteiID() {
        return parteiID;
    }

    public void setParteiID(Partei parteiID) {
        this.parteiID = parteiID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idabgeordneter != null ? idabgeordneter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abgeordneter)) {
            return false;
        }
        Abgeordneter other = (Abgeordneter) object;
        if ((this.idabgeordneter == null && other.idabgeordneter != null) || (this.idabgeordneter != null && !this.idabgeordneter.equals(other.idabgeordneter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Abgeordneter[ idabgeordneter=" + idabgeordneter + " ]";
    }
    
}
