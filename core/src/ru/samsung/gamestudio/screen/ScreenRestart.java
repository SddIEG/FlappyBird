package ru.samsung.gamestudio.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.components.PointCounter;
import ru.samsung.gamestudio.components.TextButton;

public class ScreenRestart implements Screen {
    MyGdxGame mGG;
    TextButton buttonRestart , buttonMenu;
    PointCounter pointCounter;
    GameFON background;

    int gamePoint;
    public ScreenRestart(MyGdxGame mGG) {

        this.mGG = mGG;
        pointCounter = new PointCounter(750, 530);
        buttonRestart = new TextButton(100, 400, "Restart");
        buttonMenu = new TextButton(100, 100, "Menu");
        background = new GameFON("fon/restart_bg.png");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        if (Gdx.input.justTouched()) {
            Vector3 touch = mGG.camera.unproject(
                    new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0)
            );
            if (buttonRestart.isHit((int) touch.x, (int) touch.y)) {
                mGG.setScreen(mGG.oTg);
            } else if (buttonMenu.isHit((int) touch.x, (int) touch.y)){
                mGG.setScreen(mGG.screenMenu);
            }
        }
        mGG.camera.update();
        mGG.batch.setProjectionMatrix(mGG.camera.combined);
        mGG.batch.begin();

        background.draw(mGG.batch);
        buttonRestart.draw(mGG.batch);
        buttonMenu.draw(mGG.batch);
        pointCounter.draw(mGG.batch, gamePoint);

        mGG.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }



    @Override
    public void dispose() {
        background.despose();
        buttonRestart.dispose();
    }

}



