/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import kontroler.Kontroler;
import domen.Klijent;
import domen.Mesto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author asceric
 */
@ManagedBean(name = "klijentBean")
@ViewScoped
public class KlijentBean implements Serializable {

    private Klijent klijent;
    private List<Klijent> prikazanKlijent;
    private Mesto mesto;
    private Klijent selektovaniKlijent;
    private List<Klijent> klijenti = new ArrayList<Klijent>();
    private List<Klijent> filtriraniKlijenti;

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public List<Klijent> getPrikazanKlijent() {
        return prikazanKlijent;
    }

    public void setPrikazanKlijent(List<Klijent> prikazanKlijent) {
        this.prikazanKlijent = prikazanKlijent;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public Klijent getSelektovaniKlijent() {
        return selektovaniKlijent;
    }

    public void setSelektovaniKlijent(Klijent selektovaniKlijent) {
        this.selektovaniKlijent = selektovaniKlijent;
    }

    public List<Klijent> getKlijenti() {
        return klijenti;
    }

    public void setKlijenti(List<Klijent> klijenti) {
        this.klijenti = klijenti;
    }

    public List<Klijent> getFiltriraniKlijenti() {
        return filtriraniKlijenti;
    }

    public void setFiltriraniKlijenti(List<Klijent> filtriraniKlijenti) {
        this.filtriraniKlijenti = filtriraniKlijenti;
    }

    

  
    

    /**
     * Creates a new instance of KlijentBean
     */
    public KlijentBean() {
        klijent=new Klijent();
       //prikazanKlijent=vratiSveKlijente();
        mesto=new Mesto();
        

    }

    

    public void sacuvajKlijenta() throws Exception {
        String poruka =validacijaPodataka();
       
         if (!poruka.isEmpty()) {
            String[] poruke = poruka.split(",");
            for (String por : poruke) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, por, ""));
            }
        } else {
            try {
                postaviID();

                Kontroler.vratiObjekat().zapamtiKlijenta(klijent);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je zapamtio klijenta", ""));
               
                klijent=new Klijent();

            } catch (Exception ex) {
                ex.printStackTrace();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da zapamti klijenta", ""));
            }
        }
    }

    private void postaviID() throws Exception {
        int klijentid = Kontroler.vratiObjekat().vratiMaxKljucKlijent();
        klijent.setKlijentID(klijentid+1);
    }

    public void vratiKlijente() {
        try {
            prikazanKlijent = Kontroler.vratiObjekat().pronadjiKlijente(mesto);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da nađe klijente po zadatim vrednostima", ""));
        }

    }

    public List<Klijent> vratiSveKlijente() {
        try {
            klijenti = Kontroler.vratiObjekat().vratiSveKlijente();
            return klijenti;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da nađe klijente", ""));
            return null;
        }

    }

    public void obrisiKlijenta() {
        try {
            Kontroler.vratiObjekat().obrisiKlijenta(selektovaniKlijent);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je obrisao klijenta", ""));
           
            selektovaniKlijent=new Klijent();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sistem ne može da obriše klijenta", ""));
        }
    }
     public void izmeniKlijenta() throws Exception {
            try {
                Kontroler.vratiObjekat().izmeniKlijenta(selektovaniKlijent);
                selektovaniKlijent = new Klijent();
                filtriraniKlijenti= null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je izmenio klijenta", ""));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da izmeni klijenta", ""));
            }
        }
     
     public String validacijaPodataka() throws Exception {
     String poruka = null;
     
       if (!klijent.getEmail().contains("@") || !klijent.getEmail().contains(".")) {
            poruka = "Niste ispravno uneli email,";
            
        }
        if (klijent.getFiksniTelefon() != null) {
            try {
                Long.parseLong(klijent.getFiksniTelefon());
            } catch (Exception e) {
                poruka += "Niste ispravno uneli fiksni broj telefona,";
               
            }
        }
        if (klijent.getMobilniTelefon()!= null) {
            try {
                Long.parseLong(klijent.getMobilniTelefon());
            } catch (Exception e) {
                poruka += "Niste ispravno uneli mobilni broj telefona,";
               
                
            }
        }
       
        return poruka;
     
     }
}
