package tests.creatures;

import includes.creatures.*;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NympheFemelleTest {

    Enclos tuto = new EnclosStandard("Tuto", 20, 5);

    @Test
    void NympheFemelle(){
        Nymphe n1 = new NympheFemelle(50, 150, 25, "Maria", tuto);
        n1.setID(0);
        assertEquals("nom : Maria | espece : NYMPHE | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", n1.toString());
    }

    @Test
    void mettreBas() {
        NympheFemelle n1 = new NympheFemelle(50, 150, 25, "Maria", tuto);
        Bebe b = n1.mettreBas("Marie", SexesEnum.FEMELLE, tuto);
        assertEquals("nom : Marie | espece : NYMPHE | age : 0 | temps gestation restant : 2", b.toString());
    }
}