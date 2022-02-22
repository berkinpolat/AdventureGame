import java.util.Scanner;

public class Game {
    public static Player player;
    private static Location location;
    public static boolean hasWon = false;

    public static void start(){
        player = new Player();
        //player.showStats();
        //System.out.println("---------------");
        player.setHealth(player.getHealth()-10);
        //player.showStats();
        //System.out.println("---------------");
        SafeHouse safeHouse = new SafeHouse();
        safeHouse.onLocation();

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
