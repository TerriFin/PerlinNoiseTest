/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.gui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author samisaukkonen
 */
public class MapBatcher {
    static Texture lightBlue = new Texture("LightBlue.png");
    static Texture darkBlue = new Texture("DarkBlue.png");
    static Texture orange = new Texture("Orange.png");
    static Texture lightGreen = new Texture("LightGreen.png");
    static Texture darkGreen = new Texture("darkGreen.png");
    static Texture lightBrown = new Texture("lightBrown.png");
    static Texture darkBrown = new Texture("DarkBrown.png");
    static Texture white = new Texture("White.png");

    public static void placeNodeMapInBatch(SpriteBatch batch, double[][] map) {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                Texture img;
                
                if (map[x][y] <= -0.3) {
                    img = darkBlue;
                } else if (map[x][y] <= 0.07) {
                    img = lightBlue;
                } else if (map[x][y] <= 0.17) {
                    img = orange;
                } else if (map[x][y] <= 0.35) {
                    img = lightGreen;
                } else if (map[x][y] <= 0.65) {
                    img = darkGreen;
                } else if (map[x][y] <= 0.8) {
                    img = lightBrown;
                } else if (map[x][y] <= 0.9) {
                    img = darkBrown;
                } else {
                    img = white;
                }
                
                batch.draw(img, x * 2, y * 2, 2, 2);
            }
        }
    }
}
