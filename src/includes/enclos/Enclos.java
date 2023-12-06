package includes.enclos;

import includes.creatures.Creature;

import java.util.ArrayList;

/**
 * Classe qui représente un enclos
 */
public abstract class Enclos {
    /**
     * Permet de création de numéro d'enclos unique
     */
    private static int lastID = 0;
    /**
     * Numéro unique de l'enclos
     */
    private int ID;
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
    private ArrayList<Creature> listeCreatures;
    /**
     * Degré de propreté de l'encos
     */
    private PropreteEnum propreteEnum;

    /**
     * Constructeur simple
     * @param nom Nom de l'enclos
     * @param superficie Superficie de l'enclos
     * @param capaciteEnclos Capacité de l'enclos
     */
    public Enclos(String nom, int superficie, int capaciteEnclos) {
        this.ID = this.lastID++;
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteEnclos = capaciteEnclos;
        this.propreteEnum = PropreteEnum.BON;
        this.listeCreatures = new ArrayList<>();
    }

    /**
     * Fonction permettant surtout des tests rapide grâce à la possibilité de définir tous les champs dès sa contruction
     * @param nom Le nom de l'enclos
     * @param superficie La superficie de l'enclos
     * @param capaciteEnclos La capacité maximale de l'enclos
     * @param propreteEnum Le degré de propreté qui peut etre MAUVAIS, CORRECT, BON
     * @param listeCreatures La liste des créatures présentent dans l'enclos
     */
    public Enclos(String nom, int superficie, int capaciteEnclos, PropreteEnum propreteEnum, ArrayList<Creature> listeCreatures) {
        this.ID = this.lastID++;
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteEnclos = capaciteEnclos;
        this.propreteEnum = propreteEnum;
        this.listeCreatures = listeCreatures;
    }

    /**
     * Permet de récupérer la valeur de la variable lastID
     * @return
     */
    public static int getLastID() {
        return lastID;
    }

