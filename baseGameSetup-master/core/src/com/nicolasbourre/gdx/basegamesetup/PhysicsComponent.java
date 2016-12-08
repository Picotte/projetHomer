package com.nicolasbourre.gdx.basegamesetup;

/**
 * Created by 1285798 on 16-11-21.
 */
public interface PhysicsComponent
{
    void PhysicsComponent();

    void update(float deltaTime, GameObject gameObject);

    PhysicsComponent PlayerPhysicsComponent(PlayerInputComponent input, PlayerGraphicsComponent graphics);
}
