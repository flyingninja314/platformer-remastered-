package com.wrightd.platformer.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public static TiledMap map;

    public Level(String mapPath) {
        map = new TmxMapLoader().load(mapPath);
    }
}