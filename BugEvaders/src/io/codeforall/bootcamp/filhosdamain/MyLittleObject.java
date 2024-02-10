package io.codeforall.bootcamp.filhosdamain;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MyLittleObject {

    private Picture trackRace = new Picture(0,0,"resources/TrackRace.jpg");


    public MyLittleObject(){

        trackRace.draw();
    }
    public void moveRight(){
        trackRace.translate(10,0);
    }
    public void moveLeft(){
        trackRace.translate(-10,0);
    }
}
