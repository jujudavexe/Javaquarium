package entity.race;

import entity.Fish;
import entity.Gender;
import entity.Regime;

public class Thon extends Fish {
    public Thon(String name, Gender gender, int age) {
        super(name, gender, age);
        Regime regime = Regime.CARNIVORE;
    }
}
