package tests.enclos;

import includes.creatures.Creature;
import includes.creatures.LycanthropeFemelle;
import includes.creatures.LycanthropeMale;
import includes.enclos.EnclosStandard;
import includes.enclos.PropreteEnum;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EnclosTest {

    @Test
    void getLastID() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 120, 22);
        assertEquals(13, E1.getLastID(), "L'id devrait être 0");
    }

    @Test
    void getID() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 120, 22);
        assertEquals(11, E1.getID(), "L'id devrait être 0");
    }

    @Test
    void getNom() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 120, 22);
        assertEquals("Enclos1", E1.getNom(), "Le nom devrait être Enclos1");
    }

    @Test
    void setNom() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 120, 22);
        E1.setNom("Harry");
        assertEquals("Harry", E1.getNom(), "Le nom devrait être Harry");
    }

    @Test
    void getSuperficie() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 120, 22);
        assertEquals(120, E1.getSuperficie(), "La superficie devrait être 120");
    }

    @Test
    void setSuperficie() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 120, 22);
        E1.setSuperficie(21);
        assertEquals(21, E1.getSuperficie(), "La superficie devrait être 21");
    }

    @Test
    void getCapaciteEnclos() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 120, 22);
        assertEquals(22, E1.getCapaciteEnclos(), "La capacitée devrait être 22");
    }

    @Test
    void setCapaciteEnclos() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 120, 22);
        E1.setCapaciteEnclos(2);
        assertEquals(2, E1.getCapaciteEnclos(), "La capacitée devrait être 2");
    }

    @Test
    void getListeCreatures() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 120, 22);
        LycanthropeMale L1 = new LycanthropeMale(80, 170, 21, "James");
        ArrayList<Creature> Liste = new ArrayList<>();
        assertEquals(Liste, E1.getListeCreatures(), "La devrait être vide");
        Liste.add(L1);
        E1.ajouterCreature(L1);
        assertEquals(Liste, E1.getListeCreatures(), "La devrait être contenir James");
    }

    @Test
    void setListeCreatures() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 120, 22);
        LycanthropeMale L1 = new LycanthropeMale(80, 170, 21, "James");
        ArrayList<Creature> Liste = new ArrayList<>();
        Liste.add(L1);
        E1.setListeCreatures(Liste);
        assertEquals(Liste, E1.getListeCreatures(), "La devrait être la même");
    }

    @Test
    void getProprete() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 120, 22);
        assertEquals(PropreteEnum.BON, E1.getProprete(), "L'enclos devrait être propre à sa création");
    }

    @Test
    void setProprete() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 120, 22);
        E1.setProprete(PropreteEnum.MAUVAIS);
        assertEquals(PropreteEnum.MAUVAIS, E1.getProprete(), "L'enclos devrait être propre à sa création");
    }

    @Test
    void testToString() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 150, 13);
        LycanthropeMale C1 = new LycanthropeMale(10, 100, 12, "James");
        assertEquals("Enclos{nom='Enclos1', superficie=150, capaciteEnclos=13, listeCreatures=[], proprete=BON}", E1.toString(), "L'affichage n'est pas correct");
        E1.ajouterCreature(C1);
        assertEquals("Enclos{nom='Enclos1', superficie=150, capaciteEnclos=13, listeCreatures=[Lycanthrope{ Creature{ID=0, nomEspece=LYCANTROPE, sexe=MALE, poids=10, taille=100, age=12, faim=false, estEnTrainDeDormir=false, sante=true, name='James'}}], proprete=BON}", E1.toString(), "L'affichage n'est pas correct");
    }

    @Test
    void afficherCreatures() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 150, 13);
        LycanthropeMale C1 = new LycanthropeMale(10, 100, 12, "James");
        LycanthropeMale C2 = new LycanthropeMale(10, 100, 12, "Harry");
        assertEquals("Enclos1 = {L'enclos est vide}", E1.afficherCreatures(), "L'enclos est vide normalement");
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
        EnclosStandard E1 = new EnclosStandard("Enclos1", 150, 13);
        LycanthropeFemelle C1 = new LycanthropeFemelle(10, 100, 12, "Maria");
        LycanthropeMale C2 = new LycanthropeMale(10, 100, 12, "James");
        E1.ajouterCreature(C1);
        E1.ajouterCreature(C2);
        E1.retirerCreature(C1);
        ArrayList<Creature> listeTest = new ArrayList<>();
        listeTest.add(C2);
        assertEquals(listeTest, E1.getListeCreatures(), "La créature C1 devrait être retirée de la liste");

    }

    @Test
    void getIndexCreature() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 150, 13);
        LycanthropeMale C1 = new LycanthropeMale(10, 100, 12, "James");
        LycanthropeMale C2 = new LycanthropeMale(10, 100, 12, "Harry");
        LycanthropeMale C3 = new LycanthropeMale(10, 100, 12, "Josh");
        E1.ajouterCreature(C1);
        E1.ajouterCreature(C2);
        assertEquals(0, E1.getIndexCreature(C1), "L'indice devrait être 0");
        assertEquals(2, E1.getIndexCreature(C3), "L'indice devrait être 2 soit la taille de la liste des créatures");
        assertEquals(true, E1.getListeCreatures().size()==E1.getIndexCreature(C3), "L'indice renvoyé n'est pas la taille de la liste");
    }

    @Test
    void existInListeCreature() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 150, 13);
        LycanthropeMale C1 = new LycanthropeMale(10, 100, 12, "James");
        LycanthropeMale C2 = new LycanthropeMale(10, 100, 12, "Harry");
        assertEquals(false, E1.existInListeCreature(C1), "La liste est vide donc elle ne devrait pas retourner autre chose que false");
        E1.ajouterCreature(C1);
        assertEquals(true, E1.existInListeCreature(C1), "C1 se trouve dans la liste donc devrait être trouvé");
        assertEquals(false, E1.existInListeCreature(C2), "C2 ne se trouve pas dans la liste donc ne devrait pas être trouvé");
    }
}