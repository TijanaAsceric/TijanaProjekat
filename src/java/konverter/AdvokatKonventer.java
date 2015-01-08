/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package konverter;

import kontroler.Kontroler;
import domen.Advokat;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author asceric
 */
@FacesConverter(forClass = Advokat.class, value = "advokatKonverter")
public class AdvokatKonventer implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       if (value != null) {
            try {
                int advID = Integer.parseInt(value);
                List<Advokat> advokati = Kontroler.vratiObjekat().vratiSveAdvokate();
                for (Advokat a : advokati) {
                    if (a.getAdvokatID()==advID) {
                        return a;
                    }
                }
                return null;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
            }
        } else {
            return new Advokat();
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
          return String.valueOf(((Advokat)value).getAdvokatID());
    }
    
}
