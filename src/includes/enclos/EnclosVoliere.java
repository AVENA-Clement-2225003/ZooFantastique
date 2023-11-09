package includes.enclos;

import java.util.ArrayList;

/**
 * Classe qui représente une volière
 */
public class EnclosVoliere extends Enclos {
    private boolean toitCageOK;
    public EnclosVoliere(String nom, int superficie, int capaciteEnclos) {
        super(nom, superficie, capaciteEnclos);
        toitCageOK = true;
    }

    /**
     * Fonction permettant surtout des tests rapide grâce à la possibilité de définir tous les champs dès sa contruction
     * @param nom
     * @param superficie
     * @param capaciteEnclos
     * @param propreteEnum
     * @param listeCreatures
     * @param toitCageOK
     */
    public EnclosVoliere(String nom, int superficie, int capaciteEnclos, PropreteEnum propreteEnum, ArrayList<Creature> listeCreatures, boolean toitCageOK) {
        super(nom, superficie, capaciteEnclos, propreteEnum, listeCreatures);
        this.toitCageOK = toitCageOK;
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
        toitCageOK = true;
        super.setProprete(PropreteEnum.BON);
        return 0;
    }
}
