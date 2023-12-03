package app;
import includes.creatures.*;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import includes.enclos.EnclosVoliere;
import includes.maitreZoo.ENUMSexe;
import includes.zoo.zooFantastique;
import includes.maitreZoo.MaitreZooFantastique;

import java.util.ArrayList;

public class Model {
    private static Model instance = null;
    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }

        return instance;
    }

    private MaitreZooFantastique maitre;
    private zooFantastique unZoo;

    public zooFantastique CreerUnZoo(String nom, String nomMaitreDeZoo) {
        if (nom.equals("")) nom = "UnZooSuper";
        if (nomMaitreDeZoo.equals("")) nomMaitreDeZoo = "UnMaitreSuper";
        maitre = new MaitreZooFantastique(nomMaitreDeZoo, ENUMSexe.Male, 23);
        unZoo = new zooFantastique(nom, nomMaitreDeZoo/*maitre*/, 15, new ArrayList<>());
        unZoo.ajouterEnclos(new EnclosStandard("Tuto", 45, 5));
        Licorne L1 = new LicorneMale(50, 150, 25, "James", unZoo.getEnclosByNom("Tuto"));
        Licorne L2 = new LicorneFemelle(50, 150, 25, "Maria", unZoo.getEnclosByNom("Tuto"));
        unZoo.getEnclosExistant().get(0).ajouterCreature(L1);
        unZoo.getEnclosExistant().get(0).ajouterCreature(L2);

        unZoo.ajouterEnclos(new EnclosVoliere("T1", 45, 5, 15));
        Phenix P1 = new PhenixMale(50, 150, 25, "James", unZoo.getEnclosByNom("T1"));
        Phenix P2 = new PhenixFemelle(50, 150, 25, "Maria", unZoo.getEnclosByNom("T1"));
        verifierNomEtRenommerCreature(P1, P1.getNom());
        verifierNomEtRenommerCreature(P2, P2.getNom());
        unZoo.getEnclosExistant().get(1).ajouterCreature(P1);
        unZoo.getEnclosExistant().get(1).ajouterCreature(P2);
        return unZoo;
    }

    public void verifierNomEtRenommerCreature(Creature animal, String nom) {
        int id = 1;
        String nvNom = nom;
        for (Enclos e:unZoo.getEnclosExistant()) {
            for (Creature c:e.getListeCreatures()) {
                if (nvNom.equals(c.getNom())) {
                    nvNom = nom + id;
                    ++id;
                }
            }
        }
        animal.setNom(nvNom);
    }

    public MaitreZooFantastique getMaitre() {
        return maitre;
    }

    public zooFantastique getZoo() {
        return unZoo;
    }

    public ArrayList<String> get7erEnclos() {
        ArrayList<String> liste = new ArrayList<>();
        for (Enclos e:unZoo.getEnclosExistant()) {
            if (liste.size() == 7) return liste;
            liste.add(e.getNom());
        }
        int nombreAAjouter = (7 - liste.size());
        for (int i = 0; i < nombreAAjouter; i+=1) {liste.add(" ");}
        return liste;
    }
    public ArrayList<String> get7erMalades() {
        ArrayList<String> liste = new ArrayList<>();
        for (Enclos e:unZoo.getEnclosExistant()) {
            for (Creature c:e.getListeCreatures()) {
                if (liste.size() == 7) return liste;
                if (c.isSante() == false) liste.add(c.getNom());
            }
        }
        int nombreAAjouter = (7 - liste.size());
        for (int i = 0; i < nombreAAjouter; i+=1) {liste.add(" ");}
        return liste;
    }
    public ArrayList<String> get7erFaims() {
        ArrayList<String> liste = new ArrayList<>();
        for (Enclos e:unZoo.getEnclosExistant()) {
            for (Creature c:e.getListeCreatures()) {
                if (liste.size() == 7) return liste;
                if (c.isFaim() == true) liste.add(c.getNom());
            }
        }
        int nombreAAjouter = (7 - liste.size());
        for (int i = 0; i < nombreAAjouter; i+=1) {liste.add(" ");}
        return liste;
    }
    public ArrayList<String> get7erMorts() {
        ArrayList<String> liste = new ArrayList<>();
        for (Enclos e:unZoo.getEnclosExistant()) {
            for (Creature c:e.getListeCreatures()) {
                if (liste.size() == 7) return liste;
                if (c.getAge() >= c.getAgeMort()) liste.add(c.getNom());
            }
        }
        int nombreAAjouter = (7 - liste.size());
        for (int i = 0; i < nombreAAjouter; i+=1) {liste.add(" ");}
        return liste;
    }
}