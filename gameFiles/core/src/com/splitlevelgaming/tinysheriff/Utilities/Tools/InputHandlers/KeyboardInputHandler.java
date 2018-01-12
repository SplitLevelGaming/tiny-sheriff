package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class KeyboardInputHandler{

  public KeyboardInputHandler(){

  }

  public float getVerticalAxis(){
    if(Gdx.input.isKeyPressed(Input.Keys.W) && !Gdx.input.isKeyPressed(Input.Keys.S)){
      return 1;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.S) && !Gdx.input.isKeyPressed(Input.Keys.W)){
      return 1;
    }
    return 0;
  }

  public float getHorizontalAxis(){
    if(Gdx.input.isKeyPressed(Input.Keys.D) && !Gdx.input.isKeyPressed(Input.Keys.A)){
      return 1;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.A) && !Gdx.input.isKeyPressed(Input.Keys.D)){
      return 1;
    }
    return 0;
  }

  public boolean shootShotButtonIsPressed(){
    return Gdx.input.isKeyPressed(Input.Keys.E);
  }

  public boolean miscButtonIsPressed(){
    return Gdx.input.isKeyPressed(Input.Keys.Q);
  }

  public boolean shootJustPressed(){
    return Gdx.input.isKeyJustPressed(Input.Keys.E);
  }

  public boolean miscJustPressed(){
    return Gdx.input.isKeyJustPressed(Input.Keys.Q);
  }

  public void refresh(){

  }
}
