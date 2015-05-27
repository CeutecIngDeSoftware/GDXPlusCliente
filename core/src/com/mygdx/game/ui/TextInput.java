package com.mygdx.game.ui;

import com.badlogic.gdx.Input;

/**
 * Created by turupawn on 5/23/15.
 * source: https://github.com/libgdx/libgdx/wiki/Simple-text-input
 */
public class TextInput implements Input.TextInputListener {
    @Override
    public void input (String text) {

        System.out.print("Input");
    }

    @Override
    public void canceled () {
        System.out.print("Canceled");
    }
}