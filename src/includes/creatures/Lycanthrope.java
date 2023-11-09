package includes.creatures;

import includes.creatures.Creature;

public class Lycanthrope extends Creature implements peutCourir {


    public Lycanthrope(EspecesEnum espece, Sexe sexe, int poids, int taille, int age, String name) {
        super(espece, sexe, poids, taille, age, false, false, true , name);
    }

    public Lycanthrope(EspecesEnum espece, Sexe sexe, int poids, int taille, int age, boolean faim, boolean estEnTrainDeDormir, boolean sante, String name) {
        super(espece, sexe, poids, taille, age, faim, estEnTrainDeDormir, sante, name);
    }
    @Override
    public String courir() {
        return "Le lycantrope " + this.getName() + " court.";
    }
}
