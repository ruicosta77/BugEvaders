package io.codeforall.bootcamp.filhosdamain.gameArea;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {
    private Rectangle gameArea;
    private Picture backGround;
    private  int height;
    private  int width;
    public final int PADDING = 10;

    public Field (int width, int height) {
        this.height = height;
        this.width = width;
        gameArea = new Rectangle(PADDING,PADDING, this.height, this.width);
        backGround = new Picture(PADDING,PADDING,"BugEvaders/resources/background.jpg");
        gameArea.draw();
        backGround.draw();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
