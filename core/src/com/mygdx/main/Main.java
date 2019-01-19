package com.mygdx.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.domain.PerlinNoise2;
import com.mygdx.generation.MapGeneration;
import com.mygdx.generation.TwoDimensionalNoiseGenerator;
import com.mygdx.gui.MapBatcher;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

public class Main extends ApplicationAdapter {
    
    Random r;

    SpriteBatch batch;
    double[][] map;
    int counter;

    @Override
    public void create() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        r = new Random();

        batch = new SpriteBatch();
        map = new double[screenSize.width][screenSize.height];
        counter = 0;
    }

    @Override
    public void render() {
        if (counter % 40 == 0) {
            MapGeneration.generateNewMapRandomValues(map);
        } else {
            MapGeneration.moveMapRightBy(map, 5);
        }
        
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        MapBatcher.placeMapInBatch(batch, map);
        batch.end();
        
        counter++;
        System.out.println(counter);
    }

    @Override
    public void dispose() {
        batch.dispose();

    }
}
