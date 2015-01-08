/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import domen.Klijent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asceric
 */
public class KlijentBeanTest {

    public KlijentBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void validirajPodatke() throws Exception {
        System.out.println("Testiranje...");
        KlijentBean kb = new KlijentBean();
        Klijent k = new Klijent();
        k.setEmail("tijana@.");
        k.setMobilniTelefon("1233");
        k.setFiksniTelefon("125555");
        kb.setKlijent(k);
        String result = kb.validacijaPodataka();
        assertNull("Neispravni podaci", result);

    }
}
