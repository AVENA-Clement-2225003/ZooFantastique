package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente un phenix male
 */
public class PhenixMale extends Phenix{
    /**
     * Constructeur qui permet de creer un phenix, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids du phenix
     * @param taille taille du phenix
     * @param age age du phenix
     * @param nom nom du phenix
     * @param enclos Enclos du phenix
     */
    public PhenixMale( int poids, int taille, int age, String nom, Enclos enclos) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom, enclos);
    }
}
