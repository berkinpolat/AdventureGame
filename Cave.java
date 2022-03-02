import java.util.ArrayList;
import java.util.Scanner;

public class Cave extends BattleLoc{
    private ArrayList<Zombie> zombieList = new ArrayList<>();

    public Cave() {
        this.genMonster();
    }

    @Override
    public void genMonster() {
        for (int i = 0; i < super.genNum(); i++){
            Zombie zombie = new Zombie();
            super.monsterList.add(zombie);
            this.zombieList.add(zombie);
        }
    }

    @Override
    public String onLocation() {

        System.out.println("////////////TEST////////////\n");
        for (Zombie zombie : zombieList) {
            System.out.println(zombie);
        }
        System.out.println("\n");


        System.out.println("""
                ====
                CAVE
                ====\n""");

        if (zombieList.size() == 0) genMonster();
        else if (zombieList.size() == 1) System.out.println("There is a Zombie waiting for you.");
        else if (zombieList.size() > 1) System.out.println("There are " + zombieList.size()
                + " Zombies waiting for you.");


        String choice;
        while (true){
            System.out.print("""
                    
                    1 - Fight
                    M - Map
                    
                    Choice: """);
            Scanner sc = new Scanner(System.in);
            choice = sc.nextLine();

            if (!(choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("m")))
                System.out.println("Invalid command, try again.");
            else break;
        }

        if (choice.equalsIgnoreCase("1")){
            for (int i = 0; i < zombieList.size(); i++){
                combat(zombieList.get(i));
                zombieList.remove(zombieList.get(i));

                if (zombieList.size() > 0){
                    if (zombieList.size() == 1) System.out.println("There is a Zombie waiting for you.");
                    else if (zombieList.size() > 1) System.out.println("There are " + zombieList.size()
                            + " Zombies waiting for you.");

                    while (true){
                        Scanner sc = new Scanner(System.in);
                        System.out.print("Would you like to continue? Y/N: ");
                        choice = sc.nextLine();
                        if ((choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")))
                            break;
                        else System.out.println("Invalid command, try again.");
                    }
                    if (choice.equalsIgnoreCase("N")) break;
                }

                else break;
            }

            if (!Game.player.getInventory().hasFirewood() && zombieList.isEmpty()){
                System.out.println("You obtained food.");
                Game.player.getInventory().setFirewood(true);
            }

        }
        System.out.println("Returning to map.");
        return "M";
    }

}
