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
    addProp(new Prop_Test(this, 0, 0, toolBox));
    toolBox.playMusic("music_testMusic");
  }

  @Override
  protected void update(){

  }

  @Override
  public void timerEnd(String code){

  }

}
