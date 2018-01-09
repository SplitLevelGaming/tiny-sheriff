package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import java.util.ArrayList;
import java.util.Hashtable;

public class TextureHandler{

	private SpriteBatch batch;
	private double pixelsPerBottomBlockside;
	private double pixelsPerSideBlockside;
	private double screenWidth;
	private double screenHeight;
	private Hashtable<String, Texture> textureTable;
	private Hashtable<String, String> directoryKeyTable;

	TextureHandler () {
		textureTable = new Hashtable<String, Texture>();
		directoryKeyTable = new Hashtable<String, String>();
		ArrayList<String> textureExtensions = new ArrayList<String>();
		textureExtensions.add(".png");
		textureExtensions.add(".jpg");
		DirectoryManager directoryManager = new DirectoryManager();
		batch = new SpriteBatch();
		//Build the directoryKeyTable
		directoryKeyTable = directoryManager.createDirectoryHash("./", textureExtensions);
	}

	public void draw (String textureName, double blockX, double blockY, double blockWidth, double blockHeight) {
		drawComprehensive(textureName, blockX, blockY, blockWidth, blockHeight, false);
	}

	public void drawReversed(String textureName, double blockX, double blockY, double blockWidth, double blockHeight){
		drawComprehensive(textureName, blockX, blockY, blockWidth, blockHeight, true);
	}

	private void drawComprehensive(String textureName,
		double blockX,
		double blockY,
		double blockWidth,
		double blockHeight,
		boolean flipx){
			Texture texture = getTexture(textureName);
			if(texture == null){
				texture = instantiateTexture(textureName);
			}
			batch.draw(
				texture,
				(float) blockX * (float) pixelsPerBottomBlockside,
				(float) blockY * (float) pixelsPerSideBlockside,
				(float) blockWidth * (float) pixelsPerBottomBlockside,
				(float) blockHeight * (float) pixelsPerSideBlockside,
				0,
				0,
				texture.getWidth(),
				texture.getHeight(),
				flipx,
				false);
	}

	public double getPixelsPerBottomBlockside(){
		return pixelsPerBottomBlockside;
	}

	public double getPixelsPerSideBlockside(){
		return pixelsPerSideBlockside;
	}

	public void startStep(){
		batch.begin();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		pixelsPerBottomBlockside = (double) screenWidth / 32;
		pixelsPerSideBlockside = (double) screenHeight / 18;
		OrthographicCamera orthoCam = new OrthographicCamera((float) screenWidth, (float) screenHeight);
		orthoCam.position.set((float) screenWidth / 2, (float) screenHeight / 2, 0);
		orthoCam.update();
		batch.setProjectionMatrix(orthoCam.combined);
	}

	public void endStep(){
		batch.end();
	}

	public void dispose(){
		batch.dispose();
		disposeAllAssets();
	}

	private Texture getTexture(String texture){
		String[] keys = new String[0];
		keys = textureTable.keySet().toArray(keys);
		for(int i = 0; i < keys.length; i++){
			if(keys[i].equals(texture)){
				return textureTable.get(keys[i]);
			}
		}
		return null;
	}

	private boolean hasTexture(String texture){
		return getTexture(texture) != null;
	}

	private String getTextureNumberString(String textureName){
		int startingIndex = getTextureNumberStartIndex(textureName);
		return textureName.substring(startingIndex);
	}

	private String getTexturePrefixString(String textureName){
		int startingIndex = getTextureNumberStartIndex(textureName);
		return textureName.substring(0, startingIndex);
	}

	private int getTextureNumberStartIndex(String textureName){
		int startingIndex = textureName.length();
    while(Character.isDigit(textureName.charAt(startingIndex-1))){
      startingIndex--;
    }
		return startingIndex;
	}

	public String getIncrementedTextureName(String textureName){
    String prefix = getTexturePrefixString(textureName);
    String suffix = getTextureNumberString(textureName);
		if(suffix.length() == 0){
			return textureName;
		}
    int textureNumber = Integer.parseInt(suffix);
    textureNumber++;
    if(hasTexture(prefix + textureNumber)){
      return prefix + textureNumber;
    }
    else{
      return prefix + "1";
    }
	}

	public String getDecrementedTextureName(String textureName){
		String prefix = getTexturePrefixString(textureName);
    String suffix = getTextureNumberString(textureName);
		if(suffix.length() == 0){
			return textureName;
		}
    int textureNumber = Integer.parseInt(suffix);
    textureNumber--;
    if(hasTexture(prefix + textureNumber)){
      return prefix + textureNumber;
    }
    else{
			textureNumber++;
			while(hasTexture(prefix + (textureNumber + 1))){
				textureNumber++;
			}
      return prefix + textureNumber;
    }
	}


	private Texture instantiateTexture(String textureName){
		String directory = directoryKeyTable.get(textureName);
		Texture retVal = new Texture(directory);
		textureTable.put(textureName, retVal);
		return retVal;
	}

	private void disposeAllAssets(){
		String[] keys = new String[0];
		keys = textureTable.keySet().toArray(keys);
		for(int i = 0; i < keys.length; i++){
				textureTable.get(keys[i]).dispose();
			}
		}

}
