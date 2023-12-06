package tests.creatures;

import includes.creatures.*;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {

    Enclos Tuto = new EnclosStandard("Tuto", 20, 5);

    @Test
    void getLastID() {
        Licorne L1 = new LicorneMale(50, 150, 25, "James", null);
        assertEquals(L1.getID()+1, Creature.getLastID());
        Licorne L2 = new LicorneMale(50, 150, 25, "James", null);
        assertEquals(L1.getID()+2, Creature.getLastID());
    }

    @Test
    void getID() {
        Licorne L1 = new LicorneMale(50, 150, 25, "James", null);
        assertEquals(13, L1.getID());
    }

    @Test
    void setID() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        assertEquals(15, d1.getID());
        d1.setID(200);
        assertEquals(200, d1.getID());
    }

    @Test
    void Creature(){
        Licorne L1 = new LicorneMale(50, 150, 25, "James", Tuto);
        L1.setID(0);
        assertEquals("nom : James | espece : LICORNE | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", L1.toString());
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
        Dragon d1 = new DragonMale(50, 150, 25, "James", Tuto);
        d1.vieillir();
        assertEquals(26, d1.getAge());
    }

    @Test
    void testToString() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", Tuto);
        assertEquals("nom : James | espece : DRAGON | age : 25 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Tuto", d1.toString());
    }

    @Test
    void afficherCreature() {
        Licorne L1 = new LicorneMale(50, 150, 25, "James", null);
        L1.setID(0);
        assertEquals("La creature James de type LICORNE, d'identifiant 0 et de sexe MALE fait 150 cm, 50 kg, a 25 ans, n'a pas faim, n'a pas sommeil et est en bonne sante", L1.afficherCreature());
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
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        assertEquals("MALE", d1.getSexe().toString());
    }

    @Test
    void setSexe() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        d1.setSexe(SexesEnum.FEMELLE);
        assertEquals("FEMELLE", d1.getSexe().toString());
    }

    @Test
    void getPoids() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        assertEquals(50, d1.getPoids());
    }

    @Test
    void setPoids() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        d1.setPoids(500);
        assertEquals(500, d1.getPoids());
    }

    @Test
    void getTaille() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        assertEquals(150, d1.getTaille());
    }

    @Test
    void setTaille() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        d1.setTaille(900);
        assertEquals(900, d1.getTaille());
    }

    @Test
    void getAge() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        assertEquals(25, d1.getAge());
    }

    @Test
    void setAge() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        d1.setAge(230);
        assertEquals(230, d1.getAge());
    }

    @Test
    void isFaim() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        assertFalse(d1.isFaim());
    }

    @Test
    void setFaim() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        d1.setFaim(true);
        assertTrue(d1.isFaim());
    }

    @Test
    void isEstEnTrainDeDormir() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        assertFalse(d1.isEstEnTrainDeDormir());
    }

    @Test
    void setEstEnTrainDeDormir() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        d1.setEstEnTrainDeDormir(true);
        assertTrue(d1.isEstEnTrainDeDormir());
    }

    @Test
    void isSante() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        assertTrue(d1.isSante());
    }

    @Test
    void setSante() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        d1.setSante(false);
        assertFalse(d1.isSante());
    }

    @Test
    void getNom() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        assertEquals("James", d1.getNom());
    }

    @Test
    void setNom() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        d1.setNom("Maria");
        assertEquals("Maria", d1.getNom());
    }

    @Test
    void getEnclos() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", Tuto);
        assertEquals("Tuto", d1.getEnclos().getNom());
    }

    @Test
    void setEnclos() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", Tuto);
        d1.setEnclos(new EnclosStandard("SuperEnclos", 55, 5));
        assertEquals("SuperEnclos", d1.getEnclos().getNom());
    }

    @Test
    void getAgeMort() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        d1.setAgeMort(30);
        assertEquals(30, d1.getAgeMort());
    }

    @Test
    void setAgeMort() {
        Dragon d1 = new DragonMale(50, 150, 25, "James", null);
        d1.setAgeMort(39);
        assertEquals(39, d1.getAgeMort());
    }

    @Test
    void courir(){
        Dragon d1 = new DragonMale(50, 150, 25, "James", Tuto);
        assertEquals("Le dragon James court." , d1.courir());
     }

    @Test
    void nager(){
        Dragon d1 = new DragonMale(50, 150, 25, "James", Tuto);
        assertEquals("Le dragon James nage." , d1.nager());
    }

    @Test
    void voler(){
        Dragon d1 = new DragonMale(50, 150, 25, "James", Tuto);
        assertEquals("Le dragon James vole." , d1.voler());
    }


}