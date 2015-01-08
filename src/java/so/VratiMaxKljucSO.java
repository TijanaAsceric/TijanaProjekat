/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import so.OpstaSO;

public class VratiMaxKljucSO extends OpstaSO {

    private int kljuc;
    
    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
        kljuc = DBBroker.vratiObjekat().vratiMaxKljuc((OpstiDomenskiObjekat)objekat);
    }

    public int getKljuc() {
        return kljuc;
    }
    
    
}
