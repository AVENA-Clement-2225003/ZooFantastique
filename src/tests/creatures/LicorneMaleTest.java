package tests.creatures;

import includes.creatures.Licorne;
import includes.creatures.LicorneMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LicorneMaleTest {

    Enclos tuto = new EnclosStandard("Tuto", 20, 5);

    @Test
    void LicorneMale(){
        Licorne l1 = new LicorneMale(50, 150, 25, "James", tuto);
        l1.setID(0);
        assertEquals("nom : James | espece : LICORNE | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", l1.toString());
    }

}