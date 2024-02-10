package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controls implements KeyboardHandler {

    Player myLittleObject;
    Keyboard myKeyboard;

    BugProjectile myBugProjectile;

    public Controls(Player myLittleObject) {
        this.myLittleObject = myLittleObject;
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
                myBugProjectile.bugProjectileMovement();
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
