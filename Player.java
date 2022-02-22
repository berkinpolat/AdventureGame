import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private Character character;
    private Inventory inventory;

    public Player() {
        this.character = this.selectChar();
        this.inventory = new Inventory(this.character.getBalance());
        this.damage = this.character.getDamage() + this.inventory.getWeapon().getDamage();
        this.health = this.character.getHealth();
    }

    public Character selectChar() {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.print("""
                    Pick a Character ID from below:
                    
                    ID  Character   Damage  Health  Balance
                    1   Samurai     5       21      15
                    2   Archer      7       18      20
                    3   Knight      8       24      5
                    
                    Choice:""");
            choice = sc.nextInt();
            if (choice >= 1 && choice <=3) break;
            else System.out.println("Wrong ID, try again.");
        }
        Character character = null;
        if (choice == 1)
            character = new Character(1, "Samurai", 5, 21, 15);
        else if (choice == 2)
            character = new Character(2, "Archer", 7, 18, 20);
        else
            character = new Character(3, "Knight", 8, 24, 5);

        return character;
    }

    public void showStats() {
        System.out.println(this.toString());
        System.out.println(this.character.toString());
        System.out.println(this.inventory.toString());
        System.out.println(this.inventory.getWeapon().toString());
        System.out.println(this.inventory.getArmor().toString());
    }

    public void incrementHealth() {
        this.health++;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
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

    public Character getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return "Player{" +
                "damage=" + damage +
                ", health=" + health +
                '}';
    }
}
