public class MonsterToRefactor {

    public final static int monster = 1;
    public final static int sulley = 2;
    public final static int wazowski = 3;

    public final static int eat = 1;
    public final static int scare = 2;
    public final static int makeLaugh = 3;


    private int type;
    String name;
    private int strength;
    private int aggression;
    private int bananas;

    public MonsterToRefactor(int type, String n, int s, int a, int b) {
        this.type = type;
        name = n;
        strength = s;
        aggression = a;
        if (type == 3) {
            this.bananas = b;
        }
    }

    public int getAggression() {
        return aggression;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }


    public int getBananas() {
        return bananas;
    }

    public void action(int type, MonsterToRefactor c){
        if (type == 1){
            strength += 1;
        } else if (type ==2) {
            aggression -= 1;
            c.strength -= 1;
        } else if (type ==3 && this.type == 3) {
            bananas -= 1;
            strength += 1;
            double random = Math.random();
            if (random < 0.5) {
                c.aggression -= 2;
            }
        }
    }

    public void action(int type){
        if (type != 2) {
            action(type, null);
        }
    }

    public boolean isActive() {
        if ((strength <= 0) || (aggression <= 0))
            return false;
        return true;
    }

    public String toString() {
        if (type == 3) {
            return name + ", " + "strength = " + strength + ", aggression = " + aggression + ", bannas = " + bananas;
        } else
            return name + ", " + "strength = " + strength + ", aggression = " + aggression;
    }
}
