package ru.samsung.gamestudio.character;

import static ru.samsung.gamestudio.MyGdxGame.SCR_HEIGHT;
import static ru.samsung.gamestudio.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

public class Tryba {
    Random r;
    Texture textyraUpTryba;
    Texture textyraDownTryba;

    boolean isPointReceived = false;
    int gapY;
    int wight = 200, height = 700;
    int gapHeight = 400;
    int padding = 100;
    int speed = 10;
    int distanceTubes;
    int x;



    public Tryba(int countTryba, int idxTryba) {
        r = new Random();
        gapY = gapHeight / 2 + padding + r.nextInt(SCR_HEIGHT - 2 * (padding + gapHeight / 2));
        distanceTubes = (SCR_WIDTH + wight) / (countTryba - 1);
        x = distanceTubes * idxTryba + SCR_WIDTH;

        textyraUpTryba = new Texture("trybi/tube_flipped.png");
        textyraDownTryba = new Texture("trybi/tube.png");

    }

    public void draw(Batch batch) {
        batch.draw(textyraUpTryba, x, gapY + gapHeight / 2, wight, height);
        batch.draw(textyraDownTryba, x, gapY - gapHeight / 2 - height, wight, height);
    }

    public void move() {
        x -= speed;
        if (x < -wight) {
            isPointReceived = false;
            x = SCR_WIDTH + distanceTubes;
            gapY = gapHeight / 2 + padding + r.nextInt(SCR_HEIGHT - 2 * (padding + gapHeight / 2));
        }
    }

    public void last(){
        x -= speed;

    }

    public void disponse() {
        textyraUpTryba.dispose();
        textyraDownTryba.dispose();
    }

    public boolean isHit(Ptaha ptaha) {

        if (ptaha.y <= gapY - gapHeight / 2 && ptaha.x + ptaha.weight >= x && ptaha.x <= x)
            return true;
        if (ptaha.y + ptaha.height >= gapY + gapHeight / 2 && ptaha.x + ptaha.weight >= x && ptaha.x <= x)
            return true;


        return false;
    }

    public boolean isNeedPoints(Ptaha ptaha) {
        System.out.print("ptahaX = " +ptaha.x);
        System.out.print("X = " +x);
        System.out.println("w = " +wight);
        if (ptaha.x >= x + wight ){
            return  !isPointReceived;
        }
        return false;
    }

    public void setPointReceived() {
        isPointReceived = true;
    }


}


