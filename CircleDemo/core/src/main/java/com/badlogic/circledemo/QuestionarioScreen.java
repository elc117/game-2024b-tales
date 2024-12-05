package com.badlogic.circledemo;

import java.util.Iterator;

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

public class QuestionarioScreen implements Screen {
    final Main game;
	GameData gameData;

    Texture fundoImage;
    Array<Bolinha> bolinhas;
	Avatar av1, av2;
	Quiz quiz;

	int vezP;

	OrthographicCamera camera;
	SpriteBatch batch;
	BitmapFont font;
	Vector3 touchPos;

    public QuestionarioScreen(final Main passed_game, int idPergunta, GameData gameData){
        game = passed_game; 
		this.vezP = gameData.getVez();
		this.gameData = gameData;

        fundoImage = new Texture(Gdx.files.internal("fundoQuiz.jpg"));

        av1 = gameData.getAvatar(true);
		av2 = gameData.getAvatar(false);

		quiz = new Quiz(idPergunta);

        // Init the camera objects.
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1600, 837);
		touchPos = new Vector3();
		
		batch = new SpriteBatch();
		font = new BitmapFont();

        bolinhas = new Array<Bolinha>();
		createBolinhas();
    }

    @Override
	public void render(float delta) {
		/* Clear screen with a dark blue color.
		 * Arguments to ClearColor are r g b, alpha
		 */
		Gdx.gl.glClearColor(0, 0, .2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		if(this.vezP == 0){
			av2.setFrameIni();
			av1.update();
		}
		else if(this.vezP == 1){
			av1.setFrameIni();
			av2.update();
		}

		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();

		game.batch.draw(fundoImage, 300, 0, 1000, 837);
		
        for (Bolinha b : bolinhas) {
			game.batch.draw(b.getImg(), b.getX(), b.getY());
		}

		game.batch.draw(av1.getFrame(), av1.getPosx(), av1.getPosy());
		game.batch.draw(av2.getFrame(), av2.getPosx(), av2.getPosy());

		Array<String> algo = quiz.getPergunta();
		int i = 100;
		for (String a : algo) {
			game.font.draw(game.batch, a, 100, i, 1000, 10, true);
			i += 100;
		}
		// game.font.draw(game.batch, "Somos uma iniciativa da UFSM emaaaaaaaaaaaaa", 100, 500, 2000, 10, true);

		// for(int i=0; i < 4; i++){
		// 	game.font.draw(game.batch, quiz.getRespostas().get(i), bolinhas.get(i).getX(), bolinhas.get(i).getY());
		// }

		// game.font.draw(game.batch, "Welcome to Main!!", 100, 150);

		game.batch.end();

		// // Process any user input
		if (Gdx.input.isTouched()) {
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			for (Bolinha b : bolinhas) {
				if(b.clicou(touchPos.x, touchPos.y)){
					if(quiz.isRespostaCorreta(b.getIdLocal())){
						if(this.vezP == 0){
							av1.setPersonagem(gameData.getLocal().getPersonagem());
							gameData.setAvatar(av1, true, gameData.getLocal().getPersonagem());
						}
						else if(this.vezP == 1){
							av2.setPersonagem(gameData.getLocal().getPersonagem());
							gameData.setAvatar(av2, true, gameData.getLocal().getPersonagem());
						}
						gameData.passaVez();
						game.setScreen(new GameScreen(game, gameData));
						dispose();
					}
				}
			}
		}

        
		
	}
    private void createBolinhas(){
        Bolinha bolinha;
        bolinha = new Bolinha(500, 100+24, 0); 
        this.bolinhas.add(bolinha);
        bolinha = new Bolinha(500, 206+24, 1); 
        this.bolinhas.add(bolinha);
        bolinha = new Bolinha(500, 313+24, 2); 
        this.bolinhas.add(bolinha);
        bolinha = new Bolinha(500, 421+24, 3); 
        this.bolinhas.add(bolinha);
    }
	
	@Override
	public void dispose() {
		// Clear all the "native" resources
		fundoImage.dispose();
		// dropImage.dispose();
		// bucketImage.dispose();
		// dropSound.dispose();
		// rainMusic.dispose();
		batch.dispose();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// rainMusic.play();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
}
