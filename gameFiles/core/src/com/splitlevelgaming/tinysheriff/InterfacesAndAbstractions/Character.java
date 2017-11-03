package com.splitlevelgaming.tinysheriff;

public abstract class Character extends Prop{

  private int playerNumber;

  Character(Stage stage, int playerNumber, long x, long y){
    super(stage, x, y);
    this.playerNumber = playerNumber;
  }

  public ControllerInputHandler getPlayerController(){
    return getControllers()[playerNumber - 1];
  }

}
