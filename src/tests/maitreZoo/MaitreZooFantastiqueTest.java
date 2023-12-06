package tests.maitreZoo;

import includes.creatures.LycanthropeFemelle;
import includes.creatures.LycanthropeMale;
import includes.creatures.SexesEnum;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import includes.maitreZoo.MaitreZooFantastique;
import includes.zoo.zooFantastique;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MaitreZooFantastiqueTest {

    @Test
    void getAge() {
        MaitreZooFantastique Pierre = new MaitreZooFantastique("Pierre", SexesEnum.MALE, 28);
        assertEquals(28,Pierre.getAge(),"La fonction getAge ne fonctionne pas.");
    }

    @Test
    void setAge() {
        MaitreZooFantastique Pierre = new MaitreZooFantastique("Pierre", SexesEnum.MALE, 28);
        Pierre.setAge(29);
        assertEquals(29,Pierre.getAge(),"La fonction setAge ne fonctionne pas.");
    }

    @Test
    void getNom() {
        MaitreZooFantastique Pierre = new MaitreZooFantastique("Pierre", SexesEnum.MALE, 28);
        assertEquals("Pierre",Pierre.getNom(),"La fonction getNom ne fonctionne pas.");
    }

    @Test
    void setNom() {
        MaitreZooFantastique Pierre = new MaitreZooFantastique("Pierre", SexesEnum.MALE, 28);
        Pierre.setNom("Robert");
        assertEquals("Robert",Pierre.getNom(),"La fonction setNom ne fonctionne pas.");
    }

    @Test
    void getSexe() {
        MaitreZooFantastique Pierre = new MaitreZooFantastique("Pierre", SexesEnum.MALE, 28);
        assertEquals(SexesEnum.MALE,Pierre.getSexe(),"La fonction getSexe ne fonctionne pas.");
    }

    @Test
    void setSexe() {
        MaitreZooFantastique Pierre = new MaitreZooFantastique("Pierre", SexesEnum.MALE, 28);
        Pierre.setSexe(SexesEnum.FEMELLE);
        assertEquals(SexesEnum.FEMELLE,Pierre.getSexe(),"La fonction setSexe ne fonctionne pas.");
    }

    @Test
    void testToString() {
        MaitreZooFantastique Pierre = new MaitreZooFantastique("Pierre", SexesEnum.MALE, 28);
        assertEquals("maître de zoo fantastique{nom='Pierre', sexe='MALE', age=28}",Pierre.toString() ,"La fonction ToString ne fonctionne pas.");
    }

    @Test
    void examinerEnclos() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        MaitreZooFantastique Pierre = new MaitreZooFantastique("Pierre", SexesEnum.MALE, 28);
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        EnclosStandard E1 = new EnclosStandard("Enclos de Lycanthrope", 100, 10);
        LycanthropeMale Ly1 = new LycanthropeMale(100, 180, 10,"Micheline", E1);
        LycanthropeFemelle Ly2 = new LycanthropeFemelle(100, 180, 10,"Jeanne", E1);
        listeEnclos.add(E1);
        E1.ajouterCreature(Ly1);
        E1.ajouterCreature(Ly2);
        assertEquals("Le maître de zoo Pierre est dans le l'Enclos de Lycanthrope d'une superficie de 100m² pouvant accueillir 10 créatures avec 2 présentes et il est en BON état",Pierre.examinerEnclos(E1), "La fonction examinerEnclos ne fonctionne pas.");
    }

    @Test
    void nettoyerEnclos() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        MaitreZooFantastique Pierre = new MaitreZooFantastique("Pierre", SexesEnum.MALE, 28);
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        EnclosStandard E1 = new EnclosStandard("Enclos de Lycanthrope", 100, 10);
        LycanthropeMale Ly1 = new LycanthropeMale(100, 180, 10,"Micheline", E1);
        LycanthropeFemelle Ly2 = new LycanthropeFemelle(100, 180, 10,"Jeanne", E1);
        listeEnclos.add(E1);
        E1.ajouterCreature(Ly1);
        E1.ajouterCreature(Ly2);
        assertEquals("Pierre a nettoyer l'enclos : 1",Pierre.nettoyerEnclos(E1), "La fonction nettoyerEnclos ne fonctionne pas.");
    }

    @Test
    void nourrirCreatures() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        MaitreZooFantastique Pierre = new MaitreZooFantastique("Pierre", SexesEnum.MALE, 28);
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        EnclosStandard E1 = new EnclosStandard("Enclos de Lycanthrope", 100, 10);
        LycanthropeMale Ly1 = new LycanthropeMale(100, 180, 10,"Micheline", E1);
        LycanthropeFemelle Ly2 = new LycanthropeFemelle(100, 180, 10,"Jeanne", E1);
        listeEnclos.add(E1);
        E1.ajouterCreature(Ly1);
        E1.ajouterCreature(Ly2);
        assertEquals("Pierre a nourrit les créatures de l'enclos : Enclos: Enclos de Lycanthrope | Superficie: 100 | Capacitée: 10 | Propretée: BON",Pierre.nourrirCreatures(E1), "La fonction nourrirCreatures ne fonctionne pas.");
    }

    @Test
    void deplacerCreature() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        MaitreZooFantastique Pierre = new MaitreZooFantastique("Pierre", SexesEnum.MALE, 28);
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        EnclosStandard E1 = new EnclosStandard("Enclos de Lycanthrope", 100, 10);
        EnclosStandard E2 = new EnclosStandard("Enclos de Lycanthrope numéro 2", 50, 5);
        LycanthropeMale Ly1 = new LycanthropeMale(100, 180, 10,"Micheline", E1);
        LycanthropeFemelle Ly2 = new LycanthropeFemelle(100, 180, 10,"Jeanne", E1);
        listeEnclos.add(E1);
        E1.ajouterCreature(Ly1);
        E1.ajouterCreature(Ly2);
        assertEquals(0,Pierre.deplacerCreature(Ly1, E2), "La fonction deplacerCreature ne fonctionne pas.");
    }
}