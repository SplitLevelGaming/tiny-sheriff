package com.splitlevelgaming.tinysheriff;

public class Prop_ArenaWall extends Prop_Barrier{
  private boolean breakable;

  Prop_ArenaWall(Stage stage, double x, double y, double width, double height, ToolBox toolBox){
    super(stage, x, y, width, height, "img_null", toolBox, false);
  }

}
