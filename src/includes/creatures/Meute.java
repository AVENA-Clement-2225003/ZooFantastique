package includes.creatures;

import java.util.ArrayList;

public class Meute {

    private String nom;

    private ArrayList<Lycanthrope> listeMeute;
    CoupleAlpha coupleAlpha = new CoupleAlpha(null, null);

    public Meute(String nom, ArrayList<Lycanthrope> listeMeute) {
        this.nom = nom;
        this.listeMeute = listeMeute;
        if (this.listeMeute.size() != 0){
            this.coupleAlpha = instaurerHierarchie();
        }
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

    /**
     * Fonction qui permet l'ajout d'un lycanthrope dans lam meute
     * @param l lycanthrope a ajouter dans la meute
     */
    public void ajouterLycanthrope(Lycanthrope l){
        this.listeMeute.add(l);
    }

    public CoupleAlpha instaurerHierarchie(){
        // Separer les males et les femelles
        ArrayList<Lycanthrope> sousListeMales = new ArrayList<>();
        ArrayList<Lycanthrope> sousListeFemelle = new ArrayList<>();
        for (Lycanthrope l : listeMeute){
            if (l instanceof LycanthropeFemelle){
                sousListeFemelle.add(l);
            }
            else {
                sousListeMales.add(l);
            }
        }
        this.triSelectionForce(sousListeMales);
        this.triSelectionForce(sousListeFemelle);

        coupleAlpha.setMaleAlpha((LycanthropeMale) sousListeMales.get(0));
        coupleAlpha.setFemelleAlpha((LycanthropeFemelle) sousListeFemelle.get(0));
        if (sousListeMales.size() > 1){
            System.out.println("Coucou");
            sousListeMales.get(sousListeMales.size()-1).setRang(RangEnum.Omega);
        }
        else {
            if (sousListeMales.size()-2 % 4 != 0){
                if (sousListeMales.size()-2 % 4 >= 1){
                    sousListeMales.get(sousListeMales.size()-2).setRang(RangEnum.Omega);
                }
                if (sousListeMales.size()-2 % 4 >= 2 ){
                    sousListeMales.get(sousListeMales.size()-3).setRang(RangEnum.Omega);
                }
                if (sousListeMales.size()-2 % 4 >= 3){
                    sousListeMales.get(sousListeMales.size()-4).setRang(RangEnum.Omega);
                }

            }
            int nbParRang = (sousListeMales.size()-2) / 4;
            System.out.println(nbParRang + " = " + (sousListeMales.size()-2) + "/" + 4);
            for (int i = 0; i < nbParRang; ++i){
                sousListeMales.get(i+1).setRang(RangEnum.Beta);
            }
            for (int i = 0; i < nbParRang; ++i){
                sousListeMales.get(i+1+nbParRang*1).setRang(RangEnum.Gamma);
            }
            for (int i = 0; i < nbParRang; ++i){
                sousListeMales.get(i+1+nbParRang*2).setRang(RangEnum.Delta);
            }
            for (int i = 0; i < nbParRang; ++i){
                sousListeMales.get(i+1+nbParRang*3).setRang(RangEnum.Epsilon);
            }
        }
        if (sousListeFemelle.size() > 1){
            sousListeFemelle.get(sousListeFemelle.size()-1).setRang(RangEnum.Omega);
        }
        else {
            if (sousListeFemelle.size()-2 % 4 != 0){
                if (sousListeFemelle.size()-2 % 4 >= 1){
                    sousListeFemelle.get(sousListeFemelle.size()-2).setRang(RangEnum.Omega);
                }
                if (sousListeFemelle.size()-2 % 4 >= 2 ){
                    sousListeFemelle.get(sousListeFemelle.size()-3).setRang(RangEnum.Omega);
                }
                if (sousListeFemelle.size()-2 % 4 >= 3){
                    sousListeFemelle.get(sousListeFemelle.size()-4).setRang(RangEnum.Omega);
                }

            }
            int nbParRang = (sousListeFemelle.size()-2) / 4;
            nbParRang = sousListeFemelle.size()-2 / 4;
            for (int i = 0; i < nbParRang; ++i){
                sousListeFemelle.get(i+1).setRang(RangEnum.Beta);
            }
            for (int i = 0; i < nbParRang; ++i){
                sousListeFemelle.get(i+1+nbParRang*1).setRang(RangEnum.Gamma);
            }
            for (int i = 0; i < nbParRang; ++i){
                sousListeFemelle.get(i+1+nbParRang*2).setRang(RangEnum.Delta);
            }
            for (int i = 0; i < nbParRang; ++i){
                sousListeFemelle.get(i+1+nbParRang*3).setRang(RangEnum.Epsilon);
            }
            System.out.println(listeMeute);
        }

        return coupleAlpha;
    }

    /**
     * Fonction qui fait un tri par selection en fonction de la force des lycantropes
     * @param liste liste de l'enclos a trier
     */
    private void triSelectionForce(ArrayList<Lycanthrope> liste)
    {
        for (int i = 0; i < liste.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < liste.size(); j++)
            {
                if (liste.get(j).getForce() > liste.get(index).getForce()){
                    index = j;
                }
            }

            Lycanthrope min = liste.get(index);
            liste.set(index, liste.get(i));
            liste.set(i, min);
        }
    }
}
