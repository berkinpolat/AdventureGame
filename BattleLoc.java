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

        //copy player health+armor
        //copy player damage+weapon

        int playerHP = Game.player.getHealth();
        int playerAD = Game.player.getDamage()
                + Game.player.getInventory().getWeapon().getDamage();


        //copy monster health
        int monsterAD = monster.getDamage()
                - Game.player.getInventory().getWeapon().getDamage();
        int monsterHP = monster.getHealth();

        //player attacks first
        //monster attacks second

        while (playerHP > 0 && monsterHP > 0) {
            monsterHP -= playerAD;
            if (monsterHP < 0) monsterHP = 0;
            System.out.println("You attacked.\n"+monster.getName()+" HP: " + monsterHP);
            if (monsterHP == 0) break;
            playerHP -= monsterAD;
            System.out.println(monster.getName() + " attacked you.\nYour HP: " + playerHP);
        }

        //if player health <= 0
            //player lost

        if (playerHP <= 0) {
            System.out.println("Your HP: " + playerHP + "\nYou lost.");
        }

        //if monster health <= 0
            //add monster gold + loot to player.
            //remove from list

        if (monsterHP == 0) {
            System.out.print("You slayed a " + monster.getName() + "\nYou obtained ");
            if (monster instanceof Vampire){
                Game.player.getInventory().setFirewood(true);
                System.out.println(" firewood.");
            }
            else if (monster instanceof Zombie){
                Game.player.getInventory().setFood(true);
                System.out.println(" food.");
            }
            else if (monster instanceof Bear){
                Game.player.getInventory().setWater(true);
                System.out.println(" water.");
            }
            Game.player.getInventory().setBalance(Game.player.getInventory().getBalance() + monster.getLoot());
            System.out.println("You gained " + monster.getLoot() + "G by slaying " + monster.getName());
            monsterList.remove(monster);
            Game.player.setHealth(playerHP);
        }


    }
}
