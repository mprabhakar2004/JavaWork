package com.home.practice.tree;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.*;

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

    public List<Integer> rightSideView(Node root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(root == null) return result;

        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(queue.size() > 0){
            //get size here
            int size = queue.size();

            for(int i=0; i<size; i++){
                Node top = queue.remove();

                //the first element in the queue (right-most of the tree)
                if(i==0){
                    result.add(top.data);
                }
                //add right first
                if(top.right != null){
                    queue.add(top.right);
                }
                //add left
                if(top.left != null){
                    queue.add(top.left);
                }
            }
        }

        return result;
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

    int noOfLeftNode(Node root){
        if(root==null){
            return 0;
        }else if(root.left == null){
            return noOfLeftNode(root.right);
        }else {
            return 1 + noOfLeftNode(root.left) + noOfLeftNode(root.right);
        }
    }

    boolean isEachNodeHasOneChild(Node root){
        return false;
    }

    private int minLenSumPathBST(final Node root, final int sum, final int len) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // find the remaining sum as we are including current node in the current path
        final int remainingSum = sum - root.data;
        // If remaining sum is zero and it is a leaf node then we found a complete path from root to a leaf.
        if (remainingSum == 0 && root.left == null && root.right == null) {
            return len + 1;
        }
        // If remaining sum is less than current node value then we search remaining in the left subtree.
        else if (remainingSum <= root.data) {
            int l = minLenSumPathBST(root.left, remainingSum, len + 1);
            // if search in left subtree fails to find such path only then we search in the right subtree
            if (l == Integer.MAX_VALUE) {
                l = minLenSumPathBST(root.right, remainingSum, len + 1);
            }

            return l;
        }
        // If remaining sum is greater than current node value then we search remaining in the right subtree.
        else {
            int l = minLenSumPathBST(root.right, remainingSum, len + 1);
            // if search in right subtree fails to find such path only then we search in the left subtree
            if (l == Integer.MAX_VALUE) {
                l = minLenSumPathBST(root.left, remainingSum, len + 1);
            }

            return l;
        }
    }
}
