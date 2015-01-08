/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so.usluga;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author asceric
 */
public class VratiSveUslugeSO extends OpstaSO{
    List<OpstiDomenskiObjekat> listaUsluga;

    public List<OpstiDomenskiObjekat> getListaUsluga() {
        return listaUsluga;
    }
    
    

    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
        listaUsluga=DBBroker.vratiObjekat().vratiSveObjekte((OpstiDomenskiObjekat) objekat);
    }
    
}
