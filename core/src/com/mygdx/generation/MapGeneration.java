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
public class MapGeneration {
    
    private static Random r = new Random();
    private static TwoDimensionalNoiseGenerator lastGen;
    private static double lastSize;
    
    private static int movedUp;
    private static int movedDown;
    private static int movedRight;
    private static int movedLeft;
    
    public static void moveMapUpBy(double[][] map, int amount) {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length - amount; y++) {
                map[x][y] = map[x][y + amount];
                
                if (y + 1 == map[x].length - amount) {
                    for (int i = y + 1; i < map[x].length; i++) {
                        map[x][i] = lastGen.getNoise(x * lastSize, (i + amount + movedUp) * lastSize);
                    }
                }
            }
        }
        
        movedUp += amount;
    }
    
    public static void moveMapDownBy(double[][] map, int amount) {
        for (int x = 0; x < map.length; x++) {
            for (int y = map[x].length - 1; y > amount; y--) {
                map[x][y] = map[x][y - amount];
                
                if (y - 1 == amount) {
                    for (int i = y - 1; i >= 0; i--) {
                        map[x][i] = lastGen.getNoise(x * lastSize, (i - amount - movedDown) * lastSize);
                    }
                }
            }
        }
        
        movedDown += amount;
    }
    
    public static void moveMapRightBy(double[][] map, int amount) {
        for (int x = 0; x < map.length - amount; x++) {
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] = map[x + amount][y];
                
                if (x + 1 == map.length - amount) {
                    for (int i = x + 1; i < map.length; i++) {
                        map[i][y] = lastGen.getNoise((i + amount + movedRight) * lastSize, y * lastSize);
                    }
                }
            }
        }
        
        movedRight += amount;
    }
    
    public static void moveMapLeftBy(double[][] map, int amount) {
        for (int x = map.length - 1; x > amount; x--) {
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] = map[x - amount][y];
                
                if (x - 1 == amount) {
                    for (int i = x - 1; i >= 0; i--) {
                        map[i][y] = lastGen.getNoise((i - amount - movedLeft) * lastSize, y * lastSize);
                    }
                }
            }
        }
        
        movedLeft += amount;
    }
    
    public static void generateNewMapRandomValues(double[][] map) {
        double amplitude = 80 + r.nextDouble() * 40;
        int waveLength = 17 + r.nextInt(122);
        int octaves = 3 + r.nextInt(5);
        double size = waveLength * (r.nextDouble() * 0.02);
        
        lastGen = new TwoDimensionalNoiseGenerator(amplitude, waveLength, octaves);
        lastSize = size;
        
        movedUp = 0;
        movedDown = 0;
        movedRight = 0;
        movedLeft = 0;

        for (double x = 0; x < map.length; x++) {
            for (double y = 0; y < map[(int) x].length; y++) {
                int intX = (int) x;
                int intY = (int) y;

                map[intX][intY] = lastGen.getNoise(x * size, y * size);
            }
        }
        
        // Print random values for debugging
        /**
        System.out.println("Amplitude: " + amplitude);
        System.out.println("WaveLength: " + waveLength);
        System.out.println("Octaves: " + octaves);
        System.out.println("Size: " + size);
        * **/
    }
    
    public void generateNewMap(double[][] map, double amplitude, int waveLength, int octaves, double size) {
        lastGen = new TwoDimensionalNoiseGenerator(amplitude, waveLength, octaves);
        lastSize = size;
        
        movedUp = 0;
        movedDown = 0;
        movedRight = 0;
        movedLeft = 0;

        for (double x = 0; x < map.length; x++) {
            for (double y = 0; y < map[(int) x].length; y++) {
                int intX = (int) x;
                int intY = (int) y;

                map[intX][intY] = lastGen.getNoise(x * size, y * size);
            }
        }
    }
}
