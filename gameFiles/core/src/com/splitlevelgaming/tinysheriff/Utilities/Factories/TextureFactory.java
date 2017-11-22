package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;

public class TextureFactory implements Factory<Texture>{
  public Texture buildOne(String directory){
    return new Texture(directory);
  }
}
