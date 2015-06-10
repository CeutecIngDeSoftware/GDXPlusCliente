package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.examples.ActorExample;
import com.mygdx.game.examples.BarExample;
import com.mygdx.game.examples.ButtonExample;
import com.mygdx.game.examples.InputButtonExample;
import com.mygdx.game.examples.PasswordButton;
import com.mygdx.game.examples.UserButton;

public class MyGdxGame extends ApplicationAdapter {
    Label.LabelStyle textStyle;
    BitmapFont font;

	public static Stage stage;
    public static BarExample bar;
    public static Label text_user,text_password;
    public static String str_user,str_password;

	@Override
	public void create () {
        stage = new Stage();
        stage.addActor(new Image(new Texture("background.png")));
        stage.addActor(new ActorExample());
        bar=new BarExample();
        stage.addActor(bar);
        stage.addActor(new ButtonExample());
        stage.addActor(new UserButton());
        stage.addActor(new PasswordButton());


        //font.setUseIntegerPositions(false);(Optional?)
        font = new BitmapFont();
        textStyle = new Label.LabelStyle();
        textStyle.font = font;

        text_user = new Label("Usuario:",textStyle);
        text_user.setPosition(250,150);
        text_password = new Label("Pass:",textStyle);
        text_password.setPosition(250,10);
        //text.setBounds(0,.2f,Room.WIDTH,2);
        //text.setFontScale(1f,1f);

        stage.addActor(text_user);
        stage.addActor(text_password);

        Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render ()
    {
        stage.draw();
        stage.act();
	}
}
