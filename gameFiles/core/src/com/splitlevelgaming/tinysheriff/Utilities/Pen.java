package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Pen {

	SpriteBatch batch;
	float pixelsPerBottomBlockside;
	float pixelsPerSideBlockside;
	float screenWidth;
	float screenHeight;

	Pen (SpriteBatch passedBatch, float passedPixelsPerBottomBlockside, float passedPixelsPerSideBlockside, float passedScreenWidth, float passedScreenHeight) {
		batch = passedBatch;
		pixelsPerBottomBlockside = passedPixelsPerBottomBlockside;
		pixelsPerSideBlockside = passedPixelsPerSideBlockside;
		screenWidth = passedScreenWidth;
		screenHeight = passedScreenHeight;
	}

	public void draw (Texture texture, float blockX, float blockY, float blockWidth, float blockHeight) {
		batch.draw(texture, blockX * pixelsPerBottomBlockside, blockY * pixelsPerSideBlockside, blockWidth * pixelsPerBottomBlockside, blockHeight * pixelsPerSideBlockside);
	}

	public float getPixelsPerBottomBlockside(){
		return pixelsPerBottomBlockside;
	}

	public float getPixelsPerSideBlockside(){
		return pixelsPerSideBlockside;
	}

}
