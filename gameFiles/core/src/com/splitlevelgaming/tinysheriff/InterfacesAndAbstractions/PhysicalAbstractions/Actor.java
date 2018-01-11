package com.splitlevelgaming.tinysheriff;

public abstract class Actor extends Prop{

  protected int playerNumber;
  protected boolean imageMirrored = false;

  Actor(Stage stage, int playerNumber, double x, double y, double width, double height, String activeSprite, ToolBox toolBox){
    super(stage, x, y, width, height, activeSprite, toolBox);
    this.playerNumber = playerNumber;
  }

  protected void update(){
    ControllerInputHandler playerController = getPlayerController();
      y += .2*playerController.getVerticalAxis();
      x += .2*playerController.getHorizontalAxis();
  }

  public ControllerInputHandler getPlayerController(){
    return toolBox.getControllers()[playerNumber - 1];
  }

  @Override
  protected void render(){
    if(!imageMirrored){
      drawMe();
    }
    else{
      drawMeReversed();
    }
  }

}
