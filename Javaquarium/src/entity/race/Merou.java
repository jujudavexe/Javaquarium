package entity.race;

import entity.*;

import java.io.IOException;

public class Merou extends Fish {
    public Merou(String name, Gender gender, int age) {
        super(name, gender, age);
        setRegime(Regime.CARNIVORE);
        setRace(Race.MEROU);
        setSexuality(Sexuality.AGE);
    }

    @Override
    public Living reproduce() throws IOException {
        return new Merou(randomName(), aleatoryGender(), 0);
    }
}
