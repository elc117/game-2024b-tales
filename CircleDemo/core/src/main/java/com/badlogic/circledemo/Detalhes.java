package com.badlogic.circledemo;

import java.util.ArrayList;

import com.badlogic.circledemo.Bolinha;
import com.badlogic.circledemo.Locais;
import com.badlogic.circledemo.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Detalhes implements Screen {
    private final Main game;
    private SpriteBatch batch;
    private Texture fundo;
    private Locais local;
    private ArrayList<Bolinha> bolinhas = new ArrayList<>();

    public Detalhes(Main game, Integer idLocal) {
        this.game = game;
        batch = new SpriteBatch();
        local = new Locais(idLocal);
        fundo = new Texture(local.getImagens().get(0));

        createBolinhas(0);

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
        for (Bolinha b : bolinhas) {
            batch.draw(b.getImg(), b.getX(), b.getY());
        }
        // batch.draw(botaoHelp.getButtonTexture(), botaoHelp.getButtonX(), botaoHelp.getButtonY(), botaoHelp.getButtonWidth(), botaoHelp.getButtonHeight());
        // batch.draw(botaoJogar.getButtonTexture(), botaoJogar.getButtonX(), botaoJogar.getButtonY(), botaoJogar.getButtonWidth(), botaoJogar.getButtonHeight());
        batch.end();

        for (Bolinha b : bolinhas) {
            if (b.clicou()){
                game.setScreen(new Detalhes(game, 1));
                dispose();
            }
        }
       
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

    // Parte Criacoes
    private void createBolinhas(Integer op){
        Bolinha bolinha;
        bolinhas.clear();
        if(op == 0){
            bolinha = new Bolinha(725, 425, 1); // Quarta Colônia
            this.bolinhas.add(bolinha);
            bolinha = new Bolinha(625, 600, 2); // Missões
            this.bolinhas.add(bolinha);
            bolinha = new Bolinha(1125, 525, 3); // Torres
            this.bolinhas.add(bolinha);
        } 
        if(op == 1){
            bolinha = new Bolinha(470, 100+24, 1); 
            this.bolinhas.add(bolinha);
            bolinha = new Bolinha(470, 206+24, 2); 
            this.bolinhas.add(bolinha);
            bolinha = new Bolinha(470, 313+24, 3); 
            this.bolinhas.add(bolinha);
            bolinha = new Bolinha(470, 421+24, 4); 
            this.bolinhas.add(bolinha);
        }
    }
    // private void createAvatars(){
    //     Avatar avatar = new Avatar(true, this.tamx, this.tamy);
    //     this.avatars.add(avatar);
    //     avatar = new Avatar(false, this.tamx, this.tamy);
    //     this.avatars.add(avatar);
    // }
    // private void createPersonagem(Integer id){
    //     Personagem p;
    //     if(this.avatarAtualSelec == 1){
    //         p = new Personagem(id, 0, 100);
            
    //         ArrayList<Integer> movies = new ArrayList<Integer>();
    //         movies.add(Input.Keys.A);
    //         movies.add(Input.Keys.D);
    //         movies.add(Input.Keys.W);
    //         movies.add(Input.Keys.F); // ataque
    //         p.setMoves(movies);
    //     }
    //     else if(this.avatarAtualSelec == 2) {
    //         p = new Personagem(id, 500, 100);

    //         ArrayList<Integer> movies = new ArrayList<Integer>();
    //         movies.add(Input.Keys.LEFT);
    //         movies.add(Input.Keys.RIGHT);
    //         movies.add(Input.Keys.UP);
    //         movies.add(Input.Keys.ENTER); // ataque
    //         p.setMoves(movies);
    //     }
    //     else{
    //         return;
    //     }
    //     this.personagens.add(p); 
    //     // changeAvatar();
    //     // this.gameDraw.changeAvatar();
    // }
}