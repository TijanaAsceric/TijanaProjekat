/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author asceric
 */
@Entity
@Table(name = "klijent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klijent.findAll", query = "SELECT k FROM Klijent k"),
    @NamedQuery(name = "Klijent.findByKlijentID", query = "SELECT k FROM Klijent k WHERE k.klijentID = :klijentID"),
    @NamedQuery(name = "Klijent.findByIme", query = "SELECT k FROM Klijent k WHERE k.ime = :ime"),
    @NamedQuery(name = "Klijent.findByPrezime", query = "SELECT k FROM Klijent k WHERE k.prezime = :prezime"),
    @NamedQuery(name = "Klijent.findByFiksniTelefon", query = "SELECT k FROM Klijent k WHERE k.fiksniTelefon = :fiksniTelefon"),
    @NamedQuery(name = "Klijent.findByMobilniTelefon", query = "SELECT k FROM Klijent k WHERE k.mobilniTelefon = :mobilniTelefon"),
    @NamedQuery(name = "Klijent.findByEmail", query = "SELECT k FROM Klijent k WHERE k.email = :email"),
    @NamedQuery(name = "Klijent.findByUlica", query = "SELECT k FROM Klijent k WHERE k.ulica = :ulica"),
    @NamedQuery(name = "Klijent.findByBroj", query = "SELECT k FROM Klijent k WHERE k.broj = :broj")})
public class Klijent implements Serializable,OpstiDomenskiObjekat {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "klijentID")
    private Integer klijentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "fiksniTelefon")
    private String fiksniTelefon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "mobilniTelefon")
    private String mobilniTelefon;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ulica")
    private String ulica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "broj")
    private String broj;
    @JoinColumn(name = "ptt", referencedColumnName = "ptt")
    @ManyToOne(optional = false)
    private Mesto ptt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klijentID")
    private Collection<Predmet> predmetCollection;

    public Klijent() {
    }

    public Klijent(Integer klijentID) {
        this.klijentID = klijentID;
    }

    public Klijent(Integer klijentID, String ime, String prezime, String fiksniTelefon, String mobilniTelefon, String email, String ulica, String broj) {
        this.klijentID = klijentID;
        this.ime = ime;
        this.prezime = prezime;
        this.fiksniTelefon = fiksniTelefon;
        this.mobilniTelefon = mobilniTelefon;
        this.email = email;
        this.ulica = ulica;
        this.broj = broj;
    }

    public Integer getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(Integer klijentID) {
        this.klijentID = klijentID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getFiksniTelefon() {
        return fiksniTelefon;
    }

    public void setFiksniTelefon(String fiksniTelefon) {
        this.fiksniTelefon = fiksniTelefon;
    }

    public String getMobilniTelefon() {
        return mobilniTelefon;
    }

    public void setMobilniTelefon(String mobilniTelefon) {
        this.mobilniTelefon = mobilniTelefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public Mesto getPtt() {
        return ptt;
    }

    public void setPtt(Mesto ptt) {
        this.ptt = ptt;
    }

    @XmlTransient
    public Collection<Predmet> getPredmetCollection() {
        return predmetCollection;
    }

    public void setPredmetCollection(Collection<Predmet> predmetCollection) {
        this.predmetCollection = predmetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klijentID != null ? klijentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klijent)) {
            return false;
        }
        Klijent other = (Klijent) object;
        if ((this.klijentID == null && other.klijentID != null) || (this.klijentID != null && !this.klijentID.equals(other.klijentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    @Override
    public String vratiNazivKljuca() {
        return "k.klijentID";
    }

    @Override
    public String vratiNazivTabele() {
        return "Klijent k";
    }

    @Override
    public Object vratiVrednostKljuca() {
        return klijentID;
    }
    
}
