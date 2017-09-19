package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;

public abstract class Prop{

  Prop(){

  }

  public void activate(Pen pen){
    update();
    render(pen);
  }

  protected abstract void update();

  protected abstract void render(Pen pen);

}
