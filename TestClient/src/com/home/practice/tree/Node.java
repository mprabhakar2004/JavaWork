package com.home.practice.tree;

/**
 * Created by manish_kumar9 on 16/08/15.
 */
public class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left= this.right =null;
    }
    Node(){
        this.left= this.right =null;
    }

}
