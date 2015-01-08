/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Advokat;
import domen.Klijent;
import domen.Korisnik;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DBBroker {

    private static DBBroker objekat;
    private EntityManagerFactory emf;
    private EntityManager em;

    public static DBBroker vratiObjekat() {
        if (objekat == null) {
            objekat = new DBBroker();
        }
        return objekat;
    }

    private DBBroker() {
        emf = Persistence.createEntityManagerFactory("napredne");
    }

    public void zapocniTransakciju() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void zatvoriEntityManager() {
        em.close();
    }

    public void commit() throws Exception {
        try {
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Greska prilikom commit-a transakcije!");
        }
    }

    public void rollback() throws Exception {
        try {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            throw new Exception("Nastala je greska prilikom rollbacka!");
        }
    }

    public void sacuvajObjekat(OpstiDomenskiObjekat odo) throws Exception {
        System.out.println("DOSAO U BAZU");
        em.persist(odo);


    }

    public void izmeniObjekat(OpstiDomenskiObjekat odo) throws Exception {
        em.merge(odo);
    }

    public void obrisiObjekat(OpstiDomenskiObjekat odo) throws Exception {
       
        Query q = em.createQuery("DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiNazivKljuca() + " = :id");
        q.setParameter("id", odo.vratiVrednostKljuca()).executeUpdate();
    }

    public List<OpstiDomenskiObjekat> vratiSveObjekte(OpstiDomenskiObjekat odo) throws Exception {
        List<OpstiDomenskiObjekat> lista = em.createNamedQuery(odo.getClass().getSimpleName() + ".findAll").getResultList();
        return lista;
    }

    public Korisnik vratiKorisnika(OpstiDomenskiObjekat odo) throws Exception {


        Query q = em.createQuery("SELECT k FROM Korisnik k WHERE k.username = :username AND k.password = :password");
        q.setParameter("username", ((Korisnik) odo).getUsername());
        q.setParameter("password", ((Korisnik) odo).getPassword());
        Korisnik k = (Korisnik) q.getSingleResult();

        return k;

    }

    public int vratiMaxKljuc(OpstiDomenskiObjekat odo) {
        
        Query q = em.createQuery("SELECT max(" + odo.vratiNazivKljuca() + ") FROM " + odo.vratiNazivTabele() + "");

        Object kljuc = q.getSingleResult();
        if (kljuc != null) {
            return Integer.parseInt(kljuc.toString());
        } else {
            return 0;
        }
    }

    

    public List<OpstiDomenskiObjekat> vratiKlijente(Mesto mesto) {
        List<OpstiDomenskiObjekat> klijenti = null;
        Query q = em.createQuery("SELECT k FROM Klijent k WHERE k.ptt = :ptt");
        System.out.println(q);
        q.setParameter("ptt", mesto);
        klijenti = q.getResultList();
        return klijenti;

    }

    public List<OpstiDomenskiObjekat> pronadjiPredmete(Klijent klijent) {
        List<OpstiDomenskiObjekat> predmeti=null;
        Query q = em.createQuery("SELECT p FROM Predmet p WHERE p.klijentID = :klijentID");
         q.setParameter("klijentID", klijent);
        predmeti= q.getResultList();
        return predmeti;
    }
}
