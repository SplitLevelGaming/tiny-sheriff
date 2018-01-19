package com.splitlevelgaming.tinysheriff;

public class Prop_Bullet extends Prop{

  private int targetPlayerNumber = 0;

  Prop_Bullet(Stage stage, double x, double y, int targetPlayerNumber, ToolBox toolBox){
    super(stage, x, y, .1, .1, "img_bullet", toolBox);
    this.targetPlayerNumber = targetPlayerNumber;
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

  @Override
  protected void render(){

  }

}
