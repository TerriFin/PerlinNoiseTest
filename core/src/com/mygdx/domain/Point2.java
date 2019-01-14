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
public class Point2 {
    public int x;
    public int y;
    
    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int hashCode() {
        return Integer.parseInt(x + "" + y);
    }
    
    @Override
    public boolean equals(Object o) {
        Point2 point = (Point2) o;
        
        return this.hashCode() == o.hashCode();
    }
}
