package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;

public class Prop_Barrier extends Prop{
  private boolean breakable;

  Prop_Barrier(Stage stage, double x, double y, double width, double height, String textureName, ToolBox toolBox, boolean breakable){
    super(stage, x, y, width, height, textureName, toolBox);
    this.breakable = breakable;
  }

  @Override
  protected void update(){

  }

  @Override
  protected void checkCollisions(){

  }

  @Override
  protected void updateSprite(){

  }

}
