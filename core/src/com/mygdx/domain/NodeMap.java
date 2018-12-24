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

    public Node[][] map;

    public NodeMap(int width, int height) {
        this.map = new Node[width][height];

        for (int x = 0; x < this.map.length; x++) {
            for (int y = 0; y < this.map[x].length; y++) {
                this.map[x][y] = new Node(x, y, 0);
            }
        }
    }

    public void applyNewNoiseSharp(int[][] noise) {
        for (int x = 0; x < noise.length; x++) {
            for (int y = 0; y < noise[x].length; y++) {
                map[x][y].elevation += noise[x][y];
            }
        }
    }

    public void applyNewNoise(int[][] noise) {
        for (int x = 0; x < noise.length; x++) {
            for (int y = 0; y < noise[x].length; y++) {
                map[x][y].elevation = getNormalizedPointNoise(x, y, noise);
            }
        }
    }

    private int getNormalizedPointNoise(int x, int y, int[][] noiseToApply) {
        int howManyInsideMap = 0;

        int toReturn = map[x][y].elevation;

        int right = 0;
        int left = 0;
        int top = 0;
        int bottom = 0;

        int topRight = 0;
        int topLeft = 0;
        int bottomRight = 0;
        int bottomLeft = 0;

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

        if (x + 1 < noiseToApply.length && y + 1 < noiseToApply[x].length) {
            topRight = noiseToApply[x + 1][y + 1];
            howManyInsideMap++;
        }

        if (x - 1 >= 0 && y + 1 < noiseToApply[x].length) {
            topLeft = noiseToApply[x - 1][y + 1];
            howManyInsideMap++;
        }

        if (x + 1 < noiseToApply.length && y - 1 >= 0) {
            bottomRight = noiseToApply[x + 1][y - 1];
            howManyInsideMap++;
        }

        if (x - 1 >= 0 && y - 1 >= 0) {
            bottomLeft = noiseToApply[x - 1][y - 1];
            howManyInsideMap++;
        }

        return (toReturn + right + left + top + bottom + topRight + topLeft + bottomRight + bottomLeft) / howManyInsideMap;
    }
}
