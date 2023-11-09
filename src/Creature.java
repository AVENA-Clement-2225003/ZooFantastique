/**
 * Classe abstraite qui decrit les creatures.
 */
public abstract class Creature {

    /**
     * Nom de l'espece de la creature
     */
    private EspecesEnum nomEspece;

    /**
     * Sexe de la creature
     */
    private Sexe sexe;

    /**
     * Poids de la creature
     */
    private int poids;

    /**
     * Taille de la creature
     */
    private int taille;

    /**
     * Age de la creature
     */
    private int age;

    /**
     * Faim de la creature
     */
    private boolean faim;

    /**
     * Sommeil de la creature
     */
    private boolean estEnTrainDeDormir;

    /**
     * Sante de la creature
     */
    private boolean sante;

    /**
     * Fonction qui permet a la creature de manger
     */
    public abstract void manger();

    /**
     * Fonction qui permet a la creature d'emettre un son
     */
    public abstract void emettreUnSon();

    /**
     * Fonction qui permet a la creature d'etre soigne
     */
    public abstract void etreSoigne();

    /**
     * Fonction qui permet a la creature de s'endormir ou se reveiller
     */
    public abstract void endormir();

    /**
     * Fonction qui permet a la creature de vieillir
     */
    public abstract void vieillir();

    /**
     * Fonction qui permet d'afficher les caracteristiques de la creature
     * @return String toString
     */
    public abstract String toString();



}
