package includes.creatures;

/**
 * Classe qui gere les hurlements des lycanthropes
 */
public class Hurlement {

    /**
     * Type de hurlement
     */
    private HurlementEnum type;

    /**
     * Constructeur de hurlement
     * @param type type de hurlement (Appartenance, Domination, Soumission ou Agressivite)
     */
    public Hurlement(HurlementEnum type){
        this.type = type;
    }

    @Override
    public String toString() {
        return "Hurlement{" +
                "type=" + type +
                '}';
    }

    public HurlementEnum getType() {
        return type;
    }

    public void setType(HurlementEnum type) {
        this.type = type;
    }
}
