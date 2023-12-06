package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente une licorne male
 */
public class LicorneMale extends Licorne{
    /**
     * Constructeur qui permet de creer une licorne, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids de la licorne
     * @param taille taille de la licorne
     * @param age age de la licorne
     * @param nom nom de la licorne
     * @param enclos Enclos de la licorne
     */
    public LicorneMale( int poids, int taille, int age, String nom, Enclos enclos) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom, enclos);
    }
}
