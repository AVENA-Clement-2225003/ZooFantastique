import includes.creatures.*;
import includes.enclos.Enclos;
import includes.enclos.PropreteEnum;
import includes.zoo.zooFantastique;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Thread extends java.lang.Thread {

    private zooFantastique zoo;

    public Thread(zooFantastique zoo){
        this.zoo = zoo;
    }

    public void run(){
        System.out.println("Le thread se lance");
        int temps = 0;
        int action;
        int limiteSommeil = 5;
        int limiteFaim = 20;
        int limiteMalade = 23;
        Creature creat;
        ArrayList<Creature> lTempCreatureAAjouter = new ArrayList<>();
        ArrayList<Creature> lTempCreatureASupprimer = new ArrayList<>();
        Random r = new Random();
        while(true){
            try {
                if (temps % 5 == 0){
                    // Gerer la faim, le sommeil et la maladie des creatures et l'etat des enclos
                    action = r.nextInt(26); // Genere un entier entre 0 et 25
                    limiteMalade = 23;
                    Enclos enclos = zoo.getEnclosExistant().get(r.nextInt(zoo.getEnclosExistant().size())); // Choisi un enclos aleatoire
                    if (enclos.getProprete() == PropreteEnum.MAUVAIS){ // Ne pas re-salit un enclos deja sale, mais augmente la probabilite qu'une creature soit malade
                        limiteMalade = 26;
                    }
                    if (action < limiteSommeil){
                        creat = enclos.getListeCreatures().get(r.nextInt(enclos.getListeCreatures().size())); // Choisi une creature aleatoire dans l'enclos
                        creat.setEstEnTrainDeDormir(true);
                    }
                    else if (action <limiteFaim){ // Une creature a faim
                        creat = enclos.getListeCreatures().get(r.nextInt(enclos.getListeCreatures().size())); // Choisi une creature aleatoire dans l'enclos
                        if (!(creat instanceof Oeuf || creat instanceof Bebe)) creat.setFaim(true);
                    }
                    else if (action <limiteMalade){ // Une creature tombe malade
                        creat = enclos.getListeCreatures().get(r.nextInt(enclos.getListeCreatures().size())); // Choisi une creature aleatoire dans l'enclos
                        if (!(creat instanceof Oeuf || creat instanceof Bebe)) creat.setSante(false);
                    }
                    else {
                        enclos.setProprete(PropreteEnum.CORRECT);
                    }
                }
                if (temps % 30 == 0){
                    // Faire viellir et naitre
                    // reproduire James Maria
                    for (Iterator<Enclos> iteratorEnclos = zoo.getEnclosExistant().iterator(); iteratorEnclos.hasNext();) {
                        Enclos enclos = iteratorEnclos.next();
                        for (Iterator<Creature> iterator = enclos.getListeCreatures().iterator(); iterator.hasNext();) {
                            Creature creature = iterator.next();

                            if (creature instanceof Oeuf) { //Vérifie si la créature actuelle est un oeuf ou non
                                if (((Oeuf) creature).getTempsEclosion() == ((Oeuf) creature).getTempsMaturation()) { //Est-ce qu'il est prêt à éclore
                                    switch (creature.getNomEspece()) {
                                        case DRAGON:
                                            if (creature.getSexe().equals(SexesEnum.FEMELLE)) {
                                                lTempCreatureAAjouter.add(new DragonFemelle(new Random().nextInt(600 - 300 + 1) + 300, new Random().nextInt(2000 - 1000 + 1) + 1000, 1, creature.getNom(), creature.getEnclos()));
                                            }
                                            else {
                                                lTempCreatureAAjouter.add(new DragonMale(new Random().nextInt(600 - 300 + 1) + 300, new Random().nextInt(2000 - 1000 + 1) + 1000, 1, creature.getNom(), creature.getEnclos()));
                                            }
                                            break;
                                        case KRAKEN:
                                            if (creature.getSexe().equals(SexesEnum.FEMELLE)) {
                                                lTempCreatureAAjouter.add(new KrakenFemelle(new Random().nextInt(1000 - 500 + 1) + 500, new Random().nextInt(10000 - 5000 + 1) + 5000, 1, creature.getNom(), creature.getEnclos()));
                                            }
                                            else {
                                                lTempCreatureAAjouter.add(new KrakenMale(new Random().nextInt(1000 - 500 + 1) + 500, new Random().nextInt(10000 - 5000 + 1) + 5000, 1, creature.getNom(), creature.getEnclos()));
                                            }
                                            break;
                                        case PHENIX:
                                            if (creature.getSexe().equals(SexesEnum.FEMELLE)) {
                                                lTempCreatureAAjouter.add(new PhenixFemelle(new Random().nextInt(15 - 5 + 1) + 5, new Random().nextInt(3000 - 2000 + 1) + 2000, 1, creature.getNom(), creature.getEnclos()));
                                            }
                                            else {
                                                lTempCreatureAAjouter.add(new PhenixMale(new Random().nextInt(15 - 5 + 1) + 5, new Random().nextInt(3000 - 2000 + 1) + 2000, 1, creature.getNom(), creature.getEnclos()));
                                            }
                                            break;
                                    }
                                    lTempCreatureASupprimer.add(creature); // L'oeuf a éclot donc on le supprime
                                    System.out.println("Un oeuf a éclot !");
                                } else {
                                    ((Oeuf) creature).setTempsMaturation(((Oeuf) creature).getTempsMaturation() + 1); //Il n'est pas encore prêt
                                }
                            }
                            else if (creature instanceof Bebe) { //Vérifie si la créature actuelle est un bébé ou non #290404 Faire Bebe
                                if (((Bebe) creature).getTempsNaissance() == ((Bebe) creature).getTempsGestation()) { //Est-ce qu'il est prêt à naitre
                                    switch (creature.getNomEspece()) {
                                        case LICORNE:
                                            if (creature.getSexe().equals(SexesEnum.FEMELLE)) {
                                                lTempCreatureAAjouter.add(new LicorneFemelle(new Random().nextInt(1100 - 450 + 1) + 450, new Random().nextInt(200 - 140 + 1) + 140, 1, creature.getNom(), creature.getEnclos()));
                                            }
                                            else {
                                                lTempCreatureAAjouter.add(new LicorneMale(new Random().nextInt(1100 - 450 + 1) + 450, new Random().nextInt(200 - 140 + 1) + 140, 1, creature.getNom(), creature.getEnclos()));
                                           }
                                            break;
                                        case LYCANTHROPE:
                                            if (creature.getSexe().equals(SexesEnum.FEMELLE)) {
                                                lTempCreatureAAjouter.add(new LycanthropeFemelle(new Random().nextInt(100 - 50 + 1) + 50, new Random().nextInt(200 - 150 + 1) + 150, 1, creature.getNom(), creature.getEnclos()));
                                            }
                                            else {
                                                lTempCreatureAAjouter.add(new LycanthropeMale(new Random().nextInt(100 - 50 + 1) + 50, new Random().nextInt(200 - 150 + 1) + 150, 1, creature.getNom(), creature.getEnclos()));
                                            }
                                            break;
                                        case MEGALODON:
                                            if (creature.getSexe().equals(SexesEnum.FEMELLE)) {
                                                lTempCreatureAAjouter.add(new MegalodonFemelle(new Random().nextInt(100000 - 50000 + 1) + 50000, new Random().nextInt(2500 - 1500 + 1) + 1500, 1, creature.getNom(), creature.getEnclos()));
                                            }
                                            else {
                                                lTempCreatureAAjouter.add(new MegalodonMale(new Random().nextInt(100000 - 50000 + 1) + 50000, new Random().nextInt(2500 - 1500 + 1) + 1500, 1, creature.getNom(), creature.getEnclos()));
                                            }
                                            break;
                                        case NYMPHE:
                                            if (creature.getSexe().equals(SexesEnum.FEMELLE)) {
                                                lTempCreatureAAjouter.add(new NympheFemelle(new Random().nextInt(90 - 50 + 1) + 50, new Random().nextInt(200 - 150 + 1) + 150, 1, creature.getNom(), creature.getEnclos()));
                                            }
                                            else {
                                                lTempCreatureAAjouter.add(new NympheMale(new Random().nextInt(90 - 50 + 1) + 50, new Random().nextInt(200 - 150 + 1) + 150, 1, creature.getNom(), creature.getEnclos()));
                                            }
                                            break;
                                        case SIRENE:
                                            if (creature.getSexe().equals(SexesEnum.FEMELLE)) {
                                                lTempCreatureAAjouter.add(new SireneFemelle(new Random().nextInt(90 - 50 + 1) + 50, new Random().nextInt(200 - 150 + 1) + 150, 1, creature.getNom(), creature.getEnclos()));
                                            }
                                            else {
                                                lTempCreatureAAjouter.add(new SireneMale(new Random().nextInt(90 - 50 + 1) + 50, new Random().nextInt(200 - 150 + 1) + 150, 1, creature.getNom(), creature.getEnclos()));
                                            }
                                            break;
                                    }

                                    lTempCreatureASupprimer.add(creature);
                                    System.out.println("Un bébé est né !");
                                } else {
                                    ((Bebe) creature).setTempsGestation(((Bebe) creature).getTempsGestation() + 1); // Il n'est pas prêt
                                }
                            }
                            else {
                                // Gerer l'age des creatures (et donc leur mort)
                                creature.vieillir();
                            }
                        }

                    }
                    for (Creature c : lTempCreatureAAjouter){
                        c.getEnclos().ajouterCreature(c);
                    }
                    for (Creature c : lTempCreatureASupprimer){
                        c.getEnclos().getListeCreatures().remove(c);

                    }
                }
                temps += 5;
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
