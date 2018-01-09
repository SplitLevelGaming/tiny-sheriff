package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;

public class Actor_Test extends Actor{

  Actor_Test(Stage stage, int playerNumber, double x, double y, ToolBox toolBox){
    super(stage, playerNumber, x, y, 3, 4.5, "img_sheriff", toolBox);
  }

  @Override
  protected void checkCollisions(){

  }

  @Override
  protected void updateSprite(){

  }

}
