package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;

public class ToolBox implements PhysicalReferencer{

  private TextureHandler textureHandler;
  private MusicHandler musicHander;
  private SoundHandler soundHandler;
  private TimerController timerController;
  private ControllerInputHandler[] controllers;

  private boolean controllersHookedUp = true;

  public ToolBox(){
    musicHander = new MusicHandler();
    textureHandler = new TextureHandler();
    soundHandler = new SoundHandler();
    timerController = new TimerController();
    controllers = new ControllerInputHandler[2];
		try{
			controllers[0] = new ControllerInputHandler(Controllers.getControllers().get(0));
			controllers[1] = new ControllerInputHandler(Controllers.getControllers().get(1));
		}
		catch (Exception e) {
			System.out.println("Please connect two controllers!");
      controllersHookedUp = false;
			//Gdx.app.exit();
		}
  }

  public void startStep(){
    textureHandler.startStep();
    timerController.startStep();
    if(controllersHookedUp)
      for(int i = 0; i < controllers.length; i++){
        controllers[i].refresh();
      }
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

  public String getIncrementedTextureName(String textureName){
    return textureHandler.getIncrementedTextureName(textureName);
  }

  public String getDecrementedTextureName(String textureName){
    return textureHandler.getDecrementedTextureName(textureName);
  }

  public void playMusic(String musicName){
    musicHander.playMusic(musicName);
  }

  public void setTimer(Prop calling, String code, int setTime){
    timerController.setTimer(calling, code, setTime);
  }

  public ControllerInputHandler[] getControllers(){
		return controllers;
	}

}
