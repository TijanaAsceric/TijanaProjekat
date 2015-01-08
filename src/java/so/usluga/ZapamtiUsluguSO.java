/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so.usluga;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import so.OpstaSO;

/**
 *
 * @author asceric
 */
public class ZapamtiUsluguSO extends OpstaSO{

    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
        DBBroker.vratiObjekat().sacuvajObjekat((OpstiDomenskiObjekat) objekat);
    }
    
}
