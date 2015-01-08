/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so.predmet;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author asceric
 */
public class VratiSvePredmeteSO extends OpstaSO{
     List<OpstiDomenskiObjekat> listaPredmeta;

    public List<OpstiDomenskiObjekat> getListaPredmeta() {
        return listaPredmeta;
    }
     

    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
        listaPredmeta=DBBroker.vratiObjekat().vratiSveObjekte((OpstiDomenskiObjekat) objekat);
    }
    
}
