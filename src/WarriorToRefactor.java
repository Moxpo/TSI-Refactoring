public class WarriorToRefactor {
    public final static int warrior = 1;
    public final static int archer = 2;
    public final static int mage = 3;

    public final static int fight = 1;
    public final static int shoot = 2;
    public final static int castSpell = 3;

    private int type;
    String name;
    private int strength;
    private int experience;
    private int arrows;
    private int mana;

    public WarriorToRefactor(int type, String n, int s, int e, int a, int m) {
        this.type = type;
        name = n;
        strength = s;
        experience = e;
        if (type == 2) {
            this.arrows = a;
        }
        if (type == 3) {
            this.mana = m;
        }
    }

    public int getStrength() {
        return strength;
    }

    public int getExperience() {
        return experience;
    }

    public int getArrows() {
        return arrows;
    }

    public int getMana() {
        return mana;
    }

    public String getName() {
        return name;
    }

    public void action(int type, WarriorToRefactor w){
        if (type == 1){
            strength -= 1;
        } else if (type ==2 && this.type == 2) {
            arrows -= 1;
            experience += 1;
            double random = Math.random();
            if (random < 0.5) {
                strength -= 1;
            }
        } else if (type ==3 && this.type == 3) {
            mana -= 2;
            experience += 1;
            double random = Math.random();
            if (random < 0.5) {
                strength -= 1;
            }
        }
    }

    public void action(int type){
        action(type, null);
    }

    public boolean isActive() {
        if ((strength <= 0) || (experience <= 0))
            return false;
        return true;
    }

    public String toString() {
        if (type == 2) {
            return name + ", " + "strength = " + strength + ", experience = " + experience + ", arrows = " + arrows;
        } else if (type == 3) {
            return name + ", " + "strength = " + strength + ", experience = " + experience + ", mana = " + mana;
        } else
            return name + ", " + "strength = " + strength + ", experience = " + experience;
    }
}
