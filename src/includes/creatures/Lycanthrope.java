package includes.creatures;

import includes.enclos.Enclos;

import java.util.Random;

/**
 * Classe qui represente les lycanthopes, qui a pour interface peutCourir
 */
public abstract class Lycanthrope extends Creature implements PeutCourir {

    /**
     * Rang du lycanthrope
     */
    private RangEnum rang;

    /**
     * Age du lycanthrope
     */
    private AgeEnum categorieAge;

    /**
     * Force du lycanthrope
     */
    private int force;

    /**
     * Facteur de domination du lycanthrope
     */
    private int facteurDomination;

    /**
     * Facteur d'impetuosite du lycanthrope
     */
    private int facteurImpetuosite;

    /**
     * Niveau du lycanthrope
     */
    private int niveau;

    /**
     * Meute du lycanthrope (doit etre null si solitaire)
     */
    private Meute meute;

    /**
     * Nombre de dominations exercees par le lycanthrope
     */
    private int dominationsExercee;

    /**
     * Nombre de dominations subies du lycanthrope
     */
    private int dominationsSubies;


    /**
     * Constructeur qui permet de creer un lycanthrope, qui n'a pas faim, est reveille et est en bonne sante
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
     * @param enclos Enclos du lycanthrope
     */
    public Lycanthrope(SexesEnum sexe, int poids, int taille, int age, String nom, Enclos enclos) {
        super(EspecesEnum.LYCANTHROPE, sexe, poids, taille, age, false, false, true , nom, enclos);
    }

    /**
     * Constructeur qui permet de creer un lycanthrope en choississant sa faim, son sommeil et sa sante
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param faim boolean faim de la creature
     * @param estEnTrainDeDormir boolean sommeil de la creature
     * @param sante boolean sante de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
     * @param enclos Enclos du lycanthope
     */
    public Lycanthrope(SexesEnum sexe, int poids, int taille, int age, boolean faim, boolean estEnTrainDeDormir, boolean sante, String nom, Enclos enclos) {
        super(EspecesEnum.LYCANTHROPE, sexe, poids, taille, age, faim, estEnTrainDeDormir, sante, nom, enclos);
    }

    /**
     * Constructeur qui permet de creer un lycanthrope, qui n'a pas faim, est reveille et est en bonne sante
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
     * @param enclos Enclos du lycanthrope
     * @param rang Rang du lycanthrope
     * @param force Force du lycanthrope
     * @param meute meute du lycanthrope
     */
    public Lycanthrope(SexesEnum sexe, int poids, int taille, int age, String nom, Enclos enclos, RangEnum rang, int force, Meute meute) {
        super(EspecesEnum.LYCANTHROPE, sexe, poids, taille, age, false, false, true , nom, enclos);
        Random r = new Random();
        this.rang = rang;
        if (age < 10){
            categorieAge = AgeEnum.Jeune;
        }
        else if(age < 40){
            categorieAge = AgeEnum.Adulte;
        }
        else {
            categorieAge = AgeEnum.Vieux;
        }
        if ((Integer)this.force == null){
            this.force = r.nextInt(900);
        }
        else {
            this.force = force;
        }
        this.meute = meute;
        if (meute != null){
            this.meute.ajouterLycanthrope(this);
        }
        dominationsExercee = 0;
        dominationsSubies = 0;
        facteurDomination = dominationsExercee - dominationsSubies;
        this.facteurImpetuosite = r.nextInt(5);
        int intAge = this.attribuerIntAge(categorieAge);
        int intRang = this.attribuerIntRang(rang);

        niveau = (this.force + facteurDomination*10 + intRang) / (intAge);

    }

    /**
     * Constructeur qui permet de creer un lycanthrope en choississant sa faim, son sommeil et sa sante
     * @param sexe SexesEnum sexe de la creature
     * @param poids int poids de la creature
     * @param taille int taille de la creature
     * @param age int age de la creature
     * @param faim boolean faim de la creature
     * @param estEnTrainDeDormir boolean sommeil de la creature
     * @param sante boolean sante de la creature
     * @param nom String nom de la creature (ne depend pas de son espece)
     * @param enclos Enclos du lycanthope
     * @param force Force du lycanthrope
     * @param meute meute du lycanthrope
     */
    public Lycanthrope(SexesEnum sexe, int poids, int taille, int age, boolean faim, boolean estEnTrainDeDormir, boolean sante, String nom, Enclos enclos, int force, Meute meute) {
        super(EspecesEnum.LYCANTHROPE, sexe, poids, taille, age, faim, estEnTrainDeDormir, sante, nom, enclos);
        Random r = new Random();
        if (age < 10){
            categorieAge = AgeEnum.Jeune;
        }
        else if(age < 40){
            categorieAge = AgeEnum.Adulte;
        }
        else {
            categorieAge = AgeEnum.Vieux;
        }
        this.force = force;
        if ((Integer)this.force == null){
            this.force = r.nextInt(900);
        }
        this.meute = meute;
        if (meute != null){
            this.meute.ajouterLycanthrope(this);
        }
        dominationsExercee = 0;
        dominationsSubies = 0;
        facteurDomination = dominationsExercee - dominationsSubies;
        this.facteurImpetuosite = r.nextInt(5);
    }

    /**
     * Fonction qui permet a un lycanthrope de courir
     * @return Le lycanthrope court.
     */
    @Override
    public String courir() {
        return "Le lycanthrope " + this.getNom() + " court.";
    }

