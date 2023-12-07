package tests.creatures;

import includes.creatures.*;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OeufTest {

    Enclos tuto = new EnclosStandard("Tuto", 20, 5);
    DragonFemelle d1 = new DragonFemelle(500, 200, 25, "Maria", tuto);


    @Test
    void testToString() {
        Oeuf d2 = d1.pondreOeuf("James", SexesEnum.MALE, tuto);
        assertEquals("nom : James | espece : DRAGON | age : 0 | temps maturation restant : 1", d2.toString());
    }

    @Test
    void getTempsEclosion() {
        Oeuf d2 = d1.pondreOeuf("James", SexesEnum.MALE, tuto);
        assertEquals(1, d2.getTempsEclosion());
    }

    @Test
    void getTempsMaturation() {
        Oeuf d2 = d1.pondreOeuf("James", SexesEnum.MALE, tuto);
        assertEquals(0, d2.getTempsMaturation());
    }

    @Test
    void setTempsMaturation() {
        Oeuf d2 = d1.pondreOeuf("James", SexesEnum.MALE, tuto);
        assertEquals(0, d2.getTempsMaturation());
        d2.setTempsMaturation(3);
        assertEquals(3, d2.getTempsMaturation());
    }

    @Test
    void emettreUnSon() {
        Oeuf d2 = d1.pondreOeuf("James", SexesEnum.MALE, tuto);
        assertNull(d2.emettreUnSon());
    }

    @Test
    void getMere() {
        Oeuf d2 = d1.pondreOeuf("James", SexesEnum.MALE, tuto);
        assertEquals("Maria", d2.getMere().getNom());
    }

    @Test
    void setMere() {
        Oeuf d2 = d1.pondreOeuf("James", SexesEnum.MALE, tuto);
        assertEquals("Maria", d2.getMere().getNom());
        DragonFemelle d3 = new DragonFemelle(500, 200, 30, "Josee", tuto);
        d2.setMere(d3);
        assertEquals("Josee", d2.getMere().getNom());
    }
}