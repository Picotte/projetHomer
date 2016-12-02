package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

/**
 * Created by 1285798 on 16-11-21.
 */
public class GraphicalComponent extends Component {
    private HashMap<String, Animation> animations;
    private boolean isFacingLeft = false;
    private boolean isJumping = false;
    private TextureRegion currentFrame;

    public HashMap<String, Animation> getAnimations() {
        return animations;
    }

    public boolean isFacingLeft() {
        return isFacingLeft;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public TextureRegion getCurrentFrame() {
        return currentFrame;
    }

    public void setAnimations(HashMap<String, Animation> animations) {
        this.animations = animations;
    }

    public void setFacingLeft(boolean facingLeft) {
        isFacingLeft = facingLeft;
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    public void setCurrentFrame(TextureRegion currentFrame) {
        this.currentFrame = currentFrame;
    }
}
