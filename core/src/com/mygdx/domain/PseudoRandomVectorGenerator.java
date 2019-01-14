/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author samisaukkonen
 */
public class PseudoRandomVectorGenerator {
    private Map<Point2, Vector2> memory;
    private Random r;
    
    public PseudoRandomVectorGenerator() {
        this.memory = new HashMap();
        this.r = new Random();
    }
    
    public Vector2 getVectorForPoint(Point2 point) {
        if (memory.containsKey(point)) {
            return memory.get(point);
        } else {
            memory.put(point, new Vector2(r.nextInt(3) - 1, r.nextInt(3) - 1));
            //memory.put(point, new Vector2((r.nextDouble() * 2) - 1, (r.nextDouble() * 2) - 1));
            return memory.get(point);
        }
    }
}
