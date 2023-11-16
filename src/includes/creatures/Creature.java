package includes.creatures;

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
     */
    public Creature(EspecesEnum nomEspece, SexesEnum sexe, int poids, int taille, int age, boolean faim, boolean estEnTrainDeDormir, boolean sante, String nom) {
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
    }

    /**
     * Fonction qui permet a la creature de manger
     */
    public void manger(){
        System.out.println(this.nomEspece + " " + this.nom + " est en train de manger");
    }

    /**
     * Fonction qui permet a la creature d'emettre un son
     */
    public String emettreUnSon(){
        return (this.nomEspece + " " + this.nom + " emet un son");
    }

    /**
     * Fonction qui permet a la creature d'etre soigne
     */
    public void etreSoigne(){
        System.out.println(this.nomEspece + " " + this.nom + " est soigne");
    }

    /**
     * Fonction qui permet a la creature de s'endormir ou se reveiller
     */
    public void endormir(){
        if (this.estEnTrainDeDormir){
            System.out.println(this.nomEspece  + " " + this.nom + " se reveille");
            estEnTrainDeDormir = false;
        }
        else {
            System.out.println(this.nomEspece + " " + this.nom + " s'endort");
            estEnTrainDeDormir = true;
        }
    }

    /**
     * Fonction qui permet a la creature de vieillir
     */
    public void vieillir() {

    }

    /**
     * Fonction qui permet d'afficher les caracteristiques de la creature
     * @return String toString
     */
    @Override
    public String toString() {
        return "Creature{" +
                "ID=" + ID +
                "nomEspece=" + nomEspece +
                ", sexe=" + sexe +
                ", poids=" + poids +
                ", taille=" + taille +
                ", age=" + age +
                ", faim=" + faim +
                ", estEnTrainDeDormir=" + estEnTrainDeDormir +
                ", sante=" + sante +
                ", name='" + nom + '\'' +
                '}';
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
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}
