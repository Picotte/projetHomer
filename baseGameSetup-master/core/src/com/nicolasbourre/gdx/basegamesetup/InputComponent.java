package com.nicolasbourre.gdx.basegamesetup;

/**
 * Created by 1285798 on 16-11-21.
 */
public interface InputComponent{
    void InputComponent();


    void update(float deltaTime, GameObject gameObject);


    InputComponent PlayerInputComponent(PlayerPhysicsComponent physics, PlayerGraphicsComponent graphics);

    void setActiveKeys(boolean[] key);
}
