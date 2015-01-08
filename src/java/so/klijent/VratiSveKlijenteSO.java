/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so.klijent;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author asceric
 */
public class VratiSveKlijenteSO extends OpstaSO{

    public List<OpstiDomenskiObjekat> getListaKlijenata() {
        return listaKlijenata;
    }
    List<OpstiDomenskiObjekat> listaKlijenata;
    

    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
        listaKlijenata=DBBroker.vratiObjekat().vratiSveObjekte((OpstiDomenskiObjekat) objekat);
    }
    
}
