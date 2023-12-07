package includes.zoo;

import app.View;
import includes.creatures.Creature;
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
     * @return retourne la liste des enclos
     */

    public ArrayList<Enclos> getEnclosExistant() {
        return enclosExistant;
    }

    /**
     * Permet de mettre une valeur d'enclos maximal
     * @param maxEnclos nombre d'enclos maximum dans le zoo
     */
    public void setMaxEnclos(int maxEnclos) {
        this.maxEnclos = maxEnclos;
    }

    /**
     * Permet de récupérer la valeur d'enclos maximal
     * @return retourne la valeur d'enclos maximal
     */
    public int getMaxEnclos() {
        return maxEnclos;
    }

    /**
     * Permet de récupérer le nom du zoo
     * @return retourne le nom du zoo
     */

    public String getNom() {
        return nom;
    }

    /**
     * Permet de mettre un nom au zoo
     * @param nom nom du zoo
     */

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Permet de récupérer la liste des enclos
     * @param enclosExistant nombre d'enclos existant
     */
    public void setEnclosExistant(ArrayList<Enclos> enclosExistant) {
        this.enclosExistant = enclosExistant;
    }

    /**
     * Fonction qui compte le nombre de créature dans le zoo
     * @return retourne le nombre de créature dans le zoo
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
     * @return Les caractéristiques du zoo
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
     * @return retourne les caractéristiques des créatures du zoo
     */
    public String afficherCreature() {
        String strConteneur = "Le zoo : " + nom + " comporte les créatures suivantes :\n";
        for (int i = 0; i < enclosExistant.size(); i++) {
            strConteneur += enclosExistant.get(i).afficherCreatures();
        }
        return strConteneur;
    }

    /**
     * Permet d'afficher un enclos choisi du zoo, ainsi que ses animaux
     * @param nomEnclos le nom de l'enclos cible
     * @return les caractéristiques de l'enclos cible
     */
    public Enclos getEnclosByNom(String nomEnclos) {
        for(Enclos e:enclosExistant){
            if (e.getNom().equals(nomEnclos)) return e;
        }
        return null;
    }

    /**
     * Permet d'afficher un enclos choisi du zoo, ainsi que ses animaux
     * @param nomCreature le nom de la créature cible
     * @return retourne les caractéristiques de la créature cible
     */
    public Creature getCreatureByNom(String nomCreature) {
        for(Enclos e:enclosExistant){
            for(Creature c:e.getListeCreatures())
                if (c.getNom().equals(nomCreature)) return c;
        }
        return null;
    }

    /**
     * Permet d'afficher un enclos choisi du zoo, ainsi que ses animaux
     * @param nvEnclos prend le nom du nouvelle enclos
     */
    public void ajouterEnclos(Enclos nvEnclos) {
        enclosExistant.add(nvEnclos);
    }

}
