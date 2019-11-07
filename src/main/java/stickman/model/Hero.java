
/**
 This Entity Implementation file implements the entity interface  and the functions of the methods of this class is to modify the attributes and variables
 of the hero of this game. All three classes (CloudEntity,EntityImpl and SecondCloudEntity) implement the Entity interface
 and the descriptions and functions for each method are similar for all three.



 */
package stickman.model;

//import jdk.nashorn.internal.parser.JSONParser;
//import jdk.nashorn.internal.parser.JSONParser;


public class Hero extends AbstractEntity implements HeroMovement{

    private double YPos;
    private String CharacterImagePath;
    private double XPos;
    private double CurrentYPos;
    private double Height;
    private double Width;
    private boolean onBlock=false;
    private boolean left = false;
    private boolean right = false;
    private boolean jump = false;
    private boolean Fall =false;
    private boolean maxjumpheight=false;
    private double counter=0;
    private double count=0.5;
    private double MaxJumpLimit;
    private double MinJumpLimit;
    private Entity.Layer layer;
    private double XVel;
    private double FixedYPos;
  //  private
    private double YVel=0;
    /** This class applies the single Responsibility Principle from SOLID due to the fact that this class has a single responsibility
     * of both modifying the attributes of the EntityImpl object as well as returning them. Each class that implements the Entity
     * interfaces share the same responsibility.
     * **/
    public Hero(String CharacterImagePath, double XPos, double YPos, double Height, double Width, Entity.Layer layer){
//create an entity of level java
        //this.filename=file
        super(CharacterImagePath,XPos,YPos,Height,Width,layer);
        this.CharacterImagePath=CharacterImagePath;

        this.XPos=XPos;
        this.FixedYPos=YPos;
        this.YPos=YPos;
        this.Height=Height;
        this.Width=Width;
        this.layer=layer;
        if(this.Height==30 && this.Width==20){
            this.MaxJumpLimit=345;
            this.MinJumpLimit=300;
        }
        else if(this.Height==60 && this.Width==40){
            this.MaxJumpLimit=315;
            this.MinJumpLimit=200;
        }
        else if(this.Height==90 && this.Width==60){
            this.MaxJumpLimit=315;
            this.MinJumpLimit=200;
        }
        else if(this.Height==120 && this.Width==80){
            this.MaxJumpLimit=255;
            this.MinJumpLimit=130;
        }

    }
    public String getImagePath(){

        return CharacterImagePath;
    }
    public void setonBlock(boolean onBlock){
        this.onBlock=onBlock;
    }
    public double getXPos(){
        return this.XPos;
    }
    public void setXPos(double XPos){
        this.XPos=XPos;

    }
    public double getYPos(){
        return this.YPos;
    }
    public double getHeight(){
        return this.Height;
    }


    public void setYVelocity(double YVel) {
        this.YVel=YVel;
    }






    public void setFallTrue(){
        this.Fall=true;
}

    @Override
    public void setCounter() {

    }

    public double getWidth(){
        return this.Width;
    }
    public boolean getonBlock(){
        return this.onBlock;
    }

    public Entity.Layer getLayer(){
        return layer;
    }
    /**

    /**
     * isLeftTrue() returns the "Left" variable and returns a true or false value, wether or not the entity is moving left.
     * */
    public boolean getLeft(){
        return left;
    }
    /**
     * isRightTrue() returns the "Right" variable and returns a true or false value, wether or not the entity is moving right.
     * */
    public boolean getRight(){
        return right;
    }
    /**
     * setLeftTrue() sets the "Left" variable as true and indicates the entity is moving left.
     * */
    public void setLeftTrue(){
        left=true;
    }
    /**
     * setRightTrue() sets the "Right" variable as true and indicates the entity is moving right.
     * */
    public void setRightTrue(){
        right=true;
    }
    /**
     * setLeftFalse() sets the "Left" variable as false and indicates the entity is not moving left.
     * */
    public void setLeftFalse(){
        left=false;
    }
    /**
     * setRightFalse() sets the "Right" variable as false and indicates the entity is not moving right.
     * */
    public void setRightFalse(){
        right=false;
    }

    public void setJumpTrue(){
        jump=true;
    }
    public void setJumpFalse(){
        jump=false;
    }
    public boolean getJump(){
        return jump;
    }
    public void setXVelocity(double XVel){
        this.XVel=XVel;
    }
    public void setMaxjumpheight(){
        maxjumpheight=true;
    }

    public boolean getFall(){
        return this.Fall;
    }


    public Hero getBoundsRight(){
        return new Hero(CharacterImagePath,this.XPos+(this.Width-(this.Width*0.15f)),this.YPos,
                this.Height,this.Width*0.15f,layer );
    }

    public Hero getBoundsTop(){
        return new Hero(CharacterImagePath,this.XPos,this.YPos,
                this.Height/2,this.Width-(this.Width*0.01f), this.layer);
    }

    public Hero getBoundsLeft(){
        return new Hero(CharacterImagePath,this.XPos,this.YPos,
                this.Height,this.Width*0.15f,layer );
    }
    public Hero getBoundsBottom(){
        return new Hero(CharacterImagePath,this.XPos,this.YPos+(this.Height/2),
                this.Height/2,this.Width-(this.Width*0.01f), this.layer);
    }

    public void setFall(boolean Fall){
        this.Fall=Fall;
    }
    public void setYPos(double YPos) {
            this.YPos=YPos;
    }

    public void setCounter(double count){
        this.count=count;
    }
    public void tick(){

        if (right== true) {

            XPos=XPos+1;
        }

        if (left== true) {
            if(XPos>=0) {
                XPos = XPos - 1;
            }
        }



        if(jump==true && Fall==false) {
            if(this.counter>20){
                this.YVel=-1;
                this.Fall=true;
                this.counter=0;
            }

            this.counter = this.counter + 1;


        }

        YPos = YPos - YVel;

        if(this.YPos>(this.FixedYPos) ){
            this.YPos=this.FixedYPos;
            this.YVel=0;
            this.jump=false;
            this.Fall=false;

        }

       // XPos=XPos+3.2;

    }
}
