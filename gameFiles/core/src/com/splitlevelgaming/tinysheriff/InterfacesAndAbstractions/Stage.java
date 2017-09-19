package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;
import java.util.ArrayList;

public abstract class Stage{

  Texture background;
  MainGame mainGame;
  ArrayList<Prop> props;

  Stage(MainGame mainGame, Texture background){
    this.mainGame = mainGame;
    this.props = new ArrayList<Prop>();
    this.background = background;
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

}
