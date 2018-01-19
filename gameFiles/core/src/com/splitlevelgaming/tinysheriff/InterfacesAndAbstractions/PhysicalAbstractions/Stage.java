package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;
import java.util.ArrayList;

public abstract class Stage extends Physical implements PhysicalReferencer{

  protected String backgroundTextureName;
  protected MainGame mainGame;
  protected ArrayList<Prop> props;
  protected String background;
  protected ToolBox toolBox;

  Stage(MainGame mainGame, String backgroundTextureName, ToolBox toolBox){
    this.mainGame = mainGame;
    this.toolBox = toolBox;
    this.props = new ArrayList<Prop>();
    this.background = backgroundTextureName;
    loadOutsideWalls();
    loadInnerWalls();
    loadInitialProps();
  }

  public void activate(){
    update();
    render();
    activateProps();
  }

  protected void render(){
    toolBox.getTextureHandler().draw(background, 0, 0, 32, 18);
  }

  protected void update(){
    return;
  }

  protected void activateProps(){
    sortProps();
    for(int i = 0; i < props.size(); i++){
      props.get(i).activate();
    }
  }

  protected abstract void loadInitialProps();

  protected void sortProps(){
    for(int i = 0; i < props.size(); i++){
      int propIndex = 0;
      double propDepth = -1;
      for(int j = i; j < props.size(); j++){
        if(props.get(j).getDepth() > propDepth){
          propIndex = j;
          propDepth = props.get(j).getDepth();
        }
      }
      Prop temporary = props.get(i);
      props.set(i, props.get(propIndex));
      props.set(propIndex, temporary);
    }
  }

  protected void loadOutsideWalls(){
    //addProp(new Prop_Barrier(this, -1, 0, 1, 18, "img_null", toolBox, false));
    addProp(new Prop_ArenaWall(this, -1, 0, 1, 18, toolBox));
    addProp(new Prop_ArenaWall(this, 32, 0, 1, 18, toolBox));
    addProp(new Prop_ArenaWall(this, -1, -1, 34, 1, toolBox));
    addProp(new Prop_ArenaWall(this, -1, 18, 34, 1, toolBox));
  }

  protected abstract void loadInnerWalls();

  protected void addProp(Prop newProp){
    props.add(props.size(), newProp);
  }

  public void removePhysicalReferences(Physical physical){
    props.remove(physical);
  }

  public boolean collidesWith(double x, double y, double width, double height, Class target){
    for(int i = 0; i < props.size(); i++){
      if(target.isAssignableFrom(props.get(i).getClass())){
        if(props.get(i).intersects(x, y, width, height)){
          return true;
        }
      }
    }
    return false;
  }

}
