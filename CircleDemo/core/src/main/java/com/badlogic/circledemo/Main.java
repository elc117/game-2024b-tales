package com.badlogic.circledemo;

import com.badlogic.gdx.Game;

public class Main extends Game{
    @Override
    public void create() {
        this.setScreen(new TelaMenu(this));
    }

    @Override
    public void render() {
        super.render(); 
    }

    @Override
    public void dispose() {
        getScreen().dispose();
    }
}
