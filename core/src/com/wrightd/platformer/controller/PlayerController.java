package com.wrightd.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.wrightd.platformer.model.Player;

public class PlayerController {
    public static Player player;

    private static final float VELOCITY = 1f;
    private static final float MAX_VELOCITY = 1f;

    public static void initializeController() {
        player = new Player(new Vector2(0, 2), 70, 100);
    }

    public static void update(float deltaTime){
        handleInput();
        player.update(deltaTime);
    }

    public static void draw(Batch spriteBatch) {
        player.draw(spriteBatch);
    }

    private static void handleInput(){
        Vector2 velocity = player.physicsBody.getLinearVelocity();
        Vector2 position = player.physicsBody.getPosition();

        if(Math.abs(velocity.x) > MAX_VELOCITY) {
            velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.physicsBody.applyLinearImpulse(VELOCITY, 0, position.x, position.y, true);
        }
    }
}