package tests.creatures;

import includes.creatures.Nymphe;
import includes.creatures.NympheMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NympheTest {

    Enclos tuto = new EnclosStandard("Tuto", 20, 5);

    @Test
    void Nymphe(){
        Nymphe n1 = new NympheMale(50, 150, 25, "James", tuto);
        n1.setID(0);
        assertEquals("nom : James | espece : NYMPHE | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", n1.toString());
    }

    @Test
    void emettreUnSon() {
        Nymphe n1 = new NympheMale(50, 150, 25, "James", tuto);
        assertEquals("La nymphe James parle", n1.emettreUnSon());
    }

    @Test
    void vieillir() {
        Nymphe n1 = new NympheMale(50, 150, 25, "James", tuto);
        n1.vieillir();
        assertEquals(26, n1.getAge());
    }

    @Test
    void vieillirMort() {
        Nymphe n1 = new NympheMale(50, 150, 25, "James", tuto);
        n1.setAge(n1.getAgeMort());
        n1.vieillir();
        assertEquals(1, n1.getAge());
    }
}