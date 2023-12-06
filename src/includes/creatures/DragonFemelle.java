package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente un dragon femelle
 */
public class DragonFemelle extends Dragon implements Ovipare{
    /**
     * Constructeur qui permet de creer un dragon, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids du dragon
     * @param taille taille du dragon
     * @param age age du dragon
     * @param nom nom du dragon
     * @param enclos Enclos du dragon
     */
    public DragonFemelle( int poids, int taille, int age, String nom, Enclos enclos) {
        super(SexesEnum.FEMELLE, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Fonction qui permet aux femelles de pondre des oeufs
     * @return Oeuf
     */
    public Oeuf pondreOeuf(String nom, SexesEnum sexe, Enclos enclos) {
        return new Oeuf(EspecesEnum.DRAGON, sexe,  nom, enclos, this);
    }
}
