package io.codeforall.bootcamp.filhosdamain;

import io.codeforall.bootcamp.filhosdamain.gameObject.BugProjectile;
import io.codeforall.bootcamp.filhosdamain.gameObject.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;

public class Controls implements KeyboardHandler {

    Player myLittleObject;
    Keyboard myKeyboard;

    public LinkedList<BugProjectile> bugs;

    BugProjectile myBugProjectile;

    public Controls(Player myLittleObject, LinkedList<BugProjectile> bugProjectiles) {
        this.myLittleObject = myLittleObject;
        this.bugs = bugProjectiles;
        init();
    }

    public void init() {
        myKeyboard = new Keyboard(this);

        KeyboardEvent pressedRight = new KeyboardEvent();
        pressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedRight.setKey(KeyboardEvent.KEY_RIGHT);
        myKeyboard.addEventListener(pressedRight);

        KeyboardEvent pressedLeft = new KeyboardEvent();
        pressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedLeft.setKey(KeyboardEvent.KEY_LEFT);
        myKeyboard.addEventListener(pressedLeft);

        KeyboardEvent pressedSpace = new KeyboardEvent();
        pressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedSpace.setKey(KeyboardEvent.KEY_SPACE);
        myKeyboard.addEventListener(pressedSpace);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                myLittleObject.moveRight();
                break;
            case KeyboardEvent.KEY_LEFT:
                myLittleObject.moveLeft();
                break;
            case KeyboardEvent.KEY_SPACE:
                myBugProjectile = new BugProjectile();
                bugs.add(myBugProjectile);
                myBugProjectile.moveUp();
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
