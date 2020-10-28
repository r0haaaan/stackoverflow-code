package in.rohaan;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class games {
    public static Random rd = new Random();

    public static void main(String[] args) {

        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
// enemies
        enemies.add(new Enemy(1, "jarda", 2, 3));
        enemies.add(new Enemy(2, "pepa", 2, 3));
        enemies.add(new Enemy(3, "Palpatine", 10, 3));
        enemies.add(new Enemy(4, "Darth Vader", 9, 10));

        System.out.println("Current Enemy: " + getRandomEnemy(enemies).název);
        System.out.println("Current Enemy: " + getRandomEnemy(enemies).název);
        System.out.println("Current Enemy: " + getRandomEnemy(enemies).název);
        System.out.println("Current Enemy: " + getRandomEnemy(enemies).název);
    }

    private static Enemy getRandomEnemy(final List<Enemy> enemies) {
        int randomEnemyIndex = rd.nextInt(enemies.size());
        return enemies.get(randomEnemyIndex);
    }
}