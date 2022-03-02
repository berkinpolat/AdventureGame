import java.util.ArrayList;
import java.util.Scanner;

public class Forest extends BattleLoc{
    private ArrayList<Vampire> vampireList = new ArrayList<>();

    public Forest() {
        this.genMonster();
    }

    @Override
    public void genMonster() {
        for (int i = 0; i < super.genNum(); i++){
            Vampire vampire = new Vampire();
            super.monsterList.add(vampire);
            this.vampireList.add(vampire);
        }
    }

    @Override
    public String onLocation() {

        System.out.println("////////////TEST////////////\n");
        for (Vampire vampire : vampireList) {
            System.out.println(vampire);
        }
        System.out.println("\n");


        System.out.println("""
                ======
                FOREST
                ======\n""");

        if (vampireList.size() == 0) genMonster();
        else if (vampireList.size() == 1) System.out.println("There is a Vampire waiting for you.");
        else if (vampireList.size() > 1) System.out.println("There are " + vampireList.size()
                + " Vampires waiting for you.");


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
            for (int i = 0; i < vampireList.size(); i++){
                combat(vampireList.get(i));
                vampireList.remove(vampireList.get(i));

                if (vampireList.size() > 0){
                    if (vampireList.size() == 1) System.out.println("There is a Vampire waiting for you.");
                    else if (vampireList.size() > 1) System.out.println("There are " + vampireList.size()
                            + " Vampires waiting for you.");

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

            if (!Game.player.getInventory().hasFirewood() && vampireList.isEmpty()){
                System.out.println("You obtained firewood.");
                Game.player.getInventory().setFirewood(true);
            }

            System.out.println("Returning to map.");

        }
        return "M";
    }

}
