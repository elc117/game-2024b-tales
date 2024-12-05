package com.badlogic.circledemo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Avatar{
    private Texture img;
    private Integer idPersonagem, vidaTotal, vidaAtual, posx, posy; 
    private Animation animation;
    private Personagem personagem;
    
    public Avatar(boolean isP1){
        this.idPersonagem = 0;
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
    
    public void setPersonagem(int id){
        personagem = new Personagem(id, 0, 0); 
        this.img = personagem.getAvatar();
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