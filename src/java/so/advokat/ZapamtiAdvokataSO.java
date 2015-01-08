/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so.advokat;

import db.DBBroker;
import domen.Advokat;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import so.OpstaSO;

/**
 *
 * @author asceric
 */
public class ZapamtiAdvokataSO extends OpstaSO{

    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
        System.out.println("id"+((Korisnik)objekat).getAdvokat().getAdvokatID());
        System.out.println("datum"+((Korisnik)objekat).getAdvokat().getDatumZaposlenja());
        System.out.println("kor id"+((Korisnik)objekat).getKorisnikID());
        
        DBBroker.vratiObjekat().sacuvajObjekat((OpstiDomenskiObjekat) objekat);
    }
    
}
