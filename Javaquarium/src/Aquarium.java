import entity.*;
import entity.race.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aquarium {

    Random random = new Random();
    List<Fish> fishs = new ArrayList<>();
    List<Agua> aguas = new ArrayList<>();

    public void Turn() throws InterruptedException, IOException {


        oldingPhase();
        recycleEntities();
        eatingPhase();
        recycleEntities();
        reproducingPhase();
        resetStatue();
        showEntities();
        Thread.sleep(2500);


    }

    public void showEntities() {
        for (Fish fish : fishs)
            System.out.println(fish.getName() + " " + fish.getGender() + " " + fish.getRace() + " age: " + fish.getAge() + " PV: " + fish.getLifePoint());

        if (aguas.size() > 0)
            System.out.println("\nIl y a " + aguas.size() + " algues dans l'aquarium");
        else
            System.out.println("\nIl n'y a plus d'algue dans l'aquarium.");

        if (fishs.size() > 0)
            System.out.println("Il y a " + fishs.size() + " poissons dans l'aquarium\n");
        else
            System.out.println("Il n'y a plus de poisson dans l'aquarium.\n");
    }

    public void firstEntity() {
        addFish(new Sole("Martin", Gender.MALE, random.nextInt(20)));
        addFish(new Sole("Louise", Gender.FEMALE, random.nextInt(20)));
        addFish(new Thon("Luc", Gender.MALE, random.nextInt(20)));
        addFish(new Thon("Lou", Gender.FEMALE, random.nextInt(20)));
        addFish(new PoissonClown("Eden", Gender.FEMALE, random.nextInt(20)));
        addFish(new PoissonClown("Nemo", Gender.MALE, random.nextInt(20)));
        addFish(new Merou("Virginie", Gender.FEMALE, random.nextInt(20)));
        addFish(new Merou("Esteban", Gender.MALE, random.nextInt(20)));
        addFish(new Carpe("Laurent", Gender.MALE, random.nextInt(20)));
        addFish(new Carpe("Niouma", Gender.FEMALE, random.nextInt(20)));
        addFish(new Bar("Mathieu", Gender.MALE, random.nextInt(20)));
        addFish(new Bar("Charlotte", Gender.FEMALE, random.nextInt(20)));

        for (int i = 0; i < 5; i++)
            addAgua(new Agua(random.nextInt(20), 10));
    }

    public void addAgua(Agua agua) {
        aguas.add(agua);
    }

    public void addFish(Fish fish) {
        fishs.add(fish);
    }

    public Fish aleatoryFish() {
        //System.out.println("poissonnnnnnnn");
        return fishs.get(random.nextInt(fishs.size()));

    }

    public Living aleatoryLiving() {
        int randomNumber = random.nextInt(2);

        Living randomLivingEntity = null;
        if (randomNumber == 0 && !aguas.isEmpty()) {
            randomLivingEntity = aleatoryAgua();
        } else if (!fishs.isEmpty()) {
            randomLivingEntity = aleatoryFish();
        }
        return randomLivingEntity;
    }

    public Agua aleatoryAgua() {
        //System.out.println("algueeeeeeee");
        return aguas.get(random.nextInt(aguas.size()));

    }

    public void eatingPhase() {
        Living eaten;
        boolean b;
        if (fishs.size() > 0) {
            for (int i = fishs.size() - 1; i >= 0; i--) {
                Fish eater = fishs.get(i);
                if (eater.getLifePoint() > 0 && eater.getLifePoint() <= 5 && !eater.isEaten() && !foodNotAvailable(eater)) {
                    do {
                        eaten = aleatoryLiving();
                        b = eater.canEat(eaten);
                    } while (!b);

                    eater.eat(eaten);
                }


            }
        }
    }

    public boolean foodNotAvailable(Fish f) {
        return f.getRegime().equals(Regime.HERBIVORE) && aguas.isEmpty();
    }

    public void oldingPhase() {
        for (Fish fish : fishs) {
            fish.setAge(fish.getAge() + 1);
            fish.setLifePoint(fish.getLifePoint() - 1);
        }
        for (Agua agua : aguas) {
            agua.setAge(agua.getAge() + 1);
            agua.setLifePoint(agua.getLifePoint() + 1);
        }
    }

    public void recycleEntities() {
        for (int i = fishs.size() - 1; i >= 0; i--) {
            if (fishs.get(i).getLifePoint() <= 0 || fishs.get(i).getAge() > 20)
                fishs.remove(fishs.get(i));
        }
        for (int i = aguas.size() - 1; i >= 0; i--) {
            if (aguas.get(i).getLifePoint() <= 0 || aguas.get(i).getAge() > 20)
                aguas.remove(aguas.get(i));
        }
    }

    public void reproducingPhase() throws IOException {
        for (int i = aguas.size() - 1; i >= 0; i--) {
            Agua agua = aguas.get(i);
            if (agua.canReproduce()) {
                aguas.add((Agua) agua.reproduce());
            }
        }
        for (int i = fishs.size() - 1; i >= 0; i--) {
            Fish fish = fishs.get(i);
            Fish f = aleatoryFish();
            fish.GenderChangement(f);
            if (fish.canReproduceWith(f) && !fish.isEaten()) {
                fishs.add((Fish) fish.reproduce());
            }
        }
    }

    public void resetStatue() {
        for (int i = fishs.size() - 1; i >= 0; i--) {
            Fish fish = fishs.get(i);
            fish.setEaten(false);
        }
    }
}

