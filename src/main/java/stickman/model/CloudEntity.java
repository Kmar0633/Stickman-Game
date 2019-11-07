package stickman.model;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

public class CloudEntity extends AbstractEntity implements MovableEntity {


    private double XPos;
    private double YPos;
    private double XVelocity;
    private double YVelocity;

    /** This cloud entity has the the open for Extension, Closed for Modification principle. This is because it is possible to create
     * a cloud superclass and ensure that it can extend it to subclass cloud entitiies that have different attributes and variables,
     * such as movement speed. This ensures that both cloud entities share the same methods as the superclass, making it less
     * redundant.
     *
    **/
    public CloudEntity(String CharacterImagePath, double XPos, double YPos, double Height, double Width, Layer layer){
//create an entity of level java
        //this.filename=file

        super(CharacterImagePath,XPos,YPos,Height,Width,layer);
        this.XPos=XPos;
        this.YPos=YPos;
    }

    public double getXPos(){
        return this.XPos;
    }
    public double getYPos(){
        return this.YPos;
    }

    @Override
    public Entity getBoundsLeft() {
        return null;
    }

    @Override
    public Entity getBoundsRight() {
        return null;
    }

    @Override
    public Entity getBoundsBottom() {
        return null;
    }

    @Override
    public Entity getBoundsTop() {
        return null;
    }


    public void setXVelocity(double XVelocity){
        this.XVelocity=XVelocity;
    }

    
    public void setYVelocity(double velY) {
        this.YVelocity=velY;
    }




    public void moveTick() {
        this.XPos=this.XPos+this.XVelocity;
    }


    public void setStartingXPos(double XPos){
        this.XPos=XPos;
    }


    public void setStartingYPos(double YPos) {
        this.YPos=YPos;
    }





}