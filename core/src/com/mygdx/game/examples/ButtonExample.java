package com.mygdx.game.examples;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.ui.Button;
import com.mygdx.game.ui.TextInput;

/**
 * Created by turupawn on 5/17/15.
 */
public class ButtonExample extends Button
{
    public ButtonExample()
    {
        super("button_pressed.png","button_unpressed.png",10,10);
    }

    @Override
    public void onPressed()
    {
        MyGdxGame.bar.decreaseValue(10);
    }
}