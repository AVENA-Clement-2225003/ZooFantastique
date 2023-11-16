package includes.creatures;

public class DragonFemelle extends Dragon implements Ovipare{
    /**
     * Constructeur qui permet de creer un dragon, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids
     * @param taille
     * @param age
     * @param nom
     */
    public DragonFemelle( int poids, int taille, int age, String nom) {
        super(SexesEnum.FEMELLE, poids, taille, age, false, false, true , nom);
    }

    /**
     * Fonction qui permet aux femelles de pondre des oeufs
     * @return String message de confirmation
     */
    public String pondreOeuf() {
        return "Le dragon " + this.getNom() + " pond des oeufs";
    }
}
