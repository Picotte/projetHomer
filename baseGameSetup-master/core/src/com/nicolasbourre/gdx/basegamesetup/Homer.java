package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

/**
 * Created by nbourre on 2016-11-11.
 */

public class Homer extends Actor{


    Homer() {
        this.velocity = new Vector2(0, 0);
        this.position = new Vector2(0, 0);
        this.animations = new HashMap<String, Animation>();
        initTextures();

    }

    void initTextures() {

        setAtlasWalking(new TextureAtlas("homer_walking.txt"));
        setWalkAnimation(new Animation(1 / 8f, getAtlasWalking().getRegions()));
        getWalkAnimation().setPlayMode(Animation.PlayMode.LOOP);


        setAtlasRunning(new TextureAtlas("homer_running.txt"));
        setRunAnimation(new Animation(1 / 8f, getAtlasRunning().getRegions()));
        getRunAnimation().setPlayMode(Animation.PlayMode.LOOP);

        setAtlasJumping(new TextureAtlas("homer_running.txt"));
        setJumpAnimation(new Animation(1 / 8f, getAtlasRunning().getRegions()));
        getJumpAnimation().setPlayMode(Animation.PlayMode.LOOP);

        addAnimation("Walking", getWalkAnimation());
        addAnimation("Running", getRunAnimation());
        addAnimation("Jumping", getJumpAnimation());
    }


}
