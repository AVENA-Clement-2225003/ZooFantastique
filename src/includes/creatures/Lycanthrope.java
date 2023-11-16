package includes.creatures;

/**
 * Classe qui represente les lycanthopes, qui a pour interface peutCourir (et qui aura vivipare)
 */
public abstract class Lycanthrope extends Creature implements PeutCourir {


    /**
     * Constructeur qui permet de creer un lycanthrope, qui n'a pas faim, est reveille et est en bonne sante
     * @param espece
     * @param sexe
     * @param poids
     * @param taille
     * @param age
     * @param nom
     */
    public Lycanthrope(EspecesEnum espece, SexesEnum sexe, int poids, int taille, int age, String nom) {
        super(espece, sexe, poids, taille, age, false, false, true , nom);
    }

    /**
     * Constructeur qui permet de creer un lycanthrope en choississant sa faim, son sommeil et sa sante
     * @param espece
     * @param sexe
     * @param poids
     * @param taille
     * @param age
     * @param faim
     * @param estEnTrainDeDormir
     * @param sante
     * @param nom
     */
    public Lycanthrope(EspecesEnum espece, SexesEnum sexe, int poids, int taille, int age, boolean faim, boolean estEnTrainDeDormir, boolean sante, String nom) {
        super(espece, sexe, poids, taille, age, faim, estEnTrainDeDormir, sante, nom);
    }


    /**
     * Fonction qui permet a un lycanthrope de courir
     * @return Le lycanthrope court.
     */
    @Override
    public String courir() {
        return "Le lycantrope " + this.getNom() + " court.";
    }

    /**
     * Fonction toString du lycanthrope.
     * @return un toString
     */
    @Override
    public String toString() {
        return "Lycanthrope{} " + super.toString();
    }

    /*
    @Override
    public String mettreBas() {
        return "Le lycanthrope met bas";
    }
     */

    @Override
    public String emettreUnSon(){
        return "Le lycantrope " + this.getNom() + " fait un hurlement";
    }
}
