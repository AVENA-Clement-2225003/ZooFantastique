package tests.enclos;

import includes.creatures.Creature;
import includes.creatures.LycanthropeMale;
import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EnclosTest {

    @Test
    void getLastID() {

    }

    @Test
    void getID() {
    }

    @Test
    void getNom() {
    }

    @Test
    void setNom() {
    }

    @Test
    void getSuperficie() {
    }

    @Test
    void setSuperficie() {
    }

    @Test
    void getCapaciteEnclos() {
    }

    @Test
    void setCapaciteEnclos() {
    }

    @Test
    void getNbCreaturesDansEnclos() {
    }

    @Test
    void setNbCreaturesDansEnclos() {
    }

    @Test
    void getListeCreatures() {
    }

    @Test
    void setListeCreatures() {
    }

    @Test
    void getProprete() {
    }

    @Test
    void setProprete() {
    }

    @Test
    void entretientEnclos() {
    }

    @Test
    void testToString() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 150, 13);
        LycanthropeMale C1 = new LycanthropeMale(10, 100, 12, "James");
        assertEquals("Enclos{nom='Enclos1', superficie=150, capaciteEnclos=13, nbCreaturesDansEnclos=0, listeCreatures=[], proprete=BON}", E1.toString(), "L'affichage n'est pas correct");
        E1.ajouterCreature(C1);
        assertEquals("Enclos{nom='Enclos1', superficie=150, capaciteEnclos=13, nbCreaturesDansEnclos=0, listeCreatures=[Lycanthrope{ Creature{ID=0, nomEspece=LYCANTROPE, sexe=MALE, poids=10, taille=100, age=12, faim=false, estEnTrainDeDormir=false, sante=true, name='James'}}], proprete=BON}", E1.toString(), "L'affichage n'est pas correct");
    }

    @Test
    void afficherCreatures() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 150, 13);
        LycanthropeMale C1 = new LycanthropeMale(10, 100, 12, "James");
        LycanthropeMale C2 = new LycanthropeMale(10, 100, 12, "Harry");
        assertEquals("L'enclos est vide", E1.afficherCreatures(), "L'enclos est vide normalement");
        E1.ajouterCreature(C1);
        E1.ajouterCreature(C2);
        assertEquals("Enclos1 = {James, Harry}", E1.afficherCreatures(), "L'affichage n'est pas correct");
    }

    @Test
    void nourrirCreatures() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 150, 13);
        LycanthropeMale C1 = new LycanthropeMale(10, 100, 12, "James");
        C1.setFaim(true);
        LycanthropeMale C2 = new LycanthropeMale(10, 100, 12, "Harry");
        C2.setFaim(true);
        LycanthropeMale C3 = new LycanthropeMale(10, 100, 12, "Gabin");
        E1.nourrirCreatures();
        assertEquals(false, C1.isFaim()&&C2.isFaim()&&C3.isFaim(), "Acune créature ne devrais avoir faim");
    }

    @Test
    void ajouterCreature() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 150, 13);
        LycanthropeMale C1 = new LycanthropeMale(10, 100, 12, "James");
        LycanthropeMale C2 = new LycanthropeMale(10, 100, 12, "James");
        E1.ajouterCreature(C1);
        ArrayList<Creature> listeTest = new ArrayList<>();
        listeTest.add(C1);
        assertEquals(listeTest, E1.getListeCreatures(), "Créature non ajoutée dans la liste des créatures");
        C2.setNom(C2.getNom() + C2.getID());
        listeTest.add(C2);
        assertEquals(1, E1.ajouterCreature(C1), "La créature ne devrais pas etre ajoutée" + E1.afficherCreatures());
        E1.ajouterCreature(C2);
        assertEquals(listeTest, E1.getListeCreatures(), "La créature ajoutée devrai avoir son ID ajouté à la fin de son nom");
    }

    @Test
    void retirerCreature() {
    }

    @Test
    void getIndexCreature() {
    }

    @Test
    void existInListeCreature() {
    }
}