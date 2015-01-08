/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so.korisnik;

import db.DBBroker;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import javax.persistence.Query;
import so.OpstaSO;

/**
 *
 * @author Komp
 */
public class VratiKorisnikaSO extends OpstaSO {

    private Korisnik odo;

    public Korisnik getOdo() {
        return odo;
    }

    public void setOdo(Korisnik odo) {
        this.odo = odo;
    }

    @Override
    public void izvrsiKonkretnuOperaciju(Object o) throws Exception {
//        Query q = em.createQuery("SELECT k FROM Korisnik k WHERE k.korisnickoIme = :korisnickoIme AND k.korisnickaSifra = :korisnickaSifra");
//        System.out.println(q);
//        q.setParameter("korisnickoIme", ((Korisnik) o).getKorisnickoIme());
//        q.setParameter("korisnickaSifra", ((Korisnik) o).getKorisnickaSifra());
//        System.out.println(q);
//        odo = (Korisnik) q.getSingleResult();
  odo = DBBroker.vratiObjekat().vratiKorisnika((OpstiDomenskiObjekat) o);
    }
}
