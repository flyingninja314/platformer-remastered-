package com.wrightd.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.wrightd.platformer.controller.CameraController;
import com.wrightd.platformer.controller.LevelController;
import com.wrightd.platformer.controller.PlayerController;

public class GameScreen implements Screen {

    public GameScreen() {
        LevelController.initializeController();
        CameraController.initializeController();
        PlayerController.initializeController();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.41f, 0.41f, 0.41f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        CameraController.update();
        LevelController.update(delta);
        PlayerController.update(delta);

        LevelController.draw();
    }

    @Override
    public void resize(int width, int height) {
        CameraController.resize(width, height);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}