package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;

public class Actor_Test extends Actor{

  Actor_Test(Stage stage, int playerNumber, double x, double y, ToolBox toolBox){
    super(stage, playerNumber, x, y, 1.5, 3, "img_test_walking_1", toolBox);
    setMovementMultiplier(.12);
  }

  @Override
  protected void checkCollisions(){

  }

  @Override
  protected void updateSprite(){
    InputHandler playerController = getPlayerController();
    if(playerController != null){
      if(playerController.getVerticalAxis() != 0 || playerController.getHorizontalAxis() != 0){
        setAnimationThreshold(10);
        setAnimated(true);
      }
      else{
        setActiveSprite("img_test_walking_1");
        setAnimated(false);
      }
      if(playerController.getHorizontalAxis() > 0){
        imageMirrored = false;
      }
      if(playerController.getHorizontalAxis() < 0){
        imageMirrored = true;
      }
    }
    else{
      setAnimationThreshold(6);
      setAnimated(true);
      if(!imageMirrored){
        x+=.15;
      }
      else{
        x-=.15;
      }
      if(!imageMirrored && x+width > 32){
        imageMirrored = true;
      }
      if(imageMirrored && x < 0){
        imageMirrored = false;
      }
    }
    if(animated){
      incrementAnimationStep();
    }
  }
}
