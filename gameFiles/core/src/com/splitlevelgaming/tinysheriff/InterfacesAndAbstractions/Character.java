package com.splitlevelgaming.tinysheriff;

public abstract class Character extends Prop{

  private int playerNumber;

  Character(Stage stage, int playerNumber){
    super(stage);
    this.playerNumber = playerNumber;
  }

}
