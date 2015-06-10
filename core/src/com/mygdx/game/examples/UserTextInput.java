package com.mygdx.game.examples;

import com.badlogic.gdx.Input;
import com.mygdx.game.MyGdxGame;

/**
 * Created by turupawn on 6/10/15.
 */
public class UserTextInput implements Input.TextInputListener {
    @Override
    public void input (String text) {

        MyGdxGame.str_user = text;
        MyGdxGame.text_user.setText("User: "+text);
    }

    @Override
    public void canceled () {
        System.out.print("Canceled");
    }
}
