package includes.creatures;

import includes.enclos.Enclos;

/**
 * Interface pour les creatures vivipares
 */
public interface Vivipare {
    /**
     * Methode qui permet de mettre bas (doit etre uniquement accessible aux femelles)
     * @param nom String du nom de la future creature
     * @param sexe SexesEnum sexe de la future creature
     * @param enclos Enclos de le creature
     */
    public Bebe mettreBas(String nom, SexesEnum sexe, Enclos enclos);

}
