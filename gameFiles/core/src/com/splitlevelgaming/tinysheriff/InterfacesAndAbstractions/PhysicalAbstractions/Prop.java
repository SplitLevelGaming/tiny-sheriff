package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;

public abstract class Prop extends Physical{

  protected Stage stage;
  protected double x = 0;
  protected double y = 0;
  protected double width;
  protected double height;
  protected String activeSprite;
  protected ToolBox toolBox;
  protected int animationThreshold = 1;
  protected int animationStep = 0;
  protected boolean animated = false;
  //Creates the illusion of depth
  protected double collisionDepthHeightMultiplier = .5;

  Prop(Stage stage, double x, double y, double width, double height, String activeSprite, ToolBox toolBox){
    this.stage = stage;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.activeSprite = activeSprite;
    this.toolBox = toolBox;
  }

  public void activate(){
    update();
    checkCollisions();
    updateSprite();
    render();
  }

  protected void selfDestruct(){
    stage.removePhysicalReferences(this);
    toolBox.removePhysicalReferences(this);
  }

  protected void addProp(Prop newProp){
    stage.addProp(newProp);
  }

  private boolean linesOverlap(double start1, double end1, double start2, double end2){
    if(start1 == start2 || end1 == end2){
      return true;
    }
    if((start1 > start2 && start1 < end2) || (end1 > start2 && end1 < end2)){
      return true;
    }
    if(start2 > start1 && start2 < end1 || end2 > start1 && end2 < end1){
      return true;
    }
    return false;
  }

  public boolean intersects(double x, double y, double width, double height){
    double bottom1 = y;
    double bottom2 = this.y;
    double left1 = x;
    double left2 = this.x;
    double right1 = x + width;
    double right2 = this.x + this.width;
    double top1 = y + height;
    double top2 = this.y + (collisionDepthHeightMultiplier * this.height);
    if(linesOverlap(bottom1, top1, bottom2, top2)){
      if(linesOverlap(left1, right1, left2, right2)){
        return true;
      }
    }
    return false;
  }

  protected boolean collidesWith(Class target){
    return collidesWith(x, y, target);
  }

  protected boolean collidesWith(double x, double y, Class target){
    return stage.collidesWith(x, y, this.width, this.height * collisionDepthHeightMultiplier, target);
  }

  protected abstract void update();

  protected abstract void checkCollisions();

  protected void updateSprite(){
    if(animated){
      incrementAnimationStep();
    }
  }

  protected void render(){
    drawMe();
  }

  protected void drawMe(){
    toolBox.getTextureHandler().draw(activeSprite, x, y, width, height);

  }

  protected void drawMeReversed(){
    toolBox.getTextureHandler().drawReversed(activeSprite, x, y, width, height);

  }

  protected void incrementAnimationStep(){
    animationStep++;
    if(animationStep >= animationThreshold){
      animationStep = 0;
      increaseActiveSprite();
    }
  }

  protected void incrementAnimationStepBackwards(){
    animationStep++;
    if(animationStep >= animationThreshold){
      animationStep = 0;
      decreaseActiveSprite();
    }
  }

  protected void increaseActiveSprite(){
    String newTextureName = toolBox.getTextureHandler().getIncrementedTextureName(activeSprite);
    if(newTextureName.equals(activeSprite)){
      System.out.println("Attempted to increment animation sprite " + activeSprite);
    }
    setActiveSprite(toolBox.getTextureHandler().getIncrementedTextureName(activeSprite));
  }

  protected void decreaseActiveSprite(){
    setActiveSprite(toolBox.getTextureHandler().getDecrementedTextureName(activeSprite));
  }

  protected void setActiveSprite(String textureName){
    activeSprite = textureName;
  }

  protected void setAnimationThreshold(int animationThreshold){
    this.animationThreshold = animationThreshold;
  }

  protected void setAnimated(boolean animated){
    this.animated = animated;
  }

  public void timerEnd(String timerName){

  }

  public double getDepth(){
    return y;
  }

}
