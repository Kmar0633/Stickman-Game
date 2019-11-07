package stickman.view;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import stickman.model.Entity;
import stickman.model.GameEngine;
import stickman.model.GameEngineImpl;
import stickman.model.Hero;

import java.awt.event.InputEvent;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KeyboardInputHandler<K extends InputEvent> {
    private final GameEngineImpl model;
    private boolean left = false;
    private boolean right = false;
    private Entity entry;
    private Set<KeyCode> pressedKeys = new HashSet<>();

    private Map<String, MediaPlayer> sounds = new HashMap<>();

    public KeyboardInputHandler(GameEngineImpl model) {
        this.model = model;

        URL mediaUrl = getClass().getResource("/jump.wav");
        String jumpURL = mediaUrl.toExternalForm();

        Media sound = new Media(jumpURL);
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        sounds.put("jump", mediaPlayer);
    }

    void handlePressed(KeyEvent keyEvent) {
        if (pressedKeys.contains(keyEvent.getCode())) {
            return;
        }
        pressedKeys.add(keyEvent.getCode());

        if (keyEvent.getCode().equals(KeyCode.UP)) {
            if (model.jump()) {
                MediaPlayer jumpPlayer = sounds.get("jump");
                jumpPlayer.stop();
                jumpPlayer.play();
            }
        }

        if (keyEvent.getCode().equals(KeyCode.LEFT)) {

           //entry.XPos = entry.XPos + 5;
            left = true;
           // model.moveLeft();
        }
        else if (keyEvent.getCode().equals(KeyCode.RIGHT)) {
            right = true;

        } else {
            return;
        }

        if (left) {
            if (right) {
                model.stopMoving();
            } else {

                    model.moveLeft();

            }
        } else if(right){
            model.moveRight();
        }
    }

    void handleReleased(KeyEvent keyEvent) {
        pressedKeys.remove(keyEvent.getCode());

        if (keyEvent.getCode().equals(KeyCode.LEFT)) {
            left = false;
        }
        else if (keyEvent.getCode().equals(KeyCode.RIGHT)) {
            right = false;
        } else {
            return;
        }

        if (!(right || left)) {
            model.stopMoving();
        } else if (right) {
            model.moveRight();
        } else {
            model.moveLeft();
        }
    }
}
