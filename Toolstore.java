import java.util.Scanner;

public class Toolstore extends NormalLoc{

    public void menu(){
        Scanner sc = new Scanner(System.in);
        String choice;
        //weaponlist
            //show balance
            //show weapons
            //close list
        //armorlist
            //show balance
            //show armors
            //close list
        //close menu
        System.out.println("\nYour balance: " + Game.player.getInventory().getBalance() + "G");
        while (true){
            System.out.print("""
                    
                    1 - Armor Menu
                    2 - Weapon Menu
                    M - Map
                    
                    Choice:""");
            choice = sc.nextLine();
            if (!(choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("M")
            || choice.equalsIgnoreCase("2"))){
                System.out.println("Invalid command, try again.");
            }
            else if (choice.equalsIgnoreCase("M")) return;
            else if (choice.equalsIgnoreCase("1")) armorMenu();
            else if (choice.equalsIgnoreCase("2")) weaponMenu();
        }
    }

    public void weaponMenu(){
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("\nYour balance: " + Game.player.getInventory().getBalance() + "G");
            System.out.println("Current weapon: " + Game.player.getInventory().getWeapon().getName());
            System.out.print("""
                    
                    ID  Name    Damage   Cost
                    1   Pistol  2        25G
                    2   Sword   3        35G
                    3   Rifle   7        45G
                    
                    0 - Return to menu
                    
                    Choice:""");
            choice = sc.nextInt();
            if (!((choice>=0) && (choice<=3))){
                System.out.println("Invalid command, try again.");
            }
            if (choice == 0) break;
            else selectWeapon(Game.weaponList.get(choice));
        }
    }

    public void selectWeapon(Weapon weapon){
        if (buy(weapon.getCost())){
            Game.player.getInventory().setWeapon(weapon);
            System.out.println("Purchased: " + weapon.getName() + " Armor.");
        }
    }

    public void armorMenu(){
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("\nYour balance: " + Game.player.getInventory().getBalance() + "G");
            System.out.println("Current armor: " + Game.player.getInventory().getArmor().getName());
            System.out.print("""
                    
                    ID  Name    Defense   Cost
                    1   Light   1         15G
                    2   Middle  3         25G
                    3   Heavy   5         40G
                    
                    0 - Return to menu
                    
                    Choice:""");
            choice = sc.nextInt();
            if (!((choice>=0) && (choice<=3))){
                System.out.println("Invalid command, try again.");
            }
            if (choice == 0) break;
            else selectArmor(Game.armorList.get(choice));
        }
    }

    public void selectArmor(Armor armor){
        if (buy(armor.getCost())){
            Game.player.getInventory().setArmor(armor);
            System.out.println("Purchased: " + armor.getName() + " Armor.");
        }
    }

    public boolean buy(int cost){
        if (Game.player.getInventory().getBalance()>=cost){
            Game.player.getInventory().setBalance(Game.player.getInventory().getBalance() - cost);
            return true;
        }
        System.out.println("Not enough gold.");
        return false;
    }



    @Override
    public String onLocation() {
        //menu
        System.out.println("""
                =========
                TOOL SHOP
                =========""");
        menu();
        //return to map
        return "M";
    }
}
