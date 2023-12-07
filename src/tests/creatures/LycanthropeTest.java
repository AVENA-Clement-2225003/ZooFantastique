package tests.creatures;

import includes.creatures.Lycanthrope;
import includes.creatures.LycanthropeMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LycanthropeTest {

    Enclos tuto = new EnclosStandard("Tuto", 20, 5);

    @Test
    void Lycanthrope(){
        Lycanthrope l1 = new LycanthropeMale(50, 150, 25, "James", tuto);
        l1.setID(0);
        assertEquals("nom : James | espece : LYCANTHROPE | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", l1.toString());
    }

    @Test
    void courir() {
        Lycanthrope l1 = new LycanthropeMale(50, 150, 25, "James", tuto);
        assertEquals("Le lycanthrope James court.", l1.courir());
    }

    @Test
    void emettreUnSon() {
        Lycanthrope l1 = new LycanthropeMale(50, 150, 25, "James", tuto);
        assertEquals("Le lycanthrope James fait un hurlement", l1.emettreUnSon());
    }

    @Test
    void vieillir() {
        Lycanthrope l1 = new LycanthropeMale(50, 150, 25, "James", tuto);
        l1.vieillir();
        assertEquals(26, l1.getAge());
    }
}