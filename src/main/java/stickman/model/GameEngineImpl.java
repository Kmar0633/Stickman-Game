package stickman.model;



public class GameEngineImpl implements GameEngine {



    private GameConfiguration gameConfiguration;

    private LevelImpl level;


    /**
    *
    * Changes made to the uml diagram include more additions such as the height, YPos, XPos and velocities of different entities.
    * They are to accomodate the attributes and changes of each entity and allow the user to configure it and modify it through the JSOn file
   In the GameEngineImpl(String file) constructor, the JSON parser is reading from the JSON file and reading the variables nested there
   in order to initialise them into the global variables. Variables such as the height, YPos, XPos and Velocities are being read and intialised
    into the entities' (Hero,cloud and secondcloud) respective variables. An example of this would be having the "CharacterVelocity" variable in the JSON file
    be initialised as "CharacterVelocity" variable in the GameEngineImpl class. The constructor also reads the StickmanSize
   variable in the JSON file in order to modify the Hero's height and width based on the StickmanSize, the position of
    the hero on the level, as well as their jumplimits(how far they can jump before falling). An example of this is
    if the user were to configure the StickmanSize as "tiny" then the hero's height would be 30. New EntityImpl, CloudEntity and SecondCloudEntity
    objects as well as a List<Entity> object are also being initialised within the constructor, with their respective variables being passed in the objects.
    These new objects are being added into thr List<Entity>object.

    **/

    public GameEngineImpl(String file) {
        gameConfiguration=new GameConfiguration(file);
        level = new LevelImpl(gameConfiguration.getLevelHeight(), gameConfiguration.getLevelWidth(), gameConfiguration.getFloorHeight(), gameConfiguration.getHeroX(), gameConfiguration.getEntities() );

    }

    //  }
    public Level getCurrentLevel() {
        return level;

    }


    public void startLevel() {

    }

    /**
     *
     * jump() sets the jump variable to true and returns the jump variable to show the hero is jumping
     */
    // Hero inputs - boolean for success (possibly for sound feedback)
    public boolean jump() {

        return level.jump();

    }
    /**
     *
     * moveLeft() sets the left variable in EntityImpl to true and returns the left variable to show the hero is moving left.
     */

    public boolean moveLeft() {



        return level.moveLeft();

    }
    /**
     *
     * moveRight() sets the Right variable in EntityImpl to true and returns the right variable to show the hero is moving right
     */
    public boolean moveRight() {


        return level.moveRight();

    }

    /**
     *
     * stopMoving() sets the Right and left variables in EntityImpl to false and returns true
     */
    public boolean stopMoving() {


        return level.stopMoving();
    }

    /**
     * tick() In this method, the program checks on the Hero's Left, right and jump variables are true are responding to that accordingly.
     * the program checks if the hero's right variable is set to true and then if it is, it will cause the hero to move
     * right continously when the right key is pressed. if the hero's left variable is set to true, it will cause the hero to move to the left continously
     * when the left key is pressed. The HeroX variable is continiously updated so the camera can track along the changes in movement.
     *
     * the program also checks if the jump variable is true and if it is the hero will jump and fall when it reaches to a certain height
     * set by maxjumplimit and falling into min jumplimi. These variables were added to measure the jumplimits of each hero that corresponds to the size
     * of each of them while the minjumplimits indicate the height of which the character should fall in.

     *      *right continously.
     */

    public void tick() {
            level.tick();
    }
}



