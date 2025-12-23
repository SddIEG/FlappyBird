package ru.samsung.gamestudio.character;

import static ru.samsung.gamestudio.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

public class Boss {
    Random r;
    Texture texture, bullet;
    int xB, x, y;
    int speed;
    int height, weight;


    public Boss(int x, int y, int height, int weight) {
        this.x = x;
        xB = SCR_WIDTH;
        this.y = y;
        this.height = height;
        this.weight = weight;

        bullet = new Texture("boss/bullet.png");
        texture = new Texture("boss/boss.png");


    }

    public void draw(Batch batch) {
        batch.draw(texture, x, y, height, weight);

    }

    public void dispose() {
        texture.dispose();
    }


    public void move() {
        x = r.nextInt(SCR_WIDTH + 1);
    }



}
