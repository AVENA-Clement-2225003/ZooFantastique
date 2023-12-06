package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente un kraken femelle
 */
public class KrakenFemelle extends Kraken implements Ovipare{
    /**
     * Constructeur qui permet de creer un kraken, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids du kraken
     * @param taille taille du kraken
     * @param age age du kraken
     * @param nom nom du kraken
     * @param enclos Enclos du kraken
     */
    public KrakenFemelle( int poids, int taille, int age, String nom, Enclos enclos) {
        super(SexesEnum.FEMELLE, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Fonction qui permet aux femelles de pondre des oeufs
     * @return Oeuf
     */
    public Oeuf pondreOeuf(String nom, SexesEnum sexe, Enclos enclos) {
        return new Oeuf(EspecesEnum.KRAKEN, sexe,  nom, enclos, this);
    }
}
