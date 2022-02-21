public class Game {
    private static Player player;
    private static Location location;

    public static void start(){
        player = new Player();
        player.showStats();
    }

    public static void main(String[] args) {
        start();
    }

}
