package tests.creatures;

import includes.creatures.*;
import includes.enclos.Enclos;
import includes.enclos.EnclosAquarium;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MegalodonFemelleTest {

    Enclos tuto = new EnclosAquarium("Tuto", 20, 5, 20);

    @Test
    void MegalodonFemelle(){
        Megalodon m1 = new MegalodonFemelle(50, 150, 25, "Maria", tuto);
        m1.setID(0);
        assertEquals("nom : Maria | espece : MEGALODON | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", m1.toString());
    }

    @Test
    void pondreOeuf() {
        MegalodonFemelle d1 = new MegalodonFemelle(50, 150, 25, "Maria", tuto);
        Oeuf o = d1.pondreOeuf("Marie", SexesEnum.FEMELLE, tuto);
        assertEquals("nom : Marie | espece : MEGALODON | age : 0 | temps maturation restant : 1", o.toString());
    }
}