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
    loadInitialProps();
  }

  public void activate(){
    update();
    render();
    activateProps();
  }

  protected void render(){
    toolBox.draw(background, 0, 0, 32, 18);
  }

  protected void update(){
    return;
  }

  protected void activateProps(){
    for(int i = 0; i < props.size(); i++){
      props.get(i).activate();
    }
  }

  protected abstract void loadInitialProps();

  protected void addProp(Prop newProp){
    props.add(props.size(), newProp);
  }

  public void removePhysicalReferences(Physical physical){
    props.remove(physical);
    toolBox.removePhysicalReferences(physical);
  }

  protected ControllerInputHandler[] getControllers(){
    return mainGame.getControllers();
  }

  public boolean collidesWith(double x, double y, double width, double height, Class target){
    for(int i = 0; i < props.size(); i++){
      if(props.get(i).getClass() == target){
        if(props.get(i).intersects(x, y, width, height)){
          return true;
        }
      }
    }
    return false;
  }

}
