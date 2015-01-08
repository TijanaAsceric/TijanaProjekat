/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asceric
 */
@Entity
@Table(name = "advokat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advokat.findAll", query = "SELECT a FROM Advokat a"),
    @NamedQuery(name = "Advokat.findByAdvokatID", query = "SELECT a FROM Advokat a WHERE a.advokatID = :advokatID"),
    @NamedQuery(name = "Advokat.findByDatumZaposlenja", query = "SELECT a FROM Advokat a WHERE a.datumZaposlenja = :datumZaposlenja")})
public class Advokat implements Serializable,OpstiDomenskiObjekat {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "advokatID")
    private Integer advokatID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumZaposlenja")
    @Temporal(TemporalType.DATE)
    private Date datumZaposlenja;
    @JoinColumn(name = "advokatID", referencedColumnName = "korisnikID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Korisnik korisnik;

    public Advokat() {
    }

    public Advokat(Integer advokatID) {
        this.advokatID = advokatID;
    }

    public Advokat(Integer advokatID, Date datumZaposlenja) {
        this.advokatID = advokatID;
        this.datumZaposlenja = datumZaposlenja;
    }

    public Integer getAdvokatID() {
        return advokatID;
    }

    public void setAdvokatID(Integer advokatID) {
        this.advokatID = advokatID;
    }

    public Date getDatumZaposlenja() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(Date datumZaposlenja) {
        this.datumZaposlenja = datumZaposlenja;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (advokatID != null ? advokatID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advokat)) {
            return false;
        }
        Advokat other = (Advokat) object;
        if ((this.advokatID == null && other.advokatID != null) || (this.advokatID != null && !this.advokatID.equals(other.advokatID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return korisnik.getIme()+" "+korisnik.getPrezime();
    }

    @Override
    public String vratiNazivKljuca() {
        return "a.advokatID";
    }

    @Override
    public String vratiNazivTabele() {
        return "Advokat a";
    }

    @Override
    public Object vratiVrednostKljuca() {
        return advokatID;
    }
    
}
