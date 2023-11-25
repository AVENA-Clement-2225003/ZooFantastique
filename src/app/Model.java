package app;
import includes.zoo.zooFantastique;
import includes.maitreZoo.MaitreZooFantastique;

import java.util.ArrayList;

public class Model {

    MaitreZooFantastique maitre;
    zooFantastique unZoo;

    public void CreerUnZoo(String nom, String nomMaitreDeZoo) {
        if (nom.equals("")) nom = "UnZooSuper";
        if (nomMaitreDeZoo.equals("")) nomMaitreDeZoo = "UnMaitreSuper";
        maitre = new MaitreZooFantastique(nomMaitreDeZoo, "Mâle", 23);
        unZoo = new zooFantastique(nom, nomMaitreDeZoo/*maitre*/, 15, new ArrayList<>());
    }

    public MaitreZooFantastique getMaitre() {
        return maitre;
    }

    public zooFantastique getZoo() {
        return unZoo;
    }
}