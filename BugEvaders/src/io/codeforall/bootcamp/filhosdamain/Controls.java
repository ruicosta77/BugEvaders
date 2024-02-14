package io.codeforall.bootcamp.filhosdamain;

import io.codeforall.bootcamp.filhosdamain.gameObject.BugProjectile;
import io.codeforall.bootcamp.filhosdamain.gameObject.Mcs;
import io.codeforall.bootcamp.filhosdamain.gameObject.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;

public class Controls implements KeyboardHandler {

    private Player player;
    private boolean moveRight;
    private  boolean moveLeft;

    public Controls(Player player) {
        this.player = player;
        init();
    }

    private void init() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent rightEvent = new KeyboardEvent();
        rightEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightEvent.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(rightEvent);

        KeyboardEvent leftEvent = new KeyboardEvent();
        leftEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftEvent.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(leftEvent);

        KeyboardEvent spaceEvent = new KeyboardEvent();
        spaceEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spaceEvent.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(spaceEvent);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                player.moveRight();
                moveRight = true;
                moveLeft = false;
                break;
            case KeyboardEvent.KEY_LEFT:
                player.moveLeft();
                moveLeft = true;
                moveRight = false;
                break;

            case KeyboardEvent.KEY_SPACE:
                player.shoot();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
