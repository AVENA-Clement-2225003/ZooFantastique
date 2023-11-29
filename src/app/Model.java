package app;
import includes.creatures.Licorne;
import includes.creatures.LicorneFemelle;
import includes.creatures.LicorneMale;
import includes.enclos.EnclosStandard;
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

    MaitreZooFantastique maitre;
    zooFantastique unZoo;

    public void CreerUnZoo(String nom, String nomMaitreDeZoo) {
        if (nom.equals("")) nom = "UnZooSuper";
        if (nomMaitreDeZoo.equals("")) nomMaitreDeZoo = "UnMaitreSuper";
        maitre = new MaitreZooFantastique(nomMaitreDeZoo, ENUMSexe.Male, 23);
        unZoo = new zooFantastique(nom, nomMaitreDeZoo/*maitre*/, 15, new ArrayList<>());
        Licorne L1 = new LicorneMale(50, 150, 25, "James");
        Licorne L2 = new LicorneFemelle(50, 150, 25, "Maria");
        unZoo.ajouterEnclos(new EnclosStandard("Tuto", 45, 5));
        unZoo.getEnclosExistant().get(0).ajouterCreature(L1);
        unZoo.getEnclosExistant().get(0).ajouterCreature(L2);
    }

    public MaitreZooFantastique getMaitre() {
        return maitre;
    }

    public zooFantastique getZoo() {
        return unZoo;
    }
}