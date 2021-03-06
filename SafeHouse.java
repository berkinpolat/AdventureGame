import java.util.Scanner;

public class SafeHouse extends NormalLoc{
    @Override
    public String onLocation() {
        System.out.println("""
                =========
                SAFEHOUSE
                =========""");
        Scanner sc = new Scanner(System.in);

        if (Game.player.getInventory().hasFirewood() &&
                Game.player.getInventory().hasFood() &&
                Game.player.getInventory().hasWater()) {
            String choice;
            while (true) {
                System.out.print("""
                        =========================
                        Congratulations, You win!
                        
                        Pick a choice from below:
                        Y - Keep Playing
                        X - Quit Game
                        
                        Choice:""");

                choice = sc.nextLine();
                if (!choice.equalsIgnoreCase("x") && !choice.equalsIgnoreCase("y"))
                    System.out.println("Invalid command, try again.");
                if (choice.equalsIgnoreCase("X")) Game.quit();
                else if (choice.equalsIgnoreCase("y")) break;
            }

        }

        while (Game.player.getHealth() < Game.player.getCharacter().getHealth()) {
            System.out.println("Recovering... Health: " + Game.player.getHealth() + "/" +
                                                    Game.player.getCharacter().getHealth());
            Game.player.incrementHealth();
            Game.suspense(1);
            if (Game.player.getHealth() > Game.player.getCharacter().getHealth())
                Game.player.setHealth(Game.player.getCharacter().getHealth());
            if (Game.player.getHealth() == Game.player.getCharacter().getHealth())
                System.out.println("\nRecovered! Health: " + Game.player.getHealth() + "/" +
                        Game.player.getCharacter().getHealth() +
                        "\n\nNothing else to do here.");
        }


        String choice;
        while (true) {
            Game.player.showStats();
            System.out.print("""
                    
                    Pick a choice from below:
                    M - Map
                    0 - Quit Game
                    Choice:""");
            choice = sc.nextLine();
            if (!choice.equalsIgnoreCase("m") && !choice.equalsIgnoreCase("0"))
                System.out.println("Invalid command, try again.");
            if (choice.equalsIgnoreCase("0")) Game.quit();
            else if (choice.equalsIgnoreCase("m")) break;
        }

        return "M";

    }
}
