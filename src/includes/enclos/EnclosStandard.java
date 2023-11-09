package includes.enclos;

import java.util.ArrayList;

/**
 * Classe qui représente un enclos standard
 */
public class EnclosStandard extends Enclos {
    /**
     *
     * @param nom
     * @param superficie
     * @param capaciteEnclos
     */
    public EnclosStandard(String nom, int superficie, int capaciteEnclos) {
        super(nom, superficie, capaciteEnclos);
    }

    /**
     * Fonction permettant surtout des tests rapide grâce à la possibilité de définir tous les champs dès sa contruction
     * @param nom
     * @param superficie
     * @param capaciteEnclos
     * @param propreteEnum
     * @param listeCreatures
     */
    public EnclosStandard(String nom, int superficie, int capaciteEnclos, PropreteEnum propreteEnum, ArrayList<Creature> listeCreatures) {
        super(nom, superficie, capaciteEnclos, propreteEnum, listeCreatures);
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
        super.setProprete(PropreteEnum.BON);
        return 0;
    }
}
