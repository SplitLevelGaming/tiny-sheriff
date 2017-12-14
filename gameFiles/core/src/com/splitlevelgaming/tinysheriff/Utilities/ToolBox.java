package com.splitlevelgaming.tinysheriff;

public class ToolBox implements PhysicalReferencer{

  private TextureHandler textureHandler;
  private MusicHandler musicHander;
  private SoundHandler soundHandler;
  private TimerController timerController;

  public ToolBox(){
    musicHander = new MusicHandler();
    textureHandler = new TextureHandler();
    soundHandler = new SoundHandler();
    timerController = new TimerController();
  }

  public void startStep(){
    textureHandler.startStep();
    timerController.startStep();
  }

  public void endStep(){
    textureHandler.endStep();
    timerController.startStep();
  }

  public void dispose(){
    textureHandler.dispose();
    musicHander.dispose();
    soundHandler.dispose();
  }

  public void removePhysicalReferences(Physical physical){
    timerController.removePhysicalReferences(physical);
  }

  public void draw(String textureName, double x, double y, double width, double height){
    textureHandler.draw(textureName, x, y, width, height);
  }

  public void drawReversed(String textureName, double x, double y, double width, double height){
    textureHandler.drawReversed(textureName, x, y, width, height);
  }

  public void playMusic(String musicName){
    musicHander.playMusic(musicName);
  }

  public void setTimer(Prop calling, String code, int setTime){
    timerController.setTimer(calling, code, setTime);
  }

}
