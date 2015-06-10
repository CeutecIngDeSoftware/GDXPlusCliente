package com.mygdx.game.examples;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.ui.Button;

/**
 * Created by turupawn on 6/10/15.
 */
public class PasswordButton extends Button
{
    public PasswordButton()
    {
        super("button_pressed.png","button_unpressed.png",250,10);
    }

    @Override
    public void onPressed()
    {
        PasswordTextInput listener = new PasswordTextInput();
        Gdx.input.getTextInput(listener, "Password", "","");
    }
}