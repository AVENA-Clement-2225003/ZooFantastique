package includes.creatures;

public class MegalodonMale extends Megalodon{
    /**
     * Constructeur qui permet de creer un megalodon, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids
     * @param taille
     * @param age
     * @param nom
     */
    public MegalodonMale( int poids, int taille, int age, String nom) {
        super( SexesEnum.MALE, poids, taille, age, false, false, true , nom);
    }
}
