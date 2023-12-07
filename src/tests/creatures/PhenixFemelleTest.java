package tests.creatures;

import includes.creatures.*;
import includes.enclos.Enclos;
import includes.enclos.EnclosVoliere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhenixFemelleTest {

    Enclos tuto = new EnclosVoliere("Tuto", 20, 5, 50);

    @Test
    void PhenixFemelle(){
        Phenix p1 = new PhenixFemelle(50, 150, 25, "Maria", tuto);
        p1.setID(0);
        assertEquals("nom : Maria | espece : PHENIX | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", p1.toString());
    }

    @Test
    void pondreOeuf() {
        PhenixFemelle d1 = new PhenixFemelle(50, 150, 25, "Maria", tuto);
        Oeuf o = d1.pondreOeuf("Marie", SexesEnum.FEMELLE, tuto);
        assertEquals("nom : Marie | espece : PHENIX | age : 0 | temps maturation restant : 1", o.toString());
    }
}