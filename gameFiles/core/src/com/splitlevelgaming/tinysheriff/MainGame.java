package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import java.util.Hashtable;
import java.util.ArrayList;

public class MainGame extends ApplicationAdapter {
	private Stage activeStage;
	private ControllerInputHandler[] controllers;
	private boolean controllersHookedUp = true;
	private ToolBox toolBox;

	@Override
	public void create () {
		toolBox = new ToolBox();

		activeStage = new Stage_Test(this, toolBox);

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

	@Override
	public void render () {
		toolBox.startStep();
		if(controllersHookedUp)
			for(int i = 0; i < controllers.length; i++){
				controllers[i].refresh();
			}
		activeStage.activate();
		toolBox.endStep();
	}

	@Override
	public void dispose () {
		toolBox.dispose();
	}

	public void enterNewStage(Stage newStage){
		activeStage = newStage;
	}

	public ControllerInputHandler[] getControllers(){
		return controllers;
	}
}
