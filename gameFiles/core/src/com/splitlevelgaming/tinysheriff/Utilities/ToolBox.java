package com.splitlevelgaming.tinysheriff;

public class ToolBox{

  private TextureHandler textureHandler;
  private MusicHandler musicHander;
  private SoundHandler soundHandler;

  public ToolBox(){
    musicHander = new MusicHandler();
    textureHandler = new TextureHandler();
    soundHandler = new SoundHandler();
  }

  public void startStep(){
    textureHandler.startStep();
  }

  public void endStep(){
    textureHandler.endStep();
  }

  public void dispose(){
    textureHandler.dispose();
    musicHander.dispose();
    soundHandler.dispose();
  }

  public void draw(String textureName, double x, double y, double width, double height){
    textureHandler.draw(textureName, x, y, width, height);
  }

  public void playMusic(String musicName){
    musicHander.playMusic(musicName);
  }


}
