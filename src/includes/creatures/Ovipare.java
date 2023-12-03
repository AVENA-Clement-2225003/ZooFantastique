package includes.creatures;

import includes.enclos.Enclos;

/**
 * Interface pour les creatures ovipares
 */
public interface Ovipare {
    /**
     * Methode qui permet de pondre des oeufs (doit etre uniquement accessible aux femelles)
     * @param nom String du nom de la future creature
     * @param sexe SexesEnum sexe de la future creature
     * @param enclos Enclos de le creature
     */
    public Oeuf pondreOeuf(String nom, SexesEnum sexe, Enclos enclos);


}
