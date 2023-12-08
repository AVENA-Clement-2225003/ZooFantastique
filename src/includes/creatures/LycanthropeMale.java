package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente un lycanthrope male
 */
public class LycanthropeMale extends Lycanthrope{

    /**
     * Constructeur qui permet de creer un lycanthrope, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids du lycanthrope
     * @param taille taille du lycanthrope
     * @param age age du lycanthrope
     * @param nom nom du lycanthrope
     * @param enclos Enclos du lycanthrope
     */
    public LycanthropeMale( int poids, int taille, int age, String nom, Enclos enclos) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Constructeur qui permet de creer un lycanthrope, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids poids du lycanthrope
     * @param taille taille du lycanthrope
     * @param age age du lycanthrope
     * @param nom nom du lycanthrope
     * @param enclos Enclos du lycanthrope
     * @param rang Rang du lycanthrope
     * @param force Force du lycanthrope
     * @param meute meute du lycanthrope
     */
    public LycanthropeMale( int poids, int taille, int age, String nom, Enclos enclos, RangEnum rang, int force, Meute meute) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom, enclos, rang, force, meute);
    }
}
