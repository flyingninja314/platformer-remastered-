package com.wrightd.platformer.controller;

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
    }

    public static void draw(Batch spriteBatch) {
        spriteBatch.begin();
        left.draw(spriteBatch);
        spriteBatch.end();
    }

}