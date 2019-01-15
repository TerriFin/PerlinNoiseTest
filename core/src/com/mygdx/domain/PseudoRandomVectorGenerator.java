/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author samisaukkonen
 */
public class PseudoRandomVectorGenerator {

    private Map<Point2, Vector2> memory;
    private Random r;

    private static Vector2[] vectors = new Vector2[]{new Vector2(0, 1), new Vector2(1, 0),
        new Vector2(-1, 0), new Vector2(0, -1),
        new Vector2(1, 1), new Vector2(-1, -1),
        new Vector2(-1, 1), new Vector2(1, -1)};

    public PseudoRandomVectorGenerator() {
        this.memory = new HashMap();
        this.r = new Random();
    }

    public Vector2 getVectorForPoint(Point2 point) {
        if (memory.containsKey(point)) {
            return memory.get(point);
        } else {
            //memory.put(point, new Vector2(r.nextInt(3) - 1, r.nextInt(3) - 1));
            //memory.put(point, new Vector2((r.nextDouble() * 2) - 1, (r.nextDouble() * 2) - 1));
            memory.put(point, vectors[r.nextInt(vectors.length)]);
            return memory.get(point);
        }
    }
}
