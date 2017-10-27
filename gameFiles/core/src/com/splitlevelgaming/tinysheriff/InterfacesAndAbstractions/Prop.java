package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;

public abstract class Prop{

  private Stage stage;
  long x = 0;
  long y = 0;

  Prop(Stage stage, long x, long y){
    this.stage = stage;
    this.x = x;
    this.y = y;
  }

  public void activate(Pen pen){
    update();
    render(pen);
  }

  protected void selfDestruct(){
    stage.removeProp(this);
  }

  protected Texture getTexture(String textureName){
    return stage.getTexture(textureName);
  }

  protected ControllerInputHandler[] getControllers(){
    return stage.getControllers();
  }

  protected void addProp(Prop newProp){
    stage.addProp(newProp);
  }

  protected abstract void update();

  protected abstract void render(Pen pen);

}
