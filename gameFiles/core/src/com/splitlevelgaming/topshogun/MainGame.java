package com.splitlevelgaming.topshogun;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainGame extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont font;
	float pixelsPerBottomBlockside;
	float pixelsPerSideBlockside;

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
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
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.setProjectionMatrix(orthoCam.combined);
		Pen pen = new Pen(batch, pixelsPerBottomBlockside, pixelsPerSideBlockside, screenWidth, screenHeight);
		font.draw(batch, screenWidth + ", " + screenHeight, 0, 15);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}
}
