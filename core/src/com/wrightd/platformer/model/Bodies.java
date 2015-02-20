package com.wrightd.platformer.model;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.wrightd.platformer.controller.LevelController;

public class Bodies {

    public static void createBody(MapObject mapObject) {
        String bodyType = mapObject.getProperties().get("type").toString();

        if(bodyType .equalsIgnoreCase("ground")) {
            PolylineMapObject polylineMapObject = (PolylineMapObject)mapObject;
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.StaticBody;
            bodyDefinition.position.set(polylineMapObject.getPolyline().getX() * LevelController.UNIT_SCALE, polylineMapObject.getPolyline().getY() * LevelController.UNIT_SCALE);

            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
            ChainShape chainShape = new ChainShape();

            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = chainShape;

            physicsBody.createFixture(fixtureDefinition);
            chainShape.dispose();
        }
        else if(bodyType .equalsIgnoreCase("slope")) {
            PolygonMapObject polygonObject = (PolygonMapObject)mapObject;
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.StaticBody;
            bodyDefinition.position.set(polygonObject.getPolygon().getX() * LevelController.UNIT_SCALE, polygonObject.getPolygon().getY() *LevelController.UNIT_SCALE);

            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
            PolygonShape slopeShape = new PolygonShape();

            float[] transformedVertices = new float[6];

            for(int index = 0; index < transformedVertices.length; index++) {
                transformedVertices[index] = polygonObject.getPolygon().getVertices()[index] * LevelController.UNIT_SCALE;
            }

            slopeShape.set(transformedVertices);

            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = slopeShape;

            physicsBody.createFixture(fixtureDefinition);
            slopeShape.dispose();
        }
    }
}