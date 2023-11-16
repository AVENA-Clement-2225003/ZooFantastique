package app;

import java.util.ArrayList;

public class Controller {
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
            //executerCommande(nomCommande, tabOption);
        }else {
            //executerCommande(nomCommande, new ArrayList<>());
        }
        //potentiel appel de fonction executerCommande(nomCommande, tabOption);
    }
    /*public int executerCommande(String nomCommande, ArrayList<String> tabOption) {
        switch (nomCommande) {
            case "help":
                if(tabOption.isEmpty()) {
                    System.out.println("Liste de toutes les commandes : soigner, nourir, renommerCreature, nettoyer, renommerEnclos, deplacer, reproduire, retirerCadavre, creerEnclos, supprimerEnclos\nPour plus d'aide help nomCommande");
                }else {
                    entreeCommande("help " + tabOption.get(0));
                }
                break;
            case "soigner":
                System.out.println("Commande pour soigner un animal\nTapez soigner leNomAnimal");
                break;
            case "nourir":
                System.out.println("Commande pour nourir un animal\nTapez nourir leNomAnimal");
                break;
            case "renommerCreature":
                System.out.println("Commande pour renommer un animal\nTapez renommerCreature leNomAnimal LeNouveauNom");
                break;
            case "nettoyer":
                System.out.println("Commande pour nettoyer un enclos\nTapez nettoyer leNomEnclos");
                break;
            case "renommerEnclos":
                System.out.println("Commande pour renommer un enclos\nTapez renomerEnclos leNomEnclos leNouveauNom");
                break;
            case "retirerCadavre":
                System.out.println("Commande pour retirer un animal mort\nTapez retirerCadrave leNomAnimal");
                break;
            case "supprimerEnclos":
                System.out.println("Commande pour supprimer un enclos VIDE\nTapez suppri leNomAnimal");
                break;
            case "soigner":
                System.out.println("Commande pour soiger un animal\nTapez soigner leNomAnimal");
                break;
            case "soigner":
                System.out.println("Commande pour soiger un animal\nTapez soigner leNomAnimal");
                break;
            case "soigner":
                System.out.println("Commande pour soiger un animal\nTapez soigner leNomAnimal");
                break;
        }
    }*/
}
