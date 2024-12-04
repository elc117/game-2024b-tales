package com.badlogic.circledemo;

import com.badlogic.circledemo.Avatar;

public class GameData {
    private Avatar av1, av2;
    private int vezP;
    public GameData(){
        this.vezP = 0;
        this.av1 = new Avatar(true);
        this.av2 = new Avatar(false);
    }
    public void setAvatar(Avatar av, boolean isp1, int idPersonagem){
        if(isp1){
            this.av1.setPersonagem(idPersonagem);
        }
        else{
            this.av2.setPersonagem(idPersonagem);
        }
    }
    public Avatar getAvatar(boolean isp1){
        if(isp1) return this.av1;
        return this.av2;
    }
    public void passaVez(){
        this.vezP ++;
    }
    public int getVez(){ return this.vezP; }
}
