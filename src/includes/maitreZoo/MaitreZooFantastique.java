package includes.maitreZoo;


import includes.creatures.Creature;
import includes.creatures.SexesEnum;
import includes.enclos.Enclos;

/**
 * Classe qui représente le maître du zoo fantastique
 */
public class MaitreZooFantastique {
    public MaitreZooFantastique(String nom, SexesEnum sexe, int age) {
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
    private SexesEnum sexe;
    /**
     * Age du maître du zoo
     */
    private int age;

    /**
     * Permet de récupérer l'âge du maître du zoo
     * @return retourne l'âge du maître de zoo
     */
    public int getAge() {
        return age;
    }

    /**
     * Permet de mettre l'âge du maître du zoo
     * @param age prend l'age du maitre de zoo
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

    public SexesEnum getSexe() {
        return sexe;
    }

    public void setSexe(SexesEnum sexe) {
        this.sexe = sexe;
    }

    /**
     * Fonction d'affichage du maître du zoo
     * @return retourne les caractéristiques du maître de zoo
     */
    @Override
    public String toString() {
        return "maître de zoo fantastique{" +
                "nom='" + nom + '\'' +
                ", sexe='" + sexe + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * Fonction qui permet au maître de zoo de examiner l'enclos
     * @param enclos nom de la enclos cible
     * @return retourne le nom du maître du zoo avec les caractéristiques de l'enclos et les animaux de l'enclos cible
     */
    public String examinerEnclos(Enclos enclos) {
        return "Le maître de zoo " + nom + " est dans le l'" + enclos.afficherEnclos();
    }

    /**
     * Fonction qui permet au maître de zoo de nettoyter l'enclos
     * @param enclos nom de la enclos cible
     * @return retourne le nom du maître du zoo avec l'id de l'enclos
     */
    public String nettoyerEnclos(Enclos enclos) {
        return nom + " a nettoyer l'enclos : " + enclos.entretientEnclos();
    }

    /**
     * Fonction qui permet au maître de zoo de nourrir les créatures d'un enclos
     * @param enclos nom de la enclos cible
     * @return retourne le nom du maître du zoo avec les caractéristiques de l'enclos cible
     */
    public String nourrirCreatures(Enclos enclos) {
        enclos.nourrirCreatures();
        return nom + " a nourrit les créatures de l'enclos : " + enclos;
    }

    /**
     * Fonction qui permet au maître de zoo de déplacer une créature d'un enclos a un autre
     * @param creature nom de la enclos cible
     * @param enclos nom de l'enclos cible
     * @return 0 si la fonction a fonctionne
     */
    public int deplacerCreature(Creature creature, Enclos enclos) {
        return creature.getEnclos().deplacerCreatureEnclos(creature, enclos);
    }
}
