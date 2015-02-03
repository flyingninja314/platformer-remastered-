package com.wrightd.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
    public Texture spriteSheet;

    public Player() {
        position = new Vector2(0, 0);
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));
    }

    public void draw(Batch spriteBatch) {
        spriteBatch.draw(spriteSheet, 0, 0, 70, 100);
    }

    public void update(float deltaTime) {

    }
}