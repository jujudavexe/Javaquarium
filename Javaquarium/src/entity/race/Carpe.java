package entity.race;

import entity.*;

import java.io.IOException;

public class Carpe extends Fish {
    public Carpe(String name, Gender gender, int age) {
        super(name, gender, age);
        setRegime(Regime.HERBIVORE);
        setRace(Race.CARPE);
        setSexuality(Sexuality.MONO);
    }

    @Override
    public Living reproduce() throws IOException {
        return new Carpe(randomName(), aleatoryGender(), 0);
    }
}
