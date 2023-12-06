package includes.creatures;

import includes.enclos.Enclos;

public class LicorneMale extends Licorne{
    /**
     * Constructeur qui permet de creer une licorne, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids
     * @param taille
     * @param age
     * @param nom
     * @param enclos Enclos de la licorne
     */
    public LicorneMale( int poids, int taille, int age, String nom, Enclos enclos) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom, enclos);
    }
}
