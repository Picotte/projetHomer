package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;


/**
 * Created by 1285798 on 16-12-08.
 */
public class PlayerGraphicsComponent implements GraphicsComponent
{
    private HashMap<String, Animation> animations;
    private TextureRegion currentFrame;
    public String currentAnimation;
    private PlayerPhysicsComponent physics;
    private PlayerInputComponent input;
    private float elapsedTime = 0;


    public PlayerGraphicsComponent() {

    }


    @Override
    public void GraphicsComponent() {

    }

    public void update(float deltaTime, GameObject gameObject)
    {
        elapsedTime+=deltaTime;
        if(input.isJumping())
            currentAnimation="running";
        else
            currentAnimation=this.currentAnimation;
        currentFrame = animations.get(currentAnimation).getKeyFrame(elapsedTime);
    }
    public void draw(SpriteBatch batch) {
        if(!this.input.isFacingLeft()) {
            batch.draw(currentFrame, physics.getPosition().x, physics.getPosition().y);
        }
        else {

            batch.draw(currentFrame, physics.getPosition().x + currentFrame.getRegionWidth(), physics.getPosition().y, -currentFrame.getRegionWidth(), currentFrame.getRegionHeight());
        }
    }

    @Override
    public GraphicsComponent PlayerGraphicsComponent(PlayerPhysicsComponent physics, PlayerInputComponent input) {
        this.physics = physics;
        this.input = input;
        animations = new HashMap<String, Animation>();
        return this;
    }


    public void addAnimation(String name, Animation animation) {
        animations.put(name, animation);
    }
}
