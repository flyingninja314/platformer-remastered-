package com.wrightd.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class LevelController {
    public static TiledMap map;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;

    public static World gameWorld;
    private static Box2DDebugRenderer debugRenderer;



    public static void initializeController() {
        map = new TmxMapLoader().load("map/level01.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
        gameWorld = new World(new Vector2(0, -10), true);
        debugRenderer = new Box2DDebugRenderer();

        spriteBatch = renderer.getSpriteBatch();

    }

    public static void draw() {
        spriteBatch.begin();
        player.draw(spriteBatch);
        spriteBatch.end();
        debugRenderer.render(gameWorld, CameraController.camera.combined);
    }

    public static void update(float deltaTime) {

        renderer.setView(CameraController.camera);
        renderer.render();

    }
}