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
            this.addToVampireList(vampire);
        }
    }

    @Override
    public String onLocation() {
        System.out.println("""
                ======
                FOREST
                ======\n""");
        int monsterCount = 0;
        for (int i = 0; i < monsterList.size(); i++)
            if (monsterList.get(i) instanceof Vampire) monsterCount++;

        if (monsterCount == 0) genMonster();
        else if (monsterCount == 1) System.out.println("There is a Vampire waiting for you.");
        else if (monsterCount > 1) System.out.println("There are " + monsterCount + " Vampires waiting for you.");


        String choice;
        while (true){
            System.out.println("Would you like to fight? Y/N");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextLine();

            if (!(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")))
                System.out.println("Invalid command, try again.");
            else break;
        }
        while (choice.equalsIgnoreCase("y")){
            for (int i = 0; i < vampireList.size(); i++){
                combat(getVampireList().get(i));
                // vampire list remove defeated enemy
            }




        }



        return null;
    }

    public void addToVampireList(Vampire vampire) {
        this.vampireList.add(vampire);
    }

    public ArrayList<Vampire> getVampireList() {
        return vampireList;
    }

    public void setVampireList(ArrayList<Vampire> vampireList) {
        this.vampireList = vampireList;
    }
}
