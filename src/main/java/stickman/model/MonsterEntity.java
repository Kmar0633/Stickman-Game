package stickman.model;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

public class MonsterEntity extends InteractableEntity implements MovableEntity {


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
     *
     **/
    public MonsterEntity(String CharacterImagePath, double XPos, double YPos, double Height, double Width, Layer layer){
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
        if(this.XPos>(this.FixedXPos+10)) {
            this.XVelocity=-1;
           // this.counter=0;


        }
        if(this.XPos<(this.FixedXPos-10) ){
            this.XVelocity=1;
        }
       // this.counter=this.counter+1;
        if(this.YPos>(this.FixedYPos+10)) {
            this.YVelocity=-1;
            // this.counter=0;


        }
        if(this.YPos<(this.FixedYPos-10) ){
            this.YVelocity=1;
        }
        this.YPos=this.YPos+this.YVelocity;
         this.XPos=this.XPos+this.XVelocity;

       //     this.counter = this.counter + 1;

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

    public MonsterEntity getBoundsRight(){
        return new MonsterEntity(CharacterImagePath,this.XPos+(this.Width-(this.Width*0.15f)),this.YPos,
                this.Height,this.Width*0.15f,this.layer );
    }
    public MonsterEntity getBoundsLeft(){
        return new MonsterEntity(CharacterImagePath,this.XPos,this.YPos,
                this.Height,this.Width*0.15f,this.layer );
    }
    public MonsterEntity getBoundsTop(){
        return new MonsterEntity(CharacterImagePath,this.XPos,this.YPos,
                this.Height/2,this.Width-(this.Width*0.01f), this.layer);
    }




}