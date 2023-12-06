package app;

import includes.zoo.zooFantastique;

import java.util.ArrayList;

/**
 * Classe Vue de notre application
 */
public class View {
    /**
     * Instance de la classe View
     */
    public static View instance = null;
    /**
     * Instance de la classe Controller
     */
    private Controller controlleur;

    /**
     * Contructeur de la classe View
     */
    private View() {
        controlleur = Controller.getInstance();
    }

    /**
     * Fonction permettant de n'avoir qu'une seule instance de classe de View
     * @return
     */
    public static View getInstance() {
        if (instance == null) {
            instance = new View();
        }

        return instance;
    }

    /**
     * Fonction qui va traiter le cas de la commande exit et vide, ou la transmettre pour découpage et execution
     * @param commande
     * @return
     */
    public String entreeCommande(String commande) {
        if (commande.equals("exit")) return "exit";
        if (commande.equals("")) return "";
        return controlleur.entreeCommande(commande);
    }

    /**
     * Fonction qui va afficher les informations sous forme de tableau dans le shell
     * @return
     */
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

    /**
     * Fonction qui permet de généer les lignes en fonction de l'espacement donné (sert à aligner les colonnes du tableau)
     * @param value
     * @param width
     * @return
     */
    private String formatColumn(String value, int width) {
        return String.format("%-" + (width) + "s", value);
    }

    /**
     * Fonction qui va appeller la fonction CreerUnZoo() du controlleur
     * @param nom
     * @param nomMaitreDeZoo
     * @return
     */
    public zooFantastique CreerUnZoo(String nom, String nomMaitreDeZoo) {
        zooFantastique zoo = controlleur.CreerUnZoo(nom, nomMaitreDeZoo);
        return zoo;
    }
}
