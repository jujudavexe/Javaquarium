package entity.race;

import entity.Fish;
import entity.Gender;
import entity.Regime;

public class Sole extends Fish {
    public Sole(String name, Gender gender, int age) {
        super(name, gender, age);
        Regime regime = Regime.HERBIVORE;
    }
}
