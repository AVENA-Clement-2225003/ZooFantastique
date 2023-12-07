package tests.creatures;

import includes.creatures.Phenix;
import includes.creatures.PhenixMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosVoliere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhenixMaleTest {

    Enclos tuto = new EnclosVoliere("Tuto", 20, 5, 50);

    @Test
    void PhenixMale(){
        Phenix p1 = new PhenixMale(50, 150, 25, "James", tuto);
        p1.setID(0);
        assertEquals("nom : James | espece : PHENIX | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", p1.toString());
    }


}