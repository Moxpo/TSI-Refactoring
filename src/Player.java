// Players is now abstract because it serves as a base for all types of players
public abstract class Player {
    // Removed 'type' variable since the type of player will be determined by the class now

    protected String name; // Changed access modifier to 'protected' so subclasses can access it directly
    protected int health;
    protected int ammo;

    public Player(String name, int health, int ammo) { // Removed 'type' from constructor
        this.name = name;
        this.health = health;
        this.ammo = ammo;
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

    public abstract void action(Player p); // action method is now abstract and specific implementation will be in subclasses

    public void reload() {
        ammo++;
    }

    public boolean isAlive() {
        return (health > 0);
    }

    public void shoot(){
        ammo--;
        if (ammo < 0) ammo = 0; // Can't have negative ammo
    }

    @Override
    public String toString() {
        return name + ", health = " + health + ", ammo = " + ammo;
    }
}

// Class names should start with an uppercase and should not be all capitals
public class Soldier extends Player {
    public Soldier(String name, int health, int ammo) {
        super(name, health, ammo); // Using 'super' to call the constructor of the parent class
    }

    @Override
    public void action(Player p) {
        shoot(); // Soldier shoots
        p.health--; // Decrease health of the opponent player
    }
}

public class Medic extends Player {
    private int medkits; // Medkits should be a private member of Medic class

    public Medic(String name, int health, int ammo, int medkits) {
        super(name, health, ammo);
        this.medkits = medkits;
    }

    @Override
    public void action(Player p) {
        heal(p); // Medic heals
    }

    public void heal(Player p) {
        if (medkits > 0) {
            medkits--;
            p.health++;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", medkits = " + medkits; // Using 'super' to call the parent's toString() method
    }
}

public class Sniper extends Player {
    public Sniper(String name, int health, int ammo) {
        super(name, health, ammo);
    }

    @Override
    public void action(Player p) {
        shoot(); // Sniper shoots
        p.health -= 2; // Decrease health of the opponent player by 2
    }
}
