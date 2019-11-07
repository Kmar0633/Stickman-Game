package stickman.model;


public interface HeroMovement {

    void setLeftTrue();

    void tick();

    
    void setRightFalse();

    void setLeftFalse();

    boolean getLeft();

    boolean getRight();

    void setRightTrue();

    void setJumpTrue();
    void setJumpFalse();
    boolean getJump();
    double getXPos();
    void setXVelocity(double XVel);

    void setXPos(double v);

    Entity getBoundsRight();

    Entity getBoundsLeft();

    Entity getBoundsBottom();

    void setYPos(double YPos);

    double getHeight();

    void setYVelocity(double YVel);

    void setFallTrue();

    void setCounter();

    void setMaxjumpheight();

    void setFall(boolean Fall);

    boolean getFall();

    void setonBlock(boolean onBlock);

    Entity getBoundsTop();
}
