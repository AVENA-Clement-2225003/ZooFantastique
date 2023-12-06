package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente un dragon male
 */
public class DragonMale extends Dragon{
    /**
     * Constructeur qui permet de creer un dragon, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids du dragon
     * @param taille taille du dragon
     * @param age age du dragon
     * @param nom nom du dragon
     * @param enclos Enclos du dragon
     */
    public DragonMale( int poids, int taille, int age, String nom, Enclos enclos) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom, enclos);
    }
}
