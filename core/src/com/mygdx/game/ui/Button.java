package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGdxGame;

/**
 * Created by turupawn on 5/17/15.
 */
public class Button extends Actor
{
    Image pressed, unpressed;
    private boolean is_pressed;

    public Button(String pressed_path, String unpressed_path, int x, int y)
    {
        this.is_pressed = false;
        this.pressed = new Image(new Texture(pressed_path));
        this.unpressed = new Image(new Texture(unpressed_path));
        this.pressed.setX(x);
        this.pressed.setY(y);
        this.unpressed.setX(x);
        this.unpressed.setY(y);
        MyGdxGame.stage.addActor(pressed);
        MyGdxGame.stage.addActor(unpressed);

        unpressed.addListener(new ClickListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                press();
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                unPress();
            }
        });
    }

    boolean isPressed()
    {
        return is_pressed;
    }

    void press()
    {
        is_pressed = true;
        pressed.setVisible(true);
        unpressed.setVisible(false);
        onPressed();
    }

    void unPress()
    {
        is_pressed = false;
        pressed.setVisible(false);
        unpressed.setVisible(true);
    }

    public void onPressed()
    {

    }

    @Override
    public void draw(Batch batch, float parentAlpha)
    {
    }
}