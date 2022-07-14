package com.manish.interview.hackerearth.atlassian;

public class q3 {

    static class Node{
        String val;
        Node next;
        Node(String val){
            this.val = val;
        }
    }

    static int find(Node l1,Node l2){
        StringBuilder list1 = new StringBuilder();
        StringBuilder list2 = new StringBuilder();

        while (l1!=null){
            list1.append(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            list2.append(l2.val);
            l2=l2.next;
        }

        return list1.indexOf(list2.toString());
    }
    public static void main(String[] args) {
        Node l1 = new Node("1");
        l1.next = new Node("2");
        l1.next.next =new Node("3");

        Node l2 = new Node("2");
        l2.next = new Node("4");

        System.out.println(find(l1,l2));
    }
}
