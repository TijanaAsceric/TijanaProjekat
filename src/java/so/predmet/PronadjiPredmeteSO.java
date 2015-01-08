/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so.predmet;

import db.DBBroker;
import domen.Advokat;
import domen.Klijent;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import domen.Predmet;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author asceric
 */
public class PronadjiPredmeteSO extends OpstaSO{
    List<OpstiDomenskiObjekat> predmeti;
   Klijent klijent;

    public PronadjiPredmeteSO(Klijent klijent) {
        this.klijent = klijent;
    }

    
    public List<OpstiDomenskiObjekat> getPredmeti() {
        return predmeti;
    }
    

    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
        
        predmeti=DBBroker.vratiObjekat().pronadjiPredmete(klijent);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : predmeti) {
            System.out.println("Predmet"+((Predmet)opstiDomenskiObjekat).getNaziv());
        }
    }
    
}
