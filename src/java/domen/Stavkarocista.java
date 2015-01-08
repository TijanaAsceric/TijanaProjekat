/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asceric
 */
@Entity
@Table(name = "stavkarocista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stavkarocista.findAll", query = "SELECT s FROM Stavkarocista s"),
    @NamedQuery(name = "Stavkarocista.findByRocisteID", query = "SELECT s FROM Stavkarocista s WHERE s.stavkarocistaPK.rocisteID = :rocisteID"),
    @NamedQuery(name = "Stavkarocista.findByRb", query = "SELECT s FROM Stavkarocista s WHERE s.stavkarocistaPK.rb = :rb")})
public class Stavkarocista implements Serializable,OpstiDomenskiObjekat {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StavkarocistaPK stavkarocistaPK;
    @JoinColumn(name = "rocisteID", referencedColumnName = "rocisteID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rociste rociste;
    @JoinColumn(name = "uslugaID", referencedColumnName = "uslugaID")
    @ManyToOne(optional = false)
    private Usluga uslugaID;

    public Stavkarocista() {
    }

    public Stavkarocista(StavkarocistaPK stavkarocistaPK) {
        this.stavkarocistaPK = stavkarocistaPK;
    }

    public Stavkarocista(int rocisteID, int rb) {
        this.stavkarocistaPK = new StavkarocistaPK(rocisteID, rb);
    }

    public StavkarocistaPK getStavkarocistaPK() {
        return stavkarocistaPK;
    }

    public void setStavkarocistaPK(StavkarocistaPK stavkarocistaPK) {
        this.stavkarocistaPK = stavkarocistaPK;
    }

    public Rociste getRociste() {
        return rociste;
    }

    public void setRociste(Rociste rociste) {
        this.rociste = rociste;
    }

    public Usluga getUslugaID() {
        return uslugaID;
    }

    public void setUslugaID(Usluga uslugaID) {
        this.uslugaID = uslugaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stavkarocistaPK != null ? stavkarocistaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stavkarocista)) {
            return false;
        }
        Stavkarocista other = (Stavkarocista) object;
        if ((this.stavkarocistaPK == null && other.stavkarocistaPK != null) || (this.stavkarocistaPK != null && !this.stavkarocistaPK.equals(other.stavkarocistaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Stavkarocista[ stavkarocistaPK=" + stavkarocistaPK + " ]";
    }

    @Override
    public String vratiNazivKljuca() {
        return "s.stavkarocistaPK.rocisteID";
    }

    @Override
    public String vratiNazivTabele() {
        return "Stavkarocista s";
    }

    @Override
    public Object vratiVrednostKljuca() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
