package stickman.model;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

public class CheckpointEntity extends InteractableEntity {



    private final String CharacterImagePath;
    private final Layer layer;
    private final double Width;
    private final double Height;
    private double XPos;
    private double YPos;
    private double XVelocity;
    private double YVelocity=0;
    private int counter=0;
    private double FixedXPos;
    private double FixedYPos;
    private boolean Alive=true;

    /** This cloud entity has the the open for Extension, Closed for Modification principle. This is because it is possible to create
     * a cloud superclass and ensure that it can extend it to subclass cloud entitiies that have different attributes and variables,
     * such as movement speed. This ensures that both cloud entities share the same methods as the superclass, making it less
     * redundant.
     *Aaa
     **/
    public CheckpointEntity(String CharacterImagePath, double XPos, double YPos, double Height, double Width, Layer layer){
//create an entity of level java
        //this.filename=file

        super(CharacterImagePath,XPos,YPos,Height,Width,layer);

        this.FixedXPos=XPos;
        this.CharacterImagePath=CharacterImagePath;
        this.FixedYPos=YPos;
        this.XPos=XPos;
        this.YPos=YPos;
        this.Height=Height;
        this.Width=Width;
        this.layer=layer;
    }

    public double getXPos(){
        return this.XPos;
    }
    public double getYPos(){
        return this.YPos;
    }
    public void setXVelocity(double XVelocity){
        this.XVelocity=XVelocity;
    }


    public void setYVelocity(double velY) {
        this.YVelocity=velY;
    }


    public void moveTick() {


    }

    @Override
    public Entity getBoundsBottom() {
        return null;
    }


    public void setStartingXPos(double XPos){
        this.XPos=XPos;
    }


    public void setStartingYPos(double YPos) {
        this.YPos=YPos;
    }

    public CheckpointEntity getBoundsRight(){
        return new CheckpointEntity(CharacterImagePath,this.XPos+(this.Width-(this.Width*0.15f)),this.YPos,
                this.Height,this.Width*0.15f,this.layer );
    }
    public CheckpointEntity getBoundsLeft(){
        return new CheckpointEntity(CharacterImagePath,this.XPos,this.YPos,
                this.Height,this.Width*0.15f,this.layer );
    }
    public CheckpointEntity getBoundsTop(){
        return new CheckpointEntity(CharacterImagePath,this.XPos,this.YPos,
                this.Height/2,this.Width-(this.Width*0.01f), this.layer);
    }
}




