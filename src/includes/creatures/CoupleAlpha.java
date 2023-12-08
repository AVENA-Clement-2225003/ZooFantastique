package includes.creatures;

/**
 * Classe qui represente le couple Alpha
 */
public class CoupleAlpha {

    /**
     * Male alpha du couple
     */
    private LycanthropeMale maleAlpha;

    /**
     * Femelle alpha du couple
     */
    private LycanthropeFemelle femelleAlpha;

    /**
     * Constructeur du couple Alpha
     * @param maleAlpha Male alpha du couple
     * @param femelleAlpha Femelle alpha du couple
     */
    public CoupleAlpha(LycanthropeMale maleAlpha, LycanthropeFemelle femelleAlpha) {
        this.maleAlpha = maleAlpha;
        this.femelleAlpha = femelleAlpha;
    }

    public LycanthropeMale getMaleAlpha() {
        return maleAlpha;
    }

    public void setMaleAlpha(LycanthropeMale maleAlpha) {
        this.maleAlpha = maleAlpha;
    }

    public LycanthropeFemelle getFemelleAlpha() {
        return femelleAlpha;
    }

    public void setFemelleAlpha(LycanthropeFemelle femelleAlpha) {
        this.femelleAlpha = femelleAlpha;
    }

    @Override
    public String toString() {
        return "CoupleAlpha{" +
                "maleAlpha=" + maleAlpha +
                ", femelleAlpha=" + femelleAlpha +
                '}';
    }
}
