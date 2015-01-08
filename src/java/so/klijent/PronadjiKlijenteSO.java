/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so.klijent;

import db.DBBroker;
import domen.Klijent;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author asceric
 */
public class PronadjiKlijenteSO extends OpstaSO{
    List<OpstiDomenskiObjekat> klijenti;
    Mesto mesto;

    public PronadjiKlijenteSO(Mesto mesto) {
        this.mesto = mesto;
    }

    public List<OpstiDomenskiObjekat> getKlijenti() {
        return klijenti;
    }
    

    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
        klijenti=DBBroker.vratiObjekat().vratiKlijente(mesto);
    }
    
}
