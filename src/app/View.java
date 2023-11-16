package app;

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
            Controlleur.executerCommande(nomCommande, tabOption);
        }else {
            Controlleur.executerCommande(nomCommande, new ArrayList<>());
        }
        //potentiel appel de fonction executerCommande(nomCommande, tabOption);
    }
}
