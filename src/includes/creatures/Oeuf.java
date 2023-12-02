package includes.creatures;

public class Oeuf extends Creature{

    private int tempsEclosion;
    private int tempsMaturation;
    public Oeuf(EspecesEnum espece, SexesEnum sexe, int poids, int taille, int  age, boolean faim, boolean enTrainDeDormir, boolean sante, String nom){
        super(espece, sexe, poids, taille, age, faim, enTrainDeDormir, sante, nom);
        tempsEclosion = 60;
        tempsMaturation = 0;
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
}
