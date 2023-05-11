// Made Avatar an abstract class as it will not be directly instantiated
abstract class Avatar {
    // Moved shared attributes to the parent class
    String name;
    int strength;
    int gold;

    // Constructor in the parent class for common attributes
    public Avatar(String name, int strength, int gold) {
        this.name = name;
        this.strength = strength;
        this.gold = gold;
    }

    // Getters for the common attributes
    public int getGold() {
        return gold;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    // Abstract method in the parent class to be overridden in the child classes
    public abstract void action(Avatar c);

    // Common method for all Avatars, so kept in the parent class
    public boolean isActive() {
        return strength > 0 && gold > 0;
    }

    // toString method in the parent class to avoid duplication
    @Override
    public String toString() {
        return name + ", " + "strength = " + strength + ", gold = " + gold;
    }

    // Dig method, common for all Avatars, so kept in the parent class
    protected void dig() {
        gold += 1;
        strength -= 1;
    }
}

// Wizard class extends Avatar to inherit common attributes and methods
class Wizard extends Avatar {
    // Magic stars is unique to Wizard, so kept it in the Wizard class
    private int magicStars;

    // Constructor in Wizard class with super() to call parent class constructor
    public Wizard(String name, int strength, int gold, int magicStars) {
        super(name, strength, gold);
        this.magicStars = magicStars;
    }

    // Wizard's unique implementation of the action method
    @Override
    public void action(Avatar c) {
        c.strength -= 1;
        gold -= 2;
        magicStars -= 2;
    }

    // Overriding toString method in Wizard to include magic stars, using super.toString() to reuse code from parent class
    @Override
    public String toString() {
        return super.toString() + ", magic stars = " + magicStars;
    }
}

// Adventurer class extends Avatar to inherit common attributes and methods
class Adventurer extends Avatar {
    // Constructor in Adventurer class with super() to call parent class constructor
    public Adventurer(String name, int strength, int gold) {
        super(name, strength, gold);
    }

    // Adventurer's unique implementation of the action method
    @Override
    public void action(Avatar c) {
        takeAChance();
    }

    // takeAChance is unique to Adventurer, so kept it in the Adventurer class
    private void takeAChance() {
        double random = Math.random();
        if (random < 0.5) {
            gold /= 2;
        } else {
            gold *= 2;
        }
    }
}
