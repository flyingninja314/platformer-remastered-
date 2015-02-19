package com.wrightd.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.wrightd.platformer.controller.LevelController;

import java.util.HashMap;

public class Sprite {
    public Body physicsBody;
    public Vector2 position;
    public Spritesheet spriteSheet;
    public float width;
    public float height;
    public String currentAnimation;
    private float stateTime;
    protected HashMap<String, Animation> animations;

    public Sprite(Vector2 position, int width, int height, String sheetPath) {
        this.position = position;
        spriteSheet = new Spritesheet(sheetPath, width, height);
        this.width = width * (LevelController.UNIT_SCALE);
        this.height = height * (LevelController.UNIT_SCALE);
        animations = new HashMap<String, Animation>();
        stateTime = 0f;
    }

    public void draw(Batch spriteBatch) {
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);
    }

    public void update(float deltaTime) {
        stateTime += deltaTime;
    }
}