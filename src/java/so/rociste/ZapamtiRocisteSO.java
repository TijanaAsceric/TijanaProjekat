/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so.rociste;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Rociste;
import domen.Stavkarocista;
import java.util.Collection;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author asceric
 */
public class ZapamtiRocisteSO extends OpstaSO{

    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
        DBBroker.vratiObjekat().sacuvajObjekat((OpstiDomenskiObjekat) objekat);
        Collection<Stavkarocista> lista=((Rociste) objekat).getStavkarocistaCollection();
        for (Stavkarocista stavkarocista : lista) {
            System.out.println("RB"+stavkarocista.getStavkarocistaPK().getRb());
            DBBroker.vratiObjekat().sacuvajObjekat(stavkarocista);
        }
    }
    
}
