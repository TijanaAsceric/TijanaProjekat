/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package konverter;

import kontroler.Kontroler;
import domen.Usluga;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author asceric
 */
@FacesConverter(forClass = Usluga.class, value = "uslugaKonverter")
public class UslugaKonverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            try {
                int id = Integer.parseInt(value);
                List<Usluga> listausluga = Kontroler.vratiObjekat().vratiSveUsluge();
                for (Usluga u : listausluga) {
                    if (u.getUslugaID()==id) {
                        return u;
                    }
                }
                return null;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
            }
        } else {
            return new Usluga();
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       return String.valueOf(((Usluga) value).getUslugaID());
    }
    
}
