package includes.creatures;

import includes.enclos.Enclos;

public abstract class Dragon extends Creature implements PeutVoler, PeutCourir, PeutNager{
    /**
     * Constructeur qui permet de creer un dragon, qui n'a pas faim, est reveille et est en bonne sante
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
     */
    public Dragon(SexesEnum sexe, int poids, int taille, int age, String nom, Enclos enclos) {
        super(EspecesEnum.DRAGON, sexe, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Constructeur qui permet de creer un dragon en choississant sa faim, son sommeil et sa sante
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param faim boolean faim de la creature
     * @param estEnTrainDeDormir boolean sommeil de la creature
     * @param sante boolean sante de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
     * @param enclos Enclos du dragon
     */
    public Dragon(SexesEnum sexe, int poids, int taille, int age, boolean faim, boolean estEnTrainDeDormir, boolean sante, String nom, Enclos enclos) {
        super(EspecesEnum.DRAGON, sexe, poids, taille, age, faim, estEnTrainDeDormir, sante, nom, enclos);
    }

    /**
     * Fonction qui permet a un dragon de voler
     * @return Le dragon vole.
     */
    public String voler() {
        return "Le dragon " + this.getNom() + " vole.";
    }
    /**
     * Fonction qui permet a un dragon de courir
     * @return Le dragon court.
     */
    public String courir() {
        return "Le dragon " + this.getNom() + " court.";
    }

    /**
     * Fonction qui permet a un dragon de nager
     * @return Le dragon nage.
     */
    public String nager() {
        return "Le dragon " + this.getNom() + " nage.";
    }

    /**
     * Fonction qui permet au dragon de faire un rugissement
     * @return String rugissement
     */
    @Override
    public String emettreUnSon(){
        return "Le dragon " + this.getNom() + " fait un rugissement";
    }

    /**
     * Permet a la creature de renaitre des ses cendres, a l'age d'un an
     * @return String msg de confirmation
     */
    @Override
    public String vieillir(){
        setAge(getAge()+1);
        if (getAge() >= getAgeMort()){
            this.setAge(1);
            return "Le dragon " + getNom() + " est mort. Il renait de ses cendres";
        }
        else {
            return "" + getAge();
        }
    }
}
