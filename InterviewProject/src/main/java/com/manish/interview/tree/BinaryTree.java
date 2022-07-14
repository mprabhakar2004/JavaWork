package com.manish.interview.tree;

import com.sun.tools.javac.util.StringUtils;

import java.io.*;
import java.util.Scanner;

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree
{
    Node root;

    int sum=0;

    // A simple function to print leaf nodes of a binary tree
    void printLeaves(Node node)
    {
        if (node != null)

        {
            // Print it if it is a leaf node
            if (node.left == null && node.right == null) {
                System.out.print(node.data + " ");
                sum+=node.data;
            }
            printLeaves(node.left);


            printLeaves(node.right);
        }
    }

    // A function to print all left boundry nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(Node node)
    {
        if (node != null)
        {
            if (node.left != null)
            {

                // to ensure top down order, print the node
                // before calling itself for left subtree
                System.out.print(node.data + " ");
                sum+=node.data;
                printBoundaryLeft(node.left);
            }
            else if (node.right != null)
            {
                System.out.print(node.data + " ");
                sum+=node.data;
                printBoundaryLeft(node.right);
            }

            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to print all right boundry nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(Node node)
    {
        if (node != null)
        {
            if (node.right != null)
            {
                // to ensure bottom up order, first call for right
                //  subtree, then print this node
                printBoundaryRight(node.right);
                System.out.print(node.data + " ");
                sum+=node.data;
            }
            else if (node.left != null)
            {
                printBoundaryRight(node.left);
                System.out.print(node.data + " ");
                sum+=node.data;
            }
            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(Node node)
    {
        if (node != null)
        {
            System.out.print(node.data + " ");
            sum+=node.data;

            // Print the left boundary in top-down manner.
            printBoundaryLeft(node.left);

            // Print all leaf nodes
            printLeaves(node);
            //printLeaves(node.right);

            // Print the right boundary in bottom-up manner
            printBoundaryRight(node.right);
        }
    }


    // Driver program to test above functions
    public static void main(String args[]) throws IOException {
//        BinaryTree tree = new BinaryTree();
//        tree.root = new Node(20);
//        tree.root.left = new Node(8);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(12);
//        tree.root.left.right.left = new Node(10);
//        tree.root.left.right.right = new Node(14);
//        tree.root.right = new Node(22);
//        tree.root.right.right = new Node(25);
//        tree.printBoundary(tree.root);
//
//        System.out.println(tree.sum);

//        InputStream fakeIn = new ByteArrayInputStream("wing1scool".getBytes());
//        System.setIn(fakeIn);
        Scanner in = new Scanner(System.in);
        String text = in.next();
//        //System.out.println(text);
//        String []texts=new String[2];
        InputStream newSystemIn = new ByteArrayInputStream(text.getBytes());
        System.setIn(newSystemIn);
        in = new Scanner(System.in);
        text = in.next();
        System.out.println(text);

//        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        int i=0;
//        while ((line = r.readLine()) != null) {
//            texts[i++]= line;
//        }


    }
}

