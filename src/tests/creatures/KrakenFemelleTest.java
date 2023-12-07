package tests.creatures;

import includes.creatures.*;
import includes.enclos.Enclos;
import includes.enclos.EnclosAquarium;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KrakenFemelleTest {

    Enclos tuto = new EnclosAquarium("Tuto", 20, 5, 20);

    @Test
    void KrakenFemelle(){
        Kraken k1 = new KrakenFemelle(50, 150, 25, "Maria", tuto);
        k1.setID(0);
        assertEquals("nom : Maria | espece : KRAKEN | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", k1.toString());
    }

    @Test
    void pondreOeuf() {
        KrakenFemelle d1 = new KrakenFemelle(50, 150, 25, "Maria", tuto);
        Oeuf o = d1.pondreOeuf("Marie", SexesEnum.FEMELLE, tuto);
        assertEquals("nom : Marie | espece : KRAKEN | age : 0 | temps maturation restant : 1", o.toString());
    }
}