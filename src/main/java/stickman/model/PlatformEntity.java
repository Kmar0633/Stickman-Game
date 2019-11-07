package stickman.model;

public class PlatformEntity extends InteractableEntity {
    private double XPos;
    private double YPos;
    private double Height;
    private double Width;
    private String ImagePath;
    private Entity.Layer layer;
    public PlatformEntity(String ImagePath, double XPos, double YPos, double Height, double Width, Layer layer){
//create an entity of level java
        //this.filename=file

        super(ImagePath,XPos,YPos,Height,Width,layer);
        this.ImagePath=ImagePath;

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
    public PlatformEntity getBoundsRight(){
        return new PlatformEntity(ImagePath,this.XPos+(this.Width-(this.Width*0.15f)),this.YPos,
                this.Height,this.Width*0.15f,this.layer );
    }
    public PlatformEntity getBoundsLeft(){
        return new PlatformEntity(ImagePath,this.XPos,this.YPos,
                this.Height,this.Width*0.15f,this.layer );
    }
    public PlatformEntity getBoundsTop(){
        return new PlatformEntity(ImagePath,this.XPos,this.YPos,
                this.Height/2,this.Width-(this.Width*0.01f), this.layer);
    }
    public PlatformEntity getBoundsBottom(){
        return new PlatformEntity(ImagePath,this.XPos,this.YPos+(this.Height/2),
                this.Height/2,this.Width-(this.Width*0.01f), this.layer ) ;
    }




}
