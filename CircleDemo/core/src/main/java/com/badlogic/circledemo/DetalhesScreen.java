package com.badlogic.circledemo;

import java.util.Iterator;
import java.util.List;

import javax.swing.Box;

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

public class DetalhesScreen implements Screen {
	final Main game;
	
	Texture fundoImage;
    Locais local;
	Botao btSelec, btVoltar;


	// Texture dropImage;
	// Texture bucketImage;
	// Sound dropSound;
	// Music rainMusic;
	OrthographicCamera camera;
	SpriteBatch batch;
	// Rectangle bucket;
	Vector3 touchPos;
	// Array<Rectangle> raindrops;
	// long lastDropTime;
	// int dropsGathered;
	
	public DetalhesScreen(final Main passed_game, int vezP, int idLocal) {
		game = passed_game; 
		local = new Locais(idLocal);
		
		// Load images, 64px each
		fundoImage = new Texture(Gdx.files.internal(local.getImagens().get(0)));

		btSelec = new Botao(0, 100, 200);
		btVoltar = new Botao(1, 800, 200);
		// dropImage = new Texture(Gdx.files.internal("droplet.png"));
		// bucketImage = new Texture(Gdx.files.internal("bucket.png"));
		
		// Load the drop sfx and the rain background music
		// dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
		// rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
		
		// Start playback of music in bg
		// rainMusic.setLooping(true);
		// rainMusic.play();
		
		// Init the camera objects.
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1600, 837);
		touchPos = new Vector3();
		
		batch = new SpriteBatch();
		
		// bucket = new Rectangle();
		// bucket.width = 64;
		// bucket.x = 800 / 2 - bucket.width / 2;
		// bucket.y = 20;
		// bucket.height = 64;
		
		// Create Raindrops and spawn the first one.
		// raindrops = new Array<Rectangle>();
		// spawnRaindrop();

	}

	@Override
	public void render(float delta) {
		/* Clear screen with a dark blue color.
		 * Arguments to ClearColor are r g b, alpha
		 */
		Gdx.gl.glClearColor(0, 0, .2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		
		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();
		game.batch.draw(fundoImage, 0, 200, 1600, 637);
		game.batch.draw(btSelec.getImg(), btSelec.getPosx(), btSelec.getPosy());
		game.batch.draw(btVoltar.getImg(), btVoltar.getPosx(), btVoltar.getPosy());
		
		game.batch.end();

		// // Process any user input
		// if (Gdx.input.isTouched()) {
		// 	touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		// 	camera.unproject(touchPos);
		// 	bucket.x = touchPos.x - bucket.width / 2;
		// }
		
		
		// // Process any user input
		if (Gdx.input.isTouched()) {
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			if(btSelec.clicou(touchPos.x, touchPos.y)){
				game.setScreen(new TelaMenu(game));
				dispose();
			}
			else if(btVoltar.clicou(touchPos.x, touchPos.y)){
				game.setScreen(new GameScreen(game, 0));
				dispose();
			}
		}
		
		// // Ensure that the bucket's within the screen bounds
		// if (Gdx.input.isKeyPressed(Keys.LEFT)) 
		// 	bucket.x -= 200 * Gdx.graphics.getDeltaTime();
		// if (Gdx.input.isKeyPressed(Keys.RIGHT)) 
		// 	bucket.x += 200 * Gdx.graphics.getDeltaTime();
		// if (bucket.x < 0) 
		// 	bucket.x = 0;
		// if (bucket.x > 800 - bucket.width) 
		// 	bucket.x = 800 - bucket.width;
		
		// // Check time since last raindrop. Do we need another?
		// if (TimeUtils.nanoTime() - lastDropTime > 1000000000) 
		// 	spawnRaindrop();
		
		// Update all the raindrops
		// Iterator<Rectangle> iter = raindrops.iterator();
		// while (iter.hasNext()) {
		// 	Rectangle raindrop = iter.next();
		// 	raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
		// 	if (raindrop.y + raindrop.height < 0) 
		// 		iter.remove();
		// 	if (raindrop.overlaps(bucket)) {
		// 		dropsGathered++;
		// 		dropSound.play();
		// 		iter.remove();
		// 	}
		// }
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