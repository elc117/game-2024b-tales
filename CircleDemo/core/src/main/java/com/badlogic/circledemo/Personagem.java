package com.badlogic.circledemo;

import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.io.File;
import java.util.Map;

class Ataque {
    private int dano;
    private int alcance;
    private int velocidade;

    // Getters e Setters
    public int getDano() { return dano; }
    public int getAlcance() { return alcance; }
    public int getVelocidade() { return velocidade; }

    public void setDano(int dano) { this.dano = dano; }
    public void setAlcance(int alcance) { this.alcance = alcance; }
    public void setVelocidade(int velocidade) { this.velocidade = velocidade; }
}

public class Personagem {
    private int id;
    private int tamx, tamy;
    private int esq = 0, dir = 0, whereG = 0;
    private float posx, posy, posyBase; 
    private double dy = 0.0;
    private String img1, img2, imgAva;
    private Map<String, Ataque> ataques;
    private Animation animation, aniAtack;
    private Texture avatar;
    private ArrayList<Integer> listMoves = new ArrayList<Integer>();

    // Construtor que inicializa o Personagem com base no ID
    public Personagem(int id, float posx, float posy) {
        
            this.id = 1;
            this.tamx = 742;
            this.tamy = 409;
            this.img1 = "img/Bagualossauro2-g.png";
            this.img2 = "img/Bagualossauro2-g.png";
            this.posx = posx;
            this.posy = posy;
            this.posyBase = posy;
            this.imgAva = "img/avatarBagual1.png";

            Texture imagem = new Texture(Gdx.files.internal(this.img1));
            this.avatar = new Texture(Gdx.files.internal(this.imgAva));
            this.animation = new Animation(new TextureRegion(imagem), 2, 10f);

    }

    public void setMoves(ArrayList<Integer> listMoves){
        this.listMoves = listMoves;
    }

    public void processMove(Integer move){
        if (move.equals(this.listMoves.get(0))) {
            changeEsq();
        } 
        else if (move.equals(this.listMoves.get(1))){
            changeDir();
        }
        else if (move.equals(this.listMoves.get(2))){
            jump();
        }
    }

    public void move(){
        if(this.dir == 1 && this.esq == 1){
            this.animation.setFrameIni();
        }
        else{
            if(this.esq == 1){
                this.move_esq();
                this.animation.update(1);
            }
            if(this.dir == 1){
                this.move_dir();
                this.animation.update(1);
            }
        }
        gravity();
    }

    private void move_esq(){
        this.posx -= 5;
        if(this.posx < 0){
            this.posx = 0;
        }
    }

    private void move_dir(){
        this.posx += 5;
        if(this.posx > 1000){
            this.posx = 1000;
        }
    }

    public void jump(){
        if(this.posy == this.posyBase){
            this.dy = 19;
        }
    }

    public void atack(){

    }

    private void gravity(){
        this.posy += this.dy;
        this.dy -= 0.6;
        if(this.posy < this.posyBase){
            this.posy = this.posyBase;
            this.dy = 0;
        }
    }

    

    // Getters e Setters
    public int getId() { return id; }
    public int getTamx() { return tamx; }
    public int getTamy() { return tamy; }
    public String getImg1() { return img1; }
    public String getImg2() { return img2; }
    public Map<String, Ataque> getAtaques() { return ataques; }
    public Float getPx() { return this.posx; }
    public Float getPy() { return this.posy; }
    public TextureRegion getFrame(){return this.animation.getFrame();}
    public Texture getAvatar(){return this.avatar; }
    
    

    public int whereGo(){
        if(this.dir == 1 && this.esq == 0){
            this.whereG = 0;
        }
        else if(this.esq == 1 && this.dir == 0){
            this.whereG = 1;
        }
        return this.whereG;
    }
    private void changeEsq(){
        if(this.esq == 0){
            this.esq = 1;
        }
        else{
            this.esq = 0;
        }
    }
    private void changeDir(){
        if(this.dir == 0){
            this.dir = 1;
        }
        else{
            this.dir = 0;
        }
    }

}