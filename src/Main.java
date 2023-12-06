import app.View;
import includes.zoo.zooFantastique;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        System.out.print("Donnez un nom à votre zoo : ");
        String nom = myObj.nextLine();
        System.out.print("Donnez un nom à votre maitre de zoo : ");
        zooFantastique zoo = View.getInstance().CreerUnZoo(nom, myObj.nextLine());

        /*Thread t1 = new Thread(zoo);
        t1.start();*/

        String resCommande = "";
        while(true) {
            System.out.print(View.getInstance().affichageInfos());
            resCommande = View.getInstance().entreeCommande(myObj.nextLine()); // Lis la commande de l'utilisateur
            if (resCommande.equals("exit")) break; // Si l'utilisateur veut quitter le jeu alors on sors de la boucle
            clear();
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