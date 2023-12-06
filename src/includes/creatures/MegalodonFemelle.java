package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente un megalodon femelle
 */
public class MegalodonFemelle extends Megalodon implements Ovipare{

    /**
     * Constructeur qui permet de creer un megalodon, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids du megalodon
     * @param taille taille du megalodon
     * @param age age du megalodon
     * @param nom nom du megalodon
     * @param enclos Enclos du megalodon
     */
    public MegalodonFemelle( int poids, int taille, int age, String nom, Enclos enclos) {
        super(SexesEnum.FEMELLE, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Fonction qui permet aux femelles de pondre des oeufs
     * @return Oeuf
     */
    public Oeuf pondreOeuf(String nom, SexesEnum sexe, Enclos enclos) {
        return new Oeuf(EspecesEnum.MEGALODON, sexe,  nom, enclos, this);
    }
}
