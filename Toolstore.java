import java.util.Scanner;

public class Toolstore extends NormalLoc{

    public void menu(){
        Scanner sc = new Scanner(System.in);
        String choice;
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
            System.out.println("\nID\tName\tDamage\tCost");
            for (int i = 1; i < Game.weaponList.size(); i++){
                System.out.println(Game.weaponList.get(i).getId() + "\t"
                        + Game.weaponList.get(i).getName() + "\t"
                        + Game.weaponList.get(i).getDamage() + "\t\t"
                        + Game.weaponList.get(i).getCost());
            }
            System.out.print("\n0 - Return to menu\n\nChoice: ");

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
            Game.player.setDamage(Game.player.getDamage() + Game.player.getInventory().getWeapon().getDamage());
            System.out.println("Purchased: " + weapon.getName() + " Armor.");
        }
    }

    public void armorMenu(){
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("\nYour balance: " + Game.player.getInventory().getBalance() + "G");
            System.out.println("Current armor: " + Game.player.getInventory().getArmor().getName());
            System.out.println("\nID\tName\tDefense\tCost");
            for (int i = 1; i < Game.armorList.size(); i++){
                System.out.println(Game.armorList.get(i).getId() + "\t"
                + Game.armorList.get(i).getName() + "\t"
                + Game.armorList.get(i).getBlock() + "\t\t"
                + Game.armorList.get(i).getCost());
            }
            System.out.print("\n0 - Return to menu\n\nChoice: ");

            choice = sc.nextInt();
            if (!((choice>=0) && (choice<=3))){
                System.out.println("Invalid command, try again.");
            }
            if (choice == 0) break;
            else selectArmor(Game.armorList.get(choice));
        }
    }

    public void selectArmor(Armor armor){
        Scanner sc = new Scanner(System.in);
        if (Game.player.getInventory().getArmor().getId() == armor.getId()){
            System.out.println("Buu sahipsin buna almak istediğine emin misin?");
            String cevap = sc.nextLine();
            if (cevap.equalsIgnoreCase("yes") && buy(armor.getCost())){
                Game.player.getInventory().setArmor(armor);
                System.out.println("Purchased: " + armor.getName() + " Armor.");
            }

        }
        else if (buy(armor.getCost())){
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
        System.out.println("""
                =========
                TOOL SHOP
                =========""");
        menu();
        return "M";
    }
}
