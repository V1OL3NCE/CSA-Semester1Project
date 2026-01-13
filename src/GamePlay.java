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
            System.out.println("You are on stage " + stage);
            System.out.println("You have encountered an enemy");
            while (!enemy.isDead() && !player.isDead()) {

                System.out.println("Enemy hp is " + enemy.getHp());
                System.out.println("Press enter to attack");
                scan.nextLine();
                enemy.setHp(enemy.getHp() - player.getAtk());
                System.out.println("Enemy's hp is now " + enemy.getHp());
                if (enemy.isDead()) {
                    System.out.println("You have defeated the enemy!");
                    stage++;
                } else {
                    System.out.println("Enemy attacks");
                    player.setHp(player.getHp() - enemy.getAtk());
                    System.out.println("Your hp is now " + player.getHp());
                    if (player.isDead()) {
                        System.out.println("You have died!");
                        System.out.println("returning to previous stage");
                        stage--;
                    }
                }
            }
            enemy.setMaxHp(enemy.getMaxHp() + 3);
            enemy.setHp(enemy.getMaxHp());

        }
    }


    public boolean isGameOver() {
        return stage >= 60;
    }

}
