/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.domain;

/**
 *
 * @author samisaukkonen
 */
public class NodeMap {
    Node[][] map;
    
    public NodeMap(int width, int height) {
        this.map = new Node[width][height];
    }
    
    public void applyNewNoise(int[][] noise) {
        for (int x = 0; x < noise.length; x++) {
            for (int y = 0; y < noise[x].length; y++) {
                map[x][y].elevation = getNormalizedPointNoise(x, y, noise);
            }
        }
    }
    
    private int getNormalizedPointNoise(int x, int y, int[][] noiseToApply) {
        int howManyInsideMap = 1;
        
        int toReturn = map[x][y].elevation;
        
        int right = 0;
        int left = 0;
        int top = 0;
        int bottom = 0;
        
        if (x + 1 < noiseToApply.length) {
            right = noiseToApply[x + 1][y];
            howManyInsideMap++;
        } 
        
        if (x - 1 >= 0) {
            left = noiseToApply[x - 1][y];
            howManyInsideMap++;
        }
        
        if (y + 1 < noiseToApply[0].length) {
            top = noiseToApply[x][y + 1];
            howManyInsideMap++;
        } 
        
        if (y - 1 >= 0) {
            bottom = noiseToApply[x][y - 1];
            howManyInsideMap++;
        }
        
        return (toReturn + right + left + top + bottom) / howManyInsideMap;
    }
}
