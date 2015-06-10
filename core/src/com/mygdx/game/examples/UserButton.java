package com.mygdx.game.examples;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.ui.Button;

/**
 * Created by turupawn on 6/10/15.
 */
public class UserButton extends Button
{
    public UserButton()
    {
        super("button_pressed.png","button_unpressed.png",250,150);
    }

    @Override
    public void onPressed()
    {
        UserTextInput listener = new UserTextInput();
        Gdx.input.getTextInput(listener, "Usuario", "","");
    }
}