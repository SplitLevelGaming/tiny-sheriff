package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;

public class Prop_Test extends Prop{
  long x;
  long y;
  Texture test_sprite = getTexture("img_badlogic");
  Prop_Test(Stage stage, double x, double y){
    super(stage, x, y, 1, 1);
  }

  @Override
  protected void update(){

  }

  @Override
  protected void checkCollisions(){

  }

  @Override
  protected void render(Pen pen){
    pen.draw(test_sprite, x, y, 1, 1);
  }

  @Override
  protected void updateSprite(){

  }
  
}
