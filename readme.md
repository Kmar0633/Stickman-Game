# Stickman Game

## Instructions to run the program:

Go to your terminal and type in the path of the program so that you will go to the local project directory and type "gradle run" to run the program in gradle. Use 'gradle build' to build the program. The program can also be run using gradle run and gradle build within Intellij.

## Location of JSON file:
The JSON file is located in "file:src/main/java/stickman/model/StickmanModel.json"

## Configuration of JSON file:
The JSON file is broken down into several sections while contains the levels of the game that can be loaded
in GameConfiguration. Each level also contains information about the entities of the game.
Each Entity is further divided into subsections such as "XVelocity","YVelocity","Height"
,"Width","XPos" and "YPos" which are the X-axis velocities, Y-axis velocities, Height
,Width, X-axis Position of the Entity as well as the Y-axis Position of the entity.
The file can be configured and edited and the java class that parses the information
in GameConfiguration.

## Screenshots of the game

## How to play:
Click the left arrow button to make the player move left and click the right arrow button to make the player more right.
Player can collide with the blocks and can land on it. However, if the player makes contact with the enemy (slimes)
on the left or right side then it will reset to its original, if the player jumps on it then it disappears.
The player wins by reaching the door at the end of the level, ending the game.



## Coding Style:
I used the google java style and followed its guidlines:

## Acknowledgements:

I based my intersection functions on this code
https://stackoverflow.com/questions/49914153/java-collision-detection-glitch


https://google.github.io/styleguide/javaguide.html?fbclid=IwAR0YpBXPZcd6EcDW3y4zfcMV5vtIEaES9Td7pJi55AFauAnDwtSQJ5sLSuQ#s3-source-file-structure
