package com.badlogic.circledemo;

import com.badlogic.circledemo.Avatar;
import com.badlogic.circledemo.Locais;

public class GameData {
    private Avatar av1, av2;
    private Locais local;
    private int vezP;
    public GameData(){
        this.vezP = 0;
        this.av1 = new Avatar(true);
        this.av2 = new Avatar(false);
        this.local = new Locais(0);
    }
    public void setAvatar(Avatar av, boolean isp1, int idPersonagem){
        if(isp1){
            this.av1.setPersonagem(idPersonagem);
        }
        else{
            this.av2.setPersonagem(idPersonagem);
        }
    }
    public void setLocal(int idLocal){
        this.local.mudaLocal(idLocal);
    }

    public Avatar getAvatar(boolean isp1){
        if(isp1) return this.av1;
        return this.av2;
    }
    
    public int getVez(){ return this.vezP; }
    
    public Locais getLocal(){ return this.local; }

    public void passaVez(){
        if(this.vezP <= 2) this.vezP ++;
        else this.vezP = 0;
    }
}
