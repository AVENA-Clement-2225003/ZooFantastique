package tests.creatures;

import includes.creatures.Phenix;
import includes.creatures.PhenixMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosVoliere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhenixTest {

    Enclos tuto = new EnclosVoliere("Tuto", 20, 5, 50);

    @Test
    void Phenix(){
        Phenix p1 = new PhenixMale(50, 150, 25, "James", tuto);
        p1.setID(0);
        assertEquals("nom : James | espece : PHENIX | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", p1.toString());
    }

    @Test
    void voler() {
        Phenix p1 = new PhenixMale(50, 150, 25, "James", tuto);
        assertEquals("Le phenix James vole.", p1.voler());
    }

    @Test
    void emettreUnSon() {
        Phenix p1 = new PhenixMale(50, 150, 25, "James", tuto);
        assertEquals("Le phenix James pialle", p1.emettreUnSon());
    }

    @Test
    void vieillir() {
        Phenix p1 = new PhenixMale(50, 150, 25, "James", tuto);
        p1.vieillir();
        assertEquals(26, p1.getAge());
    }
}