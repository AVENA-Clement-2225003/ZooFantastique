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
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos );
        EnclosStandard E1 = new EnclosStandard("Enclos de Lycanthrope", 100, 10);
        EnclosStandard E2 = new EnclosStandard("Enclos de Licorne", 100, 10);
        listeEnclos.add(E1);
        listeEnclos.add(E2);
        assertEquals(2,zoo.getEnclosExistant().size(),"La fonction getEnclosExistant ne marche pas");

    }

    @Test
    void setMaxEnclos() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos );
        zoo.setMaxEnclos(20);
        assertEquals(20, zoo.getMaxEnclos(), "Le setMaxEnclos ne fonctionne pas");
    }

    @Test
    void getNom() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos );
        assertEquals("L'amnéstie",zoo.getNom(),"Le getNom ne fonctionne pas");
    }

    @Test
    void setNom() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos );
        zoo.setNom("L'amertume");
        assertEquals("L'amertume",zoo.getNom(),"Le getNom ne fonctionne pas");
    }

    @Test
    void setEnclosExistant() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>();
        ArrayList<Enclos> listeEnclos2 = new ArrayList<>();
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos );
        EnclosStandard E1 = new EnclosStandard("Enclos de Lycanthrope", 100, 10);
        EnclosStandard E2 = new EnclosStandard("Enclos de Licorne", 100, 10);
        EnclosStandard E3 = new EnclosStandard("Enclos de Megalodon", 100, 10);
        listeEnclos.add(E1);
        listeEnclos.add(E2);
        listeEnclos2.add(E3);
        zoo.setEnclosExistant(listeEnclos2);
        assertEquals("[Enclos: Enclos de Megalodon | Superficie: 100 | Capacitée: 10 | Propretée: BON]", zoo.getEnclosExistant().toString(), "La fonction setEnclosExistant ne marche pas");

    }

    @Test
    void compteNbCreatureZoo() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        EnclosStandard E1 = new EnclosStandard("Enclos de Lycanthrope", 100, 10);
        LycanthropeMale Ly1 = new LycanthropeMale(100, 180, 10,"Micheline", E1);
        LycanthropeFemelle Ly2 = new LycanthropeFemelle(100, 180, 10,"Jeanne", E1);
        EnclosStandard E2 = new EnclosStandard("Enclos de Licorne", 100, 10);
        LicorneMale L1 = new LicorneMale(350, 180, 10, "Petit Poney", E1);
        LicorneFemelle L2 = new LicorneFemelle(300, 180, 11, "Petit Tonerre", E1);
        listeEnclos.add(E1);
        listeEnclos.add(E2);
        E1.ajouterCreature(Ly1);
        E1.ajouterCreature(Ly2);
        E2.ajouterCreature(L1);
        E2.ajouterCreature(L2);
        assertEquals(4,zoo.compteNbCreatureZoo(),"La fonction NbCreatureZoo ne fonctionne pas");
    }

    @Test
    void testToString() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        EnclosStandard E1 = new EnclosStandard("Enclos de Lycanthrope", 100, 10);
        LycanthropeMale Ly1 = new LycanthropeMale(100, 180, 10,"Micheline", E1);
        LycanthropeFemelle Ly2 = new LycanthropeFemelle(100, 180, 10,"Jeanne", E1);
        listeEnclos.add(E1);
        E1.ajouterCreature(Ly1);
        E1.ajouterCreature(Ly2);
        assertEquals("zooFantastique{nom='L'amnéstie', maitreZoo='Pierre', maxEnclos=10, enclosExistant=[Enclos: Enclos de Lycanthrope | Superficie: 100 | Capacitée: 10 | Propretée: BON]}", zoo.toString(), "Le message 'toString' est incorrect");
    }

    @Test
    void afficherCreature() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        EnclosStandard E1 = new EnclosStandard("Enclos de Lycanthrope", 100, 10);
        LycanthropeMale Ly1 = new LycanthropeMale(100, 180, 10,"Micheline", E1);
        LycanthropeFemelle Ly2 = new LycanthropeFemelle(100, 180, 10,"Jeanne", E1);
        EnclosStandard E2 = new EnclosStandard("Enclos de Licorne", 100, 10);
        LicorneMale L1 = new LicorneMale(350, 180, 10, "Petit Poney", E1);
        LicorneFemelle L2 = new LicorneFemelle(300, 180, 11, "Petit Tonerre", E1);
        listeEnclos.add(E1);
        listeEnclos.add(E2);
        E1.ajouterCreature(Ly1);
        E1.ajouterCreature(Ly2);
        E2.ajouterCreature(L1);
        E2.ajouterCreature(L2);
        assertEquals("Le zoo : L'amnéstie comporte les créatures suivantes :\n" +
                "nom : Micheline | espece : LYCANTHROPE | age : 10 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Enclos de Lycanthrope\n" +
                "nom : Jeanne | espece : LYCANTHROPE | age : 10 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Enclos de Lycanthrope\n" +
                "nom : Petit Poney | espece : LICORNE | age : 10 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Enclos de Lycanthrope\n" +
                "nom : Petit Tonerre | espece : LICORNE | age : 11 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Enclos de Lycanthrope\n",zoo.afficherCreature(),"La fonction afficherCreatures ne fonctionne pas");

    }

    @Test
    void getEnclosByNom() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        EnclosStandard EV2 = new EnclosStandard("Enclos2", 100, 10);
        listeEnclos.add(EV2);
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        MaitreZooFantastique Pierre = new MaitreZooFantastique("Pierre", SexesEnum.MALE, 28);
        //assertEquals("Enclos2 d'une superficie de 100m² pouvant accueillir 10 créatures avec 0 présentes et il est en BON état",zoo.getEnclosByNom(EV2), "L'affichage de 'getEnclosByNom' est incorrect");
    }

    @Test
    void getCreatureByNom() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        EnclosStandard E1 = new EnclosStandard("Enclos de Lycanthrope", 100, 10);
        LycanthropeMale Ly1 = new LycanthropeMale(100, 180, 10,"Micheline", E1);
        LycanthropeFemelle Ly2 = new LycanthropeFemelle(100, 180, 10,"Jeanne", E1);
        listeEnclos.add(E1);
        E1.ajouterCreature(Ly1);
        E1.ajouterCreature(Ly2);
        assertEquals("nom : Micheline | espece : LYCANTHROPE | age : 10 | a faim :  non  | en bonne sante :  oui  | dort :  non  | Enclos : Enclos de Lycanthrope", zoo.getCreatureByNom("Micheline").toString(),"La fonction getCreatureByNom ne fonctionne pas");
    }

    @Test
    void ajouterEnclos() {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        EnclosStandard E1 = new EnclosStandard("Enclos de Lycanthrope", 100, 10);
        ArrayList<Enclos> enclosExistant = new ArrayList<>();
        enclosExistant.add(E1);
        zoo.ajouterEnclos(E1);
        assertEquals( enclosExistant,zoo.getEnclosExistant(),"La fonction ajouterEnclos ne fonctionne pas.");
    }

}