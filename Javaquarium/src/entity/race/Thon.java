package entity.race;

import entity.*;

import java.io.IOException;

public class Thon extends Fish {
    public Thon(String name, Gender gender, int age) {
        super(name, gender, age);
        setRegime(Regime.CARNIVORE);
        setRace(Race.THON);
        setSexuality(Sexuality.MONO);
    }

    @Override
    public Living reproduce() throws IOException {
        return new Thon(randomName(), aleatoryGender(), 0);
    }
}
