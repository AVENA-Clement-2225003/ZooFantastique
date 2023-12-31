package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente une licorne
 */
public abstract class Licorne extends Creature implements PeutCourir {
    /**
     * Constructeur qui permet de creer une licorne, qui n'a pas faim, est reveille et est en bonne sante
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
     * @param enclos Enclos de la licorne
     */
    public Licorne(SexesEnum sexe, int poids, int taille, int age, String nom, Enclos enclos) {
        super(EspecesEnum.LICORNE, sexe, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Constructeur qui permet de creer une licorne en choississant sa faim, son sommeil et sa sante
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param faim boolean faim de la creature
     * @param estEnTrainDeDormir boolean sommeil de la creature
     * @param sante boolean sante de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
     * @param enclos Enclos de la licorne
     */
    public Licorne(SexesEnum sexe, int poids, int taille, int age, boolean faim, boolean estEnTrainDeDormir, boolean sante, String nom, Enclos enclos) {
        super(EspecesEnum.LICORNE, sexe, poids, taille, age, faim, estEnTrainDeDormir, sante, nom, enclos);
    }


    /**
     * Fonction qui permet a une licorne de courir
     * @return Le lycanthrope court.
     */
    public String courir() {
        return "La licorne " + this.getNom() + " court.";
    }

    /**
     * Fonction qui permet a la licorne de hennir
     * @return String hennissement
     */
    @Override
    public String emettreUnSon(){
        return "La licorne " + this.getNom() + " hennit";
    }
}
