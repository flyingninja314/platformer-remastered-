package com.wrightd.platformer.controller;

import com.badlogic.gdx.math.Vector2;
import com.wrightd.platformer.model.Player;

public class PlayerController {
    public static Player player;

    public static void initializeController() {
        player = new Player(new Vector2(0, 2), 70, 100);
    }

    public static void update(float deltaTime){
        player.update(deltaTime);
    }
}