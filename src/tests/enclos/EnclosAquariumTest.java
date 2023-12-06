package tests.enclos;

import includes.enclos.EnclosAquarium;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnclosAquariumTest {
    @Test
    public void testEnclosAquariumSimple() {
        EnclosAquarium E1 = new EnclosAquarium("Enclos1", 140, 25, 12);
        assertEquals("Enclos: Enclos1 | Superficie: 140 | Capacitée: 25 | Propretée: BON", E1.toString());
    }
    @Test
    public void testEnclosAquariumToutParametre() {
        EnclosAquarium E1 = new EnclosAquarium("Enclos1", 140, 25, includes.enclos.PropreteEnum.BON, new ArrayList<>(), 12, true);
        assertEquals("Enclos: Enclos1 | Superficie: 140 | Capacitée: 25 | Propretée: BON", E1.toString());
    }

    @Test
    void getProfondeur() {
        EnclosAquarium E1 = new EnclosAquarium("Enclos1", 140, 25, includes.enclos.PropreteEnum.BON, new ArrayList<>(), 12, true);
        assertEquals(12, E1.getProfondeur());
    }

    @Test
    void setProfondeur() {
        EnclosAquarium E1 = new EnclosAquarium("Enclos1", 140, 25, includes.enclos.PropreteEnum.BON, new ArrayList<>(), 12, true);
        E1.setProfondeur(15);
        assertEquals(15, E1.getProfondeur());
    }

    @Test
    void isSaliniteBassinOK() {
        EnclosAquarium E1 = new EnclosAquarium("Enclos1", 140, 25, includes.enclos.PropreteEnum.BON, new ArrayList<>(), 12, true);
        assertEquals(true, E1.isSaliniteBassinOK());
    }

    @Test
    void setSaliniteBassinOK() {
        EnclosAquarium E1 = new EnclosAquarium("Enclos1", 140, 25, includes.enclos.PropreteEnum.BON, new ArrayList<>(), 12, true);
        E1.setSaliniteBassinOK(false);
        assertEquals(false, E1.isSaliniteBassinOK());
    }

    @Test
    void entretientEnclos() {
        EnclosAquarium E1 = new EnclosAquarium("Enclos1", 140, 25, includes.enclos.PropreteEnum.BON, new ArrayList<>(), 12, false);
        assertEquals(0, E1.entretientEnclos());
    }
}