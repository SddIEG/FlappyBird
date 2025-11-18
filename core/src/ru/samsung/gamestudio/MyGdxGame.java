package ru.samsung.gamestudio;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.samsung.gamestudio.screen.OtrisovkaGame;
import ru.samsung.gamestudio.screen.ScreenRestart;

public class MyGdxGame extends Game {
	public SpriteBatch batch;
	OtrisovkaGame oTg;
	public static final int SCR_WIDTH = 1280;
	public static final int SCR_HEIGHT = 720;
	public OrthographicCamera camera;
 public ScreenRestart screenRestart;


	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();

		screenRestart = new ScreenRestart(this);
		camera.setToOrtho(false,SCR_WIDTH, SCR_HEIGHT);

		oTg = new OtrisovkaGame(this) ;
		setScreen(oTg);
	}


	@Override
	public void dispose () {
		batch.dispose();


	}
}

