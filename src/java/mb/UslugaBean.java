/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import kontroler.Kontroler;
import domen.Advokat;
import domen.Usluga;
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
@ManagedBean(name = "uslugaBean")
@ViewScoped
public class UslugaBean implements Serializable {

    private Usluga usluga;
    private Usluga selektovanaUsluga;
    private List<Usluga> filtriraneUsluge;
    private List<Usluga> listausluga=new ArrayList<Usluga>();

    /**
     * Creates a new instance of UslugaBean
     */
    public UslugaBean() {
        usluga = new Usluga();

        selektovanaUsluga = new Usluga();
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    public Usluga getSelektovanaUsluga() {
        return selektovanaUsluga;
    }

    public void setSelektovanaUsluga(Usluga selektovanaUsluga) {
        this.selektovanaUsluga = selektovanaUsluga;
    }

    public List<Usluga> getFiltriraneUsluge() {
        return filtriraneUsluge;
    }

    public void setFiltriraneUsluge(List<Usluga> filtriraneUsluge) {
        this.filtriraneUsluge = filtriraneUsluge;
    }

    public List<Usluga> getListausluga() {
        return listausluga;
    }

    public void setListausluga(List<Usluga> listausluga) {
        this.listausluga = listausluga;
    }
    

    public void sacuvajUslugu() throws Exception {
        String poruka = "";
        if (usluga.getCena() == 0) {
            poruka += "Niste ispravno uneli cenu,";

        }
        if (!poruka.isEmpty()) {
            String[] poruke = poruka.split(",");
            for (String por : poruke) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, por, ""));
            }
        } else {

            try {
                postaviID();
                Kontroler.vratiObjekat().zapamtiUslugu(usluga);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je zapamtio uslugu", ""));
                usluga = new Usluga();
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da zapamti uslugu", ""));
            }
        }
    }

    private void postaviID() throws Exception {
        int id = Kontroler.vratiObjekat().vratiMaxKljucUsluge();
        usluga.setUslugaID(id + 1);
    }
    
    public List<Usluga> vratiUsluge(){
          try {
           
            listausluga=Kontroler.vratiObjekat().vratiSveUsluge();
            return listausluga;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da nađe usluge", ""));
            return null;
        }
    
    
    }

}
