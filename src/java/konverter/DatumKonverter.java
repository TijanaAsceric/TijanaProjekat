/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package konverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author asceric
 */
@FacesConverter(forClass = Date.class, value = "datumKonverter")
public class DatumKonverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            return sdf.parse(value);
        } catch (ParseException ex) {
            FacesContext.getCurrentInstance().addMessage(component.getClientId(), new FacesMessage("Greska"));
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(value);
    }
    
}
