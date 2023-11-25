package app;

import java.util.ArrayList;

import includes.creatures.Creature;
import includes.creatures.LycanthropeFemelle;
import includes.creatures.LycanthropeMale;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import includes.zoo.zooFantastique;

import java.util.ArrayList;
import java.util.Scanner;

public class View {

    public static View instance = null;
    private Controller controlleur;

    private View() {
        controlleur = new Controller();
    }

    public static View getInstance() {
        if (instance == null) {
            instance = new View();
        }

        return instance;
    }

    public String entreeCommande(String commande) {
        if (commande.equals("exit")) return "exit";
        if (commande.equals("")) return "";
        return controlleur.entreeCommande(commande);
    }
    public void CreerUnZoo(String nom, String nomMaitreDeZoo) {
        controlleur.CreerUnZoo(nom, nomMaitreDeZoo);
    }
    public void showScreen(int moreLengthName, ArrayList<String> nomCreatures, ArrayList<String> nomEnclos) {
        if (moreLengthName < "Créatures".length()) {
            moreLengthName = "Créatures".length();
        }
        System.out.println("Créatures" + "\t".repeat(((moreLengthName / 4) - 1) < 0 ? 0 : ((moreLengthName / 4) - 1)) +
                "Enclos"+ "\t".repeat(Math.max(((moreLengthName / 4) - 1), 0)) +
                "Malades" + "\t".repeat(Math.max(((moreLengthName / 4) - 1), 0)) +
                "Faim");

        for (int i = 0; i < 5; i++) {
            String creature = (i < nomCreatures.size() && !nomCreatures.get(i).isEmpty()) ? nomCreatures.get(i) + "\t".repeat((moreLengthName-nomCreatures.get(i).length())/4) : "\t".repeat((moreLengthName+1/4)-1);
            String enclos = (i < nomEnclos.size() && !nomEnclos.get(i).isEmpty()) ? nomEnclos.get(i) + "\t".repeat((moreLengthName-nomEnclos.get(i).length())/4)  : "\t".repeat((moreLengthName+1/4)-1);;

            System.out.println(creature + "\t" + enclos);
        }
        System.out.println("...\t...\t...\t...");
    }


}
