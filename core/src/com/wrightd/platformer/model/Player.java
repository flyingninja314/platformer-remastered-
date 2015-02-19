package com.wrightd.platformer.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.wrightd.platformer.controller.LevelController;

public class Player extends Sprite{

    public Player(Vector2 position, int width, int height) {
        super(position, width, height);
        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);

        physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
        physicsBody.setUserData(this);

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width / 2f, this.height / 2f), 0);

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        physicsBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();

        animations.put("walkRight", spriteSheet.createAnimation(31, 32, 0.125f));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walkRight"), true, false));

        animations.put("jumpRight", spriteSheet.createAnimation(27, 27, 0.125f));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jumpRight"), true, false));

        animations.put("duckRight", spriteSheet.createAnimation(25, 25, 0.125f));
        animations.put("duckLeft", spriteSheet.flipAnimation(animations.get("duckRight"), true, false));

        animations.put("hurtRight", spriteSheet.createAnimation(26, 26, 0.125f));
        animations.put("hurtLeft", spriteSheet.flipAnimation(animations.get("hurtRight"), true, false));

        animations.put("idleRight", spriteSheet.createAnimation(28, 28, 0.125f));
        animations.put("idleLeft", spriteSheet.flipAnimation(animations.get("idleRight"), true, false));

        animations.put("swimRight", spriteSheet.createAnimation(29, 30, 0.125f));
        animations.put("swimLeft", spriteSheet.flipAnimation(animations.get("swimRight"), true, false));

        animations.put("climb", spriteSheet.createAnimation(23, 24, 0.125f));

        animations.put("stand", spriteSheet.createAnimation(22, 22, 0.125f));

        currentAnimation = "walkRight";
    }

    public void draw(Batch spriteBatch) {
        super.draw(spriteBatch);
    }

    public void update(float deltaTime) {
        super.update(deltaTime);
    }
}