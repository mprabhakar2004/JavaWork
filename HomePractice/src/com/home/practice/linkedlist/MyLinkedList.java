package com.home.practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by manish_kumar9 on 15/08/15.
 */
public class MyLinkedList {
    Node head;

    Node InsertNth(Node head, int data, int position) {

        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node tmp = head;
            for (int i = 1; i < position; i++) {
                tmp = tmp.next;
            }
            newNode.next = tmp.next;
            tmp.next = newNode;
        }
        return head;
    }

    /**
     * Delete all node having data value greater than x
     *
     * @param list
     * @param x
     * @return
     */
    Node removeNodes(Node list, int x) {

        while (list != null && list.data > x) {
            list = list.next;
        }
        if (list != null) {
            Node prev = list;
            Node curr = list;
            while (curr != null) {
                if (curr.data > x) {
                    prev.next = curr.next;
                } else {
                    prev = curr;
                }
                curr = curr.next;
            }
        }
        return list;
    }

    Node Delete(Node head, int position) {
        if (position == 0) {
            head = head.next;
        } else {
            Node tmp = head;
            for (int i = 1; i < position; i++) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
        }
        return head;
    }

    Node createLL(int data) {
        head = new Node(data);
        return head;
    }

    void ReversePrint(Node head) {
        if (head == null) {
            return;
        }
        ReversePrint(head.next);
        System.out.println(head.data);

    }


    void Print(Node head) {
        Node tmp = head;
        while (tmp != null) {
            System.out.print("=>" + tmp.data);
            tmp = tmp.next;
        }
    }

    Node Reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node curNode, nextNode, prevNode = null;
        curNode = head;
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        return prevNode;
    }

    int CompareLists(Node headA, Node headB) {
        if (headA == null && headB == null)
            return 1;
        if (headA != null && headB != null && headA.data == headB.data)
            return CompareLists(headA.next, headB.next);
        return 0;

    }

    Node MergeLists(Node headA, Node headB) {
        Node mergeList = null;
        int pos = 0;
        if (headA == null) {
            return headB;
        } else if (headB == null)
            return headA;
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                mergeList = InsertNth(mergeList, headA.data, pos);
                headA = headA.next;
                pos++;
            } else if (headA.data > headB.data) {
                mergeList = InsertNth(mergeList, headB.data, pos);
                headB = headB.next;
                pos++;
            } else {
                headA = headA.next;
                headB = headB.next;
                mergeList = InsertNth(mergeList, headA.data, pos);
                pos++;
            }
        }

        Node last = mergeList;
        if (mergeList != null)
            while (last.next != null)
                last = last.next;
        if (headA != null) {
            last.next = headA;
        } else {
            last.next = headB;
        }
        return mergeList;
    }

    int GetNthNode(Node head, int n) {
        Node p1, p2 = p1 = head;
        if (head == null)
            return 0;
        for (int i = 0; i <= n; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2.data;
    }

    Node RemoveDuplicates(Node head) {
        Node tmp = head;
        if (head == null || head.next == null)
            return head;
        while (tmp.next != null) {
            if (tmp.data == tmp.next.data) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }

        }
        return head;
    }

    int HasCycle(Node head) {
        Node fast, slow = fast = head;
        if (head == null)
            return 0;
        fast = fast.next;
        while (fast != slow || (fast != null && fast.next != null)) {
            if (fast == slow || fast.next == slow) {
                return 1;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return 0;
    }

    int CountNode(Node head) {
        if (head == null)
            return 0;
        return 1 + CountNode(head.next);
    }

    int FindMergeNode(Node headA, Node headB) {
        int l1 = CountNode(headA);
        int l2 = CountNode(headB);
        Node p1, p2;
        int diff = 0;
        if (l1 > l2) {
            p1 = headA;
            p2 = headB;
            diff = l1 - l2;
        } else {
            p1 = headB;
            p2 = headA;
            diff = l2 - l1;
        }
        for (int i = 0; i < diff; i++) {
            p1 = p1.next;
        }
        while (p1.data != p2.data) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.data;
    }

    Node SortedInsert(Node head, int data) {
        Node newNode = new Node();
        newNode.data = data;
        //newNode.next = newNode.prev=null;
        if (head == null)
            return newNode;
        Node tmp = head, cur = head;
        while (tmp != null && tmp.data <= data) {
            cur = tmp;
            tmp = tmp.next;
        }
        newNode.next = tmp;
        //newNode.prev= cur;
        cur.next = newNode;
        return head;

    }

    /***
     * Reverse double link list
     * <--1<-->2<-->3-->
     * @param head
     * @return
     */
    Node Reverse1(Node head) {
        Node tmp = head;
        if (head == null || head.next == null)
            return head;
        Node cur = head;
        while (cur != null) {
            //tmp = cur.prev;
            //cur.prev= cur.next;
            cur.next = tmp;
            //cur =cur.prev ;
        }
        //if(tmp!=null)
        //    head= tmp.prev;
        return head;
    }

    Node add1ToList(Node head) {
        return null;
    }

    Node addList(Node list1, Node list2) {
        return null;
    }

    Node addList1(Node list1, Node list2) {
        return null;
    }

    Node insertNullInCircularSortedList(Node Head) {
        return null;
    }

    Node deleteDuplicateInUnsortedList(Node head) {
        Node temp1, temp = temp1 = head;
        Set<Integer> dataSet = new HashSet<>();
        while (temp1 != null) {
            if (!dataSet.contains(temp1.data)) {
                dataSet.add(temp1.data);
                temp = temp1;
            }
            temp1 = temp1.next;
            temp.next = temp1;
        }
        return head;
    }

    Node deleteDuplicateInUnsortedList2(Node head) {
        Node temp1, temp = temp1 = head;
        while (temp!=null && temp.next != null) {
            temp1 = temp;
            while (temp1.next != null) {
                if (temp.data == temp1.next.data) {
                    temp1.next = temp1.next.next;
                }else {
                    temp1 = temp1.next;
                }
            }
            temp = temp.next;
        }
        return head;
    }

}
