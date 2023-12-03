import includes.creatures.Creature;
import includes.creatures.EspecesEnum;
import includes.creatures.Oeuf;
import includes.creatures.SexesEnum;
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
                    for (Creature creature : enclos.getListeCreatures()){
                        /*
                        if (creature.getClass() == o1.getClass()){
                            // Gerer les naissances
                        } */
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
