package com.nicolasbourre.gdx.basegamesetup;


import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GraphicsComponent
{
    void GraphicsComponent();

    void update(float deltaTime, GameObject gameObject);


    void addAnimation(String walking, Animation walkAnimation);

    void draw(SpriteBatch batch);

    GraphicsComponent PlayerGraphicsComponent(PlayerPhysicsComponent physics, PlayerInputComponent input);
}
