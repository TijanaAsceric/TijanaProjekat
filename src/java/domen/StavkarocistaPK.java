/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author asceric
 */
@Embeddable
public class StavkarocistaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "rocisteID")
    private int rocisteID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rb")
    private int rb;

    public StavkarocistaPK() {
    }

    public StavkarocistaPK(int rocisteID, int rb) {
        this.rocisteID = rocisteID;
        this.rb = rb;
    }

    public int getRocisteID() {
        return rocisteID;
    }

    public void setRocisteID(int rocisteID) {
        this.rocisteID = rocisteID;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rocisteID;
        hash += (int) rb;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavkarocistaPK)) {
            return false;
        }
        StavkarocistaPK other = (StavkarocistaPK) object;
        if (this.rocisteID != other.rocisteID) {
            return false;
        }
        if (this.rb != other.rb) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.StavkarocistaPK[ rocisteID=" + rocisteID + ", rb=" + rb + " ]";
    }
    
}
