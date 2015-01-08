/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Advokat;
import domen.Klijent;
import domen.Korisnik;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Predmet;
import domen.Rociste;
import domen.Sud;
import domen.Usluga;
import java.util.ArrayList;
import java.util.List;
import so.VratiMaxKljucSO;
import so.advokat.VratiSveAdvokateSO;
import so.advokat.ZapamtiAdvokataSO;
import so.klijent.IzmeniKlijentaSO;
import so.klijent.ObrisiKlijentaSO;
import so.klijent.PronadjiKlijenteSO;
import so.klijent.VratiSveKlijenteSO;
import so.klijent.ZapamtiKlijentaSO;
import so.korisnik.VratiKorisnikaSO;
import so.mesta.VratiSvaMestaSO;
import so.predmet.PronadjiPredmeteSO;
import so.predmet.VratiSvePredmeteSO;
import so.predmet.ZapamtiPredmetSO;
import so.rociste.ZapamtiRocisteSO;
import so.sud.VratiSveSudoveSo;
import so.usluga.VratiSveUslugeSO;
import so.usluga.ZapamtiUsluguSO;

public class Kontroler {

    private static Kontroler k;

    private Kontroler() {
    }

    public static Kontroler vratiObjekat() {
        if (k == null) {
            k = new Kontroler();
        }
        return k;
    }



  

    public Korisnik vratiKorisnika(Korisnik korisnik) throws Exception {
        VratiKorisnikaSO vk = new VratiKorisnikaSO();
        vk.izvrsiOperaciju(korisnik);
        return vk.getOdo();
    }

  



    public List<Klijent> vratiSveKlijente() throws Exception {
        try {
            List<Klijent> klijenti = new ArrayList<Klijent>();
            VratiSveKlijenteSO vratiKl = new VratiSveKlijenteSO();
            vratiKl.izvrsiOperaciju(new Klijent());

            List<OpstiDomenskiObjekat> objekti = vratiKl.getListaKlijenata();
            for (OpstiDomenskiObjekat odo : objekti) {
                klijenti.add((Klijent) odo);
            }
            return klijenti;
        } catch (Exception e) {
            throw e;
        }
    }

    public void zapamtiKlijenta(Klijent klijent) throws Exception {
        try {
            ZapamtiKlijentaSO zapamtiKl = new ZapamtiKlijentaSO();
            zapamtiKl.izvrsiOperaciju(klijent);
        } catch (Exception e) {
            throw e;
        }
    }

