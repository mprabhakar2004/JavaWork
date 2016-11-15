package com.home.practice.tree;

/**
 * Created by manish_kumar9 on 17/08/15.
 */
public class TestClient {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.right = new Node(3);
        root.left = new Node(2);
        root.left.left= new Node(1);
        root.left.right = new Node(1);
        MyTree mt =new MyTree();
        mt.decode("1001011",root);
    }
}
