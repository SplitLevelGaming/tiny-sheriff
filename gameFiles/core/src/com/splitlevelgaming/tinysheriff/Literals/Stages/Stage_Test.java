package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Gdx;

public class Stage_Test extends Stage{

  Prop test_prop;

  Stage_Test(MainGame mainGame, ToolBox toolBox){
    super(mainGame, "img_testBackground", toolBox);
  }

  @Override
  protected void loadInitialProps(){
    addProp(new Actor_Test(this, 1, 0, 0, toolBox));
    addProp(new Actor_Test(this, 2, 5, 5, toolBox));
    toolBox.getMusicHandler().playMusic("music_testMusic");
  }

  @Override
  protected void update(){

  }

  @Override
  public void timerEnd(String code){

  }

}
