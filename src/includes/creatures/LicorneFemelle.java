package includes.creatures;

public class LicorneFemelle extends Licorne implements Vivipare{
    /**
     * Constructeur qui permet de creer une licorne, qui n'a pas faim, est reveille et est en bonne sante
     * @param poids
     * @param taille
     * @param age
     * @param nom
     */
    public LicorneFemelle( int poids, int taille, int age, String nom) {
        super(SexesEnum.FEMELLE, poids, taille, age, false, false, true , nom);
    }

    /**
     * Fonction qui permet aux femelles de mettre bas
     * @return String message de confirmation
     */
    public String mettreBas() {
        return "La sirene " + this.getNom() + " met bas";
    }
}
