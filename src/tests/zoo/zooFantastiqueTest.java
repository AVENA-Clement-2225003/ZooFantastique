package tests.zoo;

import includes.creatures.LicorneMale;
import includes.creatures.Lycanthrope;
import includes.creatures.LycanthropeFemelle;
import includes.creatures.LycanthropeMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import includes.maitreZoo.MaitreZooFantastique;
import includes.zoo.zooFantastique;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static includes.enclos.PropreteEnum.BON;
import static org.junit.jupiter.api.Assertions.*;

class zooFantastiqueTest {
    @Test
    void getEnclosExistant() {
    }

    @Test
    void setMaxEnclos() {
    }

    @Test
    void getNom() {
    }

    @Test
    void setNom() {
    }

    @Test
    void setEnclosExistant() {
    }

    @Test
    void compteNbCreatureZoo() {
    }

    @Test
    void testToString() {
    }

    @Test
    void afficherCreature() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        EnclosStandard E1 = new EnclosStandard("Enclos de Lycanthrope", 100, 10);
        LycanthropeMale Ly1 = new LycanthropeMale(100, 180, 10,"Micheline");
        LycanthropeFemelle Ly2 = new LycanthropeFemelle(100, 180, 10,"Jeanne");
        EnclosStandard E2 = new EnclosStandard("Enclos de Licorne", 100, 10);
        LicorneMale L1 = new LicorneMale(350, 180, 10, "Petit Poney")
    }

    @Test
    void getEnclosByNom() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        EnclosStandard EV2 = new EnclosStandard("Enclos2", 100, 10);
        listeEnclos.add(EV2);
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        MaitreZooFantastique Pierre = new MaitreZooFantastique("Pierre", "Male", 28);
        assertEquals("Enclos{nom='Enclos2', superficie=100, capaciteEnclos=10, nbCreaturesDansEnclos=0, listeCreatures=[], proprete=BON}",zoo.getEnclosByNom(EV2), "L'affichage de 'getEnclosByNom' est incorrect");
    }
}