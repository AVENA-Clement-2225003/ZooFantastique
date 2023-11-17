import includes.creatures.LicorneFemelle;
import includes.creatures.LicorneMale;
import includes.creatures.LycanthropeFemelle;
import includes.creatures.LycanthropeMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import includes.enclos.EnclosVoliere;
import includes.zoo.zooFantastique;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<Enclos> listeEnclos = new ArrayList<>() ;
        zooFantastique zoo = new zooFantastique("L'amnéstie","Pierre", 10, listeEnclos);
        EnclosStandard E1 = new EnclosStandard("Enclos de Lycanthrope", 100, 10);
        LycanthropeMale Ly1 = new LycanthropeMale(100, 180, 10,"Micheline");
        LycanthropeFemelle Ly2 = new LycanthropeFemelle(100, 180, 10,"Jeanne");
        listeEnclos.add(E1);
        E1.ajouterCreature(Ly1);
        E1.ajouterCreature(Ly2);
        System.out.println(zoo.AfficherCreature() + "\n");
        System.out.println(zoo.toString());

    }
}