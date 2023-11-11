package includes.enclos;

import java.util.ArrayList;
import includes.creatures.Creature;

/**
 * Classe qui représente une volière
 */
public class EnclosVoliere extends Enclos {
    /**
     * Variable pour connaître l'état du toit
     */
    private boolean toitCageOK;
    private int hauteur;

    /**
     * Constructeur simple
     * @param nom Nom de l'enclos
     * @param superficie Superficie de l'enclos
     * @param capaciteEnclos Capacité de l'enclos
     */
    public EnclosVoliere(String nom, int superficie, int capaciteEnclos, int hauteur) {
        super(nom, superficie, capaciteEnclos);
        toitCageOK = true;
        this.hauteur = hauteur;
    }

    /**
     * Fonction permettant surtout des tests rapide grâce à la possibilité de définir tous les champs dès sa contruction
     * @param nom Nom de l'enclos
     * @param superficie Superficie de l'enclos
     * @param capaciteEnclos Capacité de l'enclos
     * @param propreteEnum Niveau de propreté de l'enclos
     * @param listeCreatures Liste des créatures
     * @param toitCageOK true si le toit est OK false sinon
     */
    public EnclosVoliere(String nom, int superficie, int capaciteEnclos, PropreteEnum propreteEnum, ArrayList<Creature> listeCreatures, boolean toitCageOK, int hauteur) {
        super(nom, superficie, capaciteEnclos, propreteEnum, listeCreatures);
        this.toitCageOK = toitCageOK;
        this.hauteur = hauteur;
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

    @Override
    public String toString() {
        return "EnclosVoliere{" + super.toString() +
                ", toitCageOK=" + toitCageOK +
                ", hauteur=" + hauteur +
                '}';
    }
}
