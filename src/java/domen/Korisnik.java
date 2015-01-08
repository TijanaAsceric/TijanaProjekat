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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "korisnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k"),
    @NamedQuery(name = "Korisnik.findByKorisnikID", query = "SELECT k FROM Korisnik k WHERE k.korisnikID = :korisnikID"),
    @NamedQuery(name = "Korisnik.findByIme", query = "SELECT k FROM Korisnik k WHERE k.ime = :ime"),
    @NamedQuery(name = "Korisnik.findByPrezime", query = "SELECT k FROM Korisnik k WHERE k.prezime = :prezime"),
    @NamedQuery(name = "Korisnik.findByUsername", query = "SELECT k FROM Korisnik k WHERE k.username = :username"),
    @NamedQuery(name = "Korisnik.findByPassword", query = "SELECT k FROM Korisnik k WHERE k.password = :password"),
    @NamedQuery(name = "Korisnik.findByTip", query = "SELECT k FROM Korisnik k WHERE k.tip = :tip"),
    @NamedQuery(name = "Korisnik.findByEmail", query = "SELECT k FROM Korisnik k WHERE k.email = :email")})
public class Korisnik implements Serializable,OpstiDomenskiObjekat {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advokatID")
    private Collection<Predmet> predmetCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "korisnikID")
    private Integer korisnikID;
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
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tip")
    private int tip;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "korisnik")
    private Administrator administrator;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "korisnik")
    private Advokat advokat;

    public Korisnik() {
    }

    public Korisnik(Integer korisnikID) {
        this.korisnikID = korisnikID;
    }

    public Korisnik(Integer korisnikID, String ime, String prezime, String username, String password, int tip, String email) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.tip = tip;
        this.email = email;
    }

    public Integer getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(Integer korisnikID) {
        this.korisnikID = korisnikID;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Advokat getAdvokat() {
        return advokat;
    }

    public void setAdvokat(Advokat advokat) {
        this.advokat = advokat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korisnikID != null ? korisnikID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.korisnikID == null && other.korisnikID != null) || (this.korisnikID != null && !this.korisnikID.equals(other.korisnikID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime+" "+prezime ;
    }

    @Override
    public String vratiNazivKljuca() {
        return "k.korisnikID";
    }

    @Override
    public String vratiNazivTabele() {
        return "Korisnik k";
    }

    @Override
    public Object vratiVrednostKljuca() {
        return korisnikID;
    }

    @XmlTransient
    public Collection<Predmet> getPredmetCollection() {
        return predmetCollection;
    }

    public void setPredmetCollection(Collection<Predmet> predmetCollection) {
        this.predmetCollection = predmetCollection;
    }
    
}
