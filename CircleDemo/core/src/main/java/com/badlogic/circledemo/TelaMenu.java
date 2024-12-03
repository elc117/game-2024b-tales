package com.badlogic.circledemo;

import com.badlogic.circledemo.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class TelaMenu implements Screen {
    private final Main game;
    private SpriteBatch batch;
    private Texture fundo;
    // private Botao botaoJogar, botaoHelp;

    public TelaMenu(Main game) {
        this.game = game;
        batch = new SpriteBatch();
        fundo = new Texture("img/mapaMenu.jpg");

        // botaoJogar = new Botao("botaojogar.png", 140, 70);
        // botaoJogar.setButtonY(50);

        // botaoHelp = new Botao("botaohelp.png", 140, 70);
        // botaoHelp.setButtonY(150);

    }

    @Override
    public void show() {
        // Inicializa recursos
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(fundo, 250, 0, 1600, 837);
        // batch.draw(fundo, this.posFundox, this.posFundoy, this.tamx, this.tamy);

        // batch.draw(botaoHelp.getButtonTexture(), botaoHelp.getButtonX(), botaoHelp.getButtonY(), botaoHelp.getButtonWidth(), botaoHelp.getButtonHeight());
        // batch.draw(botaoJogar.getButtonTexture(), botaoJogar.getButtonX(), botaoJogar.getButtonY(), botaoJogar.getButtonWidth(), botaoJogar.getButtonHeight());
        batch.end();

    //    if (botaoHelp.detectaClique()){
    //        game.setScreen(new Help(game));
    //        dispose();
    //    }
       // if (botaoJogar.detectaClique()){
            //game.setScreen(new Help(game));
            //dispose();
       // }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
        // Lida com pausa
    }

    @Override
    public void resume() { // Lida com retomada
    }

    @Override
    public void hide() { // Libera recursos se necessário
    }

    @Override
    public void dispose() {
        batch.dispose();
        fundo.dispose();
        // botaoHelp.getButtonTexture().dispose();
        // botaoJogar.getButtonTexture().dispose();
    }
}