package includes.creatures;

import includes.enclos.Enclos;

public class SireneFemelle extends Sirene implements Vivipare{
    /**
     * Constructeur qui permet de creer une sirene, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids
     * @param taille
     * @param age
     * @param nom
     */
    public SireneFemelle( int poids, int taille, int age, String nom, Enclos enclos) {
        super(SexesEnum.FEMELLE, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Fonction qui permet aux femelles de mettre bas
     * @return String message de confirmation
     */
    public String mettreBas() {
        return "La sirene " + this.getNom() + " met bas";
    }
}
