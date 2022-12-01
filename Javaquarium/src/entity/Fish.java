package entity;

public abstract class Fish implements Edible {
    private final String name;
    private Gender gender;
    private int age;
    private int lifePoint;
    private final Regime regime;

    public Fish(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        regime = Regime.CARNIVORE;
        lifePoint = 10;

    }

    public void eat(Fish eater, Edible food) {

    }


    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }

    public Regime getRegime() {
        return regime;
    }
}
