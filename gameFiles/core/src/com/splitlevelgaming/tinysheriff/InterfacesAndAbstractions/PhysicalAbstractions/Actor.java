package com.splitlevelgaming.tinysheriff;

public abstract class Actor extends Prop{

  protected int playerNumber;
  protected boolean imageMirrored = false;
  protected double movementMultiplier = .15;

  Actor(Stage stage, int playerNumber, double x, double y, double width, double height, String activeSprite, ToolBox toolBox){
    super(stage, x, y, width, height, activeSprite, toolBox);
    this.playerNumber = playerNumber;
  }

  protected void update(){
      InputHandler playerController = getPlayerController();
      if(!collidesWith(x, y+movementMultiplier*playerController.getVerticalAxis(), Prop_Barrier.class)){
        y += movementMultiplier*playerController.getVerticalAxis();
      }
      if(!collidesWith(x+movementMultiplier*playerController.getHorizontalAxis(), y, Prop_Barrier.class)){
        x += movementMultiplier*playerController.getHorizontalAxis();
      }
  }

  public InputHandler getPlayerController(){
    return toolBox.getControllers()[playerNumber - 1];
  }

  protected void setMovementMultiplier(double multiplier){
    movementMultiplier = multiplier;
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
