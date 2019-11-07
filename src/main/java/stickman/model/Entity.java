package stickman.model;

public interface Entity {
    String getImagePath();
    double getXPos();
    double getYPos();
    double getHeight();
    double getWidth();
    Layer getLayer();

    Entity getBoundsLeft();

    Entity getBoundsRight();

    Entity getBoundsBottom();

    Entity getBoundsTop();


    enum Layer{
        BACKGROUND, FOREGROUND, EFFECT
    }
}
