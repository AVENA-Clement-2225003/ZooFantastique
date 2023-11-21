package app;

import java.util.ArrayList;

import includes.creatures.Creature;
import includes.enclos.Enclos;

import java.util.ArrayList;

public class View {
    private Controller Controlleur;
    public void entreeCommande(String commande) {
        if (!Character.isLetter(commande.charAt(0))) {
            System.out.println("N'est pas une commande, retirez l'espace devant");
        }
        int i = 0;
        String nomCommande = "";
        while (i < commande.length() && commande.charAt(i) != ' ') { //Récupération du nom de la commande
            nomCommande += commande.charAt(i);
            i++;
        }
        if (i < commande.length()) {
            i++; //Pour sauter l'espace
            ArrayList<String> tabOption = new ArrayList<>();
            String option;
            while (i < commande.length()) { // Récupération des options associées
                option = "";
                while (i < commande.length() && commande.charAt(i) != ' ') {
                    option += commande.charAt(i);
                    i++;
                }
                tabOption.add(option);
                i++; //Sauter l'espace pour commencer la récupération de la prochaine option
            }
            //Controlleur.executerCommande(nomCommande, tabOption);
        }else {
            //Controlleur.executerCommande(nomCommande, new ArrayList<>());
        }
        //potentiel appel de fonction executerCommande(nomCommande, tabOption);
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
