package ru.samsung.gamestudio.character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Bullet {

    int x,y;
    int height,weight;
    int speed;
    Texture texture;

    public Bullet(int x,int y,int height,int weight){
        this.x = x;
        this.y = y;
        this.height = height;
        this.weight = weight;
        speed = 2;


        texture = new Texture("boss/bullet.png");

    }

    public void draw(Batch batch){
        batch.draw(texture,x,y,height,weight);
    }


    public void move(){
        x -=speed;
    }


    public boolean isHit(Ptaha ptaha) {
return  true;

    }
}
