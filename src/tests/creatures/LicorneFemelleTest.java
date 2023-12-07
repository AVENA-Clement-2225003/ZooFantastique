package tests.creatures;

import includes.creatures.*;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LicorneFemelleTest {

    Enclos tuto = new EnclosStandard("Tuto", 20, 5);

    @Test
    void LicorneFemelle(){
        Licorne l1 = new LicorneFemelle(50, 150, 25, "Maria", tuto);
        l1.setID(0);
        assertEquals("nom : Maria | espece : LICORNE | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", l1.toString());
    }


    @Test
    void mettreBas() {
        LicorneFemelle l1 = new LicorneFemelle(50, 150, 25, "Maria", tuto);
        Bebe b = l1.mettreBas("Marie", SexesEnum.FEMELLE, tuto);
        assertEquals("nom : Marie | espece : LICORNE | age : 0 | temps gestation restant : 2", b.toString());
    }
}