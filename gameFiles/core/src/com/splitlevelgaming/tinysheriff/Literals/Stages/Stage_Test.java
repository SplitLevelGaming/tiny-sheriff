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
    addProp(new Actor_Test(this, 1, 2, 2, toolBox));
    addProp(new Actor_Test(this, 2, 28.5, 2, toolBox));
    addProp(new Prop_Barrel(this, 5, 5, toolBox));
    addProp(new Prop_Barrel(this, 10, 5, toolBox));
    addProp(new Prop_Barrel(this, 10, 10, toolBox));
    toolBox.getMusicHandler().playMusic("music_testMusic");
  }

  @Override
  protected void update(){

  }

  @Override
  protected void loadInnerWalls(){
    for(double i = 0; i < 16; i += 1.25){
      addProp(new Prop_Barrel(this, 0, i, toolBox));
      addProp(new Prop_Barrel(this, 30.55, i, toolBox));
    }
    for(double i = 0; i < 32; i += 1.8){
      if(i+1.8 < 32)
        addProp(new Prop_Barrel(this, i, 0, toolBox));
      addProp(new Prop_Barrel(this, i, 16, toolBox));
    }
  }

  @Override
  public void timerEnd(String code){

  }

}