    public int vratiMaxKljucKlijent() throws Exception {
        try {
            VratiMaxKljucSO maxKljuc = new VratiMaxKljucSO();
            maxKljuc.izvrsiOperaciju(new Klijent());
            int kljuc = maxKljuc.getKljuc();
            return kljuc;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Klijent> pronadjiKlijente(Mesto mesto) throws Exception {
        try {
            List<Klijent> klijenti = new ArrayList<Klijent>();
            PronadjiKlijenteSO pronadjiKl = new PronadjiKlijenteSO(mesto);
            pronadjiKl.izvrsiOperaciju(new Klijent());
            List<OpstiDomenskiObjekat> objekti = pronadjiKl.getKlijenti();
            for (OpstiDomenskiObjekat k : objekti) {
                klijenti.add((Klijent) k);
            }
            return klijenti;
        } catch (Exception e) {
            throw e;
        }
    }

    public void obrisiKlijenta(Klijent selektovaniKlijent) throws Exception {
        try {
            ObrisiKlijentaSO obrisiklijso = new ObrisiKlijentaSO();
            obrisiklijso.izvrsiOperaciju(selektovaniKlijent);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Mesto> vratiSvaMesta() throws Exception {
        try {
            List<Mesto> listaMesta = new ArrayList<Mesto>();
            VratiSvaMestaSO vratimesta = new VratiSvaMestaSO();
            vratimesta.izvrsiOperaciju(new Mesto());
            List<OpstiDomenskiObjekat> objekti = vratimesta.getListaMesta();
            for (OpstiDomenskiObjekat odo : objekti) {
                listaMesta.add((Mesto) odo);
            }
            return listaMesta;
        } catch (Exception e) {
            throw e;
        }
    }

    public void izmeniKlijenta(Klijent selektovaniKlijent) throws Exception {
        try {
            IzmeniKlijentaSO izmeniKlSO = new IzmeniKlijentaSO();
            izmeniKlSO.izvrsiOperaciju(selektovaniKlijent);
        } catch (Exception e) {
            throw e;
        }
    }

    public void zapamtiAdvokata(Korisnik advokat) throws Exception {
        try {
            ZapamtiAdvokataSO zapamtiAdvokataSO = new ZapamtiAdvokataSO();
            zapamtiAdvokataSO.izvrsiOperaciju(advokat);
        } catch (Exception e) {
            throw e;
        }
    }

    public int vratiMaxKljucKorisnik() throws Exception {
        try {
            VratiMaxKljucSO maxKljuc = new VratiMaxKljucSO();
            maxKljuc.izvrsiOperaciju(new Korisnik());
            int kljuc = maxKljuc.getKljuc();
            return kljuc;
        } catch (Exception e) {
            throw e;
        }
    }

    public int vratiMaxKljucUsluge() throws Exception {
        try {
            VratiMaxKljucSO maxKljuc = new VratiMaxKljucSO();
            maxKljuc.izvrsiOperaciju(new Usluga());
            int kljuc = maxKljuc.getKljuc();
            return kljuc;
        } catch (Exception e) {
            throw e;
        }
    }

    public void zapamtiUslugu(Usluga usluga) throws Exception {
        try {
            ZapamtiUsluguSO zapamtiUslso = new ZapamtiUsluguSO();
            zapamtiUslso.izvrsiOperaciju(usluga);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Advokat> vratiSveAdvokate() throws Exception {
        try {
            List<Advokat> listaAdvokata = new ArrayList<Advokat>();
            VratiSveAdvokateSO vratiAdv = new VratiSveAdvokateSO();
            vratiAdv.izvrsiOperaciju(new Advokat());
            List<OpstiDomenskiObjekat> objekti = vratiAdv.getListaAdvokata();
            for (OpstiDomenskiObjekat odo : objekti) {
                listaAdvokata.add((Advokat) odo);
            }
            return listaAdvokata;
        } catch (Exception e) {
            throw e;
        }
    }

    public int vratiMaxKljucPredmet() throws Exception {
        try {
            VratiMaxKljucSO maxKljuc = new VratiMaxKljucSO();
            maxKljuc.izvrsiOperaciju(new Predmet());
            int kljuc = maxKljuc.getKljuc();
            return kljuc;
        } catch (Exception e) {
            throw e;
        }
    }

    public void zapamtiPredmet(Predmet predmet) throws Exception {
        try {
            ZapamtiPredmetSO zapamtiPr = new ZapamtiPredmetSO();
            zapamtiPr.izvrsiOperaciju(predmet);
        } catch (Exception e) {
            throw e;
        }
    }

    public int vratiMaxKljucRociste() throws Exception {
        try {
            VratiMaxKljucSO maxKljuc = new VratiMaxKljucSO();
            maxKljuc.izvrsiOperaciju(new Rociste());
            int kljuc = maxKljuc.getKljuc();
            return kljuc;
        } catch (Exception e) {
            throw e;
        }
    }

    public void zapamtiRociste(Rociste rociste) throws Exception {
        try {
            ZapamtiRocisteSO zapamtirocso = new ZapamtiRocisteSO();
            zapamtirocso.izvrsiOperaciju(rociste);
        } catch (Exception e) {
            throw e;
        }

    }

    public List<Sud> vratiSveSudove() throws Exception {
        try {
            List<Sud> listaSudova = new ArrayList<Sud>();
            VratiSveSudoveSo vratiSud = new VratiSveSudoveSo();
            vratiSud.izvrsiOperaciju(new Sud());
            List<OpstiDomenskiObjekat> objekti = vratiSud.getListaSudova();
            for (OpstiDomenskiObjekat odo : objekti) {
                listaSudova.add((Sud) odo);
            }
            return listaSudova;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Usluga> vratiSveUsluge() throws Exception {
        try {
            List<Usluga> listaUsluga = new ArrayList<Usluga>();
            VratiSveUslugeSO vratiusl = new VratiSveUslugeSO();
            vratiusl.izvrsiOperaciju(new Usluga());

            List<OpstiDomenskiObjekat> objekti = vratiusl.getListaUsluga();
            for (OpstiDomenskiObjekat odo : objekti) {
                listaUsluga.add((Usluga) odo);
            }
            return listaUsluga;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Predmet> vratiPredmeteUslov(Klijent klijent) throws Exception {
         try {
            List<Predmet> predmeti = new ArrayList<Predmet>();
            PronadjiPredmeteSO pronadjiPr = new PronadjiPredmeteSO(klijent);
            pronadjiPr.izvrsiOperaciju(new Predmet());
            List<OpstiDomenskiObjekat> objekti = pronadjiPr.getPredmeti();
            for (OpstiDomenskiObjekat p : objekti) {
                predmeti.add((Predmet) p);
                System.out.println("Predmet"+((Predmet) p).getNaziv());
            }
            return predmeti;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Predmet> vratiSvePredmete() throws Exception {
         try {
            List<Predmet> listaUsluga = new ArrayList<Predmet>();
            VratiSvePredmeteSO vratiusl = new VratiSvePredmeteSO();
            vratiusl.izvrsiOperaciju(new Predmet());

            List<OpstiDomenskiObjekat> objekti = vratiusl.getListaPredmeta();
            for (OpstiDomenskiObjekat odo : objekti) {
                listaUsluga.add((Predmet) odo);
            }
            return listaUsluga;
        } catch (Exception e) {
            throw e;
        }
    }
}
