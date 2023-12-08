package includes.creatures;

import java.util.ArrayList;

public class Meute {

    private String nom;

    private ArrayList<Lycanthrope> listeMeute;
    CoupleAlpha coupleAlpha = new CoupleAlpha(null, null);

    public Meute(String nom, ArrayList<Lycanthrope> listeMeute) {
        this.nom = nom;
        this.listeMeute = listeMeute;
        if (this.listeMeute.size() != 0) {
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

    public CoupleAlpha getCoupleAlpha() {
        return coupleAlpha;
    }

    public void setCoupleAlpha(CoupleAlpha coupleAlpha) {
        this.coupleAlpha = coupleAlpha;
    }

    /**
     * Fonction qui permet l'ajout d'un lycanthrope dans lam meute
     *
     * @param l lycanthrope a ajouter dans la meute
     */
    public void ajouterLycanthrope(Lycanthrope l) {
        this.listeMeute.add(l);
    }

    public CoupleAlpha instaurerHierarchie() {
        // Separer les males et les femelles
        ArrayList<Lycanthrope> sousListeMales = new ArrayList<>();
        ArrayList<Lycanthrope> sousListeFemelle = new ArrayList<>();
        for (Lycanthrope l : listeMeute) {
            if (l instanceof LycanthropeFemelle) {
                sousListeFemelle.add(l);
            } else {
                sousListeMales.add(l);
            }
        }
        this.triSelectionForce(sousListeMales);
        this.triSelectionForce(sousListeFemelle);

        // Attribution des rangs Mâles
        LycanthropeMale maleAlpha = instaurerHierarchieMales();

        //Attribution des rangs Femelles
        LycanthropeFemelle femelleAlpha = instaurerHierarchieFemelle();

        coupleAlpha.setMaleAlpha(maleAlpha);
        coupleAlpha.setFemelleAlpha(femelleAlpha);

        //System.out.println("la liste des femelles : \n" + sousListeFemelle + "\nLa liste des males : \n" + sousListeMales);
        attribuerNiveau();
        return coupleAlpha;
    }

    public LycanthropeMale instaurerHierarchieMales(){
        ArrayList<Lycanthrope> sousListeMales = new ArrayList<>();
        for (Lycanthrope l : listeMeute) {
            if (l instanceof LycanthropeMale) {
                sousListeMales.add(l);
            }
        }
        coupleAlpha.setMaleAlpha((LycanthropeMale) sousListeMales.get(0));
        sousListeMales.get(0).setRang(RangEnum.Alpha);
        if (sousListeMales.size() == 2) {
            sousListeMales.get(sousListeMales.size() - 1).setRang(RangEnum.Omega);
        } else if (sousListeMales.size() != 1){
            sousListeMales.get(sousListeMales.size() - 1).setRang(RangEnum.Omega);
            if ((sousListeMales.size() - 2) % 4 != 0) {
                if (sousListeMales.size() - 2 % 4 >= 1) {
                    sousListeMales.get(sousListeMales.size() - 2).setRang(RangEnum.Omega);
                }
                if ((sousListeMales.size() - 2) % 4 >= 2) {
                    sousListeMales.get(sousListeMales.size() - 3).setRang(RangEnum.Omega);
                }
                if ((sousListeMales.size() - 2) % 4 >= 3) {
                    sousListeMales.get(sousListeMales.size() - 4).setRang(RangEnum.Omega);
                }

            }
            int nbParRang = (sousListeMales.size() - 2) / 4;
            System.out.println(nbParRang + " = " + (sousListeMales.size() - 2) + "/" + 4);
            for (int i = 0; i < nbParRang; ++i) {
                sousListeMales.get(i + 1).setRang(RangEnum.Beta);
            }
            for (int i = 0; i < nbParRang; ++i) {
                sousListeMales.get(i + 1 + nbParRang * 1).setRang(RangEnum.Gamma);
            }
            for (int i = 0; i < nbParRang; ++i) {
                sousListeMales.get(i + 1 + nbParRang * 2).setRang(RangEnum.Delta);
            }
            for (int i = 0; i < nbParRang; ++i) {
                sousListeMales.get(i + 1 + nbParRang * 3).setRang(RangEnum.Epsilon);
            }
        }
        return coupleAlpha.getMaleAlpha();
    }

    public LycanthropeFemelle instaurerHierarchieFemelle(){
        ArrayList<Lycanthrope> sousListeFemelle = new ArrayList<>();
        for (Lycanthrope l : listeMeute) {
            if (l instanceof LycanthropeFemelle) {
                sousListeFemelle.add(l);
            }
        }
        coupleAlpha.setFemelleAlpha((LycanthropeFemelle) sousListeFemelle.get(0));
        sousListeFemelle.get(0).setRang(RangEnum.Alpha);
        if (sousListeFemelle.size() == 2) {
            sousListeFemelle.get(sousListeFemelle.size() - 1).setRang(RangEnum.Omega);
        } else if (sousListeFemelle.size() != 1) {
            sousListeFemelle.get(sousListeFemelle.size() - 1).setRang(RangEnum.Omega);
            if ((sousListeFemelle.size() - 2) % 4 != 0) {
                if (sousListeFemelle.size() - 2 % 4 >= 1) {
                    sousListeFemelle.get(sousListeFemelle.size() - 2).setRang(RangEnum.Omega);
                }
                if ((sousListeFemelle.size() - 2) % 4 >= 2) {
                    sousListeFemelle.get(sousListeFemelle.size() - 3).setRang(RangEnum.Omega);
                }
                if ((sousListeFemelle.size() - 2) % 4 >= 3) {
                    sousListeFemelle.get(sousListeFemelle.size() - 4).setRang(RangEnum.Omega);
                }

            }
            int nbParRang = (sousListeFemelle.size() - 2) / 4;
            nbParRang = (sousListeFemelle.size() - 2) / 4;
            for (int i = 0; i < nbParRang; ++i) {
                sousListeFemelle.get(i + 1).setRang(RangEnum.Beta);
            }
            for (int i = 0; i < nbParRang; ++i) {
                sousListeFemelle.get(i + 1 + nbParRang * 1).setRang(RangEnum.Gamma);
            }
            for (int i = 0; i < nbParRang; ++i) {
                sousListeFemelle.get(i + 1 + nbParRang * 2).setRang(RangEnum.Delta);
            }
            for (int i = 0; i < nbParRang; ++i) {
                sousListeFemelle.get(i + 1 + nbParRang * 3).setRang(RangEnum.Epsilon);
            }
        }
        return coupleAlpha.getFemelleAlpha();
    }

    /**
     * Fonction qui permet d'attribuer le niveau d'un lycanthrope
     */
    public void attribuerNiveau(){
        int intAge;
        int intRang;
        for (Lycanthrope l : listeMeute){
            intAge = l.attribuerIntAge(l.getCategorieAge());
            intRang = l.attribuerIntRang(l.getRang());
            l.setNiveau((l.getForce() + l.getFacteurDomination()*10 + intRang) / (intAge));
        }
    }

    /**
     * Fonction qui fait un tri par selection en fonction de la force des lycantropes
     * @param liste liste de l'enclos a trier
     */
    private void triSelectionForce(ArrayList<Lycanthrope> liste) {
        for (int i = 0; i < liste.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < liste.size(); j++) {
                if (liste.get(j).getForce() > liste.get(index).getForce()) {
                    index = j;
                }
            }
            Lycanthrope min = liste.get(index);
            liste.set(index, liste.get(i));
            liste.set(i, min);
        }
    }
}
