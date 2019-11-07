package stickman.model;

import stickman.view.EntityViewImpl;

import java.util.ArrayList;
import java.util.List;

public class LevelImpl implements Level{


    private double Height;
    private MonsterEntity FirstMonster;
private double Width;
private double FloorHeight;
private double HeroX;
//private List<Entity> Entities;
private HeroMovement Hero;
private List<Entity> Entities;
private CloudEntity SecondCloud;
private CloudEntity Cloud;
private double TimeElapsed=0;
private CheckpointEntity CheckpointEntity;
private PlatformEntity FirstPlatform;
private MonsterEntity SecondMonster;
private MonsterEntity InvisiMonster;
private List<MovableEntity> MovableEntities=new ArrayList<MovableEntity>();
private List<Entity> EntitiesToRemove=new ArrayList<Entity>();
private EntityViewImpl entityviewimpl;
private List<MonsterEntity> MonsterEntities=new ArrayList<MonsterEntity>();
private List<Entity> PlatformEntities=new ArrayList<Entity>();
private boolean Win=false;

    public LevelImpl(double Height,double Width, double FloorHeight,double HeroX,List<Entity> Entities){
//initialise entity there

        this.Height=Height;
        this.Width=Width;
        this.FloorHeight=FloorHeight;
        this.HeroX=HeroX;
        this.Entities=Entities;

      //  this.MovableEntities.addAll((MovableEntity)this.Entities);
        //this.MovableEntities=Entities;



        for(Entity entity:this.Entities){
            if(entity instanceof MonsterEntity){
                this.MonsterEntities.add((MonsterEntity)entity);
                this.MovableEntities.add((MovableEntity)entity);
            }
            if(entity instanceof PlatformEntity){
                this.PlatformEntities.add(entity);
            }
            if(entity instanceof Hero){
                this.MovableEntities.remove(entity);
                this.Hero= (HeroMovement) entity;
            }
            if(entity instanceof CheckpointEntity){
                this.MovableEntities.remove(entity);
                this.CheckpointEntity=(CheckpointEntity) entity;
            }
            if(entity instanceof CloudEntity){
                this.MovableEntities.add((MovableEntity)entity);

            }
        }

        this.SecondCloud= (CloudEntity) Entities.get(1);
        this.Cloud=(CloudEntity) Entities.get(2);
      this.FirstPlatform=(PlatformEntity) Entities.get(3);

    }
    public double getHeight(){
        return this.Height;
    }
    public double getWidth(){
        return this.Width;
    }

    public void tick() {
        //HeroMovement entry;

        HeroX = Hero.getXPos();

        if(SecondCloud.getXPos()>HeroX+550){
            SecondCloud.setStartingXPos(HeroX-350);
        }

        if(Cloud.getXPos()>HeroX+600){
            Cloud.setStartingXPos(HeroX-400);
        }

        if (this.Win==false) {

        checkCollisions();
        for(MovableEntity entity: MovableEntities){
            entity.moveTick();
        }

        //   HeroX=HeroX+0.5;

             Hero.tick();

         }
        else{
            System.out.println("Time Elapsed: "+(TimeElapsed/100)+" Seconds");
            //System.exit(0);
        }
        TimeElapsed=TimeElapsed+1;
        // HeroX=HeroX+1;
            // Width=Width+50;
        }

    //updating the frames and the world in real time
    public double getFloorHeight(){
        return FloorHeight;
    }
    public double getHeroX(){

        return HeroX;
    }



    enum Layer{
        BACKGROUND, FOREGROUND, EFFECT
    }
    public boolean jump(){
        if(Hero.getJump()==false && Hero.getFall()==false) {
           // Hero.setYVel(0);
            Hero.setJumpTrue();
            Hero.setYVelocity(2.5);

            //this.Hero.setFall(false);
            Hero.setFall(false);

        }
        return Hero.getJump();
    }
    public boolean moveLeft(){
      // HeroX=HeroX+1;

        Hero.setLeftTrue();

        return Hero.getLeft();
    }

    public boolean moveRight(){
        Hero.setRightTrue();
        return Hero.getRight();

    }
    public boolean stopMoving(){
        Hero.setLeftFalse();
        Hero.setRightFalse();
        return true;
    }
    public boolean aabbintersect(Entity box1,Entity box2){
        return (box1.getXPos() < (box2.getXPos() + box2.getWidth() ) ) &&
                ((box1.getXPos() + box1.getWidth()) > box2.getXPos()) &&
         (box1.getYPos() < (box2.getYPos() + box2.getHeight())) &&
                ((box1.getYPos() + box1.getHeight()) > box2.getYPos());
    }
    public void checkCollisions() {

        checkCheckpointCollisions();
        checkMonsterCollisions();
        checkPlatformCollisions();


    }
    public void checkPlatformCollisions(){
        for (Entity platformEntity : PlatformEntities) {
            if (aabbintersect(Hero.getBoundsRight(), platformEntity.getBoundsLeft())) {
                this.Hero.setXPos(platformEntity.getXPos() - ((Entity) Hero).getWidth());

            }

            else if (aabbintersect(Hero.getBoundsLeft(), platformEntity.getBoundsRight())) {
                this.Hero.setXPos(platformEntity.getXPos() + ((Entity) Hero).getWidth());


            }
            else if (aabbintersect(Hero.getBoundsTop(), platformEntity.getBoundsBottom())) {
                this.Hero.setYPos(platformEntity.getYPos() + ((Entity) Hero).getHeight());
                this.Hero.setYVelocity(0);
                //  this.Hero.set
                //   this.Hero.setXVelocity(0);

            }
            else if (aabbintersect(Hero.getBoundsBottom(), platformEntity.getBoundsTop())) {
                this.Hero.setYPos(platformEntity.getYPos() - this.Hero.getHeight());
                this.Hero.setJumpFalse();
              //  this.Hero.setFall(false);
                this.Hero.setonBlock(true);


                //  this.Hero.setYPos(320);

            }
            else{
                this.Hero.setonBlock(false);            }

        }
    }
    public void checkCheckpointCollisions(){
        if (aabbintersect(Hero.getBoundsRight(), CheckpointEntity.getBoundsLeft())) {
            Entities.remove(this.Hero);
            this.HeroX=this.Hero.getXPos();
            this.Win=true;

        }
    }
    public void checkMonsterCollisions(){
        for (Entity monsterEntity : MonsterEntities) {
            if (aabbintersect(Hero.getBoundsRight(), monsterEntity.getBoundsLeft())) {
                this.Hero.setXPos(20);
            }

            if (aabbintersect(Hero.getBoundsLeft(), monsterEntity.getBoundsRight())) {

                this.Hero.setXPos(20);

            }
            if (aabbintersect(Hero.getBoundsBottom(), monsterEntity.getBoundsTop())) {

                Entities.remove(monsterEntity);
                EntitiesToRemove.add(monsterEntity);

            }


        }
        MonsterEntities.removeAll(EntitiesToRemove);
    }

    public List<Entity> getEntities(){



            //entries.add(entry);


        return Entities;
    }
}
