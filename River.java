import java.util.ArrayList;
import java.util.Scanner;

public class River extends BattleLoc {
    private ArrayList<Bear> bearList = new ArrayList<>();

    public River() {
        this.genMonster();
    }

    @Override
    public void genMonster() {
        for (int i = 0; i < super.genNum(); i++){
            Bear bear = new Bear();
            super.monsterList.add(bear);
            this.bearList.add(bear);
        }
    }

    @Override
    public String onLocation() {

        System.out.println("////////////TEST////////////\n");
        for (Bear bear : bearList) {
            System.out.println(bear);
        }
        System.out.println("\n");


        System.out.println("""
                =====
                RIVER
                =====\n""");

        if (bearList.size() == 0) genMonster();
        else if (bearList.size() == 1) System.out.println("There is a Bear waiting for you.");
        else if (bearList.size() > 1) System.out.println("There are " + bearList.size()
                + " Bears waiting for you.");


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
            for (int i = 0; i < bearList.size(); i++){
                combat(bearList.get(i));
                bearList.remove(bearList.get(i));

                if (bearList.size() > 0){
                    if (bearList.size() == 1) System.out.println("There is a Bear waiting for you.");
                    else if (bearList.size() > 1) System.out.println("There are " + bearList.size()
                            + " Bears waiting for you.");

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

            if (!Game.player.getInventory().hasWater() && bearList.isEmpty()){
                System.out.println("You obtained water.");
                Game.player.getInventory().setWater(true);
            }

        }
        System.out.println("Returning to map.");
        return "M";
    }

}
