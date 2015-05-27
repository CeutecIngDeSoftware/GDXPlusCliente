package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.examples.ActorExample;
import com.mygdx.game.examples.BarExample;
import com.mygdx.game.examples.ButtonExample;
import com.mygdx.game.examples.InputButtonExample;

public class MyGdxGame extends ApplicationAdapter {
	public static Stage stage;
    public static BarExample bar;

	@Override
	public void create () {
        stage = new Stage();
        stage.addActor(new Image(new Texture("background.png")));
        stage.addActor(new ActorExample());
        bar=new BarExample();
        stage.addActor(bar);
        stage.addActor(new ButtonExample());
        stage.addActor(new InputButtonExample());
        Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render ()
    {
        stage.draw();
        stage.act();
	}
}
