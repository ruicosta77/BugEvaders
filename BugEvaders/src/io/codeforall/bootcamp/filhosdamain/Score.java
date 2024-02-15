package io.codeforall.bootcamp.filhosdamain;

import io.codeforall.bootcamp.filhosdamain.gameObject.Enemy;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.ArrayList;

public class Score {

    private String name;
    private int score = 2000;
    private static int highScore;
    private Text scoreText;
    private Text highScoreText;
    private ArrayList<Enemy> enemies;

    public Score(String name, ArrayList<Enemy> enemies) {
        this.name = name;
        this.enemies = enemies;

        scoreText = new Text(850, 80, "SCORE: ");
        highScoreText = new Text(850, 100, "HIGHSCORE: ");

        scoreText.setColor(Color.ORANGE);
        highScoreText.setColor(Color.ORANGE);

        scoreText.draw();
        highScoreText.draw();
    }
    public void updateScore() {
        setScore(score - 10);
        scoreText.setText("SCORE: " + score);
        if (score > highScore) {
            setHighScore(score);
            highScoreText.setText("HIGHSCORE: " + highScore);
        }
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static void setHighScore(int highScore) {
        Score.highScore = highScore;
    }

    public void delete() {
        scoreText.delete();
        highScoreText.delete();
    }
}
