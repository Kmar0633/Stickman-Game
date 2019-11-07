package stickman.model;

public interface MovableEntity extends Entity {
    void setXVelocity(double velX);
    void setYVelocity(double velY);
    void moveTick();
    void setStartingXPos(double XPos);
    void setStartingYPos(double YPos);

}
