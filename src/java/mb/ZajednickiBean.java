/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Predmet;
import domen.Rociste;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asceric
 */
@ManagedBean(name = "zajednickiBean")
@SessionScoped
public class ZajednickiBean implements Serializable {
    Predmet selektovaniPredmet;
    Rociste rociste;
    Rociste selektovanoRociste;
    

    /**
     * Creates a new instance of ZajednickiBean
     */
    public ZajednickiBean() {
    }
    public String zapamtiPredmet(Predmet sp) {
        selektovaniPredmet = sp;
        return "unosRocista.xhtml?faces-redirect=true";
    }

    public Predmet getSelektovaniPredmet() {
        return selektovaniPredmet;
    }

    public void setSelektovaniPredmet(Predmet selektovaniPredmet) {
        this.selektovaniPredmet = selektovaniPredmet;
    }

    public Rociste getRociste() {
        return rociste;
    }

    public void setRociste(Rociste rociste) {
        this.rociste = rociste;
    }

    public Rociste getSelektovanoRociste() {
        return selektovanoRociste;
    }

    public void setSelektovanoRociste(Rociste selektovanoRociste) {
        this.selektovanoRociste = selektovanoRociste;
    }
    
    
}
