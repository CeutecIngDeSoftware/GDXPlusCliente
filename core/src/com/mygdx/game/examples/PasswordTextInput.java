package com.mygdx.game.examples;

import com.badlogic.gdx.Input;
import com.mygdx.game.ChatClient;
import com.mygdx.game.MyGdxGame;

/**
 * Created by turupawn on 6/10/15.
 */
public class PasswordTextInput implements Input.TextInputListener {
    @Override
    public void input (String text) {

        MyGdxGame.str_password = text;
        String hidden_pass = "";
        for(int i=0;i<text.length();i++)
            hidden_pass+="*";
        MyGdxGame.text_password.setText("Password: " + hidden_pass);

        System.out.print("Enviando al servidor: ");
        System.out.print("login-"+MyGdxGame.str_user+"-"+MyGdxGame.str_password);
        ChatClient cliente_temp=new ChatClient();
        cliente_temp.run();

    }

    @Override
    public void canceled () {
        System.out.print("Canceled");
    }
}