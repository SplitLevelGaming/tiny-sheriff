package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.controllers.Controller;

public class controllerInputHandler{
  int verticalAxis = 1;
  int horizontalAxis = 0;
  int slowShotButton = 0;
  int mediumShotButton = 2;
  int fastShotButton = 3;
  int miscButton = 1;
  Controller controller;

  controllerInputHandler(Controller controller){
    this.controller = controller;
  }

  public void setVerticalAxis(int value){
    verticalAxis = value;
  }

  public void setHorizontalAxis(int value){
    horizontalAxis = value;
  }

  public void setSlowShotButton(int value){
    slowShotButton = value;
  }

  public void setMediumShotButton(int value){
    mediumShotButton = value;
  }

  public void setFastShotButton(int value){
    fastShotButton = value;
  }

  public void setMiscButton(int value){
    miscButton = value;
  }

  public float getVerticalAxis(){
    return -1*controller.getAxis(verticalAxis);
  }

  public float getHorizontalAxis(){
    return controller.getAxis(horizontalAxis);
  }

  public boolean slowShotButtonIsPressed(){
    return controller.getButton(slowShotButton);
  }

  public boolean mediumShotButtonIsPressed(){
    return controller.getButton(mediumShotButton);
  }

  public boolean fastShotButtonIsPressed(){
    return controller.getButton(fastShotButton);
  }

  public boolean mistButtonIsPressed(){
    return controller.getButton(miscButton);
  }
}
