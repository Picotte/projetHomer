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

public class GameObject {

    private InputComponent input;
    private GraphicsComponent graphics;
    private PhysicsComponent physics;

    public int runKey;
    private int leftKey;
    private int rightKey;
    private int jumpKey;

    TextureAtlas atlasWalking;
    Animation walkAnimation;

    TextureAtlas atlasRunning;
    Animation runAnimation;



    GameObject(InputComponent inputs, PhysicsComponent physics, GraphicsComponent graphics)
    {
        this.input = inputs;
        this.physics = physics;
        this.graphics = graphics;

        initTextures();

        graphics.addAnimation("walking", walkAnimation);
        graphics.addAnimation("running", runAnimation);

    }

    public void initTextures(){
        atlasWalking = new TextureAtlas("homer_walking.txt");
        walkAnimation = new Animation(1 / 8f, atlasWalking.getRegions());
        walkAnimation.setPlayMode(Animation.PlayMode.LOOP);


        atlasRunning = new TextureAtlas("homer_running.txt");
        runAnimation = new Animation(1 / 8f, atlasRunning.getRegions());
        runAnimation.setPlayMode(Animation.PlayMode.LOOP);

    }

    void update(float deltaTime) {
        input.update( deltaTime, this);
        physics.update(deltaTime, this);
        graphics.update(deltaTime, this);

    }

    void showOnScreen(SpriteBatch batch){
        graphics.draw(batch);
    }

    public void setKeys(int left, int right, int run, int jump){
        this.leftKey = left;
        this.rightKey = right;
        this.runKey = run;
        this.jumpKey = jump;
    }
    public int getRunKey() {
        return runKey;
    }

    public int getLeftKey() {
        return leftKey;
    }

    public int getRightKey() {
        return rightKey;
    }

    public int getJumpKey() {
        return jumpKey;
    }
    void setInputKey(boolean key[]){
        input.setActiveKeys(key);
    }

}