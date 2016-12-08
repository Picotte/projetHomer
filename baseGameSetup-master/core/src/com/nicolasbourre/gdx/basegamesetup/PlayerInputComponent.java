package com.nicolasbourre.gdx.basegamesetup;

/**
 * Created by 1285798 on 16-12-08.
 */
public class PlayerInputComponent implements InputComponent{

    private boolean isFacingLeft = false;
    private boolean isJumping = false;

    boolean activeKeys[];

    private PlayerPhysicsComponent physics;
    private PlayerGraphicsComponent graphics;


    public PlayerInputComponent() {

    }


    @Override
    public void InputComponent() {

    }

    public void update(float deltaTime, GameObject gameObject) {

        if (activeKeys[gameObject.getRunKey()]) {
            graphics.currentAnimation = "running";
            physics.speedFactor = 2f;
        } else
        {
            graphics.currentAnimation = "walking";
            physics.speedFactor = 1f;
        }

        if (activeKeys[gameObject.getJumpKey()]) {
            this.isJumping = true;

            graphics.currentAnimation = "running";
            physics.velocity.y = 2 * physics.speedFactor;
        }

        if (activeKeys[gameObject.getLeftKey()]) {
            this.isFacingLeft = true;
            physics.velocity.x = -1 * physics.speedFactor;

        } else if (activeKeys[gameObject.getRightKey()]) {
            this.isFacingLeft = false;
            physics.velocity.x = 1* physics.speedFactor;
        } else {
            physics.velocity.x = 0;
            graphics.currentAnimation = "walking";
        }

    }

    @Override
    public InputComponent PlayerInputComponent(PlayerPhysicsComponent physics, PlayerGraphicsComponent graphics) {
        this.physics = physics;
        this.graphics = graphics;
        return this;
    }

    public void setActiveKeys(boolean[] activeKeys) {
        this.activeKeys = activeKeys;
    }
    public boolean isFacingLeft() {
        return isFacingLeft;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    public boolean[] getActiveKeys() {
        return activeKeys;
    }
}
