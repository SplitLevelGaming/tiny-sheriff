package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;

public abstract class Prop{

  protected Stage stage;
  protected double x = 0;
  protected double y = 0;
  protected double width;
  protected double height;

  Prop(Stage stage, double x, double y, double width, double height){
    this.stage = stage;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public void activate(Pen pen){
    update();
    render(pen);
  }

  public boolean intersects(double x, double y, double width, double height){
    double bottom1 = x;
    double bottom2 = this.x;
    double left1 = y;
    double left2 = this.y;
    double right1 = x + width;
    double right2 = this.x + this.width;
    double top1 = y + height;
    double top2 = this.y + this.height;
    if(left1 == left2 ||
     right1 == right2 ||
     (left1 < left2 && right1 > left2) ||
     (left1 < right2 && left1 > left2)){
      if(top1 == top2 ||
       bottom1 == bottom2 ||
       (top1 > top2 && bottom1 < top2) ||
       (top1 > bottom2 && top1 < top2)){
        return true;
      }
    }
    return false;
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
