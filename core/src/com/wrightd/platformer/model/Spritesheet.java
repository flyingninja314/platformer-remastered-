package com.wrightd.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spritesheet {
    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;
    public Animation animation;

    public Spritesheet(String pathToFile, int width, int height) {
        spriteSheet = new Texture(Gdx.files.internal(pathToFile));

        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, width, height);

        int counter = 0;
        for(int row = 0; row < spriteSheetFrames.length; row++) {
            for(int column = 0; column < spriteSheetFrames[row].length; column++) {
                counter++;
            }
        }

        spriteFrames = new TextureRegion[counter];

        counter = 0;
        for(TextureRegion[] row : spriteSheetFrames) {
            for(TextureRegion sprite : row) {
                spriteFrames[counter++] = sprite;
            }
        }

    }

    public Animation createAnimation() {
        TextureRegion[] animationFrames = new TextureRegion[2];
        animationFrames[0] = spriteFrames[9];
        animationFrames[1] = spriteFrames[10];
        animation = new Animation(.125f, animationFrames);
        return animation;
    }
}