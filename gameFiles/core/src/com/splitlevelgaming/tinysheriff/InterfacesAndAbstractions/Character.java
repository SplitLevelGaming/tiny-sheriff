package com.splitlevelgaming.tinysheriff;

public abstract class Character extends Prop{

  private int playerNumber;

  Character(Stage stage, int playerNumber, double x, double y){
    super(stage, x, y);
    this.playerNumber = playerNumber;
  }

  public ControllerInputHandler getPlayerController(){
    return getControllers()[playerNumber - 1];
  }

}
