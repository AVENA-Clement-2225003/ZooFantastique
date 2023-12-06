package includes.creatures;

import includes.enclos.Enclos;

import java.util.Random;

/**
 * Classe abstraite qui decrit les creatures.
 */
public abstract class Creature {

    /**
     * Permet de création de numéro de creature unique
     */
    private static int lastID = 0;
    /**
     * Numéro unique de la creature
     */
    private int ID;

    /**
     * Nom de l'espece de la creature
     */
    private EspecesEnum nomEspece;

    /**
     * includes.creatures.Sexe de la creature
     */
    private SexesEnum sexe;

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
     * Nom de la creature (ne depend pas de son espece)
     */
    private String nom;

    /**
     * Enclos dans lequel est la creature
     */
    private Enclos enclos;

    /**
     * Age auquel la creature meurt (si elle ne meurt pas avant a cause de sa sante)
     */
    private int ageMort;

    /**
     * Constructeur de la classe abstraite includes.creatures.Creature
     * @param nomEspece nom de l'espece de la creature
     * @param sexe sexe de la creature
     * @param poids poids de la creature
     * @param taille taille de la creature
     * @param age age de la creature
     * @param faim faim de la creature
     * @param estEnTrainDeDormir sommeil de la creature
     * @param sante sante de la creature
     * @param nom nom de la creature (ne depend pas de son espece)
     * @param enclos Enclos de la creature
     */
    public Creature(EspecesEnum nomEspece, SexesEnum sexe, int poids, int taille, int age, boolean faim, boolean estEnTrainDeDormir, boolean sante, String nom, Enclos enclos) {
        this.ID = lastID++;
        this.nomEspece = nomEspece;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.faim = faim;
        this.estEnTrainDeDormir = estEnTrainDeDormir;
        this.sante = sante;
        this.nom = nom;
        this.enclos = enclos;
        Random r = new Random();
        this.ageMort = r.nextInt((80 - 30) + 1) + 30; // Age de mort entre 30 et 80 ans
    }

    /**
     * Fonction qui permet a la creature de manger
     */
    public String manger(){
        if (this.estEnTrainDeDormir){
            return (this.nomEspece + " " + this.nom + " ne peut pas manger, il dort");
        }
        else {
            faim = false;
            return (this.nomEspece + " " + this.nom + " est en train de manger");
        }

    }

    /**
     * Fonction qui permet a la creature d'emettre un son
     */
    public abstract String emettreUnSon();

    /**
     * Fonction qui permet a la creature d'etre soigne
     */
    public String etreSoigne(){
        this.sante = true;
        if (this.sexe == SexesEnum.FEMELLE) return this.nomEspece + " " + this.nom + " est soignée";
        return this.nomEspece + " " + this.nom + " est soigné";
    }

    /**
     * Fonction qui permet a la creature d'etre soigne true si vivant false sinon
     */
    public boolean estVivant(){
        return !(this.age == this.ageMort);
    }

    /**
     * Fonction qui permet a la creature de s'endormir ou se reveiller
     */
    public String endormir(){
        if (this.estEnTrainDeDormir){
            estEnTrainDeDormir = false;
            return(this.nomEspece  + " " + this.nom + " se reveille");
        }
        else {
            estEnTrainDeDormir = true;
            return (this.nomEspece + " " + this.nom + " s'endort");
        }
    }

    /**
     * Fonction qui permet a la creature de vieillir
     */
    public String vieillir() {
        age++;
        return "" + age;
    }

    /**
     * Fonction qui permet d'afficher les caracteristiques de la creature
     * @return String toString
     */
    @Override
    public String toString() {
        return "nom : " + nom + " | espece : " + nomEspece + " | age : " + age + " | a faim : " + ((faim)?" oui ":" non ") +
                " | en bonne sante : " + ((sante)?" oui ":" non ") + " | dort : " + ((estEnTrainDeDormir)?" oui ":" non ") + " | Enclos : " + enclos.getNom();
    }

    public String afficherCreature(){
        return "La creature " + nom + " de type " + nomEspece + ", d'identifiant " + ID + " et de sexe " + sexe +
                 " fait " + taille + " cm, " + poids + " kg, a " + age + " ans, " + ((faim)?"a faim, ":"n'a pas faim, ") +
                 ((estEnTrainDeDormir)?"a sommeil et ":"n'a pas sommeil et ") + ((sante)?"est en bonne sante":"n'est pas en bonne sante");
    }

    /**
     * Getter de lastID
     * @return int lastID
     */
    public static int getLastID() {
        return lastID;
    }

    /**
     * Getter de ID
     * @return int ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Setter de ID
     * @param ID ID de la creature
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Getter de nomEspece
     * @return EspecesEnum nomEspece
     */
    public EspecesEnum getNomEspece() {
        return nomEspece;
    }

    /**
     * Setter de nomEspece
     * @param nomEspece nom de l'espece de la creature
     */
    public void setNomEspece(EspecesEnum nomEspece) {
        this.nomEspece = nomEspece;
    }

    /**
     * Getter de sexe
      * @return SexesEnum sexe
     */
    public SexesEnum getSexe() {
        return sexe;
    }

    /**
     * Setter du sexe
     * @param sexe sexe de la creature
     */
    public void setSexe(SexesEnum sexe) {
        this.sexe = sexe;
    }

    /**
     * Getter du poids
     * @return int poids
     */
    public int getPoids() {
        return poids;
    }

    /**
     * Setter du poids
     * @param poids poids de la creature
     */
    public void setPoids(int poids) {
        this.poids = poids;
    }

    /**
     * Getter de la taille
     * @return int taille
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Setter de la taille
     * @param taille taille de la creature
     */
    public void setTaille(int taille) {
        this.taille = taille;
    }

    /**
     * Getter de l age
     * @return int age
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter de l age
     * @param age age de la creature
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter de la faim
     * @return boolean faim
     */
    public boolean isFaim() {
        return faim;
    }

    /**
     * Setter de la faim
     * @param faim faim de la creature
     */
    public void setFaim(boolean faim) {
        this.faim = faim;
    }

    /**
     * Getter du sommeil
     * @return boolean estEnTrainDeDormir
     */
    public boolean isEstEnTrainDeDormir() {
        return estEnTrainDeDormir;
    }

    /**
     * Setter du sommeil de la creature
     * @param estEnTrainDeDormir sommeil de la creature
     */
    public void setEstEnTrainDeDormir(boolean estEnTrainDeDormir) {
        this.estEnTrainDeDormir = estEnTrainDeDormir;
    }

    /**
     * Getter de la sante
     * @return boolean sante
     */
    public boolean isSante() {
        return sante;
    }

    /**
     * Setter de la sante de la creature
     * @param sante sante de la creature
     */
    public void setSante(boolean sante) {
        this.sante = sante;
    }

    /**
     * Getter du nom
     * @return String nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter du nom
     * @param nom nom de la creature
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter de l'enclos
     * @return enclos
     */
    public Enclos getEnclos() {
        return enclos;
    }

    /**
     * Setter de l'enclos
     * @param enclos Enclos
     */
    public void setEnclos(Enclos enclos) {
        this.enclos = enclos;
    }

    /**
     * Getter de l'age de la mort
     * @return ageMort int
     */
    public int getAgeMort() {
        return ageMort;
    }

    /**
     * Setter de l'age de la mort
     * @param ageMort int
     */
    public void setAgeMort(int ageMort) {
        this.ageMort = ageMort;
    }
}
