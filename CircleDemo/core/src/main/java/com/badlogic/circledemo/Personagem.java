package com.badlogic.circledemo;

import com.badlogic.gdx.utils.Array;

import com.badlogic.circledemo.Animation;
import com.badlogic.circledemo.Quadrado;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Personagem {
    private int id;
    private int tamx, tamy;
    private int esq = 0, dir = 0, whereG = 0;
    private float posx, posy, posyBase; 
    private double dy = 0.0;
    private String img1, imgAva;
    // private Map<String, Ataque> ataques;
    private Animation animation, aniAtack;
    private Texture avatar;
    private Array<Integer> listMoves = new Array<Integer>();
    private Quadrado area, ataque;

    // Construtor que inicializa o Personagem com base no ID
    public Personagem(int id, float posx, float posy) {
        this.posx = posx;
        this.posy = posy;
        switch (id) {
            case 1:
                this.tamx = 742;
                this.tamy = 350;
                this.img1 = new String("Bagualossauro1-g.png");
                this.imgAva = new String("P1Bag.png");

                this.avatar = new Texture(Gdx.files.internal(imgAva));
                break;
            case 2:
                this.tamx = 742;
                this.tamy = 350;
                this.img1 = new String("Bagualossauro2-g.png");
                this.imgAva = new String("P1BagGaucho.png");

                this.avatar = new Texture(Gdx.files.internal(imgAva));
                break;
            // case 3:
            //     this.nome = "Torres";
            //     img = "Torres.jpg";
            //     this.imagens.add(img);
            //     this.personagem = 1;
            //     questao = 1;
            //     this.questoes.add(questao);
            //     questao = 2;
            //     this.questoes.add(questao);
            //     questao = 3;
            //     this.questoes.add(questao);
            //     break;
            default:
                break;
        }
    }

//     public void setMoves(Array<Integer> listMoves){
//         this.listMoves = listMoves;
//     }

//     public void processMove(Integer move){
//         if (move.equals(this.listMoves.get(0))) {
//             changeEsq();
//         } 
//         else if (move.equals(this.listMoves.get(1))){
//             changeDir();
//         }
//         else if (move.equals(this.listMoves.get(2))){
//             jump();
//         }
//         else if (move.equals(this.listMoves.get(3))){
//             atack();
//         }
//     }

//     public void move(Personagem outro){
//         if(this.dir == 1 && this.esq == 1){
//             this.animation.setFrameIni();
//         }
//         else{
//             if(this.esq == 1){
//                 this.move_esq();
//                 this.animation.update(1);
//             }
//             if(this.dir == 1){
//                 this.move_dir();
//                 this.animation.update(1);
//             }
//         }
//         gravity();
//         this.area.conflito(outro.getArea());
//     }

//     private void move_esq(){
//         this.posx -= 5;
//         this.area.moveToEsq(5);
//         if(this.posx < 0){
//             this.posx = 0;
//             this.area.setQuadrado(posx, posy+tamy, posx+tamx, posy);
//         }
//     }

//     private void move_dir(){
//         this.posx += 5;
//         this.area.moveToEsq(5);
//         if(this.posx > 1000){
//             this.posx = 1000;
//             this.area.setQuadrado(posx, posy+tamy, posx+tamx, posy);
//         }
//     }

//     public void jump(){
//         if(this.posy == this.posyBase){
//             this.dy = 22;
//         }
//     }

//     public void atack(){
//         if(this.whereG == 0){
//             System.out.println("atacou direita");
//         }
//         else{
//             System.out.println("atacou esquerda");
//         }
//     }

//     private void gravity(){
//         this.posy += this.dy;
//         this.area.moveToUp(this.dy);
//         this.dy -= 0.5;
//         if(this.posy < this.posyBase){
//             this.posy = this.posyBase;
//             this.area.setQuadrado(posx, posy+tamy, posx+tamx, posy);
//             this.dy = 0;
//         }
//     }

//     // Getters e Setters
//     public int getId() { return id; }
//     public int getTamx() { return tamx; }
//     public int getTamy() { return tamy; }
//     public String getImg1() { return img1; }
//     // public String getImg2() { return img2; }
//     // public Map<String, Ataque> getAtaques() { return ataques; }
//     public Float getPx() { return this.posx; }
//     public Float getPy() { return this.posy; }
//     public Quadrado getArea() { return this.area; }
//     public TextureRegion getFrame(){return this.animation.getFrame();}
    public Texture getAvatar(){ return this.avatar; }
    
    

//     public int whereGo(){
//         if(this.dir == 1 && this.esq == 0){
//             this.whereG = 0;
//         }
//         else if(this.esq == 1 && this.dir == 0){
//             this.whereG = 1;
//         }
//         return this.whereG;
//     }
//     private void changeEsq(){
//         if(this.esq == 0){
//             this.esq = 1;
//         }
//         else{
//             this.esq = 0;
//         }
//     }
//     private void changeDir(){
//         if(this.dir == 0){
//             this.dir = 1;
//         }
//         else{
//             this.dir = 0;
//         }
//     }

}