package app;

import includes.creatures.*;
import includes.enclos.EnclosAquarium;
import includes.enclos.EnclosStandard;
import includes.enclos.EnclosVoliere;
import includes.zoo.zooFantastique;

import java.util.*;

import static includes.creatures.EspecesEnum.*;

public class Controller {
    private static Controller instance;
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    public zooFantastique CreerUnZoo(String nom, String nomMaitreDeZoo) {
        zooFantastique zoo = Model.getInstance().CreerUnZoo(nom, nomMaitreDeZoo);
        return zoo;
    }
    private String choisirUnPrenom(int sexe) { // Il faut impérativement le même nombre de prénoms masculins et féminins
        ArrayList<ArrayList<String>> ListePrenoms = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList("Jean", "Pierre", "Paul", "Thomas", "Antoine", "Nicolas", "Alexandre", "David", "François", "Guillaume")),
                        new ArrayList<>(Arrays.asList("Marie", "Sophie", "Emma", "Alice", "Charlotte", "Léa", "Camille", "Eva", "Juliette", "Louise"))
                ));
        return ListePrenoms.get(sexe).get(new Random().nextInt(ListePrenoms.size()));
    }
    public String entreeCommande(String commande) {
        if (!Character.isLetter(commande.charAt(0))) {
            return "N'est pas une commande, retirez l'espace devant";
        }
        int i = 0;
        String nomCommande = "";
        while (i < commande.length() && commande.charAt(i) != ' ') { //Récupération du nom de la commande
            nomCommande += commande.charAt(i);
            i++;
        }
        if (i < commande.length()) {
            i++; //Pour sauter l'espace
            ArrayList<String> tabOption = new ArrayList<>();
            String option;
            while (i < commande.length()) { // Récupération des options associées
                option = "";
                while (i < commande.length() && commande.charAt(i) != ' ') {
                    option += commande.charAt(i);
                    i++;
                }
                tabOption.add(option);
                i++; //Sauter l'espace pour commencer la récupération de la prochaine option
            }
            return executerCommande(nomCommande, tabOption);
        }else {
            return executerCommande(nomCommande, new ArrayList<>());
        }
        //potentiel appel de fonction return executerCommande(nomCommande, tabOption);
    }
    public String executerCommande(String nomCommande, ArrayList<String> tabOption) {
        switch (nomCommande) {
            case "help":
                if(tabOption.isEmpty()) {
                    return "Liste de toutes les commandes : soigner, nourrir, renommerCreature, nettoyer, renommerEnclos, deplacer, reproduire, retirerCadavre, creerEnclos, supprimerEnclos, infos, reveiller, endormir, exit\nPour plus d'aide: help nomCommande";
                }else {
                    switch (tabOption.get(0)) {
                        case "soigner":
                            return "Commande pour soigner un animal\nTapez soigner leNomAnimal";
                        case "nourrir":
                            return "Commande pour nourrir les animaux d'un enclos\nTapez nourrir nomEnclos";
                        case "renommerCreature":
                            return "Commande pour renommer un animal\nTapez renommerCreature leNomAnimal LeNouveauNom";
                        case "creerEnclos":
                            return "Commande pour créer un enclos\nTapez creerEnclos type nomEnclos superficie capacite.\nPour les volière et aquarium ajouter à la suite la profondeur/hauteur";
                        case "nettoyer":
                            return "Commande pour nettoyer un enclos\nTapez nettoyer leNomEnclos";
                        case "renommerEnclos":
                            return "Commande pour renommer un enclos\nTapez renomerEnclos leNomEnclos leNouveauNom";
                        case "retirerCadavre":
                            return "Commande pour retirer un animal mort\nTapez retirerCadrave leNomAnimal";
                        case "supprimerEnclos":
                            return "Commande pour supprimer un enclos VIDE\nTapez supprimer leNomAnimal";
                        case "reproduire":
                            return "Commande pour faire reproduire deux créature de même espèce\nTapez reproduire nom1erParent nom2eParent";
                        case "infos":
                            return "Permet de visualiser les informations en fonction de l'option \"zoo\", \"maitreZoo\" ou \"Enclos nomEnclos\"";
                        case "reveiller":
                            return "Permet de reveiller une créature\n Tapez reveiller leNomAnimal";
                        case "endormir":
                            return "Permet d'endormir une créature\n Tapez endormir leNomAnimal";
                        case "deplacer":
                            return "Pas encore de description\nA faire";
                        case "exit":
                            return "Commande pour quitter le jeu";
                        default:
                            return "Erreur help: commande non reconnue";
                    }
                }
            case "infos":
                if (tabOption.isEmpty() || tabOption.get(0).equals("")) return "Il manque des options (zoo, enclos, maitreZoo)";
                switch (tabOption.get(0)) {
                    case "zoo":
                        return Model.getInstance().getZoo().toString();
                    case "maitreZoo":
                        return Model.getInstance().getMaitre().toString();
                    case "enclos":
                        if (tabOption.size() < 2) return Model.getInstance().getZoo().getEnclosExistant().toString();
                        if (tabOption.size() == 3 && tabOption.get(2).equals("creatures")) return Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).afficherCreatures(); // si l'on ecris creatures apres le nom d'enlcos alors ca nous retourne la liste des créatures
                        if (Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)) == null ) return "Pas d'enclos à ce nom";
                        return Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).toString();
                    case "creature":
                        if (tabOption.size() < 2) return "Donnez le nom de la créature";
                        if (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)) == null ) return "Pas de créature à ce nom";
                        return Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).toString(); //#290404 faire l'afficahge détaillé avec  poid et taille
                    case "creatures":
                        return Model.getInstance().getZoo().afficherCreature();
                    default:
                        return "Pas d'infos pour : " + tabOption.get(0);
                }
            case "creerEnclos":
                if (tabOption.isEmpty() || tabOption.size() < 4) return "Il manque des options (type, nom, superficie, capacité)";
                switch (tabOption.get(0)) {
                    case "standard":
                        Model.getInstance().getZoo().ajouterEnclos(new EnclosStandard(tabOption.get(1), Integer.parseInt(tabOption.get(2)), Integer.parseInt(tabOption.get(3))));
                        break;
                    case "voliaire":
                        if (tabOption.size() < 5) return "Il manque la hauteur";
                        Model.getInstance().getZoo().ajouterEnclos(new EnclosVoliere(tabOption.get(1), Integer.parseInt(tabOption.get(2)), Integer.parseInt(tabOption.get(3)), Integer.parseInt(tabOption.get(4))));
                        break;
                    case "aquarium":
                        if (tabOption.size() < 5) return "Il manque la profondeur";
                        Model.getInstance().getZoo().ajouterEnclos(new EnclosAquarium(tabOption.get(1), Integer.parseInt(tabOption.get(2)), Integer.parseInt(tabOption.get(3)), Integer.parseInt(tabOption.get(4))));
                        break;
                    default:
                        return "Type inconnu";
                }
                return "Enclos " + tabOption.get(1) + " créé, il y a maintenant " + Model.getInstance().getZoo().getEnclosExistant().size() + " enclos!";
            case "supprimerEnclos":
                if (tabOption.isEmpty()) return "Il manque le nom";
                if (Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)).getListeCreatures().size() != 0) return "Enclos non vide, la supression n'est pas possible!";
                Model.getInstance().getZoo().getEnclosExistant().remove(Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0))); //Supprime l'enclos dans la liste des enclos
                return "Enclos " + tabOption.get(0) + " supprimé, il y a maintenant " + Model.getInstance().getZoo().getEnclosExistant().size() + " enclos!";
            case "retirerCadavre":
                if (tabOption.isEmpty()) return "Il manque le nom";
                if (!Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).estVivant()) return "Créature vivante!";
                Model.getInstance().getZoo().getEnclosExistant().remove(Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0))); //Supprime l'enclos dans la liste des enclos
                return "Créature " + tabOption.get(0) + " morte retirée";
            case "deplacer":
                if (tabOption.isEmpty() || tabOption.size() < 2) return "Il manque des options (nomCreature, nomEnclosDestination)";
                if (!Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).estVivant()) return "Créature morte! Il faut retirer son cadavre";
                EspecesEnum especeCreature = Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getNomEspece();
                if ((especeCreature.equals(DRAGON) || especeCreature.equals(PHENIX)) && !(Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)) instanceof EnclosVoliere)) return "Cet enclos n'est pas adapté pour cette créature, essayez une volière";
                if ((especeCreature.equals(KRAKEN) || especeCreature.equals(MEGALODON) || especeCreature.equals(SIRENE)) && !(Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)) instanceof EnclosAquarium)) return "Cet enclos n'est pas adapté pour cette créature, essayez un aquarium";
                if ((especeCreature.equals(LICORNE) || especeCreature.equals(LYCANTHROPE) || especeCreature.equals(NYMPHE)) && !(Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)) instanceof EnclosStandard)) return "Cet enclos n'est pas adapté pour cette créature, essayez un enclos standard";
                if (!Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).getListeCreatures().isEmpty()) {
                    if (!Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).getListeCreatures().get(0).getNomEspece().equals(Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getNomEspece())) return "Les créatures de l'enclos de destination ne sont pas de la même espèce";
                }
                int code = Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)));
                if (code == 2) return "Enclos de destination complet";
                if (code == 1) return "La créature est déjà présente dans l'enclos de destination";
                if (code == 0) {
                    Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().retirerCreature(Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)));
                    return "Créature déplacée vers " + tabOption.get(1);
                }
                return "Créature " + tabOption.get(0) + " déplacée";
            case "renommerEnclos":
                if (tabOption.isEmpty() || tabOption.size() < 2) return "Il manque des options (nom, nouveau nom)";
                Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)).setNom(tabOption.get(1));
                return "Enclos " + tabOption.get(0) + " renommé " + tabOption.get(1);
            case "renommerCreature":
                if (tabOption.isEmpty() || tabOption.size() < 2) return "Il manque des options (nom, nouveau nom)";
                Model.getInstance().verifierNomEtRenommerCreature(Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)), tabOption.get(1));
                return "Créature " + tabOption.get(0) + " renommé " + tabOption.get(1);
            case "soigner":
                if (tabOption.isEmpty()) return "Il manque le nom de l'animal";
                if (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)) == null){
                    return "Cette creature n existe pas";
                }
                return Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).etreSoigne();
            case "nourrir":
                if (tabOption.isEmpty()) return "Il manque le nom de l'enclos à nourrir";
                if (Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)) == null) return "Cet enclos n'existe pas";
                Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)).nourrirCreatures();
                return "Les créatures de l'enclos " + tabOption.get(0) + " ont été nourri";
            case "reveiller":
                if (tabOption.isEmpty()) return "Il manque le nom de la créature à réveiller";
                Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).setEstEnTrainDeDormir(false);
                return tabOption.get(0) + " a été réveillée";
            case "nettoyer":
                if (tabOption.isEmpty()) return "Il manque le nom de l'enclos à nettoyer";
                if (Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)).entretientEnclos() == 1) return "L'enclos " + tabOption.get(0) + " n'est pas vide";
                return "L'enclos " + tabOption.get(0) + " est nettoyé";
            case "reproduire":
                if (tabOption.isEmpty() || tabOption.size() < 2) return "Il manque des options (nomParent, nomParent)";
                if (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getAge() >= Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getAgeMort() || Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getAge() >= Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getAgeMort()) return "Une des créatures est morte et ne peut pas se reproduire";
                if (!Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getNomEspece().equals(Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getNomEspece())) return "Les parents ne sont pas de la même espèce"; // Vérifie qu'il soient de la même espèce
                if (!Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().equals(Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getEnclos())) return "Les parents ne sont pas du même enclos"; // Vérifie qu'il soient du même enclos
                if (!Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).isSante() || !Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).isSante()) return "Une des créatures est malade et ne veut pas se reproduire";
                if (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).isEstEnTrainDeDormir() || Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).isEstEnTrainDeDormir()) return "Une des créatures est en train de dormir et ne peut pas se reproduire, il faut d'abord la réveiller !";
                if (!(Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().getListeCreatures().size()+1 < Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getEnclos().getCapaciteEnclos())) return "L'enclos de est complet, il ne peuvent pas se reproduire"; // Vérifie qu'il y ai de la place
                if (!((Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE) && Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getSexe().equals(SexesEnum.MALE)) || ((Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.MALE) && Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getSexe().equals(SexesEnum.FEMELLE))))) return "Ce n'est pas un mâle et une femelle"; // Vérifie qu'il y ai un mâle et une femelle
                EspecesEnum especeCreatures = Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getNomEspece();
                if ((especeCreatures.equals(LICORNE) || especeCreatures.equals(LYCANTHROPE) || especeCreatures.equals(NYMPHE) || especeCreatures.equals(SIRENE)) && (Model.getInstance().estEnceinte(tabOption.get(0)) || Model.getInstance().estEnceinte(tabOption.get(1)))) return "Cette femelle est déja enceinte"; //#290404 Ca ne fonctionne pas
                Creature mere;
                if (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)){
                    mere = (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)));
                }
                else {
                    mere = (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)));
                }
                int sexe = new Random().nextInt(2);
                if (sexe == 0) System.out.print("C'est un garçon ! Quel nom voulez vous lui donner : ");
                else System.out.print("C'est une fille ! Quel nom voulez vous lui donner : ");
                String nom = new Scanner(System.in).nextLine();
                if (nom.equals("")) {
                    nom = choisirUnPrenom(sexe);
                }
                switch (mere.getNomEspece()) {
                    case DRAGON:
                        ((DragonFemelle) mere).pondreOeuf(nom, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), mere.getEnclos());
                        //Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Oeuf(DRAGON, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "La dragonne a pondu un oeuf !";
                    case KRAKEN:
                        ((KrakenFemelle) mere).pondreOeuf(nom, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), mere.getEnclos());
                        //Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Oeuf(KRAKEN, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos(), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "La femelle kraken a pondu un oeuf !";
                    case LICORNE:
                        ((LicorneFemelle) mere).mettreBas(nom, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), mere.getEnclos());
                        //Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Bebe(LICORNE, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos(), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "La licorne femelle a un bébé!";
                    case LYCANTHROPE:
                        ((LycanthropeFemelle) mere).mettreBas(nom, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), mere.getEnclos());
                        //Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Bebe(LYCANTHROPE, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos(), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "Le lycanthrope femelle a un bébé!";
                    case MEGALODON:
                        ((MegalodonFemelle) mere).pondreOeuf(nom, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), mere.getEnclos());
                        //Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Oeuf(MEGALODON, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "Le mégalodon femelle a pondu un oeuf!";
                    case NYMPHE:
                        ((NympheFemelle) mere).mettreBas(nom, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), mere.getEnclos());
                        //Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Bebe(NYMPHE, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos(), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "La nymphe femelle a un bébé !";
                    case PHENIX:
                        ((PhenixFemelle) mere).pondreOeuf(nom, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), mere.getEnclos());
                        //Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Oeuf(PHENIX, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "La phénix femelle a pondu un oeuf !";
                    case SIRENE:
                        ((SireneFemelle) mere).mettreBas(nom, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), mere.getEnclos());
                        //Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Oeuf(SIRENE, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "Le sirène femelle a un bébé !";
                }
            case "dev":
                if (!Model.getInstance().isDevMode()) return "Vous n'êtes pas en mode développement";
                if (tabOption.size() < 1) return "il manque une option le nom d'une commande";
                switch (tabOption.get(0)) {
                    case "creerCreature":
                        if (tabOption.size() < 7) return "il manque une option (enclos, type, sexe, nom, age, taille, poid)";
                        if (!(tabOption.get(3).equals("male") || tabOption.get(3).equals("femelle"))) {
                            return "Il ne peut y avoir que male ou femelle et non un " + tabOption.get(3);
                        }
                        if ((tabOption.get(2).equals("dragon") || tabOption.get(2).equals("phenix")) && !(Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)) instanceof EnclosVoliere)) return "Cet enclos n'est pas adapté pour cette créature, essayez une volière";
                        if ((tabOption.get(2).equals("kraken") || tabOption.get(2).equals("megalodon") || tabOption.get(2).equals("sirene")) && !(Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)) instanceof EnclosAquarium)) return "Cet enclos n'est pas adapté pour cette créature, essayez un aquarium";
                        if ((tabOption.get(2).equals("licorne") || tabOption.get(2).equals("lycanthrope") || tabOption.get(2).equals("nymphe")) && !(Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)) instanceof EnclosStandard)) return "Cet enclos n'est pas adapté pour cette créature, essayez un enclos standard";
                        if (!Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).getListeCreatures().get(0).getNomEspece().equals(Model.getInstance().getEspeceByStr(tabOption.get(2)))) return "Les crétures de cet enclos ne sont pas de la même espèce !";
                        Creature c;
                        switch (tabOption.get(2)) {
                            case "dragon":
                                if (tabOption.get(3).equals("male")) {
                                    c = new DragonMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));
                                } else {
                                    c = new DragonFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));

                                }
                                Model.getInstance().verifierNomEtRenommerCreature(c, tabOption.get(4));
                                Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(c);
                                return "Créature créée";
                            case "kraken":
                                if (tabOption.get(3).equals("male")) {
                                    c = new KrakenMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));
                                } else {
                                    c = new KrakenFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));
                                }
                                Model.getInstance().verifierNomEtRenommerCreature(c, tabOption.get(4));
                                Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(c);
                                return "Créature créée";
                            case "licorne":
                                if (tabOption.get(3).equals("male")) {
                                    c = new LicorneMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));
                                } else {
                                    c = new LicorneFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));
                                }
                                Model.getInstance().verifierNomEtRenommerCreature(c, tabOption.get(4));
                                Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(c);
                            case "lycanthrope":
                                if (tabOption.get(3).equals("male")) {
                                    c = new LycanthropeMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));
                                } else {
                                    c = new LycanthropeFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));
                                }
                                Model.getInstance().verifierNomEtRenommerCreature(c, tabOption.get(4));
                                Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(c);
                                return "Créature créée";
                            case "megalodon":
                                if (tabOption.get(3).equals("male")) {
                                    c = new MegalodonMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));
                                } else {
                                    c = new MegalodonFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));
                                }
                                Model.getInstance().verifierNomEtRenommerCreature(c, tabOption.get(4));
                                Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(c);
                                return "Créature créée";
                            case "nymphe":
                                if (tabOption.get(3).equals("male")) {
                                    c = new NympheMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));
                                } else {
                                    c = new NympheFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));
                                }
                                Model.getInstance().verifierNomEtRenommerCreature(c, tabOption.get(4));
                                Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(c);
                                return "Créature créée";
                            case "phenix":
                                if (tabOption.get(3).equals("male")) {
                                    c = new PhenixMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));
                                } else {
                                    c = new PhenixFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));
                                }
                                Model.getInstance().verifierNomEtRenommerCreature(c, tabOption.get(4));
                                Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(c);
                                return "Créature créée";
                            case "sirene":
                                if (tabOption.get(3).equals("male")) {
                                    c = new SireneMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));
                                } else {
                                    c = new SireneFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)));
                                }
                                Model.getInstance().verifierNomEtRenommerCreature(c, tabOption.get(4));
                                Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(c);
                            default:
                                return "type " + tabOption.get(2) + " non connu";
                        }
                    case "help":
                        if(tabOption.size() < 2) {
                            return "Commandes : creerCreature, endormir, ChangerAge";
                        }else {
                            switch (tabOption.get(0)) {
                            case "creerCreature":
                                return "Commande pour creer une créture\nTapez creerCreature enclos type sexe nom age taille poid";
                            case "endormir":
                                return "Commande pour endormir une créature\nTapez endormir nomCreature";
                            case "changerAge":
                                return "Commande pour changer l'age d'une créature\nTapez changerAge nomCreature nvAge";
                            default:
                                return "Erreur help: commande non reconnue";
                            }
                        }
                    case "changerAge":
                        if (tabOption.size() < 3) return "Il manque des options (nomCreature, nvAge)";
                        Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).setAge(Integer.parseInt(tabOption.get(2)));
                        return "L'age a été changé";
                    case "endormir":
                        if (tabOption.size() < 2) return "Il manque le nom de la créature a endormir!";
                        Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).setEstEnTrainDeDormir(true);
                        return "dev: " + tabOption.get(1) + " s'est endormi";
                }
            default:
                return "Commande non reconnue";
        }
    }


    public ArrayList<ArrayList<String>> DonnesAffichageZoo() {
        ArrayList<String> EnclosZoo = Model.getInstance().get7erEnclos();
        ArrayList<String> Malades = Model.getInstance().get7erMalades();
        ArrayList<String> Morts = Model.getInstance().get7erMorts();
        ArrayList<String> Faim = Model.getInstance().get7erFaims();
        ArrayList<String> Dormir = Model.getInstance().get7erDormir();
        ArrayList<ArrayList<String>> listeDeListes = new ArrayList<>();
        listeDeListes.add(EnclosZoo);
        listeDeListes.add(Malades);
        listeDeListes.add(Morts);
        listeDeListes.add(Faim);
        listeDeListes.add(Dormir);
        return listeDeListes;
    }
}
