package com.splitlevelgaming.tinysheriff;

public abstract class Character extends Prop{

  protected int playerNumber;

  Character(Stage stage, int playerNumber, double x, double y, double width, double height){
    super(stage, x, y, width, height);
    this.playerNumber = playerNumber;
  }

  protected void update(){
    ControllerInputHandler playerController = getPlayerController();
    if(playerController.getVerticalAxis() != 0){
      y += .2*playerController.getVerticalAxis();
    }
    if(playerController.getHorizontalAxis() != 0){
      x += .2*playerController.getHorizontalAxis();
    }
  }

  public ControllerInputHandler getPlayerController(){
    return getControllers()[playerNumber - 1];
  }

}
