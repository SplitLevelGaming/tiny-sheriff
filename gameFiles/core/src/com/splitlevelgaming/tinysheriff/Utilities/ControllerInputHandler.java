package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.controllers.Controller;

public class ControllerInputHandler{
  int verticalAxis = 1;
  int horizontalAxis = 0;
  int slowShotButton = 2;
  int mediumShotButton = 3;
  int fastShotButton = 1;
  int miscButton = 0;
  double threshold = 0.2;
  //These will be true if the button was not pressed last step, but is this step
  boolean slowJustPressed;
  boolean mediumJustPressed;
  boolean fastJustPressed;
  boolean miscJustPressed;
  //These will be equivalent to the last step's button presses at the beginning of a new step
  boolean lastSlowPressed = false;
  boolean lastMediumPressed = false;
  boolean lastFastPressed = false;
  boolean lastMiscPressed = false;
  Controller controller;

  ControllerInputHandler(Controller controller){
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
    if(Math.abs(controller.getAxis(verticalAxis)) > threshold){
      return -1*controller.getAxis(verticalAxis);
    }
    return 0;
  }

  public float getHorizontalAxis(){
    if(Math.abs(controller.getAxis(horizontalAxis)) > threshold){
      return controller.getAxis(horizontalAxis);
    }
    return 0;
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

  public boolean miscButtonIsPressed(){
    return controller.getButton(miscButton);
  }

  public boolean slowJustPressed(){
    return slowJustPressed;
  }

  public boolean mediumJustPressed(){
    return mediumJustPressed;
  }

  public boolean fastJustPressed(){
    return fastJustPressed;
  }

  public boolean miscJustPressed(){
    return miscJustPressed;
  }

  public void refresh(){
    slowJustPressed = false;
    mediumJustPressed = false;
    fastJustPressed = false;
    miscJustPressed = false;
    if(!lastSlowPressed && slowShotButtonIsPressed()){
      slowJustPressed = true;
    }
    if(!lastMediumPressed && mediumShotButtonIsPressed()){
      mediumJustPressed = true;
    }
    if(!lastFastPressed && fastShotButtonIsPressed()){
      fastJustPressed = true;
    }
    if(!lastMiscPressed && miscButtonIsPressed()){
      miscJustPressed = true;
    }
    lastSlowPressed = slowShotButtonIsPressed();
    lastMediumPressed = mediumShotButtonIsPressed();
    lastFastPressed = fastShotButtonIsPressed();
    lastMiscPressed = miscButtonIsPressed();
  }
}
