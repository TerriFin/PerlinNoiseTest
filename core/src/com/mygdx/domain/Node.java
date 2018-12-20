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
public class Node {
    int x;
    int y;
    int elevation;
    
    public Node(int x, int y, int elevation) {
        this.x = x;
        this.y = y;
        this.elevation = elevation;
    }
    
    public int getDistance(Node node) {
        return Math.abs((x - node.x) + (y - node.y));
    }
    
    public int getElevationDifference(Node node) {
        return Math.abs(elevation - node.elevation);
    }
}
