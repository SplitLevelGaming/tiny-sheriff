package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.controllers.Controller;

public class ControllerInputHandler extends InputHandler{
  int verticalAxis = 1;
  int horizontalAxis = 0;
  int shootShotButton = 2;
  int miscButton = 0;
  double threshold = 0.2;
  //These will be true if the button was not pressed last step, but is this step
  boolean shootJustPressed;
  boolean miscJustPressed;
  //These will be equivalent to the last step's button presses at the beginning of a new step
  boolean lastShootPressed = false;
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

  public void setShootShotButton(int value){
    shootShotButton = value;
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

  public boolean shootShotButtonIsPressed(){
    return controller.getButton(shootShotButton);
  }

  public boolean miscButtonIsPressed(){
    return controller.getButton(miscButton);
  }

  public boolean shootJustPressed(){
    return shootJustPressed;
  }

  public boolean miscJustPressed(){
    return miscJustPressed;
  }

  public void refresh(){
    shootJustPressed = false;
    miscJustPressed = false;
    if(!lastShootPressed && shootShotButtonIsPressed()){
      shootJustPressed = true;
    }
    if(!lastMiscPressed && miscButtonIsPressed()){
      miscJustPressed = true;
    }
    lastShootPressed = shootShotButtonIsPressed();
    lastMiscPressed = miscButtonIsPressed();
  }
}
