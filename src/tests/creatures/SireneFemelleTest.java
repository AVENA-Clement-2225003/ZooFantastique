package tests.creatures;

import includes.creatures.*;
import includes.enclos.Enclos;
import includes.enclos.EnclosAquarium;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SireneFemelleTest {

    Enclos tuto = new EnclosAquarium("Tuto", 20, 5, 20);

    @Test
    void SireneMale(){
        Sirene s1 = new SireneFemelle(50, 150, 25, "Maria", tuto);
        s1.setID(0);
        assertEquals("nom : Maria | espece : SIRENE | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", s1.toString());
    }

    @Test
    void mettreBas() {
        SireneFemelle s1 = new SireneFemelle(50, 150, 25, "Maria", tuto);
        Bebe b = s1.mettreBas("Marie", SexesEnum.FEMELLE, tuto);
        assertEquals("nom : Marie | espece : SIRENE | age : 0 | temps gestation restant : 2", b.toString());
    }
}