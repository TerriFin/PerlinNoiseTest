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
public class Vector2 {
    public double x;
    public double y;
    
    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double dotProduct(Vector2 vector) {
        return x * vector.x + y * vector.y;
    }
    
    public Vector2 divideBy(int divider) {
        x /= divider;
        y /= divider;
        
        return this;
    }
}
