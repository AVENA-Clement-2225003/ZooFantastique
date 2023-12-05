package includes.creatures;

import includes.enclos.Enclos;

public class Oeuf extends Creature{

    private int tempsEclosion; //Temps nécessaire d'attendre avant eclosion
    private int tempsMaturation; //Temps que l'oeuf a deja passé a maturer

    private Creature mere;
    public Oeuf(EspecesEnum espece, SexesEnum sexe, String nom, Enclos enclos, Creature mere){
        super(espece, sexe, 3, 30, 0, false, true, true, nom, enclos);
        tempsEclosion = 1;
        tempsMaturation = 0;
        this.mere = mere;
        enclos.ajouterCreature(this);
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
