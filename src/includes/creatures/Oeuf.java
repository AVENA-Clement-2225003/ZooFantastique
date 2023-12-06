package includes.creatures;

import includes.enclos.Enclos;

/**
 * Classe qui represente les oeufs
 */
public class Oeuf extends Creature{

    /**
     * Temps nécessaire d'attendre avant eclosion
     */
    private int tempsEclosion;

    /**
     * Temps que l'oeuf a deja passé a maturer
     */
    private int tempsMaturation;

    /**
     * Mere de l'oeuf
     */
    private Creature mere;

    /**
     * Constucteur de l'oeuf
     * @param espece Espece de l'oeuf
     * @param sexe Sexe de l'oeuf
     * @param nom Nom de l'oeuf
     * @param enclos Enclos dans lequel est l'oeuf
     * @param mere Mere de l'oeuf
     */
    public Oeuf(EspecesEnum espece, SexesEnum sexe, String nom, Enclos enclos, Creature mere){
        super(espece, sexe, 3, 30, 0, false, true, true, nom, enclos);
        tempsEclosion = 1;
        tempsMaturation = 0;
        this.mere = mere;
        enclos.ajouterCreature(this);
    }

    /**
     * toString de l'oeuf
     * @return affichage du toString
     */
    @Override
    public String toString() {
        return "nom : " + super.getNom() + " | espece : " + super.getNomEspece() + " | age : " + super.getAge() + " | temps maturation restant : " + (tempsEclosion-tempsMaturation);
    }

    /**
     * Getter du temps avant l'eclosion
     * @return temps avant l'eclosion
     */
    public int getTempsEclosion() {
        return tempsEclosion;
    }

    /**
     * Getter du temps depuis lequel l'oeuf est en maturation
     * @return temps depuis lequel l'oeuf est en maturation
     */
    public int getTempsMaturation() {
        return tempsMaturation;
    }

    /**
     * Setter du temps depuis lequel l'oeuf est en maturation
     * @param tempsMaturation temps depuis lequel l'oeuf est en maturation
     */
    public void setTempsMaturation(int tempsMaturation) {
        this.tempsMaturation = tempsMaturation;
    }

    /**
     * Fonction qui permet a l'oeuf d'emettre un son
     * @return null car un oeuf ne peut pas faire de bruit
     */
    @Override
    public String emettreUnSon() {
        return null;
    }

    /**
     * Getter de la mere de l'oeuf
     * @return Creature mere de l'oeuf
     */
    public Creature getMere() {
        return mere;
    }

    /**
     * Setter de la mere de l'oeuf
     * @param mere Creature mere de l'oeuf
     */
    public void setMere(Creature mere) {
        this.mere = mere;
    }
}
