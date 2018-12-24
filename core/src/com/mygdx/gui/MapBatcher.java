/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.gui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.domain.NodeMap;

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

    public static void placeNodeMapInBatch(SpriteBatch batch, NodeMap map) {
        for (int x = 0; x < map.map.length; x++) {
            for (int y = 0; y < map.map[x].length; y++) {
                Texture img;
                
                if (map.map[x][y].elevation <= 30) {
                    img = darkBlue;
                } else if (map.map[x][y].elevation <= 40) {
                    img = lightBlue;
                } else if (map.map[x][y].elevation <= 43) {
                    img = orange;
                } else if (map.map[x][y].elevation <= 55) {
                    img = lightGreen;
                } else if (map.map[x][y].elevation <= 70) {
                    img = darkGreen;
                } else if (map.map[x][y].elevation <= 85) {
                    img = lightBrown;
                } else if (map.map[x][y].elevation <= 95) {
                    img = darkBrown;
                } else {
                    img = white;
                }
                
                batch.draw(img, map.map[x][y].x * 10, map.map[x][y].y * 10, 10, 10);
            }
        }
    }
}
