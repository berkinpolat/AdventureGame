import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static Player player;
    private static Location location;
    public static boolean hasWon = false;
    public static ArrayList<Weapon> weaponList = new ArrayList<>();
    public static ArrayList<Armor> armorList = new ArrayList<>();

    public static void start(){
        initArmors();
        initWeapons();
        player = new Player();
        //player.showStats();
        //System.out.println("---------------");
        player.setHealth(player.getHealth());
        //player.showStats();
        //System.out.println("---------------");
        //SafeHouse safeHouse = new SafeHouse();
        //safeHouse.onLocation();
        Toolstore toolstore = new Toolstore();
        toolstore.onLocation();

    }

    private static void initWeapons(){
        Weapon none = new Weapon(0, "None", 0, 0);
        Weapon pistol = new Weapon(1, "Pistol", 2, 25);
        Weapon sword = new Weapon(2, "Sword", 3, 35);
        Weapon rifle = new Weapon(3, "Rifle", 7, 45);
        weaponList.add(none);
        weaponList.add(pistol);
        weaponList.add(sword);
        weaponList.add(rifle);
    }

    private static void initArmors(){
        Armor none = new Armor(0, "None", 0, 0);
        Armor light = new Armor(1, "Light", 1, 15);
        Armor middle = new Armor(2, "Middle", 3, 25);
        Armor heavy = new Armor(3, "Heavy", 5, 40);
        armorList.add(none);
        armorList.add(light);
        armorList.add(middle);
        armorList.add(heavy);
    }

    public static void quit() {
        System.out.print("""
                
                Are you sure?
                Y - Yes, quit game.
                N - No, go back to game.
                Choice:""");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (choice.equals("Y") || choice.equals("y")) System.exit(12);
    }

    public static void main(String[] args) {
        start();
    }

}
