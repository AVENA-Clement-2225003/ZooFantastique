package tests.creatures;

import includes.creatures.Megalodon;
import includes.creatures.MegalodonMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosAquarium;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MegalodonTest {

    Enclos tuto = new EnclosAquarium("Tuto", 20, 5, 8);

    @Test
    void Megalodon(){
        Megalodon m1 = new MegalodonMale(50, 150, 25, "James", tuto);
        m1.setID(0);
        assertEquals("nom : James | espece : MEGALODON | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", m1.toString());
    }

    @Test
    void nager() {
        Megalodon m1 = new MegalodonMale(50, 150, 25, "James", tuto);
        assertEquals("Le megalodon James nage.", m1.nager());
    }

    @Test
    void emettreUnSon() {
        Megalodon m1 = new MegalodonMale(50, 150, 25, "James", tuto);
        assertEquals("Le megalodon James fait un hurlement", m1.emettreUnSon());
    }

    @Test
    void vieillir() {
        Megalodon m1 = new MegalodonMale(50, 150, 25, "James", tuto);
        m1.vieillir();
        assertEquals(26, m1.getAge());
    }
}