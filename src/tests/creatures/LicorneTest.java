package tests.creatures;

import includes.creatures.Licorne;
import includes.creatures.LicorneMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LicorneTest {

    Enclos tuto = new EnclosStandard("Tuto", 20, 5);

    @Test
    void Licorne(){
        Licorne l1 = new LicorneMale(50, 150, 25, "James", tuto);
        l1.setID(0);
        assertEquals("nom : James | espece : LICORNE | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", l1.toString());
    }

    @Test
    void courir() {
        Licorne l1 = new LicorneMale(50, 150, 25, "James", tuto);
        assertEquals("La licorne James court.", l1.courir());
    }

    @Test
    void emettreUnSon() {
        Licorne l1 = new LicorneMale(50, 150, 25, "James", tuto);
        assertEquals("La licorne James hennit", l1.emettreUnSon());
    }

    @Test
    void vieillir() {
        Licorne l1 = new LicorneMale(50, 150, 25, "James", tuto);
        l1.vieillir();
        assertEquals(26, l1.getAge());
    }
}