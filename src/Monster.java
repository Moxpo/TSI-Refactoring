public abstract class Monster {
    protected String name;
    protected int strength;
    protected int aggression;

    public Monster(String name, int strength, int aggression) {
        this.name = name;
        this.strength = strength;
        this.aggression = aggression;
    }

    public abstract void action();

    public int getStrength() {
        return strength;
    }

    public int getAggression() {
        return aggression;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return strength > 0 && aggression > 0;
    }

    public void eat() {
        strength += 1;
    }

    public void scare() {
        strength -= 1;
        aggression -= 1;
    }

    @Override
    public String toString() {
        return name + ", strength = " + strength + ", aggression = " + aggression;
    }
}

class Sulley extends Monster {
    public Sulley(String name, int strength, int aggression) {
        super(name, strength, aggression);
    }

    @Override
    public void action() {
        // Sulley can either eat or scare randomly
        if (Math.random() < 0.5) {
            eat();
        } else {
            scare();
        }
    }
}

class Wazowski extends Monster {
    private int bananas;

    public Wazowski(String name, int strength, int aggression, int bananas) {
        super(name, strength, aggression);
        this.bananas = bananas;
    }

    public int getBananas() {
        return bananas;
    }

    public void makeLaugh() {
        bananas -= 1;
        strength += 1;
        if (Math.random() < 0.5) {
            aggression -= 2;
        }
    }

    @Override
    public void action() {
        // Wazowski can either eat, scare, or makeLaugh randomly
        double rand = Math.random();
        if (rand < 0.33) {
            eat();
        } else if (rand < 0.67) {
            scare();
        } else {
            makeLaugh();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", bananas = " + bananas;
    }
}
