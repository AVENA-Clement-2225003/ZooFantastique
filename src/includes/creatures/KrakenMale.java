package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente un kraken male
 */
public class KrakenMale extends Kraken {
    /**
     * Constructeur qui permet de creer un kraken, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids du kraken
     * @param taille taille du kraken
     * @param age age du kraken
     * @param nom nom du kraken
     * @param enclos Enclos du kraken
     */
    public KrakenMale( int poids, int taille, int age, String nom, Enclos enclos) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom, enclos);
    }
}
