package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente un megalodon male
 */
public class MegalodonMale extends Megalodon{
    /**
     * Constructeur qui permet de creer un megalodon, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids du megalodon
     * @param taille taille du megalodon
     * @param age age du megalodon
     * @param nom nom du megalodon
     * @param enclos Enclos du megalodon
     */
    public MegalodonMale( int poids, int taille, int age, String nom, Enclos enclos) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom, enclos);
    }
}
