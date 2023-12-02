package includes.creatures;

import includes.enclos.Enclos;

public class PhenixFemelle extends Phenix implements Ovipare{
    /**
     * Constructeur qui permet de creer un phenix, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids
     * @param taille
     * @param age
     * @param nom
     */
    public PhenixFemelle( int poids, int taille, int age, String nom, Enclos enclos) {
        super(SexesEnum.FEMELLE, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Fonction qui permet aux femelles de pondre des oeufs
     * @return String message de confirmation
     */
    public String pondreOeuf() {
        return "Le kraken " + this.getNom() + " pond des oeufs";
    }
}
