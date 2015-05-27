package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by turupawn on 5/17/15.
 */
public class Bar extends Actor{

    private ShapeRenderer renderer;
    private float x, y, w, h,max_value,current_value;

    public Bar(float x, float y, float w, float h, float max_value, float current_value){
        this.renderer = new ShapeRenderer();
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.max_value = max_value;
        this.current_value = current_value;
    }

    public void increaseValue(int value)
    {
        current_value+=value;
        if(current_value>max_value)
            current_value=max_value;
    }

    public void decreaseValue(int value)
    {
        current_value-=value;
        if(current_value<0)
            current_value=0;
    }

    void percentualChange(float percent)
    {
        current_value*=percent;
    }

    void setValue(int value)
    {
        this.current_value = value;
        if(current_value>max_value)
            current_value=max_value;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        batch.end();
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.RED);
        renderer.rect(x, y, w*(current_value/max_value), h);
        renderer.end();
        batch.begin();
    }
}