    /**
     * Permet de récupérer la valeur de la variable ID
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * Permet de récupérer la valeur de la variable nom
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Permet de changer la valeur de la variable nom
     * @return
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Permet de récupérer la valeur de la variable superficie
     * @return
     */
    public int getSuperficie() {
        return superficie;
    }
    /**
     * Permet de changer la valeur de la variable superficie
     * @return
     */
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }
    /**
     * Permet de récupérer la valeur de la variable capaciteEnclos
     * @return
     */
    public int getCapaciteEnclos() {
        return capaciteEnclos;
    }
    /**
     * Permet de changer la valeur de la variable capaciteEnclos
     * @return
     */
    public void setCapaciteEnclos(int capaciteEnclos) {
        this.capaciteEnclos = capaciteEnclos;
    }
    /**
     * Permet de récupérer la valeur de la variable listeCreatures
     * @return
     */
    public ArrayList<Creature> getListeCreatures() {
        return listeCreatures;
    }
    /**
     * Permet de changer la valeur de la variable listeCreatures
     * @return
     */
    public void setListeCreatures(ArrayList<Creature> listeCreatures) {
        this.listeCreatures = listeCreatures;
    }
    /**
     * Permet de récupérer la valeur de la variable proprete
     * @return
     */
    public PropreteEnum getProprete() {
        return propreteEnum;
    }
    /**
     * Permet de changer la valeur de la variable proprete
     * @return
     */
    public void setProprete(PropreteEnum propreteEnum) {
        this.propreteEnum = propreteEnum;
    }

    /**
     * Fonction permettant l'entretient de l'enclos
     * @return
     */
    public abstract int entretientEnclos();

    /**
     * Fonction d'affichage de l'enclos
     * @return
     */
    @Override
    public String toString() {
        return "Enclos: " + nom + " | Superficie: " + superficie + " | Capacitée: " + capaciteEnclos + " | Propretée: " + propreteEnum;
    }

    /**
     * Fonction qui permet la récupération d'un affichage utilisateur
     * @return un string avec le nom de toutes les crétures
     */
    public String afficherCreatures() {
        if (listeCreatures.isEmpty()) return "L'enclos " + nom +  " est vide";
        String strConteneur = "";
        for (Creature c:listeCreatures) {
            strConteneur += c.toString() + "\n";
        }
        return strConteneur;
    }

    /**
     * Fonction qui permet la récupération d'un affichage utilisateur
     * @return un string avec le nom de toutes les informations de l'enclos
     */
    public String afficherEnclos() {
        return nom + " d'une superficie de " + superficie + "m² pouvant accueillir " + capaciteEnclos + " créatures avec " + listeCreatures.size() + " présentes et il est en " + propreteEnum + " état";
    }

    /**
     * Fonction qui permet la comparaison de deux créature et savoir si il s'agit de la même
     * @param enclos
     * @return
     */
    public boolean equals(Enclos enclos) {
        return this.ID == enclos.ID;
    }

    /**
     * Fonction permettant le transfert d'une créature vers un autre enclos
     * @param creature
     * @param enclos
     * @return
     */
    public int deplacerCreatureEnclos(Creature creature, Enclos enclos) {
        if (this.equals(enclos)) return 1; //Si l'enclos de destination est celui ou se trouve acutellement la créature
        if (!existInListeCreature(creature)) return 2; //Si la créature n'existe pas dans l'enclos
        if (enclos.ajouterCreature(creature)==2) return 3; //Si plus de place dans enclos de destination
        if (retirerCreature(creature)==1) return 4; //Si la créature à retirer n'existe pas dans l'enclos
        return 0; //Si tous se passe bien
    }

    /**
     * Fonction qui permet de nourrir toutes les créatures de l'enclos
     * @return 0 si tous les animaux sont nourrit, 1 sinon
     */
    public int nourrirCreatures(){
        for (Creature creature : listeCreatures){
            creature.setFaim(false);
        }
        return 0;
    }

    /**
     * Fonction permettant l'ajout d'une créature dans l'enclos
     * @param creature Créature à ajouter
     * @return 0 si la créature est ajoutée 1 si elle est déjà présente
     */
    public int ajouterCreature(Creature creature){ //la vérification que le type de creature est le même que les autres se fera dans le MVC
        if (listeCreatures.size() >= capaciteEnclos) return 2; // Si il n'y a plus de place
        for (Creature creature1 : listeCreatures) {
            if (creature1.getID() == creature.getID()) return 1; // Si la créature est déjà présente
            if (creature1.getNom() == creature.getNom()) {
                creature.setNom(creature.getNom() + creature.getID());
                listeCreatures.add(creature);
                return 0;
            }
        }
        listeCreatures.add(creature);
        return 0;
    }

    /**
     * Fonction permmettant la suppression d'un créature dans l'enclos
     * @return 0 si la suppression à fonctionner
     */
    public int retirerCreature(Creature creature){
        if (!existInListeCreature(creature)) return 1;
        listeCreatures.remove(getIndexCreature(creature));
        return 0;
    }

    /**
     * Fonction qui permet de récupérer l'indice d'une créature dans la liste des créatures
     * @param creature Créature recherché
     * @return
     */
    public int getIndexCreature(Creature creature){
        if (!existInListeCreature(creature)) return listeCreatures.size();
        for (int i = 0; i < listeCreatures.size(); i++){
            if(listeCreatures.get(i).getID() == listeCreatures.get(i).getID()){
                return i;
            }
        }
        return listeCreatures.size(); //Dupliqué car sinon la méthode est considérée comme fausse par l'IDE
    }
    /**
     * Fonction qui permet de savoir si une créature existe dans la liste des créatures
     * @param creature Créature recherché
     * @return true si elle existe false sinon
     */
    public boolean existInListeCreature(Creature creature){
        if (listeCreatures.isEmpty()) return false;
        for (Creature creatureListe : listeCreatures){
            if(creatureListe.getID() == creature.getID()){
                return true;
            }
        }
        return false;
    }
}
