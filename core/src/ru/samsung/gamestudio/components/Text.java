package ru.samsung.gamestudio.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class Text {
    BitmapFont font;

    String text;
    Texture texture;

    int x, y;
    int speed = 5;
    int textX, textY;
    int buttonWidth, buttonHeight;
    int textWidth, textHeight;

    public Text(int x, int y, String text) {
        this.text = text;
        this.x = x;
        this.y = y;

        font = new BitmapFont();
        font.getData().scale(5f);
        font.setColor(Color.WHITE);

        GlyphLayout gl = new GlyphLayout(font, text);
        textWidth = (int) gl.width;
        textHeight = (int) gl.height;

        textX = x + (buttonWidth - textWidth) / 2;
        textY = y + (buttonHeight + textHeight) / 2;
    }



    public void draw(Batch batch) {
        font.draw(batch, text, textX, textY);
    }

    public void dispose() {        font.dispose();
    }



}


