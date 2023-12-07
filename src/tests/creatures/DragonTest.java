package tests.creatures;

import includes.creatures.Dragon;
import includes.creatures.DragonMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonTest {

    Enclos tuto = new EnclosStandard("Tuto", 20, 5);

    @Test
    void Dragon(){
        Dragon d1 = new DragonMale(50, 150, 25, "James", tuto);
        d1.setID(0);
        assertEquals("nom : James | espece : DRAGON | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", d1.toString());
    }

    @Test
    void voler() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", tuto);
        assertEquals("Le dragon James vole.", d1.voler());
    }

    @Test
    void courir() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", tuto);
        assertEquals("Le dragon James court.", d1.courir());
    }

    @Test
    void nager() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", tuto);
        assertEquals("Le dragon James nage.", d1.nager());
    }

    @Test
    void emettreUnSon() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", tuto);
        assertEquals("Le dragon James fait un rugissement", d1.emettreUnSon());
    }

    @Test
    void vieillir() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", tuto);
        d1.vieillir();
        assertEquals(26, d1.getAge());
    }

    @Test
    void vieillirMort() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", tuto);
        d1.setAge(d1.getAgeMort());
        d1.vieillir();
        assertEquals(1, d1.getAge());
    }
}