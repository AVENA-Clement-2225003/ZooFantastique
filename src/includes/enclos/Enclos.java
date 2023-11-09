package includes.enclos;

import includes.enclos.PropreteEnum;

import java.util.ArrayList;

/**
 * Classe qui représente un enclos
 */
public abstract class Enclos {
    /**
     * Nom de l'enclos
     */
    private String nom;
    /**
     * Superficie de l'enclos
     */
    private int superficie;
    /**
     * Capacitée maximale de l'enclos
     */
    private int capaciteEnclos;
    /**
     * Le nombre de créature présentes dnas l'enclos
     */
    private int nbCreaturesDansEnclos;
    /**
     * La liste contenant les créatures présentes
     */
    private ArrayList<Creature> listeCreatures;
    /**
     * Degré de propreté de l'encos
     */
    private PropreteEnum propreteEnum;

    /**
     * Contructeur simple
     * @param nom Nom de l'enclos
     * @param superficie Superficie de l'enclos
     */
    public Enclos(String nom, int superficie, int capaciteEnclos) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteEnclos = capaciteEnclos;
        this.nbCreaturesDansEnclos = 0;
        this.propreteEnum = PropreteEnum.BON;
        this.listeCreatures = new ArrayList<>();
    }

    /**
     * Fonction permettant surtout des tests rapide grâce à la possibilité de définir tous les champs dès sa contruction
     * @param nom Le nom de l'enclos
     * @param superficie La superficie de l'enclos
     * @param capaciteEnclos La capacité maximale de l'enclos
     * @param propreteEnum Le degré de propreté qui peut etre MAUVAIS, CORRECT, BON
     * @param listeCreatures La liste des créatures présentent dans l'enclos
     */
    public Enclos(String nom, int superficie, int capaciteEnclos, PropreteEnum propreteEnum, ArrayList<Creature> listeCreatures) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteEnclos = capaciteEnclos;
        this.nbCreaturesDansEnclos = listeCreatures.size(); //Prend automatiquement la taille de la liste des créatures
        this.propreteEnum = propreteEnum;
        this.listeCreatures = listeCreatures;
    }

    /**
     * Permet de récupérer la valeur de la variable nom
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Permet de changer la valeur de la variable nom
     * @return
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Permet de récupérer la valeur de la variable superficie
     * @return
     */
    public int getSuperficie() {
        return superficie;
    }
    /**
     * Permet de changer la valeur de la variable superficie
     * @return
     */
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }
    /**
     * Permet de récupérer la valeur de la variable capaciteEnclos
     * @return
     */
    public int getCapaciteEnclos() {
        return capaciteEnclos;
    }
    /**
     * Permet de changer la valeur de la variable capaciteEnclos
     * @return
     */
    public void setCapaciteEnclos(int capaciteEnclos) {
        this.capaciteEnclos = capaciteEnclos;
    }
    /**
     * Permet de récupérer la valeur de la variable nbCreaturesDansEnclos
     * @return
     */
    public int getNbCreaturesDansEnclos() {
        return nbCreaturesDansEnclos;
    }
    /**
     * Permet de changer la valeur de la variable nbCreaturesDansEnclos
     * @return
     */
    public void setNbCreaturesDansEnclos(int nbCreaturesDansEnclos) {
        this.nbCreaturesDansEnclos = nbCreaturesDansEnclos;
    }
    /**
     * Permet de récupérer la valeur de la variable listeCreatures
     * @return
     */
    public ArrayList<Creature> getListeCreatures() {
        return listeCreatures;
    }
    /**
     * Permet de changer la valeur de la variable listeCreatures
     * @return
     */
    public void setListeCreatures(ArrayList<Creature> listeCreatures) {
        this.listeCreatures = listeCreatures;
    }
    /**
     * Permet de récupérer la valeur de la variable proprete
     * @return
     */
    public PropreteEnum getProprete() {
        return propreteEnum;
    }
    /**
     * Permet de changer la valeur de la variable proprete
     * @return
     */
    public void setProprete(PropreteEnum propreteEnum) {
        this.propreteEnum = propreteEnum;
    }

    /**
     * Fonction permettant l'entretient de l'enclos
     * @return
     */
    public abstract int entretientEnclos();

    /**
     * Fonction d'affichage de l'enclos
     * @return
     */
    @Override
    public String toString() {
        return "includes.enclos.Enclos{" +
                "nom='" + nom + '\'' +
                ", superficie=" + superficie +
                ", capaciteEnclos=" + capaciteEnclos +
                ", nbCreaturesDansEnclos=" + nbCreaturesDansEnclos +
                ", listeCreatures=" + listeCreatures.toString() +
                ", proprete=" + propreteEnum +
                '}';
    }
}
