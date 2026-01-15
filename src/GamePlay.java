import java.util.Scanner;

public class GamePlay {
    private int stage;

    public GamePlay() {
        stage = 1;
    }

    public void play() {
        Player player = new Player();
        Scanner scan = new Scanner(System.in);
        Enemy enemy = new Enemy();
        while (!isGameOver()) {

            while (!isGameOver() && !enemy.isDead() && !player.isDead()) {//while both are still alive
                if (enemy.getHp() == enemy.getMaxHp()) {
                    System.out.println("STAGE " + stage + "!");
                    System.out.println("You have encountered an enemy!");
                }
                //print out stats
                System.out.println("PLAYER STATS -> hp: " + player.getHpRounded() + "| def: " + player.getDefRounded() + "| atk: " + player.getAtkRounded());
                System.out.println("ENEMY STATS  -> hp: " + enemy.getHpRounded() + "| def: " + enemy.getDefRounded() + "| atk: " + enemy.getAtkRounded());
                System.out.println("Press enter to attack");
                scan.nextLine();
                if (player.getAtk() > enemy.getDef()) {//if not, then atk will not do dmg
                    enemy.setHp(enemy.getHp() - (player.getAtk() - enemy.getDef()));//decrease enemy hp by the difference between player atk and enemy def
                }
                System.out.println("Enemy's hp is now " + enemy.getHpRounded());
                //if enemy is dead, go to next stage
                if (enemy.isDead()) {
                    System.out.println("You have defeated the enemy!");
                    stage++;
                    //increases enemy hp by 3 and player hp by 5
                    enemy.setMaxHp(enemy.getMaxHp() + 3);
                    enemy.setHp(enemy.getMaxHp());
                    player.setMaxHp(player.getMaxHp() + 5);
                    player.setHp(player.getMaxHp());
                    //increase enemy attack by .5 and player attack by 1
                    enemy.setAtk(enemy.getAtk() + .5);
                    player.setAtk(player.getAtk() + 1);
                    //increase enemy def by .2 and player def by .4
                    enemy.setDef(enemy.getDef() + .2);
                    player.setDef(player.getDef() + .4);
                //enemy is not dead and will now attack player
                } else {
                    System.out.println("Enemy attacks");
                    if (enemy.getAtk() > player.getDef()) {//if not, then atk will not do dmg
                        player.setHp(player.getHp() - (enemy.getAtk() - player.getDef()));//decrease player hp by the difference between enemy atk and player def
                    }
                    System.out.println("Your hp is now " + player.getHpRounded());
                    //if player is dead then go back to previous stage
                    if (player.isDead()) {
                        System.out.println("You have died!");
                        System.out.println("returning to previous stage");
                        stage--;
                    }
                }
            }
        }
        System.out.println("Game over! YOU WIN!");
        System.out.println("-----------");
        System.out.println("Your stats:");
        System.out.println("HP: " + player.getHpRounded());
        System.out.println("DEF: " + player.getDefRounded());
        System.out.println("ATK: " + player.getAtkRounded());
    }


    public boolean isGameOver() {
        return stage >= 10;
    }

}
