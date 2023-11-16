package includes.zoo;

import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;

import java.util.ArrayList;

/**
 * Classe qui représente le zoo
 */
public class zooFantastique {
    public zooFantastique(String nom, String maitreZoo, int maxEnclos, ArrayList<Enclos> enclosExistant) {
        this.nom = nom;
        this.maitreZoo = maitreZoo;
        this.maxEnclos = maxEnclos;
        this.enclosExistant = enclosExistant;
    }

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

    /**
     * Permet de retourner le nombre de créature dans le zoo
     * @return
     */
    public int compteNbCreatureZoo(){
        int cpt = 0;
        for( Enclos enclos : enclosExistant){
            cpt += enclos.getListeCreatures().size();
        }
        return cpt;
    }

    /**
     * Fonction d'affichage du zoo
     * @return
     */
    @Override
    public String toString() {
        return "zooFantastique{" +
                "nom='" + nom + '\'' +
                ", maitreZoo='" + maitreZoo + '\'' +
                ", maxEnclos=" + maxEnclos +
                ", enclosExistant=" + enclosExistant +
                '}';
    }
    /**
     * Permet d'afficher les créatures du zoo fantastique
     * @return
     */
    public String AfficherCreature() {
        String strConteneur = "Le zoo : " + nom + " avec les créatures :  {" + enclosExistant.get(0).afficherCreatures();
        for (int i = 1; i < enclosExistant.size(); i++) {
            strConteneur += ", " + enclosExistant.get(i).afficherCreatures();
        }
        return strConteneur + '}';
    }

    /**
     * Permet d'afficher un enclos choisi du zoo, ainsi que ses animaux
     * @param enclos
     * @return
     */
    public String getEnclosByNom(Enclos enclos) {
        return enclos.toString();
    }

}
