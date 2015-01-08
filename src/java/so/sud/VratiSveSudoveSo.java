/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so.sud;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author asceric
 */
public class VratiSveSudoveSo extends OpstaSO{
    List<OpstiDomenskiObjekat> listaSudova;

    public List<OpstiDomenskiObjekat> getListaSudova() {
        return listaSudova;
    }
    

    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
        listaSudova=DBBroker.vratiObjekat().vratiSveObjekte((OpstiDomenskiObjekat) objekat);
    }
    
}
