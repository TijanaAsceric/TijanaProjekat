/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import kontroler.Kontroler;
import domen.Advokat;
import domen.Korisnik;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name = "advokatBean")
@ViewScoped
public class AdvokatBean implements Serializable {


    private Advokat advokat;
    private List<Advokat> listaAdvokata=new ArrayList<Advokat>();
    private List<Advokat> filtriraniAdvokati;
    private Advokat seletovaniAdvokat;
    private Korisnik korisnik;

    public AdvokatBean() throws Exception {
        advokat=new Advokat();
        korisnik=new Korisnik();
        advokat.setKorisnik(korisnik);
        seletovaniAdvokat=new Advokat();
    }

    public Advokat getAdvokat() {
        return advokat;
    }

    public void setAdvokat(Advokat advokat) {
        this.advokat = advokat;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    

   
    

    public List<Advokat> getListaAdvokata() {
        return listaAdvokata;
    }

    public void setListaAdvokata(List<Advokat> listaAdvokata) {
        this.listaAdvokata = listaAdvokata;
    }

    public List<Advokat> getFiltriraniAdvokati() {
        return filtriraniAdvokati;
    }

    public void setFiltriraniAdvokati(List<Advokat> filtriraniAdvokati) {
        this.filtriraniAdvokati = filtriraniAdvokati;
    }

    public Advokat getSeletovaniAdvokat() {
        return seletovaniAdvokat;
    }

    public void setSeletovaniAdvokat(Advokat seletovaniAdvokat) {
        this.seletovaniAdvokat = seletovaniAdvokat;
    }

    
    

    public void sacuvajAdvokata() throws Exception {
      String poruka = "";
       if (!korisnik.getEmail().contains("@") || !korisnik.getEmail().contains(".")) {
            poruka += "Niste ispravno uneli email,";
        } if (!poruka.isEmpty()) {
            String[] poruke = poruka.split(",");
            for (String por : poruke) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, por, ""));
            }
        } else {
            try {
                postaviID();
               
               
                korisnik.setTip(0);
                Korisnik k=advokat.getKorisnik();
                k.setAdvokat(advokat);
                advokat.setKorisnik(korisnik);
               Kontroler.vratiObjekat().zapamtiAdvokata(k);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je zapamtio advokata", ""));
              advokat=new Advokat();
              korisnik=new Korisnik();
            } catch (Exception e) {
                e.printStackTrace();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da zapamti advokata", ""));
            }
        }
    
    }
    

    private void postaviID() throws Exception {
        int id = Kontroler.vratiObjekat().vratiMaxKljucKorisnik();
        advokat.setAdvokatID(id+1);
        advokat.getKorisnik().setKorisnikID(id+1);
    }

    public List<Advokat> vratiAdvokate() {
        try {
            listaAdvokata = Kontroler.vratiObjekat().vratiSveAdvokate();
            return listaAdvokata;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da vrati advokate", ""));
            return null;
        }
    }

}
