package com.manish.interview.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manish_kumar9 on 16/08/15.
 */
public class Node {
    public int getData() {
        return data;
    }

    int data;

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        this.left= this.right =null;
    }
    Node(){
        this.left= this.right =null;
    }

    public List<Node> getChildren() {
        List<Node> children= new ArrayList<>();
        if (this.left !=null){
            children.add(this.left);
        }
        if (this.right !=null){
            children.add(this.right);
        }
        return children;
    }
}
