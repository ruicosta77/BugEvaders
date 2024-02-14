package io.codeforall.bootcamp.filhosdamain.gameObject;

import io.codeforall.bootcamp.filhosdamain.gameArea.Field;

import java.util.ArrayList;

public class EnemiesFactory {


    public static void getNewEnemy(ArrayList<Enemy> arraylist) {
        Enemy enemies;
        int random = (int) (Math.random() * 3);
        switch (random){
            case 0:
                arraylist.add(new SmallEnemy(100, 300));
                arraylist.add(new SmallEnemy(450, 300));
                arraylist.add(new SmallEnemy(900, 300));

                arraylist.add(new SmallEnemy(200, 450));
                arraylist.add(new SmallEnemy(550, 450));
                arraylist.add(new SmallEnemy(800, 400));

                arraylist.add(new SmallEnemy(700, 600));
                arraylist.add(new SmallEnemy(650, 600));
                arraylist.add(new SmallEnemy(300, 600));


                break;
            case 1:
                arraylist.add(new SmallEnemy(50, 300));
                arraylist.add(new SmallEnemy(500, 300));
                arraylist.add(new SmallEnemy(950, 300));

                arraylist.add(new SmallEnemy(150, 450));
                arraylist.add(new SmallEnemy(550, 450));
                arraylist.add(new SmallEnemy(800, 400));

                arraylist.add(new SmallEnemy(300, 600));
                arraylist.add(new SmallEnemy(600, 600));
                arraylist.add(new SmallEnemy(900, 600));
                break;
            case 2:
                arraylist.add(new SmallEnemy(100, 300));
                arraylist.add(new SmallEnemy(450, 300));
                arraylist.add(new SmallEnemy(900, 300));

                arraylist.add(new SmallEnemy(150, 450));
                arraylist.add(new SmallEnemy(550, 450));
                arraylist.add(new SmallEnemy(800, 400));

                arraylist.add(new SmallEnemy(700, 600));
                arraylist.add(new SmallEnemy(650, 600));
                arraylist.add(new SmallEnemy(300, 600));
                break;
        }
    }
}
