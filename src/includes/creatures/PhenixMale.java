package includes.creatures;

import includes.enclos.Enclos;

public class PhenixMale extends Phenix{
    /**
     * Constructeur qui permet de creer un phenix, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids
     * @param taille
     * @param age
     * @param nom
     * @param enclos Enclos du phenix
     */
    public PhenixMale( int poids, int taille, int age, String nom, Enclos enclos) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom, enclos);
    }
}
