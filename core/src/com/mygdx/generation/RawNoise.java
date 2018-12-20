/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.generation;

import java.util.Random;

/**
 *
 * @author samisaukkonen
 */
public class RawNoise {
    
    private static Random random = new Random();

    public static int[][] generateRawNoise(int width, int height) {
        int[][] rawNoise = new int[width][height];

        for (int x = 0; x < rawNoise.length; x++) {
            for (int y = 0; y < rawNoise[x].length; y++) {
                rawNoise[x][y] = random.nextInt(101);
            }
        }

        return rawNoise;
    }
}
