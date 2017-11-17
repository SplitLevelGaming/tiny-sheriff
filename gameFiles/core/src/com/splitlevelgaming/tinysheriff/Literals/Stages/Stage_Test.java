package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Gdx;

public class Stage_Test extends Stage{

  Prop test_prop;

  Stage_Test(MainGame mainGame){
    super(mainGame, "img_testBackground");
  }

  @Override
  protected void loadInitialProps(){
    addProp(new Prop_Barrier(this, 0, 0, 2, 2, "img_badlogic", true));
  }

  @Override
  protected void update(){

  }

}
