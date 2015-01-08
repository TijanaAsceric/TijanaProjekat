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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asceric
 */
@Entity
@Table(name = "predmet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predmet.findAll", query = "SELECT p FROM Predmet p"),
    @NamedQuery(name = "Predmet.findByPredmetID", query = "SELECT p FROM Predmet p WHERE p.predmetID = :predmetID"),
    @NamedQuery(name = "Predmet.findByNaziv", query = "SELECT p FROM Predmet p WHERE p.naziv = :naziv"),
    @NamedQuery(name = "Predmet.findByDatum", query = "SELECT p FROM Predmet p WHERE p.datum = :datum"),
    @NamedQuery(name = "Predmet.findByPravniOsnov", query = "SELECT p FROM Predmet p WHERE p.pravniOsnov = :pravniOsnov"),
    @NamedQuery(name = "Predmet.findByProblem", query = "SELECT p FROM Predmet p WHERE p.problem = :problem")})
public class Predmet implements Serializable,OpstiDomenskiObjekat {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "predmetID")
    private Integer predmetID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "pravniOsnov")
    private String pravniOsnov;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "problem")
    private String problem;
    @JoinColumn(name = "klijentID", referencedColumnName = "klijentID")
    @ManyToOne(optional = false)
    private Klijent klijentID;
    @JoinColumn(name = "advokatID", referencedColumnName = "korisnikID")
    @ManyToOne(optional = false)
    private Korisnik advokatID;

    public Predmet() {
    }

    public Predmet(Integer predmetID) {
        this.predmetID = predmetID;
    }

    public Predmet(Integer predmetID, String naziv, Date datum, String pravniOsnov, String problem) {
        this.predmetID = predmetID;
        this.naziv = naziv;
        this.datum = datum;
        this.pravniOsnov = pravniOsnov;
        this.problem = problem;
    }

    public Integer getPredmetID() {
        return predmetID;
    }

    public void setPredmetID(Integer predmetID) {
        this.predmetID = predmetID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getPravniOsnov() {
        return pravniOsnov;
    }

    public void setPravniOsnov(String pravniOsnov) {
        this.pravniOsnov = pravniOsnov;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public Klijent getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(Klijent klijentID) {
        this.klijentID = klijentID;
    }

    public Korisnik getAdvokatID() {
        return advokatID;
    }

    public void setAdvokatID(Korisnik advokatID) {
        this.advokatID = advokatID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (predmetID != null ? predmetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predmet)) {
            return false;
        }
        Predmet other = (Predmet) object;
        if ((this.predmetID == null && other.predmetID != null) || (this.predmetID != null && !this.predmetID.equals(other.predmetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Predmet[ predmetID=" + predmetID + " ]";
    }

    @Override
    public String vratiNazivKljuca() {
        return "p.predmetID";
    }

    @Override
    public String vratiNazivTabele() {
        return "Predmet p";
    }

    @Override
    public Object vratiVrednostKljuca() {
        return predmetID;
    }
    
}
