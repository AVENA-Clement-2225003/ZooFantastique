package includes.creatures;

import includes.enclos.Enclos;

public abstract class Sirene extends Creature implements PeutNager{
    /**
     * Constructeur qui permet de creer une sirene, qui n'a pas faim, est reveille et est en bonne sante
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
     * @param enclos Enclos de la sirene
     */
    public Sirene(SexesEnum sexe, int poids, int taille, int age, String nom, Enclos enclos) {
        super(EspecesEnum.SIRENE, sexe, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Constructeur qui permet de creer une sirene en choississant sa faim, son sommeil et sa sante
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param faim boolean faim de la creature
     * @param estEnTrainDeDormir boolean sommeil de la creature
     * @param sante boolean sante de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
     * @param enclos Enclos de la sirene
     */
    public Sirene(SexesEnum sexe, int poids, int taille, int age, boolean faim, boolean estEnTrainDeDormir, boolean sante, String nom, Enclos enclos) {
        super(EspecesEnum.SIRENE, sexe, poids, taille, age, faim, estEnTrainDeDormir, sante, nom, enclos);
    }


    /**
     * Fonction qui permet a une sirene de nager
     * @return La sirene nage.
     */
    public String nager() {
        return "Le sirene " + this.getNom() + " nage.";
    }

    /**
     * Fonction qui permet a la sirene de faire des bulles
     * @return String bulles
     */
    @Override
    public String emettreUnSon(){
        return "La sirene " + this.getNom() + " fait des bulles";
    }
}
