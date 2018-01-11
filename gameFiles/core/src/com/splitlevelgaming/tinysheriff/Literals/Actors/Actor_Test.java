package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;

public class Actor_Test extends Actor{

  Actor_Test(Stage stage, int playerNumber, double x, double y, ToolBox toolBox){
    super(stage, playerNumber, x, y, 3, 4.5, "img_test_walking_1", toolBox);
  }

  @Override
  protected void checkCollisions(){

  }

  @Override
  protected void update(){
    ControllerInputHandler playerController = getPlayerController();
    if(playerController != null){
      super.update();
    }
  }

  @Override
  protected void updateSprite(){
    ControllerInputHandler playerController = getPlayerController();
    if(playerController != null){
      if(playerController.getVerticalAxis() != 0 || playerController.getHorizontalAxis() != 0){
        setAnimationThreshold(10);
        setAnimated(true);
      }
      if(playerController.getHorizontalAxis() > 0){
        imageMirrored = false;
      }
      if(playerController.getHorizontalAxis() < 0){
        imageMirrored = true;
      }
      else{
        setActiveSprite("img_test_walking_1");
        setAnimated(false);
      }
    }
    else{
      setAnimationThreshold(6);
      setAnimated(true);
      if(!imageMirrored){
        x+=.2;
      }
      else{
        x-=.2;
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
