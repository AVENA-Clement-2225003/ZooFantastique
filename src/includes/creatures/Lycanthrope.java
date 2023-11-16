package includes.creatures;

/**
 * Classe qui represente les lycanthopes, qui a pour interface peutCourir (et qui aura vivipare)
 */
public abstract class Lycanthrope extends Creature implements PeutCourir {
    /**
     * Constructeur qui permet de creer un lycanthrope, qui n'a pas faim, est reveille et est en bonne sante
     * @param espece EspecesEnum nom de l'espece de la creature
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
     */
    public Lycanthrope(EspecesEnum espece, SexesEnum sexe, int poids, int taille, int age, String nom) {
        super(espece, sexe, poids, taille, age, false, false, true , nom);
    }

    /**
     * Constructeur qui permet de creer un lycanthrope en choississant sa faim, son sommeil et sa sante
     * @param espece EspecesEnum nom de l'espece de la creature
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param faim boolean faim de la creature
     * @param estEnTrainDeDormir boolean sommeil de la creature
     * @param sante boolean sante de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
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

    /**
     * Fonction qui permet au lycanthrope de faire un hurlement
     * @return String hurlement
     */
    @Override
    public String emettreUnSon(){
        return "Le lycantrope " + this.getNom() + " fait un hurlement";
    }
}
