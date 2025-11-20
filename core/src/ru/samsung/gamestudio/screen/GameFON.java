package ru.samsung.gamestudio.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import ru.samsung.gamestudio.MyGdxGame;

public class GameFON {
    Texture texture;
    int textyra1, textyra2;
    int speed = 2;

   public GameFON(String pathToTextyra) {
        textyra1 = 0;
        textyra2 = MyGdxGame.SCR_WIDTH;
        texture = new Texture(pathToTextyra);


    }


    public void move() {
        textyra1 -= speed;
        textyra2 -= speed;

        if (textyra1 <= -MyGdxGame.SCR_WIDTH) {
            textyra1 = MyGdxGame.SCR_WIDTH;
        }
        if (textyra2 <= -MyGdxGame.SCR_WIDTH) {
            textyra2 = MyGdxGame.SCR_WIDTH;
        }
    }

    public void draw(Batch batch) {
        batch.draw(texture, textyra1, 0, MyGdxGame.SCR_WIDTH +2, MyGdxGame.SCR_HEIGHT);
        batch.draw(texture, textyra2, 0, MyGdxGame.SCR_WIDTH + 2 , MyGdxGame.SCR_HEIGHT);
    }

    public void despose() {
        texture.dispose();
    }
}

