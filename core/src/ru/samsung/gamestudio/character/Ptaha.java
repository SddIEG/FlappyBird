package ru.samsung.gamestudio.character;

import static ru.samsung.gamestudio.MyGdxGame.SCR_HEIGHT;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Ptaha {
    int x, y;
    int speed;
    int frameCounter;
    Texture[] arrayTexture;
    boolean jamp = true;
    final int maxjampH = 100;
    int jampHeight;

    int height, weight;


    public Ptaha(int x, int y, int speed, int height, int weight) {
        this.x = x;
        this.y = y;
        this.speed = 8;
        frameCounter = 0;
        this.height = height;
        this.weight = weight;


        arrayTexture = new Texture[]{
                new Texture("skinPtaha/bird0.png"),
                new Texture("skinPtaha/bird1.png"),
                new Texture("skinPtaha/bird2.png")
        };
    }

    public void onClick() {
        jamp = true;
        jampHeight = maxjampH + y;

    }

    public void fly() {
        if (y >= jampHeight) {
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
        batch.draw(arrayTexture[frameCounter / frameM], x, y, weight, height);
        if (frameCounter++ == arrayTexture.length * frameM - 1) frameCounter = 0;
    }

    public void dispons() {
        for (Texture texture : arrayTexture) {
            texture.dispose();
        }
    }



    public boolean isInField() {
        if (y + height < 0) return false;
        if (y > SCR_HEIGHT) return false;
        return true;
    }

    public void setY(int y) {
        this.y = y;

    }
}
