package tests.creatures;

import includes.creatures.*;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BebeTest {

    Enclos tuto = new EnclosStandard("Tuto", 20, 5);
    LicorneFemelle l1 = new LicorneFemelle(500, 200, 25, "Maria", tuto);

    @Test
    void testToString() {
        Bebe l2 = l1.mettreBas("James", SexesEnum.MALE, tuto);
        assertEquals("nom : James | espece : LICORNE | age : 0 | temps gestation restant : 2", l2.toString());
    }

    @Test
    void getTempsNaissance() {
        Bebe l2 = l1.mettreBas("James", SexesEnum.MALE, tuto);
        assertEquals(2, l2.getTempsNaissance());
    }

    @Test
    void getTempsGestation() {
        Bebe l2 = l1.mettreBas("James", SexesEnum.MALE, tuto);
        assertEquals(0, l2.getTempsGestation());
    }

    @Test
    void setTempsGestation() {
        Bebe l2 = l1.mettreBas("James", SexesEnum.MALE, tuto);
        assertEquals(0, l2.getTempsGestation());
        l2.setTempsGestation(3);
        assertEquals(3, l2.getTempsGestation());
    }

    @Test
    void emettreUnSon() {
        Bebe l2 = l1.mettreBas("James", SexesEnum.MALE, tuto);
        assertNull(l2.emettreUnSon());
    }

    @Test
    void getMere() {
        Bebe l2 = l1.mettreBas("James", SexesEnum.MALE, tuto);
        assertEquals("Maria", l2.getMere().getNom());
    }

    @Test
    void setMere() {
        Bebe l2 = l1.mettreBas("James", SexesEnum.MALE, tuto);
        assertEquals("Maria", l2.getMere().getNom());
        LicorneFemelle l3 = new LicorneFemelle(500, 200, 30, "Josee", tuto);
        l2.setMere(l3);
        assertEquals("Josee", l2.getMere().getNom());
    }
}