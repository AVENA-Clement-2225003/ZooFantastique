package includes.creatures;

public abstract class Nymphe extends Creature{
    /**
     * Constructeur qui permet de creer une nymphe, qui n'a pas faim, est reveille et est en bonne sante
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
     */
    public Nymphe(SexesEnum sexe, int poids, int taille, int age, String nom) {
        super(EspecesEnum.NYMPHE, sexe, poids, taille, age, false, false, true , nom);
    }

    /**
     * Constructeur qui permet de creer une nymphe en choississant sa faim, son sommeil et sa sante
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param faim boolean faim de la creature
     * @param estEnTrainDeDormir boolean sommeil de la creature
     * @param sante boolean sante de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
     */
    public Nymphe(SexesEnum sexe, int poids, int taille, int age, boolean faim, boolean estEnTrainDeDormir, boolean sante, String nom) {
        super(EspecesEnum.NYMPHE, sexe, poids, taille, age, faim, estEnTrainDeDormir, sante, nom);
    }

    /**
     * Fonction toString de la nymphe.
     * @return un toString
     */
    @Override
    public String toString() {
        return "Nymphe{ " + super.toString() + "}";
    }

    /**
     * Fonction qui permet a la nymphe de parler
     * @return String parle
     */
    @Override
    public String emettreUnSon(){
        return "La nymphe " + this.getNom() + " parle";
    }
}
