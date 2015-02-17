package com.wrightd.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.wrightd.platformer.view.GameScreen;

import java.util.HashMap;

public class Player {
    public Vector2 position;
    public Spritesheet spriteSheet;
    public float width;
    public float height;
    public String currentAnimation;
    private float stateTime;
    private HashMap<String, Animation> animations;

    public Player(int width, int height) {
        position = new Vector2(0, 2);
        this.width = width * (1/70f);
        this.height = height * (1/70f);
        spriteSheet = new Spritesheet("img/aliens.png", width, height);
        animations = new HashMap<String, Animation>();

        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);

        Body playerBody = GameScreen.gameWorld.createBody(bodyDefinition);
        playerBody.setUserData(this);

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width / 2f, this.height / 2f), 0);

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        playerBody.createFixture(fixtureDefinition);
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
        stateTime = 0f;
    }

    public void draw(Batch spriteBatch) {
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);
    }

    public void update(float deltaTime) {
//        position.x += deltaTime;
        stateTime += deltaTime;
    }
}