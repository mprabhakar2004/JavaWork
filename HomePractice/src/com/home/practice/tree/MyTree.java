package com.home.practice.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by manish_kumar9 on 16/08/15.
 */
public class MyTree {
    Node root;

    void Preorder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            Preorder(root.left);
            Preorder(root.right);
        }
    }

    void Inorder(Node root) {
        if (root != null) {
            Inorder(root.left);
            System.out.print(root.data + " ");
            Inorder(root.right);
        }
    }

    int height(Node root) {
        if (root == null)
            return 0;
        else {
            int lhgt = height(root.left);
            int rhgt = height(root.right);
            return 1 + (lhgt > rhgt ? lhgt : rhgt);
        }
    }

    void LevelOrder(Node root) {
        if (root != null) {
            Queue<Node> queue = new LinkedList<Node>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                Node curNode = queue.poll();
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
                System.out.print(curNode.data + " ");
            }

        }

    }

    public void rightView(Node root){

    }

    public void leftView(Node root){

    }
    static Node Insert(Node root,int value){
        Node newNode= new Node();
        newNode.right=newNode.left=null;
        newNode.data=value;
        if(root==null){
            return newNode;
        }
        Node prevNode,tmp=prevNode =root;
        while (tmp!=null){
            prevNode=tmp;
            if(tmp.data< value){
                tmp=tmp.right;
            }else if (tmp.data>value){
                tmp=tmp.left;
            }
        }
        if(prevNode.data>value){
            prevNode.left=newNode;
        }else {
            prevNode.right=newNode;
        }
        return root;

    }

    static Node InsertRec(Node root,int value){

        if(root==null){
            Node newNode= new Node();
            newNode.right=newNode.left=null;
            newNode.data=value;
            return newNode;
        }
        if(root.data>value)
            root.left=InsertRec(root.left, value);
        if(root.data<value)
            root.right=InsertRec(root.right, value);
        return root;

    }

    /***
     * Huffman decoding
     * @param S
     * @param root
     */
    void decode(String S ,Node root){
        Node tmp =root;
        for (int i=0;i< S.length();i++){

            if((char)49 == S.charAt(i)){
                root=root.right;
            }else {
                root=root.left;
            }

            if(root.left==null && root.right==null){
                System.out.print(root.data + " ");
                root=tmp;
            }
        }

    }
}
