package io.codeforall.bootcamp.filhosdamain.gameObject;

import io.codeforall.bootcamp.filhosdamain.gameArea.Field;

import java.util.ArrayList;

public class EnemiesFactory {


    public static void getNewEnemy(ArrayList<Enemy> arraylist) {
        //Enemy enemies;
        int random = (int) (Math.random() * 3);
        switch (random){
            case 0:
                arraylist.add(new SmallEnemy(450, 50));
                arraylist.add(new SmallEnemy(400, 200));
                arraylist.add(new SmallEnemy(300, 400));
                break;
            case 1:
                arraylist.add(new SmallEnemy(20, 50));
                arraylist.add(new SmallEnemy(400, 50));
                arraylist.add(new SmallEnemy(550, 50));
                break;
            case 2:
                arraylist.add(new SmallEnemy(10, 50));
                arraylist.add(new SmallEnemy(200, 250));
                arraylist.add(new SmallEnemy(500, 60));
                break;
        }
    }
}
