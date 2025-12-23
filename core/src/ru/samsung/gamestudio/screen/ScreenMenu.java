package ru.samsung.gamestudio.screen;

import static ru.samsung.gamestudio.MyGdxGame.SCR_HEIGHT;
import static ru.samsung.gamestudio.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.components.Text;
import ru.samsung.gamestudio.components.TextButton;

public class ScreenMenu implements Screen {
    MyGdxGame mGG;
    TextButton buttonGame, buttonExit;
    GameFON gameFON;
    Text text;

    int y = 220;




    public  ScreenMenu(MyGdxGame mGG){
        this.mGG = mGG;
        text = new Text(SCR_HEIGHT-100,SCR_WIDTH-100 );
        buttonGame = new TextButton(0,y,"Game");
        buttonExit = new TextButton(0, y -200, "Exit");
        gameFON = new GameFON("fon/Untitled.png");
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
            if (buttonGame.isHit((int) touch.x, (int) touch.y)) {
                mGG.setScreen(mGG.oTg);
            }else if (buttonExit.isHit((int) touch.x , (int ) touch.y)){
                Gdx.app.exit();
            }

        }
        mGG.camera.update();
        mGG.batch.setProjectionMatrix(mGG.camera.combined);
        mGG.batch.begin();

        gameFON.draw(mGG.batch);
        
        buttonGame.draw(mGG.batch);
        buttonExit.draw(mGG.batch);
        text.draw(mGG.batch);
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

    }
}
