package stickman.view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import stickman.model.Entity;
import stickman.model.GameEngine;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.ImageView;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;


import javafx.animation.KeyValue;
import stickman.model.GameEngineImpl;

public class BlockedBackground implements BackgroundDrawer {
    private Rectangle sky;
    private Rectangle floor;
    private Pane pane;
    private GameEngine model;
    final Timeline timeline = new Timeline();
    final Timeline secondtimeline = new Timeline();
   // public Entity entry= new Entity("file:src/main/resources/ch_stand2.png",100, 100, 100,100, Entity.Layer.FOREGROUND);
    //public GameEngineImpl character=new GameEngineImpl();

  //  public KeyboardInputHandler paddleMovement = new KeyboardInputHandler(character);
    @Override
    public void draw(GameEngine model, Pane pane)  {
        this.model = model;
        this.pane = pane;

        double width = pane.getWidth();
        double height = pane.getHeight();
try{
        double floorHeight = model.getCurrentLevel().getFloorHeight();
    //URL url = getClass().getResource("/drawIcon.png");
    //Image image = ImageIO.read(url);
        Image pic= new Image(new FileInputStream("src/main/resources/cloud_2.png"));
        ImageView Cloud = new ImageView(pic);
        Cloud.setX(-20);
        Cloud.setY(70);
        Image picture= new Image(new FileInputStream("src/main/resources/cloud_2.png"));
    ImageView SecondCloud = new ImageView(picture);
    SecondCloud.setX(0);
    SecondCloud.setY(120);

   // Image character= new Image(new FileInputStream("file:src/main/resources/ch_stand2.png"));
   // ImageView player = new ImageView(picture);
  //  player.setX(20);
 //   player.setY(20);
 //   player.setOnKeyPressed();
       timeline.setCycleCount(Timeline.INDEFINITE);
       timeline.setAutoReverse(false);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(4500), new KeyValue (Cloud.translateXProperty(), 650)));
         timeline.play();
       secondtimeline.setCycleCount(Timeline.INDEFINITE);
       secondtimeline.setAutoReverse(false);
        secondtimeline.getKeyFrames().add(new KeyFrame(Duration.millis(5000), new KeyValue (SecondCloud.translateXProperty(), 650)));
        secondtimeline.play();





    this.sky = new Rectangle(0, 0, width, floorHeight);
        sky.setFill(Paint.valueOf("LIGHTBLUE"));
        sky.setViewOrder(1000.0);

        this.floor = new Rectangle(0, floorHeight, width, height - floorHeight);
        floor.setFill(Paint.valueOf("GREEN"));
        floor.setViewOrder(1000.0);

        pane.getChildren().addAll(sky, floor);
}
catch(FileNotFoundException e){

}
    }

    @Override
    public void update(double xViewportOffset) {
        // do nothing since this is a static bg
    }
}
