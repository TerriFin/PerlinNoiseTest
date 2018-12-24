package com.mygdx.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.domain.NodeMap;
import com.mygdx.generation.IslandNoise;
import com.mygdx.generation.RawNoise;
import com.mygdx.gui.MapBatcher;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	NodeMap map;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
                map = new NodeMap(60, 60);
                map.applyNewNoise(RawNoise.generateRawNoise(60, 60));
                
                map.applyNewNoiseSharp(IslandNoise.generateIslandNoise(60, 60));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
                    MapBatcher.placeNodeMapInBatch(batch, map);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		
	}
}
