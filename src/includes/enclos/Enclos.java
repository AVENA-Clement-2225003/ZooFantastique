package includes.enclos;

import includes.creatures.Creature;

import java.util.ArrayList;

/**
 * Classe qui représente un enclos
 */
public abstract class Enclos {
    /**
     * Permet de création de numéro d'enclos unique
     */
    private static int lastID = 0;
    /**
     * Numéro unique de l'enclos
     */
    private int ID;
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
     * Constructeur simple
     * @param nom Nom de l'enclos
     * @param superficie Superficie de l'enclos
     * @param capaciteEnclos Capacité de l'enclos
     */
    public Enclos(String nom, int superficie, int capaciteEnclos) {
        this.ID = this.lastID++;
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
        this.ID = this.lastID++;
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteEnclos = capaciteEnclos;
        this.nbCreaturesDansEnclos = listeCreatures.size(); //Prend automatiquement la taille de la liste des créatures
        this.propreteEnum = propreteEnum;
        this.listeCreatures = listeCreatures;
    }

    /**
     * Permet de récupérer la valeur de la variable lastID
     * @return
     */
    public static int getLastID() {
        return lastID;
    }

    /**
     * Permet de récupérer la valeur de la variable ID
     * @return
     */
    public int getID() {
        return ID;
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

    /**
     * Fonction qui permet de nourrir toutes les créatures de l'enclos
     * @return 0 si tous les animaux sont nourrit, 1 sinon
     */
    public int nourrirCreatures(){
        for (Creature creature : listeCreatures){
            creature.setFaim(false);
        }
        return 0;
    }

    /**
     * Fonction permettant l'ajout d'une créature dans l'enclos
     * @param creature Créature à ajouter
     * @return 0 si la créature est ajoutée
     */
    public int ajouterCreature(Creature creature){ //la vérification que le type de creature est le même que les autres se fera dans le MVC
        listeCreatures.add(creature);
        return 0;
    }

    /**
     * Fonction permmettant la suppression d'un créature dans l'enclos
     * @return 0 si la suppression à fonctionner
     */
    public int retirerCreature(Creature creature){
        listeCreatures.remove(getIndexCreature(creature));
        return 0;
    }

    /**
     * Fonction qui permet de récupérer l'indice d'une créature dans la liste des créatures
     * @param creature
     * @return
     */
    public int getIndexCreature(Creature creature){
        for (int i = 0; i < listeCreatures.size(); i++){
            if(listeCreatures.get(i).getID() == listeCreatures.get(i).getID()){
                return i;
            }
        }
        return listeCreatures.size();
    }
    /**
     * Fonction qui permet de savoir si une créature existe dans la liste des créatures
     * @param creature
     * @return true si elle existe false sinon
     */
    public boolean existInListeCreature(Creature creature){
        for (Creature creatureListe : listeCreatures){
            if(creatureListe.getID() == creature.getID()){
                return true;
            }
        }
        return false;
    }
}
