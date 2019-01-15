package com.mygdx.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.domain.PerlinNoise2;
import com.mygdx.domain.TwoDimensionalNoiseGenerator;
import com.mygdx.gui.MapBatcher;

public class Main extends ApplicationAdapter {

    SpriteBatch batch;
    double[][] map;

    @Override
    public void create() {
        batch = new SpriteBatch();
        map = new double[1300][1300];

        
        TwoDimensionalNoiseGenerator gen = new TwoDimensionalNoiseGenerator(1, 32, 10);
        System.out.println(gen.octaves);
        

        for (double x = 0; x < map.length; x++) {
            for (double y = 0; y < map.length; y++) {
                int intX = (int) x;
                int intY = (int) y;

                map[intX][intY] = gen.getNoise(x * 0.1, y * 0.1);
            }
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        MapBatcher.placeNodeMapInBatch(batch, map);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();

    }
}
