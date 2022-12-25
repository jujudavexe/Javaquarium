package entity.race;

import entity.*;

import java.io.IOException;

public class PoissonClown extends Fish {
    public PoissonClown(String name, Gender gender, int age) {
        super(name, gender, age);
        setRegime(Regime.CARNIVORE);
        setRace(Race.POISSONCLOWN);
        setSexuality(Sexuality.OPPORTUNISTE);
    }

    @Override
    public Living reproduce() throws IOException {
        return new PoissonClown(randomName(), aleatoryGender(), 0);
    }

}
