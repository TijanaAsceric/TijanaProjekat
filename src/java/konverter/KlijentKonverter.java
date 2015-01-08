/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package konverter;

import kontroler.Kontroler;
import domen.Klijent;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author asceric
 */
@FacesConverter(forClass = Klijent.class, value = "klijentKonverter")
public class KlijentKonverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       if (value != null) {
            try {
                int kliID = Integer.parseInt(value);
                List<Klijent> klijenti = Kontroler.vratiObjekat().vratiSveKlijente();
                for (Klijent k : klijenti) {
                    if (k.getKlijentID()==kliID) {
                        return k;
                    }
                }
                return null;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
            }
        } else {
            return new Klijent();
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
          return String.valueOf(((Klijent) value).getKlijentID());
    }
    
}
