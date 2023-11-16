package includes.creatures;

/**
 * Classe qui represente les lycanthopes, qui a pour interface peutCourir (et qui aura vivipare)
 */
public class Lycanthrope extends Creature implements PeutCourir, Vivipare {


    /**
     * Constructeur qui permet de creer un lycanthrope, qui n'a pas faim, est reveille et est en bonne sante
     * @param espece
     * @param sexe
     * @param poids
     * @param taille
     * @param age
     * @param name
     */
    public Lycanthrope(EspecesEnum espece, Sexe sexe, int poids, int taille, int age, String name) {
        super(espece, sexe, poids, taille, age, false, false, true , name);
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
     * @param name
     */
    public Lycanthrope(EspecesEnum espece, Sexe sexe, int poids, int taille, int age, boolean faim, boolean estEnTrainDeDormir, boolean sante, String name) {
        super(espece, sexe, poids, taille, age, faim, estEnTrainDeDormir, sante, name);
    }


    /**
     * Fonction qui permet a un lycanthrope de courir
     * @return Le lycanthrope court.
     */
    @Override
    public String courir() {
        return "Le lycantrope " + this.getName() + " court.";
    }

    /**
     * Fonction toString du lycanthrope.
     * @return un toString
     */
    @Override
    public String toString() {
        return "Lycanthrope{ " + super.toString() + "}";
    }

    @Override
    public String mettreBas() {
        return "Le lycanthrope met bas";
    }
}
