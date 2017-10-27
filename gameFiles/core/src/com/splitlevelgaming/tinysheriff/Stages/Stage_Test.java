package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Gdx;

public class Stage_Test extends Stage{

  Prop test_prop;

  Stage_Test(MainGame mainGame){
    super(mainGame, "img_testBackground.jpg");
    setFirstCharacter(new Character_Test(this, 1));
    setSecondCharacter(new Character_Test(this, 2));
  }

  @Override
  protected void loadInitialProps(){
    addProp(new Prop_Test(this, 0, 0));
  }

  @Override
  protected void update(){

  }

}
