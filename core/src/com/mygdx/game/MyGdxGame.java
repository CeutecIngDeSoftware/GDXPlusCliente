package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGdxGame extends ApplicationAdapter {
	Stage stage;
    Image image;

	@Override
	public void create () {
        stage = new Stage();
        //stage.addActor(new MiActor());
        image = new Image(new Texture("badlogic.jpg"));
        stage.addActor(image);
        Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render ()
    {
        stage.draw();
        stage.act();
        image.setX(image.getX()+1);
	}
}
