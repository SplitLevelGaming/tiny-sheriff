package com.splitlevelgaming.tinysheriff;

public class Prop_Barrel extends Prop_Barrier{
  private boolean breakable;

  Prop_Barrel(Stage stage, double x, double y, ToolBox toolBox){
    super(stage, x, y, 1.45, 1.9, "img_barrel", toolBox, true);
    collisionDepthHeightMultiplier = .5;
  }

}
