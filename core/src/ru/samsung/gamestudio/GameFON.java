package ru.samsung.gamestudio;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class GameFON {
    Texture texture;

    GameFON() {
        texture = new Texture("fon/Untitled.png");
    }
    void draw(Batch batch) {
        batch.draw(texture, 0, 0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
    }

    void despose(){
        texture.dispose();
    }
}
