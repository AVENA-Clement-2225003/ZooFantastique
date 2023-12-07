package tests.creatures;

import includes.creatures.Megalodon;
import includes.creatures.MegalodonMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosAquarium;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MegalodonMaleTest {

    Enclos tuto = new EnclosAquarium("Tuto", 20, 5, 20);

    @Test
    void MegalodonMale(){
        Megalodon m1 = new MegalodonMale(50, 150, 25, "James", tuto);
        m1.setID(0);
        assertEquals("nom : James | espece : MEGALODON | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", m1.toString());
    }

}