package com.manish.interview.hackerearth.inotix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Node{
    int num;
    int level;
    public Node(int num,int level){
        this.num = num;
        this.level = level;
    }
}

/**
 * miimimum operation requied to reach a particular number from 0 if only two operation required
 *  - ADD_1
 *  - MULTIPLY_2
 */
public class q3 {


    public static void main(String[] args) {
        int n=31;
        System.out.println(getMinOperations(n));
    }

    private static int getMinOperations(int n) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Node root = new Node(0,0);

        queue.offer(root);
        while (!queue.isEmpty()) {

            Node currNode = queue.poll();
            if (currNode.num == n) {
                return currNode.level;
            }
            visited.add(currNode);
            Node newNode1 = new Node(currNode.num + 1, currNode.level + 1);
            Node newNode2 = new Node(currNode.num * 2, currNode.level + 1);
            if(!visited.contains(newNode1))
            queue.offer(newNode1);
            if(!visited.contains(newNode2))
            queue.offer(newNode2);
        }
        return 0;
    }

    static int getMinSteps(int num) {
        int result=0;
        while(num!=0) {
            if(num%2==0 || num==1) {
                result++;
            } else {
                result +=2;
            }
            num/=2;
        }
        return result;
    }

    static int[] getMinOperations(long[] kValues) {
        int[] result = new int[kValues.length];
        int count;
        long temp;
        for (int i = 0; i < kValues.length; i++) {
            count = 0;
            if (kValues[i] == 0) {
                result[i] = 0;
            } else {
                count++;
                temp = 1;
                while (temp * 2 < kValues[i]) {
                    temp = temp * 2;
                    count++;
                }
                count = count + (int) (kValues[i] - temp);
                result[i] = count;
            }
        }
        return result;
    }
}
