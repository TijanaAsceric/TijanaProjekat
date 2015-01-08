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
@Table(name = "sud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sud.findAll", query = "SELECT s FROM Sud s"),
    @NamedQuery(name = "Sud.findBySudID", query = "SELECT s FROM Sud s WHERE s.sudID = :sudID"),
    @NamedQuery(name = "Sud.findByNazivSuda", query = "SELECT s FROM Sud s WHERE s.nazivSuda = :nazivSuda"),
    @NamedQuery(name = "Sud.findByAdresa", query = "SELECT s FROM Sud s WHERE s.adresa = :adresa")})
public class Sud implements Serializable,OpstiDomenskiObjekat {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sudID")
    private Integer sudID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nazivSuda")
    private String nazivSuda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "adresa")
    private String adresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sudID")
    private Collection<Rociste> rocisteCollection;

    public Sud() {
    }

    public Sud(Integer sudID) {
        this.sudID = sudID;
    }

    public Sud(Integer sudID, String nazivSuda, String adresa) {
        this.sudID = sudID;
        this.nazivSuda = nazivSuda;
        this.adresa = adresa;
    }

    public Integer getSudID() {
        return sudID;
    }

    public void setSudID(Integer sudID) {
        this.sudID = sudID;
    }

    public String getNazivSuda() {
        return nazivSuda;
    }

    public void setNazivSuda(String nazivSuda) {
        this.nazivSuda = nazivSuda;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @XmlTransient
    public Collection<Rociste> getRocisteCollection() {
        return rocisteCollection;
    }

    public void setRocisteCollection(Collection<Rociste> rocisteCollection) {
        this.rocisteCollection = rocisteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sudID != null ? sudID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sud)) {
            return false;
        }
        Sud other = (Sud) object;
        if ((this.sudID == null && other.sudID != null) || (this.sudID != null && !this.sudID.equals(other.sudID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Sud[ sudID=" + sudID + " ]";
    }

    @Override
    public String vratiNazivKljuca() {
        return "s.sudID";
                
    }

    @Override
    public String vratiNazivTabele() {
        return "Sud s";
    }

    @Override
    public Object vratiVrednostKljuca() {
        return sudID;
    }
    
}
