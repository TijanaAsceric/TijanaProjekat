/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import kontroler.Kontroler;
import domen.Klijent;
import domen.Predmet;
import domen.Rociste;
import domen.Stavkarocista;
import domen.StavkarocistaPK;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author asceric
 */
@ManagedBean(name = "rocisteBean")
@ViewScoped
public class RocisteBean implements Serializable {

    Rociste rociste;
    Stavkarocista stavka;
    int rb = 0;
    private int sat;
    private int min;
    Predmet predmet;
    @ManagedProperty(value = "#{zajednickiBean}")
    private ZajednickiBean zajednickiBean;
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;
    List<Rociste> listaRocista;
    Stavkarocista selektovanaStavka;
    Klijent klijentPretraga;
    Date datumPretaga;

    /**
     * Creates a new instance of RocisteBean
     */
    public RocisteBean() {
        rociste = new Rociste();
        predmet = new Predmet();
        rociste.setPredmetID(predmet);
        rociste.setUkupnaCena(0.0);
        stavka = new Stavkarocista();
        selektovanaStavka = new Stavkarocista();
        rociste.setStavkarocistaCollection(new ArrayList<Stavkarocista>());
        listaRocista = new ArrayList<Rociste>();
    }

    public Rociste getRociste() {
        return rociste;
    }

    public void setRociste(Rociste rociste) {
        this.rociste = rociste;
    }

    public Stavkarocista getStavka() {
        return stavka;
    }

    public void setStavka(Stavkarocista stavka) {
        this.stavka = stavka;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public ZajednickiBean getZajednickiBean() {
        return zajednickiBean;
    }

    public void setZajednickiBean(ZajednickiBean zajednickiBean) {
        this.zajednickiBean = zajednickiBean;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public List<Rociste> getListaRocista() {
        return listaRocista;
    }

    public void setListaRocista(List<Rociste> listaRocista) {
        this.listaRocista = listaRocista;
    }

    public Stavkarocista getSelektovanaStavka() {
        return selektovanaStavka;
    }

    public void setSelektovanaStavka(Stavkarocista selektovanaStavka) {
        this.selektovanaStavka = selektovanaStavka;
    }

    public Klijent getKlijentPretraga() {
        return klijentPretraga;
    }

    public void setKlijentPretraga(Klijent klijentPretraga) {
        this.klijentPretraga = klijentPretraga;
    }

    public Date getDatumPretaga() {
        return datumPretaga;
    }

    public void setDatumPretaga(Date datumPretaga) {
        this.datumPretaga = datumPretaga;
    }

    public int getSat() {
        return sat;
    }

    public void setSat(int sat) {
        this.sat = sat;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    private void postaviID() throws Exception {
        int id = Kontroler.vratiObjekat().vratiMaxKljucRociste();
        rociste.setRocisteID(id + 1);
    }

    public void dodajStavku() {
        try {
            postaviID();
            rb++;

            stavka.setStavkarocistaPK(new StavkarocistaPK(rociste.getRocisteID(), rb));
            rociste.getStavkarocistaCollection().add(stavka);
            izracunajCenu();
            stavka = new Stavkarocista(new StavkarocistaPK(rociste.getRocisteID(), rociste.getStavkarocistaCollection().size() + 1));

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Greska!");
        }
    }

    public void izracunajCenu() {
        rociste.setUkupnaCena(rociste.getUkupnaCena() + stavka.getUslugaID().getCena());

    }

    public void pokreniDodavanje() {
        stavka = new Stavkarocista();

        //stavka = new Stavkarocista(new StavkarocistaPK(rociste.getRocisteID(), rociste.getStavkarocistaCollection().size() + 1));
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, stavka.getStavkarocistaPK().getRb()+""+stavka.getStavkarocistaPK().getRocisteID()+"", ""));
    }

    public void sacuvajRociste() {
        boolean ispravanUnos = true;
        if (sat == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Niste ispravno uneli vreme", ""));
            ispravanUnos = false;
        } else {
            if (min < 10) {
                rociste.setVremeRocista(sat + ":0" + String.valueOf(min));
                ispravanUnos = true;
            } else {
                rociste.setVremeRocista(sat + ":" + String.valueOf(min));
                ispravanUnos = true;
            }
        }

        rociste.setPredmetID(zajednickiBean.getSelektovaniPredmet());
        if (rociste.getStavkarocistaCollection().isEmpty()) {
            ispravanUnos = false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Morate uneti bar jednu stavku", ""));
        }
        if (rociste.getDatumRocista().compareTo((new Date())) < 0) {
            ispravanUnos = false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Izabrani datum je prosao", ""));

        }

        if (ispravanUnos) {
            try {
                postaviID();
                Kontroler.vratiObjekat().zapamtiRociste(rociste);
                rociste = new Rociste();
                rociste.setStavkarocistaCollection(new ArrayList<Stavkarocista>());
                rb = 0;
                sat=0;
                min=0;

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je zapamtio rociste", ""));
            } catch (Exception ex) {
                ex.printStackTrace();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da zapamti rociste", ""));
            }
        }

    }

    public void izvrsiValidaciju() {
        if (selektovanaStavka == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Morate selektovati stavku", ""));
        } else {
            RequestContext.getCurrentInstance().execute("obrisiDlg.show()");
        }
    }

    public void izbrisiStavku() {
        rociste.getStavkarocistaCollection().remove(selektovanaStavka);
        rociste.setUkupnaCena(rociste.getUkupnaCena() - selektovanaStavka.getUslugaID().getCena());

    }

}
