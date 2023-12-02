package includes.creatures;

import includes.enclos.Enclos;

public abstract class Kraken extends Creature implements PeutNager {

    /**
     * Constructeur qui permet de creer un kraken, qui n'a pas faim, est reveille et est en bonne sante
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
     */
    public Kraken(SexesEnum sexe, int poids, int taille, int age, String nom, Enclos enclos) {
        super(EspecesEnum.KRAKEN, sexe, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Constructeur qui permet de creer un kraken en choississant sa faim, son sommeil et sa sante
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param faim boolean faim de la creature
     * @param estEnTrainDeDormir boolean sommeil de la creature
     * @param sante boolean sante de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
     */
    public Kraken(SexesEnum sexe, int poids, int taille, int age, boolean faim, boolean estEnTrainDeDormir, boolean sante, String nom, Enclos enclos) {
        super(EspecesEnum.KRAKEN, sexe, poids, taille, age, faim, estEnTrainDeDormir, sante, nom, enclos);
    }


    /**
     * Fonction qui permet a un kraken de nager
     * @return Le kraken nage.
     */
    public String nager() {
        return "Le kraken " + this.getNom() + " nage.";
    }

    /**
     * Fonction qui permet au kraken de faire un hurlement
     * @return String hurlement
     */
    @Override
    public String emettreUnSon(){
        return "Le kraken " + this.getNom() + " fait un hurlement";
    }
}
