package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente une nymphe femelle
 */
public class NympheFemelle extends Nymphe implements Vivipare{
    /**
     * Constructeur qui permet de creer une nymphe, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids de la nymphe
     * @param taille taille de la nymphe
     * @param age age de la nymphe
     * @param nom nom de la nymphe
     * @param enclos Enclos de la nymphe
     */
    public NympheFemelle( int poids, int taille, int age, String nom, Enclos enclos) {
        super(SexesEnum.FEMELLE, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Fonction qui permet aux femelles de mettre bas
     * @return Bebe
     */
    public Bebe mettreBas(String nom, SexesEnum sexe, Enclos enclos) {
        return new Bebe(EspecesEnum.NYMPHE, sexe, nom, enclos, this);
    }
}
