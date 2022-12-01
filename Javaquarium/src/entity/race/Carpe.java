package entity.race;

import entity.Fish;
import entity.Gender;
import entity.Regime;

public class Carpe extends Fish {
    public Carpe(String name, Gender gender, int age) {
        super(name, gender, age);
        Regime regime = Regime.HERBIVORE;
    }
}
