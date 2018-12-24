/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.main;

import com.mygdx.generation.IslandNoise;

/**
 *
 * @author samisaukkonen
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] island = IslandNoise.generateIslandNoise(50, 50);
        
        for (int x = 0; x < island.length; x++) {
            for (int y = 0; y < island[x].length; y++) {
                System.out.print(island[x][y] + ", ");
            }
            
            System.out.println("");
        }
    }
    
}
