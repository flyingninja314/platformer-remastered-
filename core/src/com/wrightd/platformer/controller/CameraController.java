package com.wrightd.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;
    public static OrthographicCamera inputCamera;

    public static float widthScale;
    public static float heightScale;

    public static void initializeController() {
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(14f, 14f * (height / width));
        inputCamera = new OrthographicCamera(14f, 14f * (height / width));
        inputCamera.position.set(inputCamera.viewportWidth / 2f, inputCamera.viewportHeight / 2f, 0);
//          camera view is like a graph, so without setting camera position, the map appears in the 1st quadrant of a 4 quadrant graph (       |  x    ) and this line fixes it so that the map is on the whole screen
//                                                                                                                                     (-------|-------)
//                                                                                                                                     (       |       )

        inputCamera.update();
    }

    public static void update() {
        camera.position.set(PlayerController.player.position.x, PlayerController.player.position.y, 0);
        camera.update();
    }

    public static void resize(int width, int height) {
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height / width;
        camera.update();

        inputCamera.viewportWidth = 14f;
        inputCamera.viewportHeight = 14f * height / width;
        inputCamera.position.set(inputCamera.viewportWidth / 2f, inputCamera.viewportHeight / 2f, 0);
        inputCamera.update();

        widthScale = width / inputCamera.viewportWidth * LevelController.UNIT_SCALE;
        heightScale = height / inputCamera.viewportHeight * LevelController.UNIT_SCALE;
    }
}