    /**
     * Fonction qui permet au lycanthrope de faire un hurlement
     * @return String hurlement
     */
    @Override
    public String emettreUnSon(){
        return "Le lycanthrope " + this.getNom() + " fait un hurlement";
    }

    /**
     * Fonction qui permet au lycanthrope de hurler avec un hurlement qui fait reagir les autres lycanthropes
     * @return String confirmation hurlement
     */
    public String emettreUnSon(Hurlement hurlement){
        System.out.println("Le lycanthrope " + this.getNom() + " fait un hurlement de type " + hurlement.getType());
        if (hurlement.getType() == HurlementEnum.Appartenance){
            for (Creature c : this.getEnclos().getListeCreatures()){ // Fait reagir la meute
                if (c instanceof Lycanthrope){
                    ((Lycanthrope) c).entendreHurlement(hurlement);
                }
            }
        }
        return "Le lycanthrope " + this.getNom() + " fait un hurlement de type " + hurlement.getType();
    }

    /**
     * Fonction qui permet au lycanthrope d'entendre un hurlement et d'y repondre a son tour si c'est un hurlement de meute
     * @param hurlement hurlement que le lycanthrope entend
     * @return String msg le lycanthrope repond
     */
    public String entendreHurlement(Hurlement hurlement){
        if (hurlement.getType() == HurlementEnum.Appartenance){
            System.out.println("Le lycanthrope " + this.getNom() + " repond au hurlement");
            return "Le lycanthrope " + this.getNom() + " repond au hurlement";
        }
        return "";
    }

    public RangEnum getRang() {
        return rang;
    }

    public void setRang(RangEnum rang) {
        this.rang = rang;
    }

    public AgeEnum getCategorieAge() {
        return categorieAge;
    }

    public void setCategorieAge(AgeEnum categorieAge) {
        this.categorieAge = categorieAge;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getFacteurDomination() {
        return facteurDomination;
    }

    public void setFacteurDomination(int facteurDomination) {
        this.facteurDomination = facteurDomination;
    }

    public int getFacteurImpetuosite() {
        return facteurImpetuosite;
    }

    public void setFacteurImpetuosite(int facteurImpetuosite) {
        this.facteurImpetuosite = facteurImpetuosite;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public Meute getMeute() {
        return meute;
    }

    public void setMeute(Meute meute) {
        this.meute = meute;
    }

    public int getDominationsExercee() {
        return dominationsExercee;
    }

    public void setDominationsExercee(int dominationsExercee) {
        this.dominationsExercee = dominationsExercee;
    }

    public int getDominationsSubies() {
        return dominationsSubies;
    }

    public void setDominationsSubies(int dominationsSubies) {
        this.dominationsSubies = dominationsSubies;
    }

    /**
     * Fonction qui permet d'afficher les caracteristiques du lycanthrope
     * @return String toString
     */
    @Override
    public String toString() {
        return "\n" + "[ nom : " + this.getNom() + " | sexe : " + this.getSexe() + " | espece : " + getNomEspece() + " | age : " + getAge() + " | a faim : " + ((isFaim())?" oui ":" non ") +
                " | en bonne sante : " + ((isSante())?" oui ":" non ") + " | dort : " + ((isEstEnTrainDeDormir())?" oui ":" non ") + " | Enclos : " + getEnclos().getNom() + " | Rang : " + getRang() + " | Force : " + getForce() + "]";
    }

    /**
     * Fonction qui permet de tenter une domination
     */
    public String tenterDomination(Lycanthrope l){
        if (l.getNiveau() > this.getNiveau()){
            l.emettreUnSon(new Hurlement(HurlementEnum.Agressivite));
            return ("Le lycanthrope attaquant a perdu");
        }
        else {
            this.dominationsExercee += 1;
            l.dominationsSubies +=1;
            this.calculerFacteurDomination();
            l.calculerFacteurDomination();
            this.emettreUnSon(new Hurlement(HurlementEnum.Domination));
            l.emettreUnSon(new Hurlement(HurlementEnum.Soumission));
            if (l.getRang() == RangEnum.Alpha){
                this.getMeute().getCoupleAlpha().getFemelleAlpha().setRang(this.getRang()); // Redescend la femelle alpha
                this.getMeute().instaurerHierarchieFemelle();
            }
            RangEnum transfert = this.getRang();
            this.setRang(l.getRang());
            l.setRang(transfert);
            return ("Le lycanthrope a gagne");
        }
    }

    /**
     * Fonction qui permet d'associer un int a chaque categorie d'age (utilisee pour le calcul du niveau)
     * @param categorieAge categorie d'age du lycanthrope
     * @return retourne l'int associe a sa categorie d'age
     */
    public int attribuerIntAge(AgeEnum categorieAge){
        return switch (categorieAge) {
            case Jeune -> 1;
            case Adulte -> 2;
            case Vieux -> 4;
            default -> 4;
        };
    }

    /**
     * Fonction qui permet d'associer un int a chaque rang (utilisee pour le calcul du niveau)
     * @param rang rang du lycanthrope
     * @return retourne l'int associe a son rang
     */
    public int attribuerIntRang(RangEnum rang){
        return switch (rang) {
            case Alpha -> 50;
            case Beta -> 40;
            case Gamma -> 30;
            case Delta -> 20;
            case Epsilon -> 10;
            case Omega -> 0;
            default -> 0;
        };
    }

    /**
     * Fonction qui permet de calculer et mettre a jour le facteur de domination
     */
    public void calculerFacteurDomination(){
        this.setFacteurDomination(dominationsExercee - dominationsSubies);
    }
}
