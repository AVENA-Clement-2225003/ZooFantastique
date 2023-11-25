package app;

import app.Error;
import java.util.ArrayList;

public class Controller {
    Model modele = new Model();
    public void CreerUnZoo(String nom, String nomMaitreDeZoo) {
        modele.CreerUnZoo(nom, nomMaitreDeZoo);
    }
    public String entreeCommande(String commande) {
        if (!Character.isLetter(commande.charAt(0))) {
            return "N'est pas une commande, retirez l'espace devant";
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
            return executerCommande(nomCommande, tabOption);
        }else {
            return executerCommande(nomCommande, new ArrayList<>());
        }
        //potentiel appel de fonction return executerCommande(nomCommande, tabOption);
    }
    public String executerCommande(String nomCommande, ArrayList<String> tabOption) {
        switch (nomCommande) {
            case "help":
                if(tabOption.isEmpty()) {
                    return "Liste de toutes les commandes : soigner, nourrir, renommerCreature, nettoyer, renommerEnclos, deplacer, reproduire, retirerCadavre, creerEnclos, supprimerEnclos, infos, exit\nPour plus d'aide help nomCommande";
                }else {
                    switch (tabOption.get(0)) {
                        case "soigner":
                            return "Commande pour soigner un animal\nTapez " + "\\u001B[32m" + "soigner leNomAnimal" + "\\u001B[0m";
                        case "nourrir":
                            return "Commande pour nourrir un animal\nTapez nourrir leNomAnimal";
                        case "renommerCreature":
                            return "Commande pour renommer un animal\nTapez renommerCreature leNomAnimal LeNouveauNom";
                        case "nettoyer":
                            return "Commande pour nettoyer un enclos\nTapez nettoyer leNomEnclos";
                        case "renommerEnclos":
                            return "Commande pour renommer un enclos\nTapez renomerEnclos leNomEnclos leNouveauNom";
                        case "retirerCadavre":
                            return "Commande pour retirer un animal mort\nTapez retirerCadrave leNomAnimal";
                        case "supprimerEnclos":
                            return "Commande pour supprimer un enclos VIDE\nTapez suppri leNomAnimal";
                        case "infos":
                            return "Permet de visualiser les informations en fonction de l'option \"zoo\", \"maitreZoo\" ou \"Enclos nomEnclos\"";
                        case "exit":
                            return "Commande pour quitter le jeu";
                        default:
                            return "Erreur help: commande non reconnue";
                    }
                }
            case "infos":
                if (tabOption.isEmpty() || tabOption.get(0).equals("")) return "Il manque des options (zoo, enclos, maitreZoo)";
                switch (tabOption.get(0)) {
                    case "zoo":
                        return modele.getZoo().toString();
                    case "maitreZoo":
                        return modele.getMaitre().toString();
                    case "enclos":
                        if (tabOption.size() < 2) return modele.getZoo().getEnclosExistant().toString();
                        //return modele.getZoo().getEnclosByNom(tabOption.get(1));
                }
            case "e":
                return "Commande pour soiger un animal\nTapez soigner leNomAnimal";
            case "b":
                return "Commande pour soiger un animal\nTapez soigner leNomAnimal";
            default:
                return "Commande non reconnue";
        }
    }
}
