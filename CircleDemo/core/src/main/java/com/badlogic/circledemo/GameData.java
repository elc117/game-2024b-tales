package com.badlogic.circledemo;

import com.badlogic.circledemo.Avatar;

public class GameData {
    private Avatar av1, av2;
    public GameData(){
        av1 = new Avatar(true);
        av2 = new Avatar(false);
    }
    public void setAvatar(Avatar av, boolean isp1, int idPersonagem){
        if(isp1){
            av1.setPersonagem(idPersonagem);
        }
        else{
            av2.setPersonagem(idPersonagem);
        }
    }
    public Avatar getAvatar(boolean isp1){
        if(isp1) return av1;
        return av2;
    }
}
