import app.View;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        System.out.print("Donnez un nom à votre zoo : ");
        String nom = myObj.nextLine();
        System.out.print("Donnez un nom à votre maitre de zoo : ");
        View.getInstance().CreerUnZoo(nom, myObj.nextLine());
        String resCommande = "";
        while(true) {
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