package app;
import includes.creatures.*;
import includes.enclos.Enclos;
import includes.enclos.EnclosStandard;
import includes.enclos.EnclosVoliere;
import includes.creatures.SexesEnum;
import includes.zoo.zooFantastique;
import includes.maitreZoo.MaitreZooFantastique;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.ArrayList;

/**
 * Classe Modèle de notre appilication
 */
public class Model {
    /**
     * Instance de la classe Model
     */
    private static Model instance = null;

    /**
     * Fonction permettant de n'avoir qu'une isntance de la classe Model
     * @return
     */
    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }

        return instance;
    }

    /**
     * true si le mode de développement est actif, false sinon
     */
    private boolean devMode;
    /**
     * Le maitre de zoo
     */
    private MaitreZooFantastique maitre;
    /**
     * Le zoo
     */
    private zooFantastique unZoo;

    /**
     * Constructeur de la classe Model
     */
    public Model() {
        try (BufferedReader br = new BufferedReader(new FileReader("out/production/ZooFantastique/app/config.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("devMode=")) {
                    devMode = Boolean.parseBoolean(line.substring("devMode=".length()).trim());
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("config.txt est manquant");
            devMode = false;
        }
    }

    /**
     * Fonction permettant de récupérer l'ENUM correspondant au string passé en parametre
     * @param s
     * @return
     */
    public EspecesEnum getEspeceByStr(String s) {
        switch (s) {
            case "dragon":
                return EspecesEnum.DRAGON;
            case "kraken":
                return EspecesEnum.KRAKEN;
            case "licorne":
                return EspecesEnum.LICORNE;
            case "lycanthrope":
                return EspecesEnum.LYCANTHROPE;
            case "megalodon":
                return EspecesEnum.MEGALODON;
            case "nymphe":
                return EspecesEnum.NYMPHE;
            case "phenix":
                return EspecesEnum.PHENIX;
            case "sirene":
                return EspecesEnum.SIRENE;
            default:
                return null;
        }
    }

    /**
     * Fonction qui permet de savoir si l'utilisateur est en mode développement
     * @return
     */
    public boolean isDevMode() {
        return devMode;
    }

    /**
     * Fonction qui va créer un zoo et un maitre de zoo à partir des éléments passés en paramètres
     * @param nom
     * @param nomMaitreDeZoo
     * @return
     */
    public zooFantastique CreerUnZoo(String nom, String nomMaitreDeZoo) {
        if (nom.equals("")) nom = "UnZooSuper";
        if (nomMaitreDeZoo.equals("")) nomMaitreDeZoo = "UnMaitreSuper";
        maitre = new MaitreZooFantastique(nomMaitreDeZoo, SexesEnum.MALE, 23);
        unZoo = new zooFantastique(nom, nomMaitreDeZoo/*maitre*/, 15, new ArrayList<>());
        unZoo.ajouterEnclos(new EnclosStandard("Tuto", 45, 5));
        Licorne L1 = new LicorneMale(50, 150, 25, "James", unZoo.getEnclosByNom("Tuto"));
        Licorne L3 = new LicorneMale(50, 150, 25, "Albert", unZoo.getEnclosByNom("Tuto"));
        Licorne L4 = new LicorneMale(50, 150, 25, "Béatrice", unZoo.getEnclosByNom("Tuto"));
        Licorne L2 = new LicorneFemelle(50, 150, 25, "Maria", unZoo.getEnclosByNom("Tuto"));
        unZoo.getEnclosExistant().get(0).ajouterCreature(L1);
        unZoo.getEnclosExistant().get(0).ajouterCreature(L2);
        unZoo.getEnclosExistant().get(0).ajouterCreature(L3);
        unZoo.getEnclosExistant().get(0).ajouterCreature(L4);

        unZoo.ajouterEnclos(new EnclosVoliere("T1", 45, 5, 15));
        Phenix P1 = new PhenixMale(50, 150, 25, "James", unZoo.getEnclosByNom("T1"));
        Phenix P2 = new PhenixFemelle(50, 150, 25, "Maria", unZoo.getEnclosByNom("T1"));
        verifierNomEtRenommerCreature(P1, P1.getNom());
        verifierNomEtRenommerCreature(P2, P2.getNom());
        unZoo.getEnclosExistant().get(1).ajouterCreature(P1);
        unZoo.getEnclosExistant().get(1).ajouterCreature(P2);
        return unZoo;
    }

    /**
     * Fonction qui permet de vérifier si un nom n'est pas déja utilisé et le change si c'est le cas pour simplifer les recherches de crétures
     * @param animal
     * @param nom
     */
    public void verifierNomEtRenommerCreature(Creature animal, String nom) {
        int id = 1;
        String nvNom = nom;
        for (Enclos e:unZoo.getEnclosExistant()) {
            for (Creature c:e.getListeCreatures()) {
                if (nvNom.equals(c.getNom())) {
                    nvNom = nom + id;
                    ++id;
                }
            }
        }
        animal.setNom(nvNom);
    }

    /**
     * Getter de maitre
     * @return
     */
    public MaitreZooFantastique getMaitre() {
        return maitre;
    }

    /**
     * Getter de unZoo
     * @return
     */
    public zooFantastique getZoo() {
        return unZoo;
    }

    /**
     * Fonction permettant de récupérer les 7 premier enclos du zoo
     * @return
     */
    public ArrayList<String> get7erEnclos() {
        ArrayList<String> liste = new ArrayList<>();
        for (Enclos e:unZoo.getEnclosExistant()) {
            if (liste.size() == 7) return liste;
            liste.add(e.getNom());
        }
        int nombreAAjouter = (7 - liste.size());
        for (int i = 0; i < nombreAAjouter; i+=1) {liste.add(" ");}
        return liste;
    }

    /**
     * Fonction permettant de récupérer les 7 premières créatures malades du zoo
     * @return
     */
    public ArrayList<String> get7erMalades() {
        ArrayList<String> liste = new ArrayList<>();
        for (Enclos e:unZoo.getEnclosExistant()) {
            for (Creature c:e.getListeCreatures()) {
                if (liste.size() == 7) return liste;
                if (c.isSante() == false) liste.add(c.getNom());
            }
        }
        int nombreAAjouter = (7 - liste.size());
        for (int i = 0; i < nombreAAjouter; i+=1) {liste.add(" ");}
        return liste;
    }

    /**
     * Fonction permettant de récupérer les 7 premières créatures qui ont faim du zoo
     * @return
     */
    public ArrayList<String> get7erFaims() {
        ArrayList<String> liste = new ArrayList<>();
        for (Enclos e:unZoo.getEnclosExistant()) {
            for (Creature c:e.getListeCreatures()) {
                if (liste.size() == 7) return liste;
                if (c.isFaim() == true) liste.add(c.getNom());
            }
        }
        int nombreAAjouter = (7 - liste.size());
        for (int i = 0; i < nombreAAjouter; i+=1) {liste.add(" ");}
        return liste;
    }

    /**
     * Fonction permettant de récupérer les 7 premières créatures qui dorment du zoo
     * @return
     */
    public ArrayList<String> get7erDormir() {
        ArrayList<String> liste = new ArrayList<>();
        for (Enclos e:unZoo.getEnclosExistant()) {
            for (Creature c:e.getListeCreatures()) {
                if (liste.size() == 7) return liste;
                if (c.isEstEnTrainDeDormir()) liste.add(c.getNom());
            }
        }
        int nombreAAjouter = (7 - liste.size());
        for (int i = 0; i < nombreAAjouter; i+=1) {liste.add(" ");}
        return liste;
    }

    /**
     * Fonction permettant de récupérer les 7 premières créatures mortes du zoo
     * @return
     */
    public ArrayList<String> get7erMorts() {
        ArrayList<String> liste = new ArrayList<>();
        for (Enclos e:unZoo.getEnclosExistant()) {
            for (Creature c:e.getListeCreatures()) {
                if (liste.size() == 7) return liste;
                if (c.getAge() >= c.getAgeMort()) liste.add(c.getNom());
            }
        }
        int nombreAAjouter = (7 - liste.size());
        for (int i = 0; i < nombreAAjouter; i+=1) {liste.add(" ");}
        return liste;
    }

    /**
     * Fonction permettant de savoir si une créature est enceinte
     * @param s
     * @return
     */
    public boolean estEnceinte(String s) {
        Creature c = unZoo.getCreatureByNom(s);
        for (Creature ce:c.getEnclos().getListeCreatures()) {
            if (ce instanceof Bebe && ((Bebe) ce).getMere().equals(c)) return true;
        }
        return false;
    }

    /**
     * Fonction permettant de trier par ordre alphabétiques les enclos du zoo
     */
    public void trierEnclos() {
        ArrayList<Enclos> liste = unZoo.getEnclosExistant();
        int min = 0;
        for (int i = 1; i < liste.size(); i+=1) {
            for (int j = i; j < liste.size(); j+=1) {
                if (comparerASCII(liste.get(min).getNom(), liste.get(j).getNom()) == 1) {
                    min = j;
                } else if (comparerASCII(liste.get(min).getNom(), liste.get(j).getNom()) == 2) {
                    if (liste.get(j).getID() < liste.get(min).getID()) min = j;
                }
            }
            Enclos tmp = liste.get(0);
            liste.set(0, liste.get(min));
            liste.set(min, tmp);
        }
    }

    /**
     * Fonction qui permet de savoir si un string est plus petit alphabétiquemement que le second
     * @param str1
     * @param str2
     * @return
     */
    private static int comparerASCII(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());

        for (int i = 0; i < minLength; i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            if (char1 < char2) {
                return 0;
            } else if (char1 > char2) {
                return 1;
            }
        }
        return 2;
    }

    /**
     * Fonction permettant de trier les créatures d'un enclos passé en parametre
     * @param enclos
     */
    public void trierUnEnclos(Enclos enclos) {
        ArrayList<Creature> liste = enclos.getListeCreatures();
        int min = 0;
        for (int i = 0; i < liste.size(); i+=1) {
            for (int j = i; j < liste.size(); j+=1) {
                if (comparerASCII(liste.get(min).getNom(), liste.get(j).getNom()) == 1) {
                    min = j;
                } else if (comparerASCII(liste.get(min).getNom(), liste.get(j).getNom()) == 2) {
                    if (liste.get(j).getID() < liste.get(min).getID()) min = j;
                }
            }
            Creature tmp = liste.get(i);
            liste.set(i, liste.get(min));
            liste.set(min, tmp);
        }
    }
}