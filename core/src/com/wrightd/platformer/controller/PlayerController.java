package com.wrightd.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.wrightd.platformer.model.Player;

public class PlayerController {
    public static Player player;
    public static String movementAction;
    public static String specialAction;

    public static boolean grounded;

    private static final float VELOCITY = 2f;
    private static final float MAX_VELOCITY = 2f;
    private static final float JUMP_VELOCITY = .5f;

    public static void initializeController() {
        player = new Player(new Vector2(0, 2), 70, 100, "img/aliens.png");
        movementAction = "";
        specialAction = "";
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

        if(movementAction .equalsIgnoreCase("right")) {
            player.physicsBody.applyLinearImpulse(VELOCITY, 0, position.x, position.y, true);
        }
        else if(movementAction .equalsIgnoreCase("left")) {
            player.physicsBody.applyLinearImpulse(-VELOCITY, 0, position.x, position.y, true);
        }

        if(movementAction .equalsIgnoreCase("jump")){
            if(grounded) {
                player.physicsBody.applyLinearImpulse(0, JUMP_VELOCITY, position.x, position.y, true);
            }
        }
        else if(movementAction .equalsIgnoreCase("rightJump")) {
            if(grounded) {
                player.physicsBody.applyLinearImpulse(VELOCITY, JUMP_VELOCITY, position.x, position.y, true);
            }
        }
        else if(movementAction .equalsIgnoreCase("leftJump")) {
            if(grounded) {
                player.physicsBody.applyLinearImpulse(-VELOCITY, JUMP_VELOCITY, position.x, position.y, true);
            }
        }
    }
}