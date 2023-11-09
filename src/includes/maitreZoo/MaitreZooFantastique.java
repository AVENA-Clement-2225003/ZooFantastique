package includes.maitreZoo;

/**
 * Classe qui représente le maître du zoo fantastique
 */
public class MaitreZooFantastique {
    /**
     * Nom du maître du zoo
     */
    private String nom;
    /**
     * Sexe du maître du zoo
     */
    private String sexe;
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


    /**
     * Fonction d'affichage du maître du zoo
     * @return
     */
    @Override
    public String toString() {
        return "includes.maitreZoo.MaitreZooFantastique{" +
                "nom='" + nom + '\'' +
                ", sexe='" + sexe + '\'' +
                ", age=" + age +
                '}';
    }
}
