package stickman.model;

public abstract class InteractableEntity extends AbstractEntity {
    private double XPos;
    private double YPos;
    private double Height;
    private double Width;
    private String ImagePath;
    private Entity.Layer layer;

    public InteractableEntity(String ImagePath, double XPos, double YPos, double Height, double Width, Layer layer){
        super(ImagePath,XPos,YPos,Height,Width,layer);

    }
    public abstract Entity getBoundsRight();
    public abstract Entity getBoundsLeft();
    public abstract Entity getBoundsTop();
    public abstract Entity getBoundsBottom();

}