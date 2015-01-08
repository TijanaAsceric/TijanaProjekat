/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import kontroler.Kontroler;
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
@ManagedBean(name = "mestoBean")
@ViewScoped

public class MestoBean implements Serializable{

   private Mesto mesto;
   private List<Mesto> listaMesta=new ArrayList<Mesto>();
   
    public MestoBean() {

            mesto=new Mesto();
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public List<Mesto> getListaMesta() {
        return listaMesta;
    }

    public void setListaMesta(List<Mesto> listaMesta) {
        this.listaMesta = listaMesta;
    }

   
     public List<Mesto> vratiMesta() {
        try {
           
            listaMesta=Kontroler.vratiObjekat().vratiSvaMesta();
            FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je vratio sva mesta", "");
            return listaMesta;
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne može da nađe mesta", ""));
            return null;
        }
    }
}
