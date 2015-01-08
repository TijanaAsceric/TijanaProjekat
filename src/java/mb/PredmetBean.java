/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Advokat;
import domen.Klijent;
import domen.Korisnik;
import domen.Predmet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import kontroler.Kontroler;



/**
 *
 * @author asceric
 */
@ManagedBean(name = "predmetBean")
@ViewScoped
public class PredmetBean implements Serializable{
private Predmet predmet;
private Advokat advokat;
private Klijent klijent;
 @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;
private List<Predmet> listaPredmeta=new ArrayList<Predmet>();
private List<Predmet> prikazaniPredmeti;
@ManagedProperty(value = "#{klijentBean}")
private KlijentBean klijentBean;
    /**
     * Creates a new instance of PredmetBean
     */
    public PredmetBean() {
        predmet=new Predmet();
       
        advokat=new Advokat();
        prikazaniPredmeti=vratiSvePredmete();
        predmet.setDatum(new Date());
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    

    public Predmet getPredmet() {
        return predmet;
    }

    public Advokat getAdvokat() {
        return advokat;
    }

    public void setAdvokat(Advokat advokat) {
        this.advokat = advokat;
    }

    public List<Predmet> getPrikazaniPredmeti() {
        return prikazaniPredmeti;
    }

    public void setPrikazaniPredmeti(List<Predmet> prikazaniPredmeti) {
        this.prikazaniPredmeti = prikazaniPredmeti;
    }

    public List<Predmet> getListaPredmeta() {
        return listaPredmeta;
    }

    public void setListaPredmeta(List<Predmet> listaPredmeta) {
        this.listaPredmeta = listaPredmeta;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public KlijentBean getKlijentBean() {
        return klijentBean;
    }

    public void setKlijentBean(KlijentBean klijentBean) {
        this.klijentBean = klijentBean;
    }
    
    
    
    
    private void postaviID() throws Exception {
        int predmetID = Kontroler.vratiObjekat().vratiMaxKljucPredmet();
        predmet.setPredmetID(predmetID+1);
    }
     public void sacuvajPredmet() throws Exception {
      
            try {
                postaviID();
                
                
                predmet.setAdvokatID(loginBean.getKorisnik());
               Kontroler.vratiObjekat().zapamtiPredmet(predmet);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je zapamtio predmet", ""));
              predmet=new Predmet(); 
              predmet.setDatum(new Date());
            } catch (Exception e) {
                e.printStackTrace();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da zapamti predmet", ""));
            }
        }
     public void vratiPredmetePoUslovu(){
         try{
             
     prikazaniPredmeti=Kontroler.vratiObjekat().vratiPredmeteUslov(klijent);
     if(!prikazaniPredmeti.isEmpty()){
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je pronasao predmete po zadatim vrednostima", ""));
     }
     else{
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da nađe predmete po zadatim vrednostima", ""));
     }
     
     } catch (Exception ex) {
         ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da nađe predmete po zadatim vrednostima", ""));
        }
   
             
     
     }

    private List<Predmet> vratiSvePredmete() {
         try {
             
            listaPredmeta= Kontroler.vratiObjekat().vratiSvePredmete();
            
            return listaPredmeta;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da nađe predmete", ""));
            return null;
        }
    }
    
}
