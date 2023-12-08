package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente un lycanthrope femelle
 */
public class LycanthropeFemelle extends Lycanthrope implements Vivipare{

    /**
     * Constructeur qui permet de creer un lycanthrope, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids du lycanthrope
     * @param taille taille du lycanthrope
     * @param age age du lycanthrope
     * @param nom nom du lycanthrope
     * @param enclos Enclos du lycanthrope
     */
    public LycanthropeFemelle( int poids, int taille, int age, String nom, Enclos enclos) {
        super(SexesEnum.FEMELLE, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Constructeur qui permet de creer un lycanthrope, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids du lycanthrope
     * @param taille taille du lycanthrope
     * @param age age du lycanthrope
     * @param nom nom du lycanthrope
     * @param enclos Enclos du lycanthrope
     * @param force Force du lycanthrope
     * @param meute meute du lycanthrope
     */
    public LycanthropeFemelle( int poids, int taille, int age, String nom, Enclos enclos, int force, Meute meute) {
        super( SexesEnum.FEMELLE, poids, taille, age, false, false, true , nom, enclos, force, meute);
    }

    /**
     * Fonction qui permet aux femelles de mettre bas
     * @return Bebe
     */
    public Bebe mettreBas(String nom, SexesEnum sexe, Enclos enclos) {
        return new Bebe(EspecesEnum.LYCANTHROPE, sexe, nom, enclos, this);
    }
}
