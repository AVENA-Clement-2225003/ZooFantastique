package tests.creatures;

import includes.creatures.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {

    @Test
    void Creature(){
        Licorne L1 = new LicorneMale(50, 150, 25, "James", null);
        L1.setID(0);
        assertEquals("Licorne{ \n" +
                " nom : James | espece : LICORNE | ID : 0 | age : 25 | faim :  non  | en bonne sante :  oui  | dort :  non }", L1.toString());
    }
    @Test
    void manger() {
        Licorne L1 = new LicorneMale(50, 150, 25, "James", null);
        assertEquals("LICORNE James est en train de manger", L1.manger());
    }

    @Test
    void etreSoigne() {
        Licorne L1 = new LicorneMale(50, 150, 25, "James", null);
        assertEquals("LICORNE James est soigné", L1.etreSoigne());
    }

    @Test
    void endormir() {
        Licorne L1 = new LicorneMale(50, 150, 25, "James", null);
        assertEquals("LICORNE James s'endort", L1.endormir());
    }

    @Test
    void endormirReveiller() {
        Licorne L1 = new LicorneMale(50, 150, 25, "James", null);
        L1.setEstEnTrainDeDormir(true);
        assertEquals("LICORNE James se reveille", L1.endormir());
    }

    @Test
    void vieillir() {
        fail("Not implemented");
    }

    @Test
    void testToString() {
        Licorne L1 = new LicorneMale(50, 150, 25, "James", null);
        assertEquals("Licorne{ \n" +
                " nom : James | espece : LICORNE | ID : 0 | age : 25 | faim :  non  | en bonne sante :  oui  | dort :  non }", L1.toString());
    }

    @Test
    void afficherCreature() {
        Licorne L1 = new LicorneMale(50, 150, 25, "James", null);
        L1.setID(0);
        assertEquals("La creature James de type LICORNE, d'identifiant 0 et de sexe MALE fait 150 cm, 50 kg, a 25 ans, n'a pas faim, n'a pas sommeil et est en bonne sante", L1.afficherCreature());
    }

    @Test
    void getLastID() {
        Licorne L1 = new LicorneMale(50, 150, 25, "James", null);
        Licorne L2 = new LicorneMale(50, 150, 25, "James", null);
        assertEquals(2, L1.getLastID());
        assertEquals(2, L2.getLastID());
    }

    @Test
    void getID() {
        Licorne L1 = new LicorneMale(50, 150, 25, "James", null);
        assertEquals(0, L1.getID());
    }

    @Test
    void setID() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        assertEquals(0, d1.getID());
        d1.setID(200);
        assertEquals(200, d1.getID());
    }

    @Test
    void getNomEspece() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        assertEquals("DRAGON", d1.getNomEspece().toString());
    }

    @Test
    void setNomEspece() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        d1.setNomEspece(EspecesEnum.LYCANTHROPE);
        assertEquals("LYCANTHROPE", d1.getNomEspece().toString());
    }

    @Test
    void getSexe() {
        fail("Not implemented");
    }

    @Test
    void setSexe() {
        fail("Not implemented");
    }

    @Test
    void getPoids() {
        fail("Not implemented");
    }

    @Test
    void setPoids() {
        fail("Not implemented");
    }

    @Test
    void getTaille() {
        fail("Not implemented");
    }

    @Test
    void setTaille() {
        fail("Not implemented");
    }

    @Test
    void getAge() {
        fail("Not implemented");
    }

    @Test
    void setAge() {
        fail("Not implemented");
    }

    @Test
    void isFaim() {
        fail("Not implemented");
    }

    @Test
    void setFaim() {
        fail("Not implemented");
    }

    @Test
    void isEstEnTrainDeDormir() {
        fail("Not implemented");
    }

    @Test
    void setEstEnTrainDeDormir() {
        fail("Not implemented");
    }

    @Test
    void isSante() {
        fail("Not implemented");
    }

    @Test
    void setSante() {
        fail("Not implemented");
    }

    @Test
    void getNom() {
        fail("Not implemented");
    }

    @Test
    void setNom() {
        fail("Not implemented");
    }

    @Test
    void getEnclos() {
        fail("Not implemented");
    }

    @Test
    void setEnclos() {
        fail("Not implemented");
    }

    @Test
    void getAgeMort() {
        fail("Not implemented");
    }

    @Test
    void setAgeMort() {
        fail("Not implemented");
    }
}