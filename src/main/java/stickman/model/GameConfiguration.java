package stickman.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class GameConfiguration {
    private PlatformEntity SecondPlatform;
    private PlatformEntity FirstPlatform;
    private String HeroImagePath;
    private List<Entity> Entities;
    public double HeroXPos;
    private double HeroYPos;
    private double HeroHeight;
    private double HeroWidth;
    private double LevelHeight;
    private double LevelWidth;
    private double HeroX;
    private double FloorHeight;
    private Hero Hero;
    private MonsterEntity FirstMonster;
    private MonsterEntity SecondMonster;
    private MonsterEntity InvisiMonster;
    private String StickmanSize;

    private double CharacterVelocity;
    private double CloudVelocity;
    private CloudEntity Cloud;
    private double cloudXPos;
    private String cloudImagePath;
    private double cloudYPos;
    private double cloudHeight;
    private double cloudWidth;

    private double SecondCloudYPos;
    private double SecondCloudXVelocity;
    private double SecondCloudHeight;
    private double SecondCloudWidth;
    private String SecondCloudImagePath;
    private double SecondCloudXPos;

    private String FirstPlatformImagePath;
    private double FirstPlatformXPos;
    private double FirstPlatformYPos;
    private double FirstPlatformHeight;
    private double FirstPlatformWidth;

    private String SecondPlatformImagePath;
    private double SecondPlatformXPos;
    private double SecondPlatformYPos;
    private double SecondPlatformHeight;
    private double SecondPlatformWidth;

    private String FirstMonsterImagePath;
    private double FirstMonsterXPos;
    private double FirstMonsterYPos;
    private double FirstMonsterHeight;
    private double FirstMonsterWidth;
    private double FirstMonsterXVelocity;

    private String SecondMonsterImagePath;
    private double SecondMonsterXPos;
    private double SecondMonsterYPos;
    private double SecondMonsterHeight;
    private double SecondMonsterWidth;
    private double SecondMonsterYVelocity;

    private String CheckpointImagePath;
    private double CheckpointXPos;
    private double CheckpointYPos;
    private double CheckpointHeight;
    private double CheckpointWidth;
    private double CheckpointYVelocity;
    private CheckpointEntity Checkpoint;


    private CloudEntity secondcloud;;
    public GameConfiguration(String file){
        JSONParser obj = new JSONParser();

        try (FileReader readfile = new FileReader(file)) {
            Object object = obj.parse(readfile);
            JSONObject parse = (JSONObject) object;
            JSONObject newobj = (JSONObject) parse.get("EasyLevel");
            JSONObject cloud=(JSONObject) newobj.get("FirstCloud");
            JSONObject SecondCloud=(JSONObject) newobj.get("SecondCloud");
            JSONObject Stickman=(JSONObject) newobj.get("Stickman");
            JSONObject FirstPlatformObj=(JSONObject) newobj.get("FirstPlatform");
            JSONObject FirstMonsterObj=(JSONObject) newobj.get("FirstMonsterEntity");
            JSONObject SecondMonsterObj=(JSONObject) newobj.get("SecondMonsterEntity");
            JSONObject SecondPlatformObj=(JSONObject) newobj.get("SecondPlatform");
            JSONObject CheckpointEntityObj=(JSONObject) newobj.get("Checkpoint");
            HeroImagePath = (String) Stickman.get("ImagePath");
            HeroXPos = (double) Stickman.get("XPos");

          //  Map CloudValues= (Map)newobj.get("Cloud");
            CharacterVelocity=(double) Stickman.get("XVelocity");

            StickmanSize = (String) Stickman.get("Size");

            if(StickmanSize.equals("tiny")){
                HeroHeight=30;
                HeroWidth=20;
                HeroYPos=345;

                //FloorHeight=345;
            }
            else if(StickmanSize.equals("normal")){
                HeroHeight=60;
                HeroWidth=40;
                HeroYPos=315;

            }
            else if(StickmanSize.equals("large")){
                HeroHeight=90;
                HeroWidth=60;
                HeroYPos=285;

            }
            else if(StickmanSize.equals("giant")){
                HeroHeight=120;
                HeroWidth=80;
                HeroYPos=255;


            }
            LevelHeight = (double) newobj.get("LevelHeight");
            LevelWidth = (double) newobj.get("LevelWidth");
            FloorHeight = (double) newobj.get("FloorHeight");

            cloudImagePath = (String) cloud.get("ImagePath");
           cloudXPos = (double) cloud.get("XPos");
            cloudYPos = (double) cloud.get("YPos");
            cloudHeight = (double) cloud.get("Height");
            cloudWidth = (double) cloud.get("Width");
            CloudVelocity=(double) cloud.get("XVelocity");

            SecondCloudYPos=(double) SecondCloud.get("YPos");
            SecondCloudXVelocity= (double) SecondCloud.get("XVelocity");
            SecondCloudXPos = (double) SecondCloud.get("XPos");
            SecondCloudHeight = (double) SecondCloud.get("Height");
            SecondCloudWidth = (double) SecondCloud.get("Width");
            SecondCloudImagePath = (String) SecondCloud.get("ImagePath");

           FirstPlatformImagePath=(String)FirstPlatformObj.get("ImagePath");
            FirstPlatformXPos=(double)FirstPlatformObj.get("XPos");
            FirstPlatformYPos=(double)FirstPlatformObj.get("YPos");
            FirstPlatformHeight=(double)FirstPlatformObj.get("Height");
            FirstPlatformWidth=(double)FirstPlatformObj.get("Width");

            SecondPlatformImagePath=(String)SecondPlatformObj.get("ImagePath");
            SecondPlatformXPos=(double)SecondPlatformObj.get("XPos");
            SecondPlatformYPos=(double)SecondPlatformObj.get("YPos");
            SecondPlatformHeight=(double)SecondPlatformObj.get("Height");
            SecondPlatformWidth=(double)SecondPlatformObj.get("Width");

        //
            //    CloudVelocity=(double) newobj.get("CloudVelocity");
         //   SecondCloudVelocity= (double) newobj.get("SecondCloudVelocity");

            FirstMonsterXPos=(double)FirstMonsterObj.get("XPos");
            FirstMonsterYPos=(double)FirstMonsterObj.get("YPos");
            FirstMonsterHeight=(double)FirstMonsterObj.get("Height");
            FirstMonsterWidth=(double)FirstMonsterObj.get("Width");
            FirstMonsterImagePath=(String)FirstMonsterObj.get("ImagePath");
            FirstMonsterXVelocity=(double)FirstMonsterObj.get("XVelocity");

            SecondMonsterXPos=(double)SecondMonsterObj.get("XPos");
            SecondMonsterYPos=(double)SecondMonsterObj.get("YPos");
            SecondMonsterHeight=(double)SecondMonsterObj.get("Height");
            SecondMonsterWidth=(double)SecondMonsterObj.get("Width");
            SecondMonsterImagePath=(String)SecondMonsterObj.get("ImagePath");
            SecondMonsterYVelocity=(double)SecondMonsterObj.get("YVelocity");

            CheckpointImagePath=(String)CheckpointEntityObj.get("ImagePath");
            CheckpointXPos=(double)CheckpointEntityObj.get("XPos");
            CheckpointYPos=(double)CheckpointEntityObj.get("YPos");
            CheckpointHeight=(double)CheckpointEntityObj.get("Height");
            CheckpointWidth=(double)CheckpointEntityObj.get("Width");

            HeroX = (double) newobj.get("HeroX");
            Entities = new ArrayList<Entity>();


          //  FirstMonsterXPos=


            Hero = new Hero(HeroImagePath, HeroXPos, HeroYPos, HeroHeight, HeroWidth, Entity.Layer.FOREGROUND);

            Cloud = new CloudEntity(cloudImagePath, cloudXPos, cloudYPos, cloudHeight, cloudWidth, Entity.Layer.BACKGROUND);
            secondcloud = new CloudEntity(SecondCloudImagePath, SecondCloudXPos, SecondCloudYPos, SecondCloudHeight, SecondCloudWidth, Entity.Layer.BACKGROUND);
            FirstPlatform= new PlatformEntity(FirstPlatformImagePath,FirstPlatformXPos,FirstPlatformYPos,FirstPlatformHeight,FirstPlatformWidth,Entity.Layer.FOREGROUND);
          //  InvisiMonster=new MonsterEntity(FirstMonsterImagePath,FirstMonsterXPos,0,FirstMonsterHeight,FirstMonsterWidth,Entity.Layer.FOREGROUND);
            FirstMonster=new MonsterEntity(FirstMonsterImagePath,FirstMonsterXPos,FirstMonsterYPos,FirstMonsterHeight,FirstMonsterWidth,Entity.Layer.FOREGROUND);
            SecondMonster=new MonsterEntity(SecondMonsterImagePath,SecondMonsterXPos,SecondMonsterYPos,SecondMonsterHeight,SecondMonsterWidth,Entity.Layer.FOREGROUND);
            SecondPlatform=new PlatformEntity(SecondPlatformImagePath,SecondPlatformXPos,SecondPlatformYPos,SecondPlatformHeight,SecondPlatformWidth,Entity.Layer.FOREGROUND);
            Checkpoint=new CheckpointEntity(CheckpointImagePath,CheckpointXPos,CheckpointYPos,CheckpointHeight,CheckpointWidth,Entity.Layer.FOREGROUND);
            secondcloud.setXVelocity(SecondCloudXVelocity);
            Cloud.setXVelocity(CloudVelocity);
            FirstMonster.setXVelocity(FirstMonsterXVelocity);
            SecondMonster.setXVelocity(0);
            SecondMonster.setYVelocity(SecondMonsterYVelocity);
            Entities.add(Hero);
            Entities.add(Cloud);
            Entities.add(secondcloud);
            Entities.add(FirstPlatform);
            Entities.add(FirstMonster);
            Entities.add(SecondMonster);
        //    Entities.add(InvisiMonster);
            Entities.add(SecondPlatform);
            Entities.add(Checkpoint);
        }
        catch (FileNotFoundException e) {

        }
        catch (IOException e) {

        } catch (ParseException e) {

        }


    }

    public double getLevelHeight(){
        return LevelHeight;
    }
    public double getLevelWidth(){
        return LevelWidth;
    }
    public double getFloorHeight(){
        return FloorHeight;
    }
    public double getHeroX(){
        return HeroX;
    }
    public List<Entity>  getEntities(){
        return Entities;
    }

}
