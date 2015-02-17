package com.wrightd.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.wrightd.platformer.controller.LevelController;
import com.wrightd.platformer.model.Player;

public class GameScreen implements Screen {
    public OrthographicCamera camera;

   public Player player;

    public GameScreen() {
        LevelController.initializeController();

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(14f, 14f * (height / width));
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);

        player = new Player(70, 100);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.41f, 0.41f, 0.41f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        LevelController.update(delta);

        player.update(delta);

        LevelController.draw();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height / width;
        camera.update();
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