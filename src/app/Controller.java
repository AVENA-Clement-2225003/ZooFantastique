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
                    return "Liste de toutes les commandes : soigner, nourrir, renommerCreature, nettoyer, renommerEnclos, deplacer, reproduire, retirerCadavre, creerEnclos, supprimerEnclos, infos, exit\nPour plus d'aide: help nomCommande";
                }else {
                    switch (tabOption.get(0)) {
                        case "soigner":
                            return "Commande pour soigner un animal\nTapez " + "\\u001B[32m" + "soigner leNomAnimal" + "\\u001B[0m";
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
                        return Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).toString();
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
                        if (tabOption.isEmpty() || tabOption.size() < 5) return "Il manque la hauteur";
                        Model.getInstance().getZoo().ajouterEnclos(new EnclosVoliere(tabOption.get(1), Integer.parseInt(tabOption.get(2)), Integer.parseInt(tabOption.get(3)), Integer.parseInt(tabOption.get(4))));
                        break;
                    case "aquarium":
                        if (tabOption.isEmpty() || tabOption.size() < 5) return "Il manque la profondeur";
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
                if ((especeCreature.equals(LICORNE) || especeCreature.equals(LYCANTHROPE) || especeCreature.equals(NYMPHE)) && !(Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)) instanceof EnclosVoliere)) return "Cet enclos n'est pas adapté pour cette créature, essayez un enclos standard";
                if (Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).getListeCreatures().get(0).getNomEspece() != Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getNomEspece()) return "Les créatures de l'enclos de destination ne sont pas de la même espèce";
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
                return Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).etreSoigne();
            case "nourrir":
                if (tabOption.isEmpty()) return "Il manque le nom de l'enclos à nourrir";
                Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)).nourrirCreatures();
                return "Les créatures de l'enclos " + tabOption.get(0) + " ont été nourri";
            case "nettoyer":
                if (tabOption.isEmpty()) return "Il manque le nom de l'enclos à nettoyer";
                if (Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)).entretientEnclos() == 1) return "L'enclos " + tabOption.get(0) + " n'est pas vide";
                return "L'enclos " + tabOption.get(0) + " est nettoyé";
            case "reproduire": // #290404 ne pas se reproduire quand une des créatures est malade #290404 Faire ne sorte que à la création des créature les nom soient actualisé (ex James1)
                if (tabOption.isEmpty() || tabOption.size() < 2) return "Il manque des options (nomParent, nomParent)";
                if (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getAge() >= Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getAgeMort() || Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getAge() >= Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getAgeMort()) return "Une des créatures est morte et ne peut pas se reproduire";
                if (!Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getNomEspece().equals(Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getNomEspece())) return "Les parents ne sont pas de la même espèce"; // Vérifie qu'il soient de la même espèce
                if (!Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().equals(Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getEnclos())) return "Les parents ne sont pas du même enclos"; // Vérifie qu'il soient du même enclos
                if (!Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).isSante() || !Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).isSante()) return "Une des créatures est malade et ne veut pas se reproduire";
                if (!(Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().getListeCreatures().size()+1 < Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getEnclos().getCapaciteEnclos())) return "L'enclos de est complet, il ne peuvent pas se reproduire"; // Vérifie qu'il y ai de la place
                if (!((Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE) && Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getSexe().equals(SexesEnum.MALE)) || ((Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.MALE) && Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getSexe().equals(SexesEnum.FEMELLE))))) return "Ce n'est pas un mâle et une femelle"; // Vérifie qu'il y ai un mâle et une femelle
                EspecesEnum especeCreatures = Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getNomEspece();
                if ((especeCreatures.equals(LICORNE) || especeCreatures.equals(LYCANTHROPE) || especeCreatures.equals(NYMPHE) || especeCreatures.equals(SIRENE)) && (Model.getInstance().estEnceinte(tabOption.get(0)) || Model.getInstance().estEnceinte(tabOption.get(1)))) return "Cette femelle est déja enceinte"; //#290404 Ca ne fonctionne pas
                int sexe = new Random().nextInt(2);
                if (sexe == 0) System.out.print("C'est un garçon ! Quel nom voulez vous lui donner : ");
                else System.out.print("C'est une fille ! Quel nom voulez vous lui donner : ");
                String nom = new Scanner(System.in).nextLine();
                if (nom.equals("")) {
                    nom = choisirUnPrenom(sexe);
                }
                switch (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getNomEspece()) {
                    case DRAGON:
                        Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Oeuf(DRAGON, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "La dragonne a pondu un oeuf !";
                    case KRAKEN:
                        Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Oeuf(KRAKEN, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos(), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "La femellekraken a pondu un oeuf !";
                    case LICORNE:
                        Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Bebe(LICORNE, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos(), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "La licorne femelle a un bébé!";
                    case LYCANTHROPE:
                        Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Bebe(LYCANTHROPE, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos(), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "Le lycanthrope femelle a un bébé!";
                    case MEGALODON:
                        Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Oeuf(MEGALODON, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "Le mégalodon femelle a pondu un oeuf!";
                    case NYMPHE:
                        Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Bebe(NYMPHE, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos(), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "La nymphe femelle a un bébé !";
                    case PHENIX:
                        Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Oeuf(PHENIX, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "La phénix femelle a pondu un oeuf !";
                    case SIRENE:
                        Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getEnclos().ajouterCreature(new Oeuf(SIRENE, (sexe==0?SexesEnum.MALE:SexesEnum.FEMELLE), nom, Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)), (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe().equals(SexesEnum.FEMELLE)?Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)):Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)))));
                        return "Le sirène femelle a un bébé !";
                }
            case "dev": // #290404 Ne reconnais pas les type de créatures
                if (tabOption.size() < 1) return "il manque une option le nom d'une commande";
                switch (tabOption.get(0)) {
                    case "creerCreature":
                        if (tabOption.size() < 7) return "il manque une option (enclos, type, sexe, nom, age, taille, poid)";
                        if (!(tabOption.get(3).equals("male") || tabOption.get(3).equals("femelle"))) {
                            return "Il ne peut y avoir que male ou femelle et non un " + tabOption.get(3);
                        }
                        switch (tabOption.get(2)) {
                            case "dragon":
                                if (tabOption.get(3).equals("male")) {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new DragonMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                } else {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new DragonFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                }
                            case "kraken":
                                if (tabOption.get(3).equals("male")) {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new KrakenMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                } else {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new KrakenFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                }
                            case "licorne":
                                if (tabOption.get(3).equals("male")) {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new LicorneMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                } else {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new LicorneFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                }
                            case "lycanthrope":
                                if (tabOption.get(3).equals("male")) {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new LycanthropeMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                } else {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new LycanthropeFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                }
                            case "megalodon":
                                if (tabOption.get(3).equals("male")) {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new MegalodonMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                } else {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new MegalodonFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                }
                            case "nymphe":
                                if (tabOption.get(3).equals("male")) {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new NympheMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                } else {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new NympheFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                }
                            case "phenix":
                                if (tabOption.get(3).equals("male")) {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new PhenixMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                } else {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new PhenixFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                }
                            case "sirene":
                                if (tabOption.get(3).equals("male")) {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new SireneMale(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                } else {
                                    Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).ajouterCreature(new SireneFemelle(Integer.parseInt(tabOption.get(7)), Integer.parseInt(tabOption.get(6)), Integer.parseInt(tabOption.get(5)), tabOption.get(4), Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1))));
                                }
                            default:
                                return "type " + tabOption.get(2) + " non connu";
                        }
                        //return "Créature créée";
                    case "help":
                        return "Commandes : creerCreature";
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
        ArrayList<ArrayList<String>> listeDeListes = new ArrayList<>();
        listeDeListes.add(EnclosZoo);
        listeDeListes.add(Malades);
        listeDeListes.add(Morts);
        listeDeListes.add(Faim);
        return listeDeListes;
    }
}
