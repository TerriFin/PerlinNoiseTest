/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.generation;

import com.mygdx.domain.Node;

/**
 *
 * @author samisaukkonen
 */
public class NewNodeMap {
    public static Node[][] generateNewEmptyNodeMap(int width, int height) {
        Node[][] newNodeMap = new Node[width][height];
        
        for (int x = 0; x < newNodeMap.length; x++) {
            for (int y = 0; y < newNodeMap[x].length; y++) {
                newNodeMap[x][y] = new Node(x, y, 0);
            }
        }
        
        return newNodeMap;
    }
}
