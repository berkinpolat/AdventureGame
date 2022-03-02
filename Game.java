import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    public static Player player;
    public static ArrayList<Weapon> weaponList = new ArrayList<>();
    public static ArrayList<Armor> armorList = new ArrayList<>();
    private static final SafeHouse safeHouse = new SafeHouse();
    private static final Toolstore toolstore = new Toolstore();
    private static final Forest forest = new Forest();
    private static final Cave cave = new Cave();
    private static final River river = new River();

    public static void start(){
        initArmors();
        initWeapons();
        player = new Player();
        safeHouse.onLocation();
        int location = map();

        while (true) {
            switch (location){
                case 0:
                    location = map();
                    break;
                case 1:
                    safeHouse.onLocation();
                    location = 0;
                    break;
                case 2:
                    cave.onLocation();
                    location = 0;
                    break;
                case 3:
                    forest.onLocation();
                    location = 0;
                    break;
                case 4:
                    river.onLocation();
                    location = 0;
                    break;
                case 5:
                    toolstore.onLocation();
                    location = 0;
                    break;
            }
        }

    }

    public static int map(){
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.print("""
                    ===
                    MAP
                    ===
                    
                    1 - Safe House
                    2 - Cave
                    3 - Forest
                    4 - River
                    5 - ToolStore
                    0 - Quit Game
                    
                    Choice: """);
            choice = sc.nextInt();
            if (choice >= 0 && choice <= 5) break;
            else System.out.println("Invalid command, try again.");
        }
        if (choice == 0) quit();
        return choice;
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

    public static void suspense(int i){
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void quit() {
        Scanner sc = new Scanner(System.in);
        String choice;
        while (true){
            System.out.print("""
                    
                    Are you sure?
                    Y - Yes, quit game.
                    N - No, go back to game.
                    Choice:""");
            choice = sc.nextLine();
            if (!(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")))
                System.out.println("Invalid command, try again.");
            else break;
        }
            if (choice.equalsIgnoreCase("Y")) System.exit(12);
    }

    public static void main(String[] args) {
        start();
    }

}
