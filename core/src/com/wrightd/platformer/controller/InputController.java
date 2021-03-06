package com.wrightd.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.wrightd.platformer.model.InputControl;
import com.wrightd.platformer.model.Spritesheet;

public class InputController {
    private static Spritesheet spritesheet;
    private static InputControl left;

    public static void initializeController() {
        spritesheet = new Spritesheet("img/touch-controls.png", 80, 80);
        left = new InputControl(new Vector2(0,0), spritesheet.spriteFrames[0], "left");
        Gdx.input.setInputProcessor(createInputAdapter());
    }

    public static void draw(Batch spriteBatch) {
        spriteBatch.begin();
        left.draw(spriteBatch);
        spriteBatch.end();
    }

    private static InputAdapter createInputAdapter() {
        return new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if(left.getBoundingBox().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
                    PlayerController.movementAction = "right";
                }
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                PlayerController.movementAction = "";
                return true;
            }

            @Override
            public boolean keyDown(int keycode) {
                if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    PlayerController.movementAction = "right";
                    if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
                        PlayerController.movementAction = "rightJump";
                        return true;
                    }
                    return true;
                }
                else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                    PlayerController.movementAction = "left";
                    if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
                        PlayerController.movementAction = "rightJump";
                        return true;
                    }
                    return true;
                }
                else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
                    PlayerController.movementAction = "jump";
                    return true;
                }
                return true;
            }


            @Override
            public boolean keyUp(int keycode) {
                    PlayerController.movementAction = "";
                return true;
            }
        };

    }
}