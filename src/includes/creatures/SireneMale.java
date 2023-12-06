package includes.creatures;

import includes.enclos.Enclos;

public class SireneMale extends Sirene{
    /**
     * Constructeur qui permet de creer une sirene, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids
     * @param taille
     * @param age
     * @param nom
     * @param enclos Enclos de la sirene
     */
    public SireneMale( int poids, int taille, int age, String nom, Enclos enclos) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom, enclos);
    }
}
