package entity;

import java.io.IOException;
import java.util.Random;

public abstract class Fish extends Living {
    Random random = new Random();
    private final String name;
    private Gender gender;

    private Sexuality sexuality;
    private Regime regime;

    public Fish(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        setAge(age);
        setLifePoint(10);
        setEnergyValue(5);
        setLifeResistance(4);

    }

    @Override
    public abstract Living reproduce() throws IOException;

    public boolean canEat(Living eaten) {
        boolean response = false;
        if (getRegime().equals(Regime.CARNIVORE) && eaten instanceof Fish){
            response = true;
        }
        if (getRegime().equals(Regime.HERBIVORE) && eaten instanceof Agua){
            response = true;
        }


        return  response;
    }

    public void eat(Living eaten) {
        if(!getRace().equals(eaten.getRace())){
            setLifePoint(getLifePoint() + eaten.getEnergyValue());
            eaten.setLifePoint(eaten.getLifePoint() - eaten.getLifeResistance());
            eaten.setEaten(true);
        }
    }

    public void GenderChangement(Fish f){
        if(this.getSexuality().equals(Sexuality.AGE)&&this.getAge()<=10){
            this.setGender(Gender.MALE);
        } else if (this.getSexuality().equals(Sexuality.AGE)&&this.getAge()>11){
            this.setGender(Gender.FEMALE);
        }

        
        if(this.getGender().equals(f.getGender()) && this.getRace().equals(f.getRace())&& this.getSexuality().equals(Sexuality.OPPORTUNISTE)&&this!=f){
            if(f.getGender().equals(Gender.MALE)){
                this.setGender(Gender.FEMALE);
            } else {
                this.setGender(Gender.MALE);
            }
        }
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setRegime(Regime regime) {
        this.regime = regime;
    }

    public Regime getRegime() {
        return regime;
    }

    public Sexuality getSexuality() {
        return sexuality;
    }

    public void setSexuality(Sexuality sexuality) {
        this.sexuality = sexuality;
    }

    public boolean canReproduceWith(Fish fish){
        return (this.getLifePoint() > 5 && this.getRace().equals(fish.getRace()) && !this.getGender().equals(fish.getGender()));
    }

    public Gender aleatoryGender(){
        return Gender.values()[random.nextInt(Gender.values().length)];
    }
}
