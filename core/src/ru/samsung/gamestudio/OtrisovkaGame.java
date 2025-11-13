package ru.samsung.gamestudio;

import static ru.samsung.gamestudio.MyGdxGame.SCR_HEIGHT;
import static ru.samsung.gamestudio.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class OtrisovkaGame implements Screen {

    MyGdxGame mGG;
    GameFON gameFon;
    Ptaha ptaha;
    boolean isGameOver;
    PointCounter pointCounter;
    final int pointCounterMarginTop = 60;
    final int pointCounterMarginRight = 400;

    Tryba[] trybi;


    int gamePoints;
    int countTryba = 3;

    OtrisovkaGame(MyGdxGame mGG) {
        this.mGG = mGG;

        ptaha = new Ptaha(0, 0, 10, 200, 200);
        initTryba();
    }

    void initTryba() {

        trybi = new Tryba[countTryba];
        for (int i = 0; i < countTryba; i++) {
            trybi[i] = new Tryba(countTryba, i);
        }
    }

    @Override
    public void show() {
        gamePoints = 0;
        isGameOver = false;
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            ptaha.onClick();
        }
        pointCounter = new PointCounter(SCR_WIDTH - pointCounterMarginRight, SCR_HEIGHT - pointCounterMarginTop);

        ptaha.fly();
        if (!ptaha.isInField()) {
            System.out.printf("Lox");


            isGameOver = true;
        }
        for (Tryba tryba : trybi) {
            tryba.move();


            if (tryba.isHit(ptaha)) {
                isGameOver = true;
                System.out.println("hit");
            } else if (tryba.isNeedPoints(ptaha)) {
                gamePoints += 1;
                tryba.setPointReceived();
                System.out.println(gamePoints);
            }
        }
        ScreenUtils.clear(1, 1, 0, 1);
        mGG.camera.update();
        mGG.batch.setProjectionMatrix(mGG.camera.combined);
        mGG.batch.begin();

        gameFon.draw(mGG.batch);
        ptaha.draw(mGG.batch);
        for (Tryba tryba : trybi) tryba.draw(mGG.batch);
        pointCounter.draw(mGG.batch, gamePoints);

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
        ptaha.dispons();
        gameFon.despose();
        pointCounter.despose();
        for (int i = 0; i < countTryba; i++) {
            trybi[i].disponse();
        }
    }
}
