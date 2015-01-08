/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package konverter;

import kontroler.Kontroler;
import domen.Sud;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author asceric
 */
@FacesConverter(forClass = Sud.class, value = "sudKonverter")
public class SudKonventer implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       if (value != null) {
            try {
                int sudID = Integer.parseInt(value);
                List<Sud> sudovi = Kontroler.vratiObjekat().vratiSveSudove();
                for (Sud s : sudovi) {
                    if (s.getSudID()==sudID) {
                        return s;
                    }
                }
                return null;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
            }
        } else {
            return new Sud();
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
          return String.valueOf(((Sud) value).getSudID());
    }
    
}
