package includes;

import java.util.ArrayList;

/**
 * Classe qui représente un aquarium
 */
public class EnclosAquarium extends Enclos{
    /**
     * Variable de la profondeur de l'aquarium
     */
    private int profondeur;
    /**
     * Variable de salinité de l'eau du bassin
     */
    private boolean saliniteBassinOK;

    /**
     *
     * @param nom
     * @param superficie
     * @param capaciteEnclos
     * @param profondeur
     */
    public EnclosAquarium(String nom, int superficie, int capaciteEnclos, int profondeur) {
        super(nom, superficie, capaciteEnclos);
        this.profondeur = profondeur;
    }

    /**
     * Fonction permettant surtout des tests rapide grâce à la possibilité de définir tous les champs dès sa contruction
     * @param nom
     * @param superficie
     * @param capaciteEnclos
     * @param propreteEnum
     * @param listeCreatures
     * @param profondeur
     */
    public EnclosAquarium(String nom, int superficie, int capaciteEnclos, PropreteEnum propreteEnum, ArrayList<Creature> listeCreatures, int profondeur) {
        super(nom, superficie, capaciteEnclos, propreteEnum, listeCreatures);
        this.profondeur = profondeur;
    }
    /**
     * Fonction qui permet d'effectuer l'entretient de l'enclos
     * @return 0 si l'entretient est fait, 1 si l'entretient est pas possible (enclos non vide)
     */
    @Override
    public int entretientEnclos() {
        if (super.getNbCreaturesDansEnclos() > 0) {
            return 1;
        }
        saliniteBassinOK = true;
        super.setProprete(PropreteEnum.BON);
        return 0;
    }
}
