package tests.creatures;

import includes.creatures.Dragon;
import includes.creatures.DragonFemelle;
import includes.creatures.SexesEnum;
import includes.creatures.Oeuf;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonFemelleTest {

    Enclos tuto = new EnclosStandard("Tuto", 20, 5);

    @Test
    void DragonFemelle(){
        Dragon d1 = new DragonFemelle(50, 150, 25, "Maria", tuto);
        d1.setID(0);
        assertEquals("nom : Maria | espece : DRAGON | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", d1.toString());
    }

    @Test
    void pondreOeuf() {
        DragonFemelle d1 = new DragonFemelle(50, 150, 25, "Maria", tuto);
        Oeuf o = d1.pondreOeuf("Marie", SexesEnum.FEMELLE, tuto);
        assertEquals("nom : Marie | espece : DRAGON | age : 0 | temps maturation restant : 1", o.toString());
    }
}