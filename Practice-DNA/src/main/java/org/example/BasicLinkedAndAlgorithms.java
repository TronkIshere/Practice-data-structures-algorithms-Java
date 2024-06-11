package org.example;

import java.util.List;
import java.util.SplittableRandom;

public class BasicLinkedAndAlgorithms {
    private ListNode head;

    private static class ListNode {
        private int data; //Generic Type
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " -- > ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length() {
        if(head == null) return 0;

        int count = 0;
        ListNode current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if(head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (null != current.next) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertIntoSpecificLocation(int position, int value) {
        ListNode node = new ListNode(value);

        if(position == 1) {
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int count = 1; //position - 1

            while (count < position - 1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

    public ListNode deleteFirst(){
        if(head == null) return null;
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public static void main(String[] args) {
        BasicLinkedAndAlgorithms sll = new BasicLinkedAndAlgorithms();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        sll.head.next = second; // 10 --> 1
        second.next = third; // 10 --> 1 --> 8
        third.next = fourth; //10 --> 1 --> 8 --> 11 --> null

        sll.insertFirst(1);
        sll.insertLast(10);
        sll.insertIntoSpecificLocation(2,111);

        sll.display();
        System.out.println("Linked Length: "+ sll.length());

        sll.deleteFirst();
        System.out.println("deleteFirst: "+ sll.length());
    }
}
