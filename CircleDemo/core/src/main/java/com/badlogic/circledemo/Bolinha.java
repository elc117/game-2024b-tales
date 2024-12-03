package com.badlogic.circledemo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Bolinha {
    private Texture img;
    private Integer posx, posy, idLocal;
    public Bolinha(String path, Integer posx, Integer posy, Integer idLocal){
        this.img = new Texture(Gdx.files.internal(path));
        this.posx = posx;
        this.posy = posy;
        this.idLocal = idLocal;
    }
    public Bolinha(Integer posx, Integer posy, Integer idLocal){
        this("bolinha.png", posx, posy, idLocal);
    }

    public boolean clicou(){
        // if (Gdx.input.getX()>=this.posx && Gdx.input.getX()<=this.posx+50 && Gdx.input.getY()>=this.posy &&Gdx.input.getY()<=this.posy+50) {
		// 	return true;
		// }
        return true;
        // return false;
    }

    public Integer getX(){ return this.posx; }
    public Integer getY(){ return this.posy; }
    public Integer getIdLocal(){ return this.idLocal; }
    public Texture getImg(){ return this.img; }

    public void dispose(){
        img.dispose();
    }
}
