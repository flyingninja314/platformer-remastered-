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

    public Animation createAnimation(int startFrame, int lastFrame, float animationSpeed) {
        int counter = (lastFrame + 1) - startFrame;
        TextureRegion[] animationFrames = new TextureRegion[counter];

        for(int index = lastFrame; index >= startFrame; index--) {
            animationFrames[counter] = spriteFrames[index];
        }

        animation = new Animation(animationSpeed, animationFrames);
        return animation;
    }
}