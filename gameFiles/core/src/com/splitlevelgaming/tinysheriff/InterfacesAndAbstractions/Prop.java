package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;

public abstract class Prop{

  Stage stage;

  Prop(Stage stage){
    this.stage = stage;
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
