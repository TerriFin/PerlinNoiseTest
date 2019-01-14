/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.main;

import com.mygdx.domain.PerlinNoise2;

/**
 *
 * @author samisaukkonen
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PerlinNoise2 perlin = new PerlinNoise2();
        
        for (double x = 0; x < 500; x += 0.1) {
            for (double y = 0; y < 500; y += 0.1) {
                if (perlin.getNoise(x, y) >= 1 || perlin.getNoise(x, y) <= -1) {
                    System.out.println(perlin.getNoise(x, y));
                }
            }
        }
    }
    
}
