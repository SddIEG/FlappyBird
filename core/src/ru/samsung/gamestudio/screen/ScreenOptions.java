package ru.samsung.gamestudio.screen;

import static ru.samsung.gamestudio.MyGdxGame.SCR_HEIGHT;
import static ru.samsung.gamestudio.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.components.TextButton;

public class ScreenOptions implements Screen {
    MyGdxGame mGG;
    TextButton buttonMenu, buttonFon, buttonOptions;
    GameFON backround, backroundMeryCristmas , backroundMaldivi;
   int nFon = 0;

    int y = 220;

    public ScreenOptions(MyGdxGame mGG) {
        this.mGG = mGG;
        buttonMenu = new TextButton(20, y - 200, "Menu");
        buttonFon = new TextButton(0, 0, "");
        backround = new GameFON("fon/Untitled.png");
        backroundMeryCristmas = new GameFON("fon/Untitled.png");
        backroundMaldivi = new GameFON("fon/Untitled.png");
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
            if (buttonMenu.isHit((int) touch.x, (int) touch.y)) {
                mGG.setScreen(mGG.screenMenu);
            }else if (buttonFon.isHit((int) touch.x, (int) touch.y)){
                backround.despose();
                for (int i = 0; i <3; i++) {
                    switch (i){
                        case 0: {

                            nFon = 0;
                        }
                        case 1 :{

                            nFon= 1;

                        }
                        case 2 : {

                           nFon = 2;
                        }
                        i =0 ;
                    }
                }
            }


        }
        mGG.camera.update();
        mGG.batch.setProjectionMatrix(mGG.camera.combined);
        mGG.batch.begin();

        backround.draw(mGG.batch);

        buttonMenu.draw(mGG.batch);

        mGG.batch.end();

    }
    public void fon(int nFon){
        this.nFon = nFon;
        switch (nFon){
            case 0: {
                backroundMeryCristmas.draw(mGG.batch);

            }
            case 1 :{
                backroundMaldivi.draw(mGG.batch);


            }
            case 2 : {
                backround.draw(mGG.batch);

            }

        }

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
