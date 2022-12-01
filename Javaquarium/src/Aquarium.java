import entity.*;
import entity.race.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aquarium {

    Random random = new Random();
    List<Fish> fishs = new ArrayList<>();
    List<Agua> aguas = new ArrayList<>();

    List<Edible> edibles = new ArrayList<>();

    public void start() {
        firstEntity();
        showEntities();
        eat();

    }

    public void showEntities() {
        for (Fish fish : fishs)
            System.out.println(fish.getName() + " " + fish.getGender() + " age: " + fish.getAge() + " PV: " + fish.getLifePoint());

        if (aguas.size() > 0)
            System.out.println("\nIl y a " + aguas.size() + " algues dans l'aquarium");
        else
            System.out.println("\nIl n'y a plus d'algue dans l'aquarium.");

        if (fishs.size() > 0)
            System.out.println("Il y a " + fishs.size() + " poissons dans l'aquarium");
        else
            System.out.println("Il n'y a plus de poisson dans l'aquarium.");
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

        for(int i = 0; i < 5; i++)
            addAgua(new Agua(random.nextInt(20)));
    }

    public void addAgua(Agua agua){
        aguas.add(agua);
    }

    public void addFish(Fish fish) {
        fishs.add(fish);
    }

    public Fish aleatoryFish(){
        return fishs.get(random.nextInt(fishs.size()));
    }

    public Agua aleatoryAgua(){
        return aguas.get(random.nextInt(aguas.size()));
    }

    public void eat(){
        if(fishs.size()>0){
            for(int i = fishs.size()-1; i >= 0; i--){
                Fish f = fishs.get(i);
                if(f.getRegime() == Regime.CARNIVORE){
                    f.eat(f, aleatoryFish());
                } else if (f.getRegime() == Regime.HERBIVORE){
                    f.eat(f, aleatoryAgua());
                }
            }
        }
    }
}