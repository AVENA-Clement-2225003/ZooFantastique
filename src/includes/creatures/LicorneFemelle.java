package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente une licorne femelle
 */
public class LicorneFemelle extends Licorne implements Vivipare{
    /**
     * Constructeur qui permet de creer une licorne, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids de la licorne
     * @param taille taille de la licorne
     * @param age age de la licorne
     * @param nom nom de la licorne
     * @param enclos Enclos de la licorne
     */
    public LicorneFemelle( int poids, int taille, int age, String nom, Enclos enclos) {
        super(SexesEnum.FEMELLE, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Fonction qui permet aux femelles de mettre bas
     * @return Bebe
     */
    public Bebe mettreBas(String nom, SexesEnum sexe, Enclos enclos) {
        return new Bebe(EspecesEnum.LICORNE, sexe,  nom, enclos, this);
    }
}
