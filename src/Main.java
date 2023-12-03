import app.Controller;
import app.View;
import includes.creatures.Dragon;
import includes.creatures.DragonFemelle;
import includes.creatures.SexesEnum;
import includes.enclos.Enclos;
import includes.enclos.EnclosVoliere;
import includes.zoo.zooFantastique;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        System.out.print("Donnez un nom à votre zoo : ");
        String nom = myObj.nextLine();
        System.out.print("Donnez un nom à votre maitre de zoo : ");
        zooFantastique zoo = View.getInstance().CreerUnZoo(nom, myObj.nextLine());
        /*
        ThreadDeTest t1 = new ThreadDeTest(zoo);
        t1.start();
         */
        String resCommande = "";
        while(true) {
            System.out.print(View.getInstance().affichageInfos1());
            resCommande = View.getInstance().entreeCommande(myObj.nextLine()); // Lis la commande de l'utilisateur
            if (resCommande.equals("exit")) break; // Si l'utilisateur veut quitter le jeu alors on sors de la boucle
            clear();
            //View.showScreen();
            System.out.println(resCommande); // Affiche le résultat de sa commande (si il y en a un);
        }
        // Faire le processus de sauvegarde
    }

    static private void clear()
    {
        for(int i = 0; i < 250; i++) {
            System.out.println();
        }
    }
}