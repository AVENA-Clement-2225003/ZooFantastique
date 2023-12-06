package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente une nymphe male
 */
public class NympheMale extends Nymphe{
    /**
     * Constructeur qui permet de creer une nymphe, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids de la nymphe
     * @param taille taille de la nymphe
     * @param age age de la nymphe
     * @param nom nom de la nymphe
     * @param enclos Enclos de la nymphe
     */
    public NympheMale( int poids, int taille, int age, String nom, Enclos enclos) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom, enclos);
    }
}
