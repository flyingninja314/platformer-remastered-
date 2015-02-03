package com.wrightd.platformer;

import com.badlogic.gdx.Game;
import com.wrightd.platformer.view.GameScreen;

public class Platformer extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}