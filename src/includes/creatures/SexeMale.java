package includes.creatures;

/**
 * Classe qui permet de definir le sexe des creatures
 */
public class SexeMale extends Sexe{

    /**
     * Sexe de la creature
     */
    private SexesEnum sexe;

    /**
     * Constructeur du sexe masculin de la creature
     */
    public SexeMale() {
        this.sexe = SexesEnum.MALE;
    }
}
