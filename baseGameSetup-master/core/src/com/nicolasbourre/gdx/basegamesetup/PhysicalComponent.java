package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by 1285798 on 16-11-21.
 */
public class PhysicalComponent extends Component{
    private Vector2 velocity;
    private Vector2 position;
    private float speedFactor = 1;

    public Vector2 getVelocity() {
        return velocity;
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getSpeedFactor() {
        return speedFactor;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setSpeedFactor(float speedFactor) {
        this.speedFactor = speedFactor;
    }

}
