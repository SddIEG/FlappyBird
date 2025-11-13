package ru.samsung.gamestudio;

import static ru.samsung.gamestudio.MyGdxGame.SCR_HEIGHT;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Ptaha {
    int x, y;
    int speed;
    int frameTexture;
    Texture[] arrayTexture;
    boolean jamp;
    final int maxjampH = 100;
    int height, weight;


    public Ptaha(int x, int y, int speed, int jampH, int weight) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        frameTexture = 0;
        this.height = jampH;
        this.weight = weight;


        arrayTexture = new Texture[]{
                new Texture("skinPtaha/bird0.png"),
                new Texture("skinPtaha/bird1.png"),
        };
    }


    public void fly() {
        if (y >= height) {
            jamp = false;
        }

        if (jamp) {
            y += speed;
        } else {
            y -= speed;
        }

    }

    public void draw(Batch batch) {
        int frameM = 10;
        batch.draw(arrayTexture[frameTexture / frameM], x, y, weight, weight * 3 / 4);
        if (frameTexture++ == arrayTexture.length * frameM - 1) frameTexture = 0;
    }

    void dispons() {
        for (Texture texture : arrayTexture) {
            texture.dispose();
        }
    }

    public void onClick() {
        jamp = true;
        height = maxjampH + y;

    }

    public boolean isInField() {
        if (y + height < 0) return false;
        if (y > SCR_HEIGHT) return false;
        return true;
    }
}
