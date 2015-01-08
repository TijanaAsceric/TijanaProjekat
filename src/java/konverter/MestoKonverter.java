/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package konverter;

import kontroler.Kontroler;
import domen.Mesto;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author asceric
 */
@FacesConverter(forClass = Mesto.class, value = "mestoKonverter")
public class MestoKonverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            try {
                int ptt = Integer.parseInt(value);
                List<Mesto> kuce = Kontroler.vratiObjekat().vratiSvaMesta();
                for (Mesto i : kuce) {
                    if (i.getPtt()== ptt) {
                        return i;
                    }
                }
                return null;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
            }
        } else {
            return new Mesto();
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       return String.valueOf(((Mesto) value).getPtt());
    }
    
}
