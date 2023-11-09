import java.util.ArrayList;

/**
 * Classe qui représente un enclos
 */
public class Enclos {
    /**
     * Nom de l'enclos
     */
    private String nom;
    /**
     * Superficie de l'enclos
     */
    private int superficie;
    /**
     * Capacitée maximale de l'enclos
     */
    private int capaciteEnclos;
    /**
     * Le nombre de créature présentes dnas l'enclos
     */
    private int nbCreaturesDansEnclos;
    /**
     * La liste contenant les créatures présentes
     */
    private ArrayList<Creature> listeCreatures;
    /**
     * Degré de propreté de l'encos
     */
    private Proprete proprete;

    /**
     * Contructeur simple
     * @param nom Nom de l'enclos
     * @param superficie Superficie de l'enclos
     */
    public Enclos(String nom, int superficie, int capaciteEnclos) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteEnclos = capaciteEnclos;
        this.nbCreaturesDansEnclos = 0;
        this.proprete = Proprete.BON;
        this.listeCreatures = new ArrayList<>();
    }

    /**
     * Fonction permettant surtout des tests rapide grâce à la possibilité de définir tous les champs dès sa contruction
     * @param nom Le nom de l'enclos
     * @param superficie La superficie de l'enclos
     * @param capaciteEnclos La capacité maximale de l'enclos
     * @param proprete Le degré de propreté qui peut etre MAUVAIS, CORRECT, BON
     * @param listeCreatures La liste des créatures présentent dans l'enclos
     */
    public Enclos(String nom, int superficie, int capaciteEnclos, Proprete proprete, ArrayList<Creature> listeCreatures) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteEnclos = capaciteEnclos;
        this.nbCreaturesDansEnclos = listeCreatures.size(); //Prend automatiquement la taille de la liste des créatures
        this.proprete = proprete;
        this.listeCreatures = listeCreatures;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getCapaciteEnclos() {
        return capaciteEnclos;
    }

    public void setCapaciteEnclos(int capaciteEnclos) {
        this.capaciteEnclos = capaciteEnclos;
    }

    public int getNbCreaturesDansEnclos() {
        return nbCreaturesDansEnclos;
    }

    public void setNbCreaturesDansEnclos(int nbCreaturesDansEnclos) {
        this.nbCreaturesDansEnclos = nbCreaturesDansEnclos;
    }

    public ArrayList<Creature> getListeCreatures() {
        return listeCreatures;
    }

    public void setListeCreatures(ArrayList<Creature> listeCreatures) {
        this.listeCreatures = listeCreatures;
    }

    public Proprete getProprete() {
        return proprete;
    }

    public void setProprete(Proprete proprete) {
        this.proprete = proprete;
    }

    @Override
    public String toString() {
        return "Enclos{" +
                "nom='" + nom + '\'' +
                ", superficie=" + superficie +
                ", capaciteEnclos=" + capaciteEnclos +
                ", nbCreaturesDansEnclos=" + nbCreaturesDansEnclos +
                ", listeCreatures=" + for (listeCreatures: Creature creature){creature.toString()} +
                ", proprete=" + proprete +
                '}';
    }
}
