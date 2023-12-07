package tests.creatures;

import includes.creatures.Kraken;
import includes.creatures.KrakenMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosAquarium;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KrakenTest {

    Enclos tuto = new EnclosAquarium("Tuto", 20, 5, 8);

    @Test
    void Kraken(){
        Kraken k1 = new KrakenMale(50, 150, 25, "James", tuto);
        k1.setID(0);
        assertEquals("nom : James | espece : KRAKEN | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", k1.toString());
    }

    @Test
    void nager() {
        Kraken k1 = new KrakenMale(50, 150, 25, "James", tuto);
        assertEquals("Le kraken James nage.", k1.nager());
    }

    @Test
    void emettreUnSon() {
        Kraken k1 = new KrakenMale(50, 150, 25, "James", tuto);
        assertEquals("Le kraken James fait un hurlement", k1.emettreUnSon());
    }

    @Test
    void vieillir() {
        Kraken k1 = new KrakenMale(50, 150, 25, "James", tuto);
        k1.vieillir();
        assertEquals(26, k1.getAge());
    }
}