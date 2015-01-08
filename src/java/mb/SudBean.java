/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import kontroler.Kontroler;
import domen.Sud;
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
@ManagedBean(name = "sudBean")
@ViewScoped
public class SudBean implements Serializable {

    private Sud sud;
    private List<Sud> sudovi = new ArrayList<Sud>();

   
    public SudBean() {
        sud=new Sud();
    }

    public Sud getSud() {
        return sud;
    }

    public void setSud(Sud sud) {
        this.sud = sud;
    }

    public List<Sud> getSudovi() {
        return sudovi;
    }

    public void setSudovi(List<Sud> sudovi) {
        this.sudovi = sudovi;
    }

 
     public List<Sud> vratiSudove() {
        try {
            sudovi = Kontroler.vratiObjekat().vratiSveSudove();
            return sudovi;
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da nađe sudove ", ""));
            return null;
        }
    }
}
