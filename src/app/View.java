package app;

import includes.zoo.zooFantastique;

import java.util.ArrayList;

public class View {

    public static View instance = null;
    private Controller controlleur;

    private View() {
        controlleur = Controller.getInstance();
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
    public String affichageInfos() {
        ArrayList<ArrayList<String>> liste = Controller.getInstance().DonnesAffichageZoo();
        int enclosWidth = 15;
        int maladeWidth = 15;
        int mortWidth = 15;
        int faimWidth = 15;
        int dormirWidth = 15;

        String str = "| " + formatColumn("Enclos", enclosWidth) + " | " + formatColumn("Malades", maladeWidth) + " | " + formatColumn("Morts", mortWidth) + " | " + formatColumn("Faim", faimWidth) + " | " + formatColumn("Dors", dormirWidth) + " |\n|";
        for (int i = 0; i < enclosWidth+2; ++i) {str += "-";}
        str += "|";
        for (int i = 0; i < maladeWidth+2; ++i) {str += "-";}
        str += "|";
        for (int i = 0; i < mortWidth+2; ++i) {str += "-";}
        str += "|";
        for (int i = 0; i < faimWidth+2; ++i) {str += "-";}
        str += "|";
        for (int i = 0; i < dormirWidth+2; ++i) {str += "-";}
        str += "|\n";
        for (int i = 0; i < 7; ++i) {
            if (liste.get(0).get(i).equals(" ") && liste.get(1).get(i).equals(" ") &&
                    liste.get(2).get(i).equals(" ") && liste.get(3).get(i).equals(" ") && liste.get(4).get(i).equals(" ")) {
                break;
            }
            str += "| " + formatColumn(liste.get(0).get(i), enclosWidth) + " | " +
                    formatColumn(liste.get(1).get(i), maladeWidth) + " | " +
                    formatColumn(liste.get(2).get(i), mortWidth) + " | " +
                    formatColumn(liste.get(3).get(i), faimWidth) + " | " +
                    formatColumn(liste.get(4).get(i), dormirWidth) + " |\n";
        }
        str += "\nSaisir votre commande : ";
        return str;
    }
    private String formatColumn(String value, int width) {
        return String.format("%-" + (width) + "s", value);
    }


    public zooFantastique CreerUnZoo(String nom, String nomMaitreDeZoo) {
        zooFantastique zoo = controlleur.CreerUnZoo(nom, nomMaitreDeZoo);
        return zoo;
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
