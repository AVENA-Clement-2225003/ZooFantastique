package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente une sirene male
 */
public class SireneMale extends Sirene{
    /**
     * Constructeur qui permet de creer une sirene, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids de la sirene
     * @param taille taille de la sirene
     * @param age age de la sirene
     * @param nom nom de la sirene
     * @param enclos Enclos de la sirene
     */
    public SireneMale( int poids, int taille, int age, String nom, Enclos enclos) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom, enclos);
    }
}
