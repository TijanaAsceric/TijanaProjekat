/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so.mesta;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author asceric
 */
public class VratiSvaMestaSO  extends OpstaSO{
    List<OpstiDomenskiObjekat> listaMesta;

    public List<OpstiDomenskiObjekat> getListaMesta() {
        return listaMesta;
    }
    

    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
        listaMesta=DBBroker.vratiObjekat().vratiSveObjekte((OpstiDomenskiObjekat) objekat);
    }
    
}
