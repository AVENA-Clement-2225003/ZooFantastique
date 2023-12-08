package app;
import includes.creatures.*;
import includes.enclos.Enclos;
import includes.enclos.EnclosAquarium;
import includes.enclos.EnclosStandard;
import includes.enclos.EnclosVoliere;
import includes.creatures.SexesEnum;
import includes.zoo.zooFantastique;
import includes.maitreZoo.MaitreZooFantastique;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

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
     * @return instance de Model
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
     * @param s nom de l'espèce recherchée
     * @return un ENUM correspondant
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
     * @return true si l'utilisateur est un dev mode false sinon
     */
    public boolean isDevMode() {
        return devMode;
    }

    /**
     * Fonction qui va créer un zoo et un maitre de zoo à partir des éléments passés en paramètres
     * @param nom du zoo
     * @param nomMaitreDeZoo du maitre de zoo
     * @return une instance de Zoo
     */
    public ArrayList<Object> CreerUnZoo(String nom, String nomMaitreDeZoo) {
        if (nom.equals("")) nom = "UnZooSuper";
        if (nomMaitreDeZoo.equals("")) nomMaitreDeZoo = "UnMaitreSuper";
        maitre = new MaitreZooFantastique(nomMaitreDeZoo, SexesEnum.MALE, 23);
        unZoo = new zooFantastique(nom, nomMaitreDeZoo/*maitre*/, 15, new ArrayList<>());
        Colonie colonie = new Colonie(new ArrayList<>());
        //Création d'un Enclos pour chaque type d'espèce
        unZoo.ajouterEnclos(new EnclosVoliere("Enclos dragons", 1000, 5, 100));
        unZoo.ajouterEnclos(new EnclosAquarium("Enclos krakens", 500, 4, 100));
        unZoo.ajouterEnclos(new EnclosStandard("Enclos licornes", 250, 15));
        unZoo.ajouterEnclos(new EnclosStandard("Enclos lycanthropes", 100, 30));
        unZoo.ajouterEnclos(new EnclosAquarium("Enclos megalodons", 430, 7, 35));
        unZoo.ajouterEnclos(new EnclosStandard("Enclos nymphes", 100, 9));
        unZoo.ajouterEnclos(new EnclosVoliere("Enclos phenix", 250, 15, 50));
        unZoo.ajouterEnclos(new EnclosAquarium("Enclos sirenes", 80, 13, 17));
        Meute m1 = new Meute("Meute de lycanthrope", new ArrayList<>());
        colonie.getMeutes().add(m1);
        unZoo.getEnclosExistant().get(0).ajouterCreature(new DragonMale(20000, 15000, 20, "James", unZoo.getEnclosByNom("Enclos dragons")));
        unZoo.getEnclosExistant().get(0).ajouterCreature(new DragonFemelle(20001, 15000, 20, "Princesse", unZoo.getEnclosByNom("Enclos dragons")));
        unZoo.getEnclosExistant().get(1).ajouterCreature(new KrakenMale(5000, 60000, 20, "Harry", unZoo.getEnclosByNom("Enclos krakens")));
        unZoo.getEnclosExistant().get(1).ajouterCreature(new KrakenFemelle(5000, 60000, 20, "Maria", unZoo.getEnclosByNom("Enclos krakens")));
        unZoo.getEnclosExistant().get(2).ajouterCreature(new LicorneMale(800, 230, 20, "Bernard", unZoo.getEnclosByNom("Enclos licornes")));
        unZoo.getEnclosExistant().get(2).ajouterCreature(new LicorneFemelle(800, 230, 20, "Micheline", unZoo.getEnclosByNom("Enclos licornes")));
        unZoo.getEnclosExistant().get(3).ajouterCreature(new LycanthropeMale(75, 180, 20, "Henry", unZoo.getEnclosByNom("Enclos lycanthropes"), 20, m1));
        unZoo.getEnclosExistant().get(3).ajouterCreature(new LycanthropeFemelle(75, 180, 20, "Lucy", unZoo.getEnclosByNom("Enclos lycanthropes"), 20, m1));
        unZoo.getEnclosExistant().get(4).ajouterCreature(new MegalodonMale(2000, 250, 20, "Mathis", unZoo.getEnclosByNom("Enclos megalodons")));
        unZoo.getEnclosExistant().get(4).ajouterCreature(new MegalodonFemelle(2000, 250, 20, "Hariette", unZoo.getEnclosByNom("Enclos megalodons")));
        unZoo.getEnclosExistant().get(5).ajouterCreature(new NympheMale(75, 170, 20, "Jules", unZoo.getEnclosByNom("Enclos nymphes")));
        unZoo.getEnclosExistant().get(5).ajouterCreature(new NympheFemelle(75, 170, 20, "Shana", unZoo.getEnclosByNom("Enclos nymphes")));
        unZoo.getEnclosExistant().get(6).ajouterCreature(new PhenixMale(35, 150, 20, "Plume-sec", unZoo.getEnclosByNom("Enclos phenix")));
        unZoo.getEnclosExistant().get(6).ajouterCreature(new PhenixFemelle(35, 150, 20, "Olivia", unZoo.getEnclosByNom("Enclos phenix")));
        unZoo.getEnclosExistant().get(7).ajouterCreature(new SireneMale(75, 175, 20, "Alix", unZoo.getEnclosByNom("Enclos sirenes")));
        unZoo.getEnclosExistant().get(7).ajouterCreature(new SireneFemelle(75, 175, 20, "Jeanine", unZoo.getEnclosByNom("Enclos sirenes")));
        ArrayList<Object> aReturn = new ArrayList<>();
        aReturn.add(unZoo);
        aReturn.add(colonie);
        return aReturn;
    }

    /**
     * Fonction qui permet de vérifier si un nom n'est pas déja utilisé et le change si c'est le cas pour simplifer les recherches de crétures
     * @param animal à vérifier et renommer si nécessaire
     * @param nom que l'on veut lui donner
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
     * @return instance de maitreDeZoo
     */
    public MaitreZooFantastique getMaitre() {
        return maitre;
    }

    /**
     * Getter de unZoo
     * @return instance de Zoo
     */
    public zooFantastique getZoo() {
        return unZoo;
    }

    /**
     * Fonction permettant de récupérer les 7 premier enclos du zoo
     * @return liste d'informations
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
     * @return liste d'informations
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
     * @return liste d'informations
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
     * @return liste d'informations
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
     * @return liste d'informations
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
     * @param s nom de la créature recherchée
     * @return true si elle l'est false sinon
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
     * @param str1 premier nom
     * @param str2 deuxième nom
     * @return 0 pour 1er < 2e, 1 pour 2e < 1er et 2 pour 1er == 2e
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
     * @param enclos a trier
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