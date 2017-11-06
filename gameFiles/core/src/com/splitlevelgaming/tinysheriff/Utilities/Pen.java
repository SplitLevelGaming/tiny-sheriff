package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Pen {

	SpriteBatch batch;
	double pixelsPerBottomBlockside;
	double pixelsPerSideBlockside;
	double screenWidth;
	double screenHeight;

	Pen (SpriteBatch passedBatch, double passedPixelsPerBottomBlockside, double passedPixelsPerSideBlockside, double passedScreenWidth, double passedScreenHeight) {
		batch = passedBatch;
		pixelsPerBottomBlockside = passedPixelsPerBottomBlockside;
		pixelsPerSideBlockside = passedPixelsPerSideBlockside;
		screenWidth = passedScreenWidth;
		screenHeight = passedScreenHeight;
	}

	public void draw (Texture texture, double blockX, double blockY, double blockWidth, double blockHeight) {
		batch.draw(
		texture,
		(float) blockX * (float) pixelsPerBottomBlockside,
		 (float) blockY * (float) pixelsPerSideBlockside,
		  (float) blockWidth * (float) pixelsPerBottomBlockside,
			 (float) blockHeight * (float) pixelsPerSideBlockside);
	}

	public double getPixelsPerBottomBlockside(){
		return pixelsPerBottomBlockside;
	}

	public double getPixelsPerSideBlockside(){
		return pixelsPerSideBlockside;
	}

}
