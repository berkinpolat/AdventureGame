import java.util.ArrayList;

public abstract class BattleLoc extends Location{
    public ArrayList<Monster> monsterList = new ArrayList<>();

    @Override
    public String onLocation() {
        return null;
    }

    public int genNum(){
        return (int)((Math.random()*3) + 1);
    }

    abstract public void genMonster();

    public void combat(Monster monster){

        int playerHP = Game.player.getHealth();
        int playerAD = Game.player.getDamage()
                + Game.player.getInventory().getWeapon().getDamage();

        int monsterAD = monster.getDamage()
                - Game.player.getInventory().getWeapon().getDamage();
        int monsterHP = monster.getHealth();

        while (playerHP > 0 && monsterHP > 0) {
            monsterHP -= playerAD;
            if (monsterHP < 0) monsterHP = 0;
            System.out.println("\nYou attacked.\n"+monster.getName()+" HP: " + monsterHP);
            if (monsterHP == 0) break;
            playerHP -= monsterAD;
            System.out.println(monster.getName() + " attacked you.\nYour HP: " + playerHP);
        }

        if (playerHP <= 0) {
            System.out.println("Your HP: " + playerHP + "\nYou lost.");
        }

        if (monsterHP == 0) {
            Game.player.getInventory().setBalance(Game.player.getInventory().getBalance() + monster.getLoot());
            System.out.println("You gained " + monster.getLoot() + "G by slaying " + monster.getName() + "\n");
            monsterList.remove(monster);
            Game.player.setHealth(playerHP);
        }

    }
}
