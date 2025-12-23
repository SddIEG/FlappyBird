package ru.samsung.gamestudio.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class Text {
    BitmapFont font;



    int x, y;


    public Text(int x, int y) {

        this.x = x;
        this.y = y;

        font = new BitmapFont();
        font.getData().scale(5f);
        font.setColor(Color.WHITE);


    }



    public void draw(Batch batch) {
        font.draw(batch,"Fleppy Ptichka",x,y);
    }

    public void dispose() {        font.dispose();
    }



}


