package com.home.practice.linkedlist;

/**
 * Created by manish_kumar9 on 16/08/15.
 */
public class TestClient {
    public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		String s = in.next();
//		isPanagram(s);
        MyLinkedList ln = new MyLinkedList();
        Node head,head2 = null;
        head=ln.createLL(5);
        head = ln.InsertNth(head, 10, 0);
        head = ln.InsertNth(head,15,0);

        System.out.println("Revers order");
        ln.ReversePrint(head);
        System.out.println(" Linked list data");
        ln.Print(head);
//        head = ln.Reverse(head);
        System.out.println("After Linked list data");
        ln.Print(head);

        head2=ln.createLL(5);
        head2 = ln.InsertNth(head2, 15, 1);
        head2 = ln.InsertNth(head2, 15, 2);
        head2 = ln.InsertNth(head2, 15, 3);
        head2 = ln.InsertNth(head2, 25, 4);
        System.out.println("Linked list data");
        ln.Print(head2);
        System.out.println("After dup removal Linked list data");
        head2 = ln.RemoveDuplicates(head2);
        ln.Print(head2);
        head2 = ln.InsertNth(head2, 25, 1);
        head2 = ln.InsertNth(head2, 25, 1);
        head2 = ln.InsertNth(head2, 25, 1);
        head2 = ln.InsertNth(head2, 25, 1);
        head2 = ln.InsertNth(head2, 5, 1);
        head2 = ln.InsertNth(head2, 15, 5);
        head2 = ln.InsertNth(head2, 5, 1);
        head2 = ln.InsertNth(head2, 15, 5);

        System.out.println("\nBefore duplicate removal");
        ln.Print(head2);
        head2 = ln.deleteDuplicateInUnsortedList(head2);
        System.out.println("\nAfter duplicate removal");
        ln.Print(head2);


    }
}
