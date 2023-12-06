package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente les bebes
 */
public class Bebe extends Creature{

    /**
     * Temps nécessaire d'attendre avant la naissance
     */
    private int tempsNaissance;

    /**
     * Temps que le bebe a deja passé
     */
    private int tempsGestation;

    /**
     * Mere du bebe
     */
    private Creature mere;

    /**
     * Constucteur de bebe
     * @param espece Espece du bebe
     * @param sexe Sexe du bebe
     * @param nom Nom du bebe
     * @param enclos Enclos dans lequel est le bebe
     * @param mere Mere du bebe
     */
    public Bebe(EspecesEnum espece, SexesEnum sexe, String nom, Enclos enclos, Creature mere){
        super(espece, sexe, 3, 30, 0, false, true, true, nom, enclos);
        tempsNaissance = 2;
        tempsGestation = 0;
        this.mere = mere;
        enclos.ajouterCreature(this);
    }

    /**
     * toString du bebe
     * @return affichage du toString
     */
    @Override
    public String toString() {
        return "nom : " + super.getNom() + " | espece : " + super.getNomEspece() + " | age : " + super.getAge() + " | temps gestation restant : " + (tempsNaissance - tempsGestation);
    }

    /**
     * Getter du temps avant la naissance
     * @return temps avant la naissance
     */
    public int getTempsNaissance() {
        return tempsNaissance;
    }

    /**
     * Getter du temps depuis lequel le bebe est en gestation
     * @return temps depuis lequel le bebe est en gestation
     */
    public int getTempsGestation() {
        return tempsGestation;
    }

    /**
     * Setter du temps depuis lequel le bebe est en gestation
     * @param tempsGestation temps depuis lequel le bebe est en gestation
     */
    public void setTempsGestation(int tempsGestation) {
        this.tempsGestation = tempsGestation;
    }

    /**
     * Fonction qui permet au bebe d'emettre un son
     * @return null car un bebe ne peut pas faire de bruit
     */
    @Override
    public String emettreUnSon() {
        return null;
    }

    /**
     * Getter de la mere du bebe
     * @return Creature mere du bebe
     */
    public Creature getMere() {
        return mere;
    }

    /**
     * Setter de la mere du bebe
     * @param mere Creature mere du bebe
     */
    public void setMere(Creature mere) {
        this.mere = mere;
    }

}
