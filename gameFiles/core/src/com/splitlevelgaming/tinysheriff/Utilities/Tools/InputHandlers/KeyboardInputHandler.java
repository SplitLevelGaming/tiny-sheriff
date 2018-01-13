package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class KeyboardInputHandler extends InputHandler{

  private int upKey;
  private int downKey;
  private int leftKey;
  private int rightKey;
  private int miscKey;
  private int shootKey;

  public KeyboardInputHandler(int upKey, int downKey, int leftKey, int rightKey, int miscKey, int shootKey){
    this.upKey = upKey;
    this.downKey = downKey;
    this.leftKey = leftKey;
    this.rightKey = rightKey;
    this.miscKey = miscKey;
    this.shootKey = shootKey;
  }

  public KeyboardInputHandler(){
    this(Input.Keys.W, Input.Keys.S, Input.Keys.A, Input.Keys.D, Input.Keys.E, Input.Keys.Q);
  }

  public float getVerticalAxis(){
    if(Gdx.input.isKeyPressed(upKey) && !Gdx.input.isKeyPressed(downKey)){
      return 1;
    }
    if(Gdx.input.isKeyPressed(downKey) && !Gdx.input.isKeyPressed(upKey)){
      return -1;
    }
    return 0;
  }

  public float getHorizontalAxis(){
    if(Gdx.input.isKeyPressed(rightKey) && !Gdx.input.isKeyPressed(leftKey)){
      return 1;
    }
    if(Gdx.input.isKeyPressed(leftKey) && !Gdx.input.isKeyPressed(rightKey)){
      return -1;
    }
    return 0;
  }

  public boolean shootShotButtonIsPressed(){
    return Gdx.input.isKeyPressed(shootKey);
  }

  public boolean miscButtonIsPressed(){
    return Gdx.input.isKeyPressed(miscKey);
  }

  public boolean shootJustPressed(){
    return Gdx.input.isKeyJustPressed(shootKey);
  }

  public boolean miscJustPressed(){
    return Gdx.input.isKeyJustPressed(miscKey);
  }

  public void refresh(){

  }
}
