package tests.enclos;

import includes.enclos.EnclosVoliere;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class EnclosVoliereTest {
    @Test
    public void testEnclosVoliereSimple() {
        EnclosVoliere EV1 = new EnclosVoliere("Enclos1", 140, 20, 15);
        assertEquals("Enclos: Enclos1 | Superficie: 140 | Capacitée: 20 | Propretée: BON | toit ok: oui | hauteur: 15", EV1.toString());
    }
    @Test
    public void testEnclosVoliereToutParametres() {
        EnclosVoliere EV1 = new EnclosVoliere("Enclos1", 140, 20, includes.enclos.PropreteEnum.BON, new ArrayList<>(), true, 15);
        assertEquals("Enclos: Enclos1 | Superficie: 140 | Capacitée: 20 | Propretée: BON | toit ok: oui | hauteur: 15", EV1.toString());
    }
}