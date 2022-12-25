package entity.race;

import entity.*;

import java.io.IOException;

public class Sole extends Fish {
    public Sole(String name, Gender gender, int age) {
        super(name, gender, age);
        setRegime(Regime.HERBIVORE);
        setRace(Race.SOLE);
        setSexuality(Sexuality.OPPORTUNISTE);
    }

    @Override
    public Living reproduce() throws IOException {
        return new Sole(randomName(), aleatoryGender(), 0);
    }
}
