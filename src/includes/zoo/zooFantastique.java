package includes.zoo;

import includes.enclos.Enclos;

import java.util.ArrayList;

/**
 * Classe qui représente le zoo
 */
public class zooFantastique {
    /**
     * Nom du zoo
     */
    private String nom;
    /**
     * Maître du zoo
     */
    private String maitreZoo;
    /**
     * Nombre maximal d'enclos dans le zoo
     */
    private int maxEnclos;
    /**
     * Nombre d'enclos existant
     */
    private ArrayList<Enclos> enclosExistant;

    /**
     * Récupère la liste des enclos
     * @return
     */

    public ArrayList<Enclos> getEnclosExistant() {
        return enclosExistant;
    }

    /**
     * Permet de mettre une valeur d'enclos maximal
     * @param maxEnclos
     */
    public void setMaxEnclos(int maxEnclos) {
        this.maxEnclos = maxEnclos;
    }

    /**
     * Permet de récupérer le nom du zoo
     * @return
     */

    public String getNom() {
        return nom;
    }

    /**
     * Permet de mettre un nom au zoo
     * @param nom
     */

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Permet de récupérer la liste des enclos
     * @param enclosExistant
     */
    public void setEnclosExistant(ArrayList<Enclos> enclosExistant) {
        this.enclosExistant = enclosExistant;
    }
    public void compteEnclos(ArrayList<Enclos> enclosExistant){
        for( Enclos enclos : enclosExistant){

        }
    }
}
