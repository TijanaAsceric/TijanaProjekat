/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so.predmet;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Predmet;
import so.OpstaSO;

/**
 *
 * @author asceric
 */
public class ZapamtiPredmetSO extends OpstaSO{

    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
        System.out.println("advokat id"+((Predmet)objekat).getAdvokatID());
        System.out.println(" naziv "+((Predmet)objekat).getNaziv());
         System.out.println(" pravni osnov "+((Predmet)objekat).getPravniOsnov());
          System.out.println(" problem "+((Predmet)objekat).getProblem());
           System.out.println(" klijent id "+((Predmet)objekat).getKlijentID());
            System.out.println(" predmetid "+((Predmet)objekat).getPredmetID());
        DBBroker.vratiObjekat().sacuvajObjekat((OpstiDomenskiObjekat) objekat);
    }
    
}
