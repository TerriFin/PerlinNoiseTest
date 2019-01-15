/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samisaukkonen
 */
public class TwoDimensionalNoiseGenerator {
    private List<PerlinNoise2> noises;
    public int octaves;
    
    public TwoDimensionalNoiseGenerator(double amplitude, int waveLength, int octaves) {
        this.noises = new ArrayList();
        this.octaves = octaves;
        
        int counter = 0;
        
        if (octaves == 1) {
            this.noises.add(new PerlinNoise2(amplitude, waveLength));
        } else if (octaves == 2) {
            this.noises.add(new PerlinNoise2(amplitude / 2, waveLength));
            this.noises.add(new PerlinNoise2(amplitude / 2, waveLength + 1));
        } else {
            while (waveLength >= 1 && counter < octaves) {
                amplitude /= 2;
                
                this.noises.add(new PerlinNoise2(amplitude, waveLength));
                counter++;
                
                waveLength /= 2;
            }
            
            this.octaves = counter;
        }
    }
    
    public double getNoise(double x, double y) {
        double toReturn = 0;
        for (int i = 0; i < noises.size(); i++) {
            toReturn += noises.get(i).getNoise(x, y);
        }
        
        return toReturn;
    }
}
