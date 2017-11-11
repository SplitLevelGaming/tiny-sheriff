package com.splitlevelgaming.tinysheriff;

public abstract class Character extends Prop{

  protected int playerNumber;

  Character(Stage stage, int playerNumber, double x, double y, double width, double height){
    super(stage, x, y, width, height);
    this.playerNumber = playerNumber;
  }

  public ControllerInputHandler getPlayerController(){
    return getControllers()[playerNumber - 1];
  }

}
