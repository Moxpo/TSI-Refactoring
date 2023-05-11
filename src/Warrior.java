public enum WarriorType {
    KNIGHT,
    ARCHER,
    MAGE
}

public abstract class Warrior {
    protected String name;
    protected int strength;
    protected int experience;

    public Warrior(String name, int strength, int experience) {
        this.name = name;
        this.strength = strength;
        this.experience = experience;
    }

    public abstract void action();

    public int getStrength() {
        return strength;
    }

    public int getExperience() {
        return experience;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return (strength > 0) && (experience > 0);
    }

    @Override
    public String toString() {
        return name + ", " + "strength = " + strength + ", experience = " + experience;
    }
}

public class Knight extends Warrior {

    public Knight(String name, int strength, int experience) {
        super(name, strength, experience);
    }

    @Override
    public void action() {
        this.strength -= 1;
    }
}

public class Archer extends Warrior {
    private int arrows;

    public Archer(String name, int strength, int experience, int arrows) {
        super(name, strength, experience);
        this.arrows = arrows;
    }

    @Override
    public void action() {
        this.arrows -= 1;
        this.experience += 1;
        if (Math.random() < 0.5) {
            this.strength -= 1;
        }
    }

    public int getArrows() {
        return arrows;
    }

    @Override
    public String toString() {
        return super.toString() + ", arrows = " + arrows;
    }
}

public class Mage extends Warrior {
    private int mana;

    public Mage(String name, int strength, int experience, int mana) {
        super(name, strength, experience);
        this.mana = mana;
    }

    @Override
    public void action() {
        this.mana -= 2;
        this.experience += 1;
        if (Math.random() < 0.5) {
            this.strength -= 1;
        }
    }

    public int getMana() {
        return mana;
    }

    @Override
    public String toString() {
        return super.toString() + ", mana = " + mana;
    }
}
