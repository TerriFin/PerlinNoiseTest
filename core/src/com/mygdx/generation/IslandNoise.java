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
public class IslandNoise {

    private static Random random = new Random();

    public static int[][] generateIslandNoise(int width, int height) {

        int[][] rawNoise = new int[width][height];

        int widthCenter = width / 2;
        int heightCenter = height / 2;

        for (int x = 0; x < rawNoise.length; x++) {
            for (int y = 0; y < rawNoise[x].length; y++) {

                int widthDistanceToCenter = Math.abs(widthCenter - x);
                int heightDistanceToCenter = Math.abs(heightCenter - y);

                rawNoise[x][y] = -(widthDistanceToCenter + heightDistanceToCenter);
            }
        }

        return rawNoise;
    }
}
