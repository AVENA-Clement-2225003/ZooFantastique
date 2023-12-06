package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente un phenix femelle
 */
public class PhenixFemelle extends Phenix implements Ovipare{
    /**
     * Constructeur qui permet de creer un phenix, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids du phenix
     * @param taille taille du phenix
     * @param age age du phenix
     * @param nom nom du phenix
     * @param enclos Enclos du phenix
     */
    public PhenixFemelle( int poids, int taille, int age, String nom, Enclos enclos) {
        super(SexesEnum.FEMELLE, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Fonction qui permet aux femelles de pondre des oeufs
     * @return Oeuf
     */
    public Oeuf pondreOeuf(String nom, SexesEnum sexe, Enclos enclos) {
        return new Oeuf(EspecesEnum.PHENIX, sexe,  nom, enclos, this);
    }
}
