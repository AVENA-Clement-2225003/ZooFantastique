package tests.zoo;

import includes.creatures.*;
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
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        EnclosStandard E1 = new EnclosStandard("Enclos de Lycanthrope", 100, 10);
        LycanthropeMale Ly1 = new LycanthropeMale(100, 180, 10,"Micheline");
        LycanthropeFemelle Ly2 = new LycanthropeFemelle(100, 180, 10,"Jeanne");
        listeEnclos.add(E1);
        E1.ajouterCreature(Ly1);
        E1.ajouterCreature(Ly2);
        assertEquals("zooFantastique{nom='L'amnéstie', maitreZoo='Pierre', maxEnclos=10, enclosExistant=[Enclos{nom='Enclos de Lycanthrope', superficie=100, capaciteEnclos=10, listeCreatures=[Lycanthrope{ Creature{ID=0, nomEspece=LYCANTROPE, sexe=MALE, poids=100, taille=180, age=10, faim=false, estEnTrainDeDormir=false, sante=true, nom=Micheline, ageMort='36'}}, Lycanthrope{ Creature{ID=1, nomEspece=LYCANTROPE, sexe=FEMELLE, poids=100, taille=180, age=10, faim=false, estEnTrainDeDormir=false, sante=true, nom=Jeanne, ageMort='28'}}], proprete=BON}]}", zoo, "Le message 'toString' est incorrect");

    }

    @Test
    void afficherCreature() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        EnclosStandard E1 = new EnclosStandard("Enclos de Lycanthrope", 100, 10);
        LycanthropeMale Ly1 = new LycanthropeMale(100, 180, 10,"Micheline");
        LycanthropeFemelle Ly2 = new LycanthropeFemelle(100, 180, 10,"Jeanne");
        EnclosStandard E2 = new EnclosStandard("Enclos de Licorne", 100, 10);
        LicorneMale L1 = new LicorneMale(350, 180, 10, "Petit Poney");
        LicorneFemelle L2 = new LicorneFemelle(300, 180, 11, "Petit Tonerre");
        listeEnclos.add(E1);
        listeEnclos.add(E2);
        E1.ajouterCreature(Ly1);
        E1.ajouterCreature(Ly2);
        E2.ajouterCreature(L1);
        E2.ajouterCreature(L2);
        assertEquals("Le zoo : L'amnéstie avec les créatures :  {Enclos de Lycanthrope = {La creature Micheline de type LYCANTROPE, d'identifiant 0 et de sexe MALE fait 180 cm, 100 kg, a 10 ans, n'a pas faim, n'a pas sommeil et est en bonne sante, La creature Jeanne de type LYCANTROPE, d'identifiant 1 et de sexe FEMELLE fait 180 cm, 100 kg, a 10 ans, n'a pas faim, n'a pas sommeil et est en bonne sante}, Enclos de Licorne = {La creature Petit Poney de type LICORNE, d'identifiant 2 et de sexe MALE fait 180 cm, 350 kg, a 10 ans, n'a pas faim, n'a pas sommeil et est en bonne sante, La creature Petit Tonerre de type LICORNE, d'identifiant 3 et de sexe FEMELLE fait 180 cm, 300 kg, a 11 ans, n'a pas faim, n'a pas sommeil et est en bonne sante}}",zoo.AfficherCreature(),"L'affichage des créatures ne fonctionne pas");

    }

    @Test
    void getEnclosByNom() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        EnclosStandard EV2 = new EnclosStandard("Enclos2", 100, 10);
        listeEnclos.add(EV2);
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        MaitreZooFantastique Pierre = new MaitreZooFantastique("Pierre", "Male", 28);
        assertEquals("Enclos2 d'une superficie de 100m² pouvant accueillir 10 créatures avec 0 présentes et il est en BON état",zoo.getEnclosByNom(EV2), "L'affichage de 'getEnclosByNom' est incorrect");
    }
}