package entity.race;

import entity.*;

import java.io.IOException;

public class Bar extends Fish {
    public Bar(String name, Gender gender, int age) {
        super(name, gender, age);
        setRegime(Regime.HERBIVORE);
        setRace(Race.BAR);
        setSexuality(Sexuality.AGE);
    }

    @Override
    public Living reproduce() throws IOException {
        return new Bar(randomName(), aleatoryGender(), 0);
    }
}
