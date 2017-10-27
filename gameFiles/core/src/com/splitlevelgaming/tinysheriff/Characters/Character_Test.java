package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;

public class Character_Test extends Character{

  Character_Test(Stage stage, int playerNumber, long x, long y){
    super(stage, playerNumber, x, y);
  }

  protected void update(){

  }

  protected void render(Pen pen){
    pen.draw(getTexture("img_badlogic.jpg"), x, y, 1, 1);
  }

}
