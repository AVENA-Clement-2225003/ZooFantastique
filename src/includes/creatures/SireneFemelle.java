package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente une sirene femelle
 */
public class SireneFemelle extends Sirene implements Vivipare{
    /**
     * Constructeur qui permet de creer une sirene, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids de la sirene
     * @param taille taille de la sirene
     * @param age age de la sirene
     * @param nom nom de la sirene
     * @param enclos Enclos de la sirene
     */
    public SireneFemelle( int poids, int taille, int age, String nom, Enclos enclos) {
        super(SexesEnum.FEMELLE, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Fonction qui permet aux femelles de mettre bas
     * @return Bebe
     */
    public Bebe mettreBas(String nom, SexesEnum sexe, Enclos enclos) {
        return new Bebe(EspecesEnum.SIRENE, sexe, nom, enclos, this);
    }
}
