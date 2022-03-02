public class Character {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int balance;

    public Character(int id, String name, int damage, int health, int balance) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "\nCharacter: " + this.getName();
    }
}
