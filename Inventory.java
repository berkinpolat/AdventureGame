public class Inventory {
    private boolean water;
    private boolean food;
    private boolean firewood;
    private int balance;
    private Weapon weapon;
    private Armor armor;

    public Inventory(int money) {
        this.firewood = false;
        this.food = false;
        this.water = false;
        this.balance = money;
        this.weapon = new Weapon(0, "None", 0, 0);
        this.armor = new Armor(0, "None", 0, 0);
    }

    public boolean hasWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean hasFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean hasFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int money) {
        this.balance = money;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "water=" + water +
                ", food=" + food +
                ", firewood=" + firewood +
                ", balance=" + balance +
                '}';
    }
}
