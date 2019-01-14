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
public class PerlinNoise2 {

    private PseudoRandomVectorGenerator gen;

    public PerlinNoise2() {
        this.gen = new PseudoRandomVectorGenerator();
    }

    public double getNoise(double x, double y) {
        Point2 p0 = new Point2((int) x, (int) y);
        Point2 p1 = new Point2((int) x + 1, (int) y);
        Point2 p2 = new Point2((int) x, (int) y + 1);
        Point2 p3 = new Point2((int) x + 1, (int) y + 1);
        
        Vector2 gradP0 = gen.getVectorForPoint(p0);
        Vector2 gradP1 = gen.getVectorForPoint(p1);
        Vector2 gradP2 = gen.getVectorForPoint(p2);
        Vector2 gradP3 = gen.getVectorForPoint(p3);
        
        Vector2 g0 = new Vector2(x - p0.x, y - p0.y);
        Vector2 g1 = new Vector2(x - p1.x, y - p1.y);
        Vector2 g2 = new Vector2(x - p2.x, y - p2.y);
        Vector2 g3 = new Vector2(x - p3.x, y - p3.y);
        
        double finalP0Value = gradP0.dotProduct(g0);
        double finalP1Value = gradP1.dotProduct(g1);
        double finalP2Value = gradP2.dotProduct(g2);
        double finalP3Value = gradP3.dotProduct(g3);
        
        double xFade = fade(x % 1);
        double yFade = fade(y % 1);
        
        double test1 = lerp(finalP0Value, finalP1Value, xFade);
        double test2 = lerp(finalP2Value, finalP3Value, xFade);
        return lerp(test1, test2, yFade);
    }

    private double fade(double alpha) {
        return alpha * alpha * alpha * (alpha * (alpha * 6.0 - 15.0) + 10.0);
    }

    private double lerp(double firstPoint, double secondPoint, double alpha) {
        return (firstPoint * (1 - alpha) + secondPoint * alpha);
    }
}
