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

    public void CreerUnZoo(String nom, String nomMaitreDeZoo) {
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
}