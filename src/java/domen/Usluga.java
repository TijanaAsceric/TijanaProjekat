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
@Table(name = "usluga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usluga.findAll", query = "SELECT u FROM Usluga u"),
    @NamedQuery(name = "Usluga.findByUslugaID", query = "SELECT u FROM Usluga u WHERE u.uslugaID = :uslugaID"),
    @NamedQuery(name = "Usluga.findByNazivUsluge", query = "SELECT u FROM Usluga u WHERE u.nazivUsluge = :nazivUsluge"),
    @NamedQuery(name = "Usluga.findByCena", query = "SELECT u FROM Usluga u WHERE u.cena = :cena"),
    @NamedQuery(name = "Usluga.findByOpis", query = "SELECT u FROM Usluga u WHERE u.opis = :opis")})
public class Usluga implements Serializable,OpstiDomenskiObjekat {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "uslugaID")
    private Integer uslugaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nazivUsluge")
    private String nazivUsluge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cena")
    private double cena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "opis")
    private String opis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uslugaID")
    private Collection<Stavkarocista> stavkarocistaCollection;

    public Usluga() {
    }

    public Usluga(Integer uslugaID) {
        this.uslugaID = uslugaID;
    }

    public Usluga(Integer uslugaID, String nazivUsluge, double cena, String opis) {
        this.uslugaID = uslugaID;
        this.nazivUsluge = nazivUsluge;
        this.cena = cena;
        this.opis = opis;
    }

    public Integer getUslugaID() {
        return uslugaID;
    }

    public void setUslugaID(Integer uslugaID) {
        this.uslugaID = uslugaID;
    }

    public String getNazivUsluge() {
        return nazivUsluge;
    }

    public void setNazivUsluge(String nazivUsluge) {
        this.nazivUsluge = nazivUsluge;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @XmlTransient
    public Collection<Stavkarocista> getStavkarocistaCollection() {
        return stavkarocistaCollection;
    }

    public void setStavkarocistaCollection(Collection<Stavkarocista> stavkarocistaCollection) {
        this.stavkarocistaCollection = stavkarocistaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uslugaID != null ? uslugaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usluga)) {
            return false;
        }
        Usluga other = (Usluga) object;
        if ((this.uslugaID == null && other.uslugaID != null) || (this.uslugaID != null && !this.uslugaID.equals(other.uslugaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Usluga[ uslugaID=" + uslugaID + " ]";
    }

    @Override
    public String vratiNazivKljuca() {
        return "u.uslugaID";
    }

    @Override
    public String vratiNazivTabele() {
        return "Usluga u";
    }

    @Override
    public Object vratiVrednostKljuca() {
        return uslugaID;
    }
    
}
