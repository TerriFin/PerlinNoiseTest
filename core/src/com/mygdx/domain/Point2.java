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

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int hashCode() {
        int result = 454;
        result = 37 * result + x + y;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        Point2 point = (Point2) o;

        if (x == point.x && y == point.y) {

            return true;

        }

        return false;
    }
}
