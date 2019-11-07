package stickman.view;

import javafx.scene.layout.Pane;
import stickman.model.GameEngine;

import java.io.FileNotFoundException;

public interface BackgroundDrawer {
    void draw(GameEngine model, Pane pane) throws FileNotFoundException;
    void update(double xViewportOffset);
}
