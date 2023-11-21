import includes.creatures.LicorneFemelle;
import includes.creatures.LicorneMale;
import includes.creatures.LycanthropeFemelle;
import includes.creatures.LycanthropeMale;
import includes.enclos.Enclos;
import app.View;
import includes.enclos.EnclosStandard;
import includes.enclos.EnclosVoliere;
import includes.zoo.zooFantastique;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println(zoo);
        String resCommande = "";
        Scanner myObj = new Scanner(System.in);
        while(true) {
            resCommande = View.entreeCommande(myObj.nextLine()); // Lis la commande de l'utilisateur
            if (resCommande.equals("exit")) break; // Si l'utilisateur veut quitter le jeu alors on sors de la boucle
            System.out.println(resCommande); // Affiche le résultat de sa commande (si il y en a un);
        }
        // Faire le processus de sauvegarde
    }
}