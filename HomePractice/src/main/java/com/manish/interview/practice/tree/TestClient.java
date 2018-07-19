package com.manish.interview.practice.tree;

/**
 * Created by manish_kumar9 on 17/08/15.
 */
public class TestClient {
    public static void main(String[] args) {
        /*
                        1
                2               3
            4       5       6       7

         */

        Node root  = new Node(1);
        Node node2 =  new Node(2);
        Node node3 =  new Node(3);
        Node node4 =  new Node(4);
        Node node5 =  new Node(5);
        Node node6 =  new Node(6);
        Node node7 =  new Node(7);

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        MyTree mt =new MyTree();

        System.out.println(mt.getLevelSum(root,3));

        //Node root = new Node(5);
        root.right = new Node(3);
        root.left = new Node(2);
        root.left.left= new Node(1);
        root.left.right = new Node(1);

        mt.decode("1001011",root);
    }
}
