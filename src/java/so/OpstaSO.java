/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import javax.persistence.EntityManager;

public abstract class OpstaSO {

    protected EntityManager em;

    public final void izvrsiOperaciju(Object o) throws Exception {
        try {
            DBBroker.vratiObjekat().zapocniTransakciju();
            izvrsiKonkretnuOperaciju(o);
            DBBroker.vratiObjekat().commit();
        } catch (Exception e) {
            DBBroker.vratiObjekat().rollback();
            throw e;
        } finally {
            DBBroker.vratiObjekat().zatvoriEntityManager();
        }
    }

    public abstract void izvrsiKonkretnuOperaciju(Object objekat) throws Exception;
}
