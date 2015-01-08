/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so.advokat;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author asceric
 */
public class VratiSveAdvokateSO  extends OpstaSO{
    List<OpstiDomenskiObjekat> listaAdvokata;

    public List<OpstiDomenskiObjekat> getListaAdvokata() {
        return listaAdvokata;
    }
    

    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
        listaAdvokata=DBBroker.vratiObjekat().vratiSveObjekte((OpstiDomenskiObjekat) objekat);
    }
    
}
