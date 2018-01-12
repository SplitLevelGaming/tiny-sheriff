package com.splitlevelgaming.tinysheriff;

public abstract class InputHandler{

  public InputHandler(){

  }

  public abstract float getVerticalAxis();
  public abstract float getHorizontalAxis();
  public abstract boolean shootShotButtonIsPressed();
  public abstract boolean miscButtonIsPressed();
  public abstract boolean shootJustPressed();
  public abstract boolean miscJustPressed();
  public abstract void refresh();

}
