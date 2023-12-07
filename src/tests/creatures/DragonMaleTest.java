package tests.creatures;

import includes.creatures.Dragon;
import includes.creatures.DragonMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonMaleTest {

    Enclos tuto = new EnclosStandard("Tuto", 20, 5);

    @Test
    void DragonMale(){
        Dragon d1 = new DragonMale(50, 150, 25, "James", tuto);
        d1.setID(0);
        assertEquals("nom : James | espece : DRAGON | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", d1.toString());
    }
}