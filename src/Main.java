import app.View;
import includes.creatures.*;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import includes.zoo.zooFantastique;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Main de l'application, qui lance le systeme de commande et le thread de jeu
 */
public class Main {
    public static void main(String[] args){
        /*
        Scanner myObj = new Scanner(System.in);
        System.out.print("Donnez un nom à votre zoo : ");
        String nom = myObj.nextLine();
        System.out.print("Donnez un nom à votre maitre de zoo : ");
        zooFantastique zoo = View.getInstance().CreerUnZoo(nom, myObj.nextLine());
         */
        Enclos lycan = new EnclosStandard("Enclos des lycanthropes", 20, 20);
        Meute m = new Meute("MeuteDesBg", new ArrayList<Lycanthrope>());
        Lycanthrope l1 = new LycanthropeMale(60, 120, 25, "L1", lycan, RangEnum.Beta, 20, m);
        Lycanthrope l2 = new LycanthropeMale(60, 120, 25, "L2", lycan, RangEnum.Beta, 20, m);
        Lycanthrope l3 = new LycanthropeMale(60, 120, 25, "L3", lycan, RangEnum.Beta, 20, null);
        Lycanthrope l4 = new LycanthropeMale(60, 120, 25, "L4", new EnclosStandard("AutreEnclos", 20, 20), RangEnum.Beta, 20, null);

        l1.getEnclos().ajouterCreature(l1);
        l2.getEnclos().ajouterCreature(l2);
        l3.getEnclos().ajouterCreature(l3);
        l4.getEnclos().ajouterCreature(l4);
        Hurlement h = new Hurlement(HurlementEnum.Appartenance);
        l1.emettreUnSon(h);
        /*
        Thread t1 = new Thread(zoo);
        t1.start();

        String resCommande = "";
        while(true) {
            System.out.print(View.getInstance().affichageInfos());
            resCommande = View.getInstance().entreeCommande(myObj.nextLine()); // Lis la commande de l'utilisateur
            if (resCommande.equals("exit")) break; // Si l'utilisateur veut quitter le jeu alors on sors de la boucle
            clear();
            System.out.println(resCommande); // Affiche le résultat de sa commande (si il y en a un);
        }
        // Faire le processus de sauvegarde

         */
    }

    static private void clear()
    {
        for(int i = 0; i < 250; i++) {
            System.out.println();
        }
    }
}