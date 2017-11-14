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
    addProp(new Prop_Test(this, 0, 0));
    addProp(new Character_Test(this, 1, 1, 1));
  }

  @Override
  protected void update(){

  }

}
