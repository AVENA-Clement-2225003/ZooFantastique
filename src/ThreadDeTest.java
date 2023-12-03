import includes.creatures.*;
import includes.enclos.Enclos;
import includes.enclos.PropreteEnum;
import includes.zoo.zooFantastique;

import java.util.Random;

public class ThreadDeTest extends Thread{

    private zooFantastique zoo;

    public ThreadDeTest(zooFantastique zoo){
        this.zoo = zoo;
    }

    public void run(){
        System.out.println("Le thread se lance");
        int rEtatEnclos;
        //Oeuf o1 = new Oeuf(EspecesEnum.DRAGON, SexesEnum.FEMELLE, "test", );
        while(true){
            try {
                System.out.println("1 unite de temps");
                // Gerer l'etat des enclos
                for (Enclos enclos : zoo.getEnclosExistant()){
                    rEtatEnclos = new Random().nextInt(3);      // A ajouter : verification de l'etat de l'enclos actuel pour eviter de le nettoyer
                    if (rEtatEnclos == 0){
                        enclos.setProprete(PropreteEnum.BON);
                    }
                    else if (rEtatEnclos == 1){
                        enclos.setProprete(PropreteEnum.CORRECT);
                    }
                    else {
                        enclos.setProprete(PropreteEnum.MAUVAIS);
                    }
                    for (Creature creature : enclos.getListeCreatures()){ // Faire naitre les oeufs quand ils sont à maturité les faire maturer sinon #290404 Il faut faire aussi pour ceux dont c'est des bébés
                        if (creature instanceof Oeuf) { //Vérifie si la créature actuelle est un oeuf ou non
                            if (((Oeuf) creature).getTempsEclosion() == ((Oeuf) creature).getTempsMaturation()) { //Est-ce qu'il est prêt à éclore
                                switch (creature.getNomEspece()) {
                                    case DRAGON:
                                        if (creature.getSexe().equals(SexesEnum.FEMELLE)) enclos.ajouterCreature(new DragonFemelle(new Random().nextInt(600 - 300 + 1) + 300, new Random().nextInt(2000 - 1000 + 1) + 1000, 1, creature.getNom(), creature.getEnclos()));
                                        else enclos.ajouterCreature(new DragonMale(new Random().nextInt(600 - 300 + 1) + 300, new Random().nextInt(2000 - 1000 + 1) + 1000, 1, creature.getNom(), creature.getEnclos()));
                                    case KRAKEN:
                                        if (creature.getSexe().equals(SexesEnum.FEMELLE)) enclos.ajouterCreature(new KrakenFemelle(new Random().nextInt(1000 - 500 + 1) + 500, new Random().nextInt(10000 - 5000 + 1) + 5000, 1, creature.getNom(), creature.getEnclos()));
                                        else enclos.ajouterCreature(new KrakenMale(new Random().nextInt(1000 - 500 + 1) + 500, new Random().nextInt(10000 - 5000 + 1) + 5000, 1, creature.getNom(), creature.getEnclos()));
                                    case PHENIX:
                                        if (creature.getSexe().equals(SexesEnum.FEMELLE)) enclos.ajouterCreature(new PhenixFemelle(new Random().nextInt(15 - 5 + 1) + 5, new Random().nextInt(3000 - 2000 + 1) + 2000, 1, creature.getNom(), creature.getEnclos()));
                                        else enclos.ajouterCreature(new PhenixMale(new Random().nextInt(15 - 5 + 1) + 5, new Random().nextInt(3000 - 2000 + 1) + 2000, 1, creature.getNom(), creature.getEnclos()));
                                }
                                enclos.getListeCreatures().remove(creature); // L'oeuf à éclo donc on le supprime
                                System.out.println("Un oeuf a éclo !");
                            } else {
                                ((Oeuf) creature).setTempsMaturation(((Oeuf) creature).getTempsMaturation() + 1); //Il n'est pas encore prêt
                            }
                        } /*else if (creature instanceof Bebe) { //Vérifie si la créature actuelle est un bébé ou non #290404 Faire Bebe
                            if (((Bebe) creature).getTempsEclosion() == ((Bebe) creature).getTempsMaturation()) { //Est-ce qu'il est prêt à naitre
                                switch (creature.getNomEspece()) {
                                    case LICORNE:
                                        if (creature.getSexe().equals(SexesEnum.FEMELLE)) enclos.ajouterCreature(new LicorneFemelle(new Random().nextInt(1100 - 450 + 1) + 450, new Random().nextInt(200 - 140 + 1) + 140, 1, creature.getNom(), creature.getEnclos()));
                                        else enclos.ajouterCreature(new LicorneMale(new Random().nextInt(1100 - 450 + 1) + 450, new Random().nextInt(200 - 140 + 1) + 140, 1, creature.getNom(), creature.getEnclos()));
                                    case LYCANTHROPE:
                                        if (creature.getSexe().equals(SexesEnum.FEMELLE)) enclos.ajouterCreature(new LycanthropeFemelle(new Random().nextInt(100 - 50 + 1) + 50, new Random().nextInt(200 - 150 + 1) + 150, 1, creature.getNom(), creature.getEnclos()));
                                        else enclos.ajouterCreature(new LycanthropeMale(new Random().nextInt(100 - 50 + 1) + 50, new Random().nextInt(200 - 150 + 1) + 150, 1, creature.getNom(), creature.getEnclos()));
                                    case MEGALODON:
                                        if (creature.getSexe().equals(SexesEnum.FEMELLE)) enclos.ajouterCreature(new MegalodonFemelle(new Random().nextInt(100000 - 50000 + 1) + 50000, new Random().nextInt(2500 - 1500 + 1) + 1500, 1, creature.getNom(), creature.getEnclos()));
                                        else enclos.ajouterCreature(new MegalodonMale(new Random().nextInt(100000 - 50000 + 1) + 50000, new Random().nextInt(2500 - 1500 + 1) + 1500, 1, creature.getNom(), creature.getEnclos()));
                                    case NYMPHE:
                                        if (creature.getSexe().equals(SexesEnum.FEMELLE)) enclos.ajouterCreature(new NympheFemelle(new Random().nextInt(90 - 50 + 1) + 50, new Random().nextInt(200 - 150 + 1) + 150, 1, creature.getNom(), creature.getEnclos()));
                                        else enclos.ajouterCreature(new NympheMale(new Random().nextInt(90 - 50 + 1) + 50, new Random().nextInt(200 - 150 + 1) + 150, 1, creature.getNom(), creature.getEnclos()));
                                    case SIRENE:
                                        if (creature.getSexe().equals(SexesEnum.FEMELLE)) enclos.ajouterCreature(new SireneFemelle(new Random().nextInt(90 - 50 + 1) + 50, new Random().nextInt(200 - 150 + 1) + 150, 1, creature.getNom(), creature.getEnclos()));
                                        else enclos.ajouterCreature(new SireneMale(new Random().nextInt(90 - 50 + 1) + 50, new Random().nextInt(200 - 150 + 1) + 150, 1, creature.getNom(), creature.getEnclos()));
                                }
                                enclos.getListeCreatures().remove(creature); // Le bébé est né donc on le supprime, il deviens un animal
                                System.out.println("Un bébé est né !");
                            } else {
                                ((Bebe) creature).setTempsMaturation(((Bebe) creature).getTempsMaturation() + 1); // Il n'est pas prêt
                            }
                        }*/
                        //else {
                            // Gerer l'age des creatures (et donc leur mort)
                            creature.vieillir();
                        //}
                    }

                }
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
