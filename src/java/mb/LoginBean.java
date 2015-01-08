/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import kontroler.Kontroler;
import domen.Administrator;
import domen.Advokat;
import domen.Korisnik;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author asceric
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    Korisnik korisnik;
    private boolean ulogovan = false;
    private boolean admin=false;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        korisnik = new Korisnik();
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public boolean isUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    

    public String vratiDatum() {
        Date datum = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String d = sdf.format(datum);
        return d;

    }
    public String vratiTipKorisnika(){
    if(korisnik.getTip()==1){
    return "Administrator";
    }
    else{
    return "Zaposleni";
    }
    
    }

    public void login() {
        if (!ulogovan) {
            FacesMessage msg = null;
            Korisnik k = null;
            try {
    
                k = Kontroler.vratiObjekat().vratiKorisnika(korisnik);
                if (k != null) {
                    ulogovan = true;
                    korisnik.setKorisnikID(k.getKorisnikID());
                    korisnik.setEmail(k.getEmail());
                    korisnik.setIme(k.getIme());
                    korisnik.setPrezime(k.getPrezime());
                    korisnik.setTip(k.getTip());
                    
                    if(korisnik.getTip()==1){
                    admin=true;
                    }
                    
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dobrodošli, " + k.toString(), "");

                } else {

                    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Uneli ste pogrešno korisničko ime ili lozinku", null);
                }
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception ex) {
                ex.printStackTrace();
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da nađe korisnika na osnovu unetih vrednosti", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        }
    }
     public String izlogujSe() {
       korisnik=new Korisnik();
        ulogovan = false;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }
     

}
