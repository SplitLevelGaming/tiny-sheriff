package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.OrthographicCamera;
import java.util.Hashtable;

public class MainGame extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont font;
	float pixelsPerBottomBlockside;
	float pixelsPerSideBlockside;
	Stage activeStage;
	Hashtable<String, Texture> textureVault;

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		initializeTextureVault();
		activeStage = new Stage_Test(this);
	}

	@Override
	public void render () {
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		pixelsPerBottomBlockside = screenWidth / 32;
		pixelsPerSideBlockside = screenHeight / 18;
		OrthographicCamera orthoCam = new OrthographicCamera(screenWidth, screenHeight);
		orthoCam.position.set(screenWidth / 2, screenHeight / 2, 0);
		orthoCam.update();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.setProjectionMatrix(orthoCam.combined);
		Pen pen = new Pen(batch, pixelsPerBottomBlockside, pixelsPerSideBlockside, screenWidth, screenHeight);
		activeStage.activate(pen);
		//The following lines are here for testing purposes. They should not be uncommented in any PR.
		//font.draw(batch, screenWidth + ", " + screenHeight, 0, 15);
		//font.draw(batch, Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() + "", 0, 30);
		batch.end();
		System.gc();
	}

	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
		destroyTextureVault();
	}

	public void enterNewStage(Stage newStage){
		activeStage = newStage;
	}

	public void initializeTextureVault(){
		textureVault = new Hashtable<String, Texture>();
		TexturesList temporaryTexturesList = new TexturesList();
		String texturesStrings[] = temporaryTexturesList.getTextures();
		for(int i=0; i<texturesStrings.length; i++){
			Texture vaultInput = new Texture(texturesStrings[i]);
			textureVault.put(texturesStrings[i], vaultInput);
		}
	}

	public void destroyTextureVault(){
		TexturesList temporaryTexturesList = new TexturesList();
		String texturesStrings[] = temporaryTexturesList.getTextures();
		for(int i=0; i<texturesStrings.length; i++){
			textureVault.get(texturesStrings[i]).dispose();
		}
	}

	public Texture getTexture(String textureName){
		return textureVault.get(textureName);
	}
}
