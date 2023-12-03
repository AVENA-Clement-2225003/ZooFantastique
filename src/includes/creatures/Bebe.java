package includes.creatures;

import includes.enclos.Enclos;

public class Bebe extends Creature{

    private int tempsNaissance; //Temps nécessaire d'attendre avant eclosion
    private int tempsGestation; //Temps que l'oeuf a deja passé a maturer

    private Creature mere;
    public Bebe(EspecesEnum espece, SexesEnum sexe, String nom, Enclos enclos, Creature mere){
        super(espece, sexe, 3, 30, 0, false, true, true, nom, enclos);
        tempsNaissance = 60;
        tempsGestation = 0;
        this.mere = mere;
    }

    @Override
    public String toString() {
        return "nom : " + super.getNom() + " | espece : " + super.getNomEspece() + " | age : " + super.getAge() + " | temps gestation restant : " + (tempsNaissance - tempsGestation);
    }

    public int getTempsNaissance() {
        return tempsNaissance;
    }

    public int getTempsGestation() {
        return tempsGestation;
    }

    public void setTempsGestation(int tempsGestation) {
        this.tempsGestation = tempsGestation;
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
