package com.mygdx.game.examples;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.ui.Button;
import com.mygdx.game.ui.TextInput;

/**
 * Created by turupawn on 5/27/15.
 */
public class InputButtonExample extends Button
{
    public InputButtonExample()
    {
        super("button_pressed.png","button_unpressed.png",250,10);
    }

    @Override
    public void onPressed()
    {
        TextInput listener = new TextInput();
        Gdx.input.getTextInput(listener, "Usuario", "","");
    }
}