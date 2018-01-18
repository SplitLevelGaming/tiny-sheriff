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
    addProp(new Actor_Test(this, 2, 30.5, 0, toolBox));
    addProp(new Prop_Barrier(this, 5, 5, 2, 2, "img_barrel", toolBox, true));
    addProp(new Prop_Barrier(this, 10, 5, 2, 2, "img_barrel", toolBox, true));
    addProp(new Prop_Barrier(this, 10, 10, 2, 2, "img_barrel", toolBox, true));
    toolBox.getMusicHandler().playMusic("music_testMusic");
  }

  @Override
  protected void update(){

  }

  @Override
  public void timerEnd(String code){

  }

}
