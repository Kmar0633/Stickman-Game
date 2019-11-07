package stickman.model;

public abstract class AbstractEntity implements Entity {
    private double YPos;
    private String CharacterImagePath;
    private double XPos;

    private double Height;
    private double Width;
    private Layer layer;
    public AbstractEntity(String CharacterImagePath, double XPos, double YPos, double Height, double Width, Layer layer){

        this.CharacterImagePath=CharacterImagePath;

        this.XPos=XPos;
        this.YPos=YPos;
        this.Height=Height;
        this.Width=Width;
        this.layer=layer;
    }
    public String getImagePath(){

        return CharacterImagePath;
    }
    public double getXPos(){
        return this.XPos;
    }
    public double getYPos(){
        return this.YPos;
    }
    public void setXPos(double XPos){
        this.XPos=XPos;
    }
    public double getHeight(){
        return this.Height;
    }
    public double getWidth(){
        return this.Width;
    }
    public Layer getLayer(){
        return this.layer;
    }



}

