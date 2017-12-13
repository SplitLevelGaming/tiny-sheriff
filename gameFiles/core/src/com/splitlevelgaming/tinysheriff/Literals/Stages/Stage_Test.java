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
    addProp(new Prop_Barrier(this, 0, 0, 2, 2, "img_badlogic", toolBox, true));
    toolBox.playMusic("music_testMusic");
  }

  @Override
  protected void update(){

  }

  @Override
  public void timerEnd(String code){

  }

}
