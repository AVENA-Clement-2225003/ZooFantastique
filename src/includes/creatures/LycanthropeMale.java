package includes.creatures;

public class LycanthropeMale extends Lycanthrope{

    /**
     * Constructeur qui permet de creer un lycanthrope, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids
     * @param taille
     * @param age
     * @param nom
     */
    public LycanthropeMale( int poids, int taille, int age, String nom) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom);
    }
}
