package includes.enclos;

import includes.creatures.Creature;

import java.util.ArrayList;

/**
 * Classe qui représente un enclos standard
 */
public class EnclosStandard extends Enclos {
    /**
     * Constructeur simple
     * @param nom Nom de l'enclos
     * @param superficie Superficie de l'enclos
     * @param capaciteEnclos Capacité de l'enclos
     */
    public EnclosStandard(String nom, int superficie, int capaciteEnclos) {
        super(nom, superficie, capaciteEnclos);
    }

    /**
     * Fonction permettant surtout des tests rapide grâce à la possibilité de définir tous les champs dès sa contruction
     * @param nom Nom de l'enclos
     * @param superficie Superficie de l'enclos
     * @param capaciteEnclos Capacité de l'enclos
     * @param propreteEnum Niveau de propreté de l'enclos
     * @param listeCreatures Liste des créatures
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
        if (super.getListeCreatures().size() > 0) {
            return 1;
        }
        super.setProprete(PropreteEnum.BON);
        return 0;
    }
}
