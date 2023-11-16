package includes.creatures;

public class LycanthropeFemelle extends Lycanthrope implements Vivipare{

    /**
     * Constructeur qui permet de creer un lycanthrope, qui n'a pas faim, est reveille et est en bonne sante
     * @param espece
     * @param poids
     * @param taille
     * @param age
     * @param nom
     */
    public LycanthropeFemelle(EspecesEnum espece, int poids, int taille, int age, String nom) {
        super(espece, SexesEnum.FEMELLE, poids, taille, age, false, false, true , nom);
    }

    @Override
    public String mettreBas() {
        return "Le lycanthrope " + this.getNom() + " met bas";
    }
}
