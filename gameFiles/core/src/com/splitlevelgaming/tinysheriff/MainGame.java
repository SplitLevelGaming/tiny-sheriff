package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.ApplicationAdapter;
import java.util.Hashtable;
import java.util.ArrayList;

public class MainGame extends ApplicationAdapter {
	private Stage activeStage;
	private ToolBox toolBox;

	@Override
	public void create () {
		toolBox = new ToolBox();
		activeStage = new Stage_Test(this, toolBox);
	}

	@Override
	public void render () {
		toolBox.startStep();
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
}
