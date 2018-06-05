package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    TextureAtlas textureAtlas;
    TextureRegion textureRegion;
    Sprite sprite;
    Animation<TextureRegion> stillAnimation;
    Animation movingAnimation;
    float timeForStill = 0.0f;


    @Override
    public void create () {
        batch = new SpriteBatch();
        textureAtlas = new TextureAtlas(Gdx.files.internal("JolteonSpriteSheet/JolteonAtlas.atlas"));
        textureRegion = textureAtlas.findRegion("Jolteon1");
        sprite = new Sprite(textureRegion);
        sprite.setPosition(Gdx.graphics.getWidth()/2-sprite.getWidth(),Gdx.graphics.getHeight()/2-sprite.getHeight());
        stillAnimation = new Animation(1/10f,textureAtlas.getRegions());

    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0.49411764705f, 0.80784313725f, 0.02352941176f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        timeForStill += Gdx.graphics.getDeltaTime();
        batch.draw(stillAnimation.getKeyFrame(timeForStill,true),0,0);


        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }
}