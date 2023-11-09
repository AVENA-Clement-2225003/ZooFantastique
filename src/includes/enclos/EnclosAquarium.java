package includes.enclos;

import includes.creatures.Creature;

import java.util.ArrayList;

/**
 * Classe qui représente un aquarium
 */
public class EnclosAquarium extends Enclos {
    /**
     * Variable de la profondeur de l'aquarium
     */
    private int profondeur;
    /**
     * Variable de salinité de l'eau du bassin
     */
    private boolean saliniteBassinOK;

    /**
     * Constructeur simple
     * @param nom Nom de l'enclos
     * @param superficie Superficie de l'enclos
     * @param capaciteEnclos Capacité de l'enclos
     * @param profondeur Profondeur de l'enclos
     */
    public EnclosAquarium(String nom, int superficie, int capaciteEnclos, int profondeur) {
        super(nom, superficie, capaciteEnclos);
        this.profondeur = profondeur;
    }

    /**
     * Fonction permettant surtout des tests rapide grâce à la possibilité de définir tous les champs dès sa contruction
     * @param nom Nom de l'enclos
     * @param superficie Superficie de l'enclos
     * @param capaciteEnclos Capacité de l'enclos
     * @param propreteEnum Niveau de propreté de l'enclos
     * @param listeCreatures Liste des créatures
     * @param profondeur Profondeur du bassin
     */
    public EnclosAquarium(String nom, int superficie, int capaciteEnclos, PropreteEnum propreteEnum, ArrayList<Creature> listeCreatures, int profondeur) {
        super(nom, superficie, capaciteEnclos, propreteEnum, listeCreatures);
        this.profondeur = profondeur;
    }

    /**
     * Permet de récupérer la valeur de la variable profondeur
     * @return
     */
    public int getProfondeur() {
        return profondeur;
    }

    /**
     * Permet de changer la valeur de la variable profondeur
     * @param profondeur Nouvelle valeur de la variable
     */
    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }

    /**
     * Permet de récupérer la valeur de la variable saliniteBassinOK
     * @return true si l'état est OK false sinon
     */
    public boolean isSaliniteBassinOK() {
        return saliniteBassinOK;
    }

    /**
     * Permet de changer la valeur de la variable saliniteBassinOK
     * @param saliniteBassinOK Nouvelle valeur de la variable
     */
    public void setSaliniteBassinOK(boolean saliniteBassinOK) {
        this.saliniteBassinOK = saliniteBassinOK;
    }

    /**
     * Fonction qui permet d'effectuer l'entretient de l'enclos
     * @return 0 si l'entretient est fait, 1 si l'entretient est pas possible (enclos non vide)
     */

    @Override
    public int entretientEnclos() {
        if (super.getNbCreaturesDansEnclos() > 0 && super.getProprete() == PropreteEnum.MAUVAIS) {
            return 1;
        }
        saliniteBassinOK = true;
        super.setProprete(PropreteEnum.BON);
        return 0;
    }
}
