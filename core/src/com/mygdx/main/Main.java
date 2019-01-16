package com.mygdx.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.domain.PerlinNoise2;
import com.mygdx.generation.TwoDimensionalNoiseGenerator;
import com.mygdx.gui.MapBatcher;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

public class Main extends ApplicationAdapter {

    SpriteBatch batch;
    double[][] map;
    int counter;
    Random r;

    @Override
    public void create() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        batch = new SpriteBatch();
        map = new double[screenSize.width][screenSize.height];
        
        counter = 0;
        r = new Random();
    }

    public void generateNewMap(double amplitude, int waveLength, int octaves, double size) {
        TwoDimensionalNoiseGenerator gen = new TwoDimensionalNoiseGenerator(amplitude, waveLength, octaves);

        for (double x = 0; x < map.length; x++) {
            for (double y = 0; y < map[(int) x].length; y++) {
                int intX = (int) x;
                int intY = (int) y;

                map[intX][intY] = gen.getNoise(x * size, y * size);
            }
        }
    }
    
    public void generateNewMapRandomValues() {
        double amplitude = 80 + r.nextDouble() * 40;
        int waveLength = 1 + r.nextInt(128);
        int octaves = r.nextInt(8);
        double size = 0.5;
        
        TwoDimensionalNoiseGenerator gen = new TwoDimensionalNoiseGenerator(amplitude, waveLength, octaves);

        for (double x = 0; x < map.length; x++) {
            for (double y = 0; y < map[(int) x].length; y++) {
                int intX = (int) x;
                int intY = (int) y;

                map[intX][intY] = gen.getNoise(x * size, y * size);
            }
        }
    }

    @Override
    public void render() {
        if (counter % 50 == 0) {
            generateNewMapRandomValues();
        }
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        MapBatcher.placeNodeMapInBatch(batch, map);
        batch.end();
        counter++;
        System.out.println(counter);
    }

    @Override
    public void dispose() {
        batch.dispose();

    }
}
