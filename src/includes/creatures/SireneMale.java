package includes.creatures;

public class SireneMale extends Sirene{
    /**
     * Constructeur qui permet de creer une sirene, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids
     * @param taille
     * @param age
     * @param nom
     */
    public SireneMale( int poids, int taille, int age, String nom) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom);
    }
}
