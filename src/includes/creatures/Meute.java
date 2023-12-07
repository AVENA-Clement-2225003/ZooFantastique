package includes.creatures;

import java.util.ArrayList;

public class Meute {

    private String nom;

    private ArrayList<Lycanthrope> listeMeute;

    public Meute(String nom, ArrayList<Lycanthrope> listeMeute) {
        this.nom = nom;
        this.listeMeute = listeMeute;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Lycanthrope> getListeMeute() {
        return listeMeute;
    }

    public void setListeMeute(ArrayList<Lycanthrope> listeMeute) {
        this.listeMeute = listeMeute;
    }

    public void ajouterLycanthrope(Lycanthrope l){
        this.listeMeute.add(l);
    }
}
