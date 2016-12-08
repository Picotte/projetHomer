package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BaseGame extends ApplicationAdapter implements InputProcessor {

    SpriteBatch batch;
    static final int NB_KEYS = 256;
    boolean activeKeys[] = new boolean[NB_KEYS];

    float deltaTime;
    float elapsedTime = 0;

    GameObject homer;



    @Override
    public void create() {

        batch = new SpriteBatch();
        this.initActiveKeys();
        PlayerGraphicsComponent graphics = new PlayerGraphicsComponent();
        PlayerPhysicsComponent physics = new PlayerPhysicsComponent();
        PlayerInputComponent input = new PlayerInputComponent();

        homer = new GameObject(input.PlayerInputComponent(physics, graphics), physics.PlayerPhysicsComponent(input, graphics),graphics.PlayerGraphicsComponent(physics, input));
        homer.setInputKey(activeKeys);
        homer.setKeys(Input.Keys.A,Input.Keys.D,Input.Keys.SHIFT_LEFT, Input.Keys.W);

        Gdx.input.setInputProcessor(this);
    }
    @Override
    public void render() {
        deltaTime = Gdx.graphics.getDeltaTime();
        elapsedTime += deltaTime;

        update(deltaTime);
        draw(elapsedTime);


    }

    private void update(float deltaTime) {
        homer.update(deltaTime);
    }

    private void draw(float elapsedTime) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();
        homer.showOnScreen(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();

    }



    @Override
    public boolean keyDown(int keycode) {
        activeKeys[keycode] = true;

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        activeKeys[keycode] = false;

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    void initActiveKeys() {
        for (int i = 0; i < activeKeys.length; i++) {
            activeKeys[i] = false;
        }
    }

}