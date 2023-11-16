package includes.creatures;

public class DragonMale extends Dragon{
    /**
     * Constructeur qui permet de creer un kraken, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids
     * @param taille
     * @param age
     * @param nom
     */
    public DragonMale( int poids, int taille, int age, String nom) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom);
    }
}
