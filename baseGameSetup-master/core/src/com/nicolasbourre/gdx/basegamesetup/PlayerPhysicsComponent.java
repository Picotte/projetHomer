package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by 1285798 on 16-12-08.
 */
public class PlayerPhysicsComponent implements PhysicsComponent
{
    public Vector2 velocity;
    public Vector2 position;
    private PlayerInputComponent input;
    private PlayerGraphicsComponent graphics;

    public float speedFactor = 1;


    public PlayerPhysicsComponent() {

    }


    @Override
    public void PhysicsComponent() {

    }

    public void update(float deltaTime, GameObject gameObject)
    {
        position.add(velocity);

        if (input.isJumping()) {
            velocity.y -= 0.1;

            if (position.y < 1) {
                input.setJumping(false);
                velocity.y = 0;
            }
        }
    }

    @Override
    public PhysicsComponent PlayerPhysicsComponent(PlayerInputComponent input, PlayerGraphicsComponent graphics) {
        this.input = input;
        this.graphics = graphics;
        velocity = new Vector2(0,0);
        position = new Vector2(0,0);
        return this;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public float getSpeedFactor() {
        return speedFactor;
    }

    public void setSpeedFactor(float speedFactor) {
        this.speedFactor = speedFactor;
    }
}
