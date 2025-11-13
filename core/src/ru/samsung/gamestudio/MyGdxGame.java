package ru.samsung.gamestudio;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {
	SpriteBatch batch;
	OtrisovkaGame oTg;
	public static final int SCR_WIDTH = 720;
	public static final int SCR_HEIGHT = 1280;
	public OrthographicCamera camera;



	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false,SCR_HEIGHT, SCR_WIDTH);
		batch = new SpriteBatch();
		oTg = new OtrisovkaGame(this) ;
		setScreen(oTg);
	}


	@Override
	public void dispose () {
		batch.dispose();


	}
}

