package com.wrightd.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
    public Animation animation;
    public Spritesheet spriteSheet;
    public int width;
    public int height;
    private float stateTime;

    public Player() {
        position = new Vector2(0, 2);
        width = 70;
        height = 100;
        spriteSheet = new Spritesheet("img/aliens.png", width, height);
        animation = spriteSheet.createAnimation(9, 10, 0.125f);
        animation = spriteSheet.flipAnimation(animation, true, false);
        stateTime = 0f;
    }

    public void draw(Batch spriteBatch) {
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, width * (1/70f), height * (1/70f));
    }

    public void update(float deltaTime) {
        position.x += deltaTime;
        stateTime += deltaTime;
    }
}