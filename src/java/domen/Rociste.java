/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author asceric
 */
@Entity
@Table(name = "rociste")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rociste.findAll", query = "SELECT r FROM Rociste r"),
    @NamedQuery(name = "Rociste.findByRocisteID", query = "SELECT r FROM Rociste r WHERE r.rocisteID = :rocisteID"),
    @NamedQuery(name = "Rociste.findByDatumRocista", query = "SELECT r FROM Rociste r WHERE r.datumRocista = :datumRocista"),
    @NamedQuery(name = "Rociste.findByVremeRocista", query = "SELECT r FROM Rociste r WHERE r.vremeRocista = :vremeRocista"),
    @NamedQuery(name = "Rociste.findByNapomena", query = "SELECT r FROM Rociste r WHERE r.napomena = :napomena"),
    @NamedQuery(name = "Rociste.findByUkupnaCena", query = "SELECT r FROM Rociste r WHERE r.ukupnaCena = :ukupnaCena")})
public class Rociste implements Serializable,OpstiDomenskiObjekat {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rocisteID")
    private Integer rocisteID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumRocista")
    @Temporal(TemporalType.DATE)
    private Date datumRocista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "vremeRocista")
    private String vremeRocista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "napomena")
    private String napomena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ukupnaCena")
    private double ukupnaCena;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rociste")
    private Collection<Stavkarocista> stavkarocistaCollection;
    @JoinColumn(name = "sudID", referencedColumnName = "sudID")
    @ManyToOne(optional = false)
    private Sud sudID;
    @JoinColumn(name = "predmetID", referencedColumnName = "predmetID")
    @ManyToOne(optional = false)
    private Predmet predmetID;

    public Rociste() {
    }

    public Rociste(Integer rocisteID) {
        this.rocisteID = rocisteID;
    }

    public Rociste(Integer rocisteID, Date datumRocista, String vremeRocista, String napomena, double ukupnaCena) {
        this.rocisteID = rocisteID;
        this.datumRocista = datumRocista;
        this.vremeRocista = vremeRocista;
        this.napomena = napomena;
        this.ukupnaCena = ukupnaCena;
    }

    public Integer getRocisteID() {
        return rocisteID;
    }

    public void setRocisteID(Integer rocisteID) {
        this.rocisteID = rocisteID;
    }

    public Date getDatumRocista() {
        return datumRocista;
    }

    public void setDatumRocista(Date datumRocista) {
        this.datumRocista = datumRocista;
    }

    public String getVremeRocista() {
        return vremeRocista;
    }

    public void setVremeRocista(String vremeRocista) {
        this.vremeRocista = vremeRocista;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    @XmlTransient
    public Collection<Stavkarocista> getStavkarocistaCollection() {
        return stavkarocistaCollection;
    }

    public void setStavkarocistaCollection(Collection<Stavkarocista> stavkarocistaCollection) {
        this.stavkarocistaCollection = stavkarocistaCollection;
    }

    public Sud getSudID() {
        return sudID;
    }

    public void setSudID(Sud sudID) {
        this.sudID = sudID;
    }

    public Predmet getPredmetID() {
        return predmetID;
    }

    public void setPredmetID(Predmet predmetID) {
        this.predmetID = predmetID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rocisteID != null ? rocisteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rociste)) {
            return false;
        }
        Rociste other = (Rociste) object;
        if ((this.rocisteID == null && other.rocisteID != null) || (this.rocisteID != null && !this.rocisteID.equals(other.rocisteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Rociste[ rocisteID=" + rocisteID + " ]";
    }

    @Override
    public String vratiNazivKljuca() {
        return "r.rocisteID";
    }

    @Override
    public String vratiNazivTabele() {
        return "Rociste r";
    }

    @Override
    public Object vratiVrednostKljuca() {
        return rocisteID;
    }
    
}
