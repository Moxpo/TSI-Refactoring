package AvatarToRefactor;

public class AvatarToRefactor {

    public final static int avatar = 1;
    public final static int wizard = 2;
    public final static int adventurer = 3;

    public final static int dig = 1;
    public final static int castSpell = 2;
    public final static int takeAChance = 3;


    private int type;
    String name;
    private int strength;
    private int gold;
    private int magicStars;

    public AvatarToRefactor(int type, String n, int s, int g, int magicStars) {
        this.type = type;
        name = n;
        strength = s;
        gold = g;
        if (type == 2) {
            this.magicStars = magicStars;
        }

    }

    public int getGold() {
        return gold;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    public void action(int type, AvatarToRefactor c){
        if (type == 1){
            gold = gold + 1;
            strength = strength - 1;
        } else if (type ==2) {
            c.strength = c.strength - 1;
            gold = gold - 2;
            if (type == 2) {
                magicStars -= 2;
            }
        } else if (type ==3 && this.type == 3) {
            double random = Math.random();
            if (random < 0.5) {
                gold = gold / 2;
            } else
                gold = gold * 2;
        }
    }

    public void action(int type){
        if (type != 2) {
            action(type, null);
        }
    }

    public boolean isActive() {
        if ((strength <= 0) || (gold <= 0))
            return false;
        return true;
    }

    public String toString() {
        if (type == 2) {
            return name + ", " + "strength = " + strength + ", gold = " + gold + ", magic stars = " + magicStars;
        } else
            return name + ", " + "strength = " + strength + ", gold = " + gold;
    }
}
