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
        System.out.println("""
                ======
                FOREST
                ======\n""");

        if (monsterList.size() == 0) genMonster();
        else if (monsterList.size() == 1) System.out.println("There is a Vampire waiting for you.");
        else if (monsterList.size() > 1) System.out.println("There are " + monsterList.size() + " Vampires waiting for you.");


        String choice;
        while (true){
            System.out.print("""
                    1 - Fight
                    M - Map""");
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

                if (monsterList.size() > 0){
                    if (monsterList.size() == 1) System.out.println("There is a Vampire waiting for you.");
                    else if (monsterList.size() > 1) System.out.println("There are " + monsterList.size() + " Vampires waiting for you.");

                    while (true){
                        Scanner sc = new Scanner(System.in);
                        System.out.print("Would you like to continue? Y/N: ");
                        choice = sc.nextLine();
                        if ((choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N"))) break;
                        else System.out.println("Invalid command, try again.");
                    }
                    if (choice.equalsIgnoreCase("N")) break;
                }
                else{
                    System.out.println("No more vampires left, returning to map.");
                    break;
                }
            }

        }










        return null;
    }

}
