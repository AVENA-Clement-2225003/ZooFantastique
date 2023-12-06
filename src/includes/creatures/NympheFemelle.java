package includes.creatures;

import includes.enclos.Enclos;

public class NympheFemelle extends Nymphe implements Vivipare{
    /**
     * Constructeur qui permet de creer une nymphe, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids
     * @param taille
     * @param age
     * @param nom
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
