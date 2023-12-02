package includes.creatures;

import includes.enclos.Enclos;

public class LycanthropeFemelle extends Lycanthrope implements Vivipare{

    /**
     * Constructeur qui permet de creer un lycanthrope, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids
     * @param taille
     * @param age
     * @param nom
     */
    public LycanthropeFemelle( int poids, int taille, int age, String nom, Enclos enclos) {
        super(SexesEnum.FEMELLE, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Fonction qui permet aux femelles de mettre bas
     * @return String message de confirmation
     */
    @Override
    public String mettreBas() {
        return "Le lycanthrope " + this.getNom() + " met bas";
    }
}
