package includes.maitreZoo;


import includes.creatures.Creature;
import includes.enclos.Enclos;

/**
 * Classe qui représente le maître du zoo fantastique
 */
public class MaitreZooFantastique {
    public MaitreZooFantastique(String nom, ENUMSexe sexe, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
    }

    /**
     * Nom du maître du zoo
     */
    private String nom;
    /**
     * Sexe du maître du zoo
     */
    private ENUMSexe sexe;
    /**
     * Age du maître du zoo
     */
    private int age;

    /**
     * Permet de récupérer l'âge du maître du zoo
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * Permet de mettre l'âge du maître du zoo
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ENUMSexe getSexe() {
        return sexe;
    }

    public void setSexe(ENUMSexe sexe) {
        this.sexe = sexe;
    }

    /**
     * Fonction d'affichage du maître du zoo
     * @return
     */
    @Override
    public String toString() {
        return "maître zoo fantastique{" +
                "nom='" + nom + '\'' +
                ", sexe='" + sexe + '\'' +
                ", age=" + age +
                '}';
    }
    public String examinerEnclos(Enclos enclos) {
        return "Le maître de zoo " + nom + " est dans le l'" + enclos.afficherEnclos();
    }
    public String nettoyerEnclos(Enclos enclos) {
        return nom + "a nettoyer l'" + enclos.entretientEnclos();
    }
    public String nourrirCreatures(Enclos enclos) {
        enclos.nourrirCreatures();
        return nom + "a nourrit les créatures de l'" + enclos;
    }
    public int deplacerCreature(Creature creature, Enclos enclos) {
        return creature.getEnclos().deplacerCreatureEnclos(creature, enclos);
    }
}
