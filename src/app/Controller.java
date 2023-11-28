package app;

import includes.creatures.SexesEnum;
import includes.enclos.EnclosAquarium;
import includes.enclos.EnclosStandard;
import includes.enclos.EnclosVoliere;

import java.util.ArrayList;

public class Controller {
    private static Controller instance;
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }
    public void CreerUnZoo(String nom, String nomMaitreDeZoo) {
        Model.getInstance().CreerUnZoo(nom, nomMaitreDeZoo);
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
                    return "Liste de toutes les commandes : soigner, nourrir, renommerCreature, nettoyer, renommerEnclos, deplacer, reproduire, retirerCadavre, creerEnclos, supprimerEnclos, infos, exit\nPour plus d'aide help nomCommande";
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
                            return "Commande pour supprimer un enclos VIDE\nTapez suppri leNomAnimal";
                        case "infos":
                            return "Permet de visualiser les informations en fonction de l'option \"zoo\", \"maitreZoo\" ou \"Enclos nomEnclos\"";
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
                        if (Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)) == null ) return "Pas d'enclos à ce nom";
                        return Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).toString();
                    case "creature":
                        if (tabOption.size() < 2) return "Donnez le nom de la créature";
                        if (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)) == null ) return "Pas de créature à ce nom";
                        return Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).toString();
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
            case "deplacerCreature":
                if (tabOption.isEmpty() || tabOption.size() < 2) return "Il manque des options (nomCreature, nomEnclosDestination)";
                if (Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).estVivant()) return "Créature morte!";
                if (false) return "Les créatures de l'enclos de destination ne sont pas de la même espèce"; // #290404
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
                Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).setNom(tabOption.get(1));
                return "Créature " + tabOption.get(0) + " renommé " + tabOption.get(1);
            case "soigner":
                if (tabOption.isEmpty()) return "Il manque le nom de l'animal";
                return Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).etreSoigne();
            case "nourir":
                if (tabOption.isEmpty()) return "Il manque le nom de l'enclos à nourir";
                Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)).nourrirCreatures();
                return "Les créatures de l'enclos " + tabOption.get(0) + " ont été nourri";
            case "nettoyer":
                if (tabOption.isEmpty()) return "Il manque le nom de l'enclos à nettoyer";
                if (Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)).entretientEnclos() == 1) return "L'enclos " + tabOption.get(0) + " n'est pas vide";
                return "L'enclos " + tabOption.get(0) + " est nettoyé";
            case "reproduire":
                if (tabOption.isEmpty() || tabOption.size() < 2) return "Il manque des options (nomParent, nomParent, nomBébé)";
                if (false) return "Les parents ne sont pas de la même espèce"; // Vérifie qu'il soient de la même espèce #290404
                if (false) return "Les parents ne sont aps du même enclos"; // Vérifie qu'il soient du même enclos #290404
                if (!(Model.getInstance().getZoo().getEnclosByNom(tabOption.get(0)).getListeCreatures().size()+1 < Model.getInstance().getZoo().getEnclosByNom(tabOption.get(1)).getCapaciteEnclos())) return "L'enclos de est complet, il ne peuvent pas se reproduire"; // Vérifie qu'il y ai de la place
                if (!(Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe() == SexesEnum.FEMELLE && Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getSexe() == SexesEnum.MALE) || ((Model.getInstance().getZoo().getCreatureByNom(tabOption.get(1)).getSexe() == SexesEnum.FEMELLE && Model.getInstance().getZoo().getCreatureByNom(tabOption.get(0)).getSexe() == SexesEnum.MALE))) return "Ce n'est pas un mâle et une femelle"; // Vérifie qu'il y ai un mâle et une femelle
                return tabOption.get(2) + "est né";
            case "b":
                return "Commande pour soiger un animal\nTapez soigner leNomAnimal";
            default:
                return "Commande non reconnue";
        }
    }
}
