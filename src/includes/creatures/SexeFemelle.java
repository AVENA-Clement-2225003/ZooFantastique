package includes.creatures;

/**
 * Classe qui permet a une creature de donner la vie.
 */
public class SexeFemelle extends Sexe{

    /**
     * Sexe de la creature
     */
    private SexesEnum sexe;

    /**
     * Constructeur du sexe feminin de la creature
     */
    public SexeFemelle() {
        this.sexe = SexesEnum.FEMELLE;
    }

    /**
     * Fonction qui permet de donner la vie.
     * @return "La creature donne la vie"
     */
    public String donnerVie(){
        return "La creature donne la vie";
    }

    @Override
    public String toString() {
        return "SexeFemelle{" +
                "sexe=" + sexe +
                '}';
    }
}
