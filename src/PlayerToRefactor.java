/*
 let's consider an example related to a computer game that includes different
 types of players: a Soldier, a Medic, and a Sniper. Each player has attributes
 such as name, health, and ammo. They can perform actions such as shoot, heal, and
 reload.
 Your task is to refactor this code to improve readability, reusability, and
 maintainability. The refactor should include creating distinct classes for Soldier,
 Medic, and Sniper. Each class should have appropriate methods for their actions and
 should override the toString method to display their specific attributes.
*/


public class PlayerToRefactor {

    public final static int SOLDIER = 1;
    public final static int MEDIC = 2;
    public final static int SNIPER = 3;

    public final static int SHOOT = 1;
    public final static int HEAL = 2;
    public final static int RELOAD = 3;

    private int type;
    String name;
    private int health;
    private int ammo;
    private int medkits;

    public PlayerToRefactor(int type, String n, int h, int a, int m) {
        this.type = type;
        name = n;
        health = h;
        ammo = a;
        if (type == 2) {
            this.medkits = m;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getAmmo() {
        return ammo;
    }

    public String getName() {
        return name;
    }

    public void action(int type, PlayerToRefactor p){
        if (type == SHOOT){
            ammo--;
            p.health--;
        } else if (type == HEAL && this.type == MEDIC) {
            if (medkits > 0) {
                medkits--;
                p.health++;
            }
        } else if (type == RELOAD) {
            ammo++;
        }
    }

    public boolean isAlive() {
        return (health > 0);
    }

    public String toString() {
        if (type == MEDIC) {
            return name + ", health = " + health + ", ammo = " + ammo + ", medkits = " + medkits;
        } else {
            return name + ", health = " + health + ", ammo = " + ammo;
        }
    }
}
