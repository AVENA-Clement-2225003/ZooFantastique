package tests.creatures;

import includes.creatures.Sirene;
import includes.creatures.SireneMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosAquarium;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SireneMaleTest {

    Enclos tuto = new EnclosAquarium("Tuto", 20, 5, 20);

    @Test
    void SireneMale(){
        Sirene s1 = new SireneMale(50, 150, 25, "James", tuto);
        s1.setID(0);
        assertEquals("nom : James | espece : SIRENE | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", s1.toString());
    }

}