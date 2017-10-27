package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;
import java.util.ArrayList;

public abstract class Stage{

  private String backgroundTextureName;
  private MainGame mainGame;
  private ArrayList<Prop> props;
  private Texture background;
  private Character playerOne;
  private Character playerTwo;

  Stage(MainGame mainGame, String backgroundTextureName){
    this.mainGame = mainGame;
    this.props = new ArrayList<Prop>();
    this.background = mainGame.getTexture(backgroundTextureName);
    loadInitialProps();
  }

  public void activate(Pen pen){
    update();
    render(pen);
    activateProps(pen);
  }

  protected void render(Pen pen){
    pen.draw(background, 0, 0, 32, 18);
  }

  protected void update(){
    return;
  }

  protected void activateProps(Pen pen){
    for(int i = 0; i < props.size(); i++){
      props.get(i).activate(pen);
    }
  }

  protected abstract void loadInitialProps();

  protected void addProp(Prop newProp){
    props.add(props.size(), newProp);
  }

  protected void removeProp(Prop propToRemove){
    props.remove(propToRemove);
  }

  public Texture getTexture(String textureName){
    return mainGame.getTexture(textureName);
  }

  protected ControllerInputHandler[] getControllers(){
    return mainGame.getControllers();
  }

  public void setFirstCharacter(Character character){
    playerOne = character;
  }

  public void setSecondCharacter(Character character){
    playerTwo = character;
  }

}
