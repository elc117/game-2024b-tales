package com.badlogic.circledemo;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.circledemo.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Align;

public class Avatar{
    private Texture img;
    private Integer idPersonagem, vidaTotal, vidaAtual, posx, posy; 
    private Animation animation;
    private Personagem personagem;
    private Boolean isP1;
    
    public Avatar(boolean isP1){
        this.idPersonagem = 0;
        this.isP1 = isP1;
        this.vidaTotal = 0;
        this.vidaAtual = 0;
        this.posy = 837-300;
        if(isP1){
            this.posx = 0;
            this.img = new Texture(Gdx.files.internal("IndetP1A.jpg"));
        }
        else{
            this.img = new Texture(Gdx.files.internal("IndetP2A.jpg"));
            this.posx = 1600-300;
        }
        this.animation = new Animation(new TextureRegion(this.img), 2, 30f);
    }
    
    public void setPersonagem(int id, boolean acertou){
        Array<Integer> moves = new Array<Integer>();
        if(isP1){
            this.personagem = new Personagem(id, 0, 500); 
            Integer move = Keys.A;
            moves.add(move);
            move = Keys.D;
            moves.add(move);
            move = Keys.W;
            moves.add(move);
            move = Keys.F;
            moves.add(move);
            this.personagem.setMoves(moves);
        }
        else{
            this.personagem = new Personagem(id, 800, 500); 
            Integer move = Keys.LEFT;
            moves.add(move);
            move = Keys.RIGHT;
            moves.add(move);
            move = Keys.UP;
            moves.add(move);
            move = Keys.L;
            moves.add(move);
            this.personagem.setMoves(moves);
        }
        if(!acertou){
            this.personagem.tomaDano(this.personagem.getVidaT()/2);
        }
        this.img = this.personagem.getAvatar();
        this.animation = new Animation(new TextureRegion(this.img), 1, 30f);
    }

    public Integer getPosx(){ return this.posx; }
    public Integer getPosy(){ return this.posy; }
    public Texture getImg(){ return this.img; }
    public void update(){ this.animation.update(1); }
    public TextureRegion getFrame(){ return this.animation.getFrame(); }
    public void setFrameIni(){ this.animation.setFrameIni(); }
    public void dispose(){
        this.img.dispose();
    }
    public Personagem getPersonagem(){ return this.personagem; }
}