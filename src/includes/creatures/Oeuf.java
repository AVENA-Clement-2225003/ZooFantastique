package includes.creatures;

import includes.enclos.Enclos;

public class Oeuf extends Creature{

    private int tempsEclosion;
    private int tempsMaturation;

    private Creature mere;
    public Oeuf(EspecesEnum espece, SexesEnum sexe, String nom, Enclos enclos, Creature mere){
        super(espece, sexe, 3, 30, 0, false, true, true, nom, enclos);
        tempsEclosion = 60;
        tempsMaturation = 0;
        this.mere = mere;
    }

    @Override
    public String toString() {
        return "nom : " + super.getNom() + " | espece : " + super.getNomEspece() + " | age : " + super.getAge() + " | temps maturation restant : " + (tempsEclosion-tempsMaturation);
    }

    public int getTempsEclosion() {
        return tempsEclosion;
    }

    public int getTempsMaturation() {
        return tempsMaturation;
    }

    public void setTempsMaturation(int tempsMaturation) {
        this.tempsMaturation = tempsMaturation;
    }

    @Override
    public String emettreUnSon() {
        return null;
    }

    public Creature getMere() {
        return mere;
    }

    public void setMere(Creature mere) {
        this.mere = mere;
    }
}
