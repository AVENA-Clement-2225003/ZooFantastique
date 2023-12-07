package tests.creatures;

import includes.creatures.Lycanthrope;
import includes.creatures.LycanthropeMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LycanthropeMaleTest {

    Enclos tuto = new EnclosStandard("Tuto", 20, 5);

    @Test
    void LicorneMale(){
        Lycanthrope l1 = new LycanthropeMale(50, 150, 25, "James", tuto);
        l1.setID(0);
        assertEquals("nom : James | espece : LYCANTHROPE | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", l1.toString());
    }

}