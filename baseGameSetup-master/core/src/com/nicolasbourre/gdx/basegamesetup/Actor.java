package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

/**
 * Created by 1285798 on 16-11-21.
 */
public abstract class Actor {

    private TextureAtlas atlasWalking;
    private Animation walkAnimation;

    private TextureAtlas atlasRunning;
    private Animation runAnimation;

    private TextureAtlas atlasJumping;
    private Animation jumpAnimation;

    private PhysicalComponent physic = new PhysicalComponent();
    private GraphicalComponent graph = new GraphicalComponent();
    private InputComponent input = new InputComponent();


    //protected Vector2 velocity;
    //protected Vector2 position;
    //protected HashMap<String, Animation> animations;

    //private TextureRegion currentFrame;

    private float elapsedTime = 0;

    //private boolean isFacingLeft = false;
    //private boolean isJumping = false;

    //private boolean activeKeys[];

    //private float speedFactor = 1;

    //private String currentAnimation = "walking";

    private Context ctx = new Context(new Walking());

    //---------------------------------------------------------------------------------------------------------------------------
    public Actor()
    {

    }
    //---------------------------------------------------------------------------------------------------------------------------

    void update(float deltaTime) {
        elapsedTime += deltaTime;

        if (activeKeys[Input.Keys.SHIFT_LEFT]) {
            //currentAnimation = "running";
            ctx.setState(new Running());
            speedFactor = 2f;
        } else
        {
            //currentAnimation = "walking";
            ctx.setState(new Walking());
            speedFactor = 1f;
        }

        if (activeKeys[Input.Keys.SPACE]) {
            isJumping = true;

            //currentAnimation = "running";
            ctx.setState(new Jumping());
            velocity.y = 2 * speedFactor;
        }

        if (activeKeys[Input.Keys.LEFT]) {
            isFacingLeft = true;
            velocity.x = -1 * speedFactor;

        } else if (activeKeys[Input.Keys.RIGHT]) {
            isFacingLeft = false;
            velocity.x = 1* speedFactor;
        } else {
            velocity.x = 0;
            //currentAnimation = "walking";
            ctx.setState(new Walking());
        }

        String namest = ctx.getState().getClass().getSimpleName();
        currentFrame = animations.get(namest).getKeyFrame(elapsedTime);

        position.add(velocity);

        if (isJumping) {
            velocity.y -= 0.1;

            if (position.y < 1) {
                isJumping = false;
                velocity.y = 0;
            }
        }

    }

    public void draw(SpriteBatch batch) {


        if(!isFacingLeft) {
            batch.draw(currentFrame, position.x, position.y);
        } else {

            batch.draw(currentFrame, position.x + currentFrame.getRegionWidth() , position.y, -currentFrame.getRegionWidth(), currentFrame.getRegionHeight());
        }
    }

    public void setActiveKeys(boolean[] activeKeys) {
        this.activeKeys = activeKeys;
    }

    void addAnimation(String name, Animation animation) {
        animations.put(name, animation);
    }

    public TextureAtlas getAtlasWalking() {
        return atlasWalking;
    }

    public Animation getWalkAnimation() {
        return walkAnimation;
    }

    public TextureAtlas getAtlasRunning() {
        return atlasRunning;
    }

    public Animation getRunAnimation() {
        return runAnimation;
    }

    public TextureAtlas getAtlasJumping() {
        return atlasJumping;
    }

    public Animation getJumpAnimation() {
        return jumpAnimation;
    }

    public void setAtlasWalking(TextureAtlas atlasWalking) {
        this.atlasWalking = atlasWalking;
    }

    public void setWalkAnimation(Animation walkAnimation) {
        this.walkAnimation = walkAnimation;
    }

    public void setAtlasRunning(TextureAtlas atlasRunning) {
        this.atlasRunning = atlasRunning;
    }

    public void setRunAnimation(Animation runAnimation) {
        this.runAnimation = runAnimation;
    }

    public void setAtlasJumping(TextureAtlas atlasJumping) {
        this.atlasJumping = atlasJumping;
    }

    public void setJumpAnimation(Animation jumpAnimation) {
        this.jumpAnimation = jumpAnimation;
    }
}
