package tests.creatures;

import includes.creatures.Nymphe;
import includes.creatures.NympheMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NympheMaleTest {

    Enclos tuto = new EnclosStandard("Tuto", 20, 5);

    @Test
    void NympheMale(){
        Nymphe n1 = new NympheMale(50, 150, 25, "James", tuto);
        n1.setID(0);
        assertEquals("nom : James | espece : NYMPHE | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", n1.toString());
    }

}