package org.Basic;


//Video for reference https://www.youtube.com/watch?v=2ZLl8GAk1X4&t=6019s
public class LinkedList {
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

    public ListNode deleteLast(){
        if(head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        while(current.next != null) {
            previous = current;
            current = current.next;
        }
        current.next = null;
        return current;
    }

    public void deleteInSpecificLocation(int position){
        if(position == 1) {
            head = head.next;
        } else {
            ListNode previous = head;
            int count = 1;
            while(count < position - 1){
                previous = previous.next;
                count++;
            }

            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    public boolean findListNode(ListNode head, int searchKey) {
        if(head == null) {
            return false;
        }

        ListNode current = head;
        while(current != null) {
            if(current.data == searchKey) return true;
            current = current.next;
        }
        return  false;
    }

    public ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode getNthNodeFromEnd(int n){
        if(head == null) return null;
        if(n <= 0)
            throw new IllegalArgumentException("Invalid value: n = " + n);
        ListNode mainPtr = head;
        ListNode refPtr = head;

        int count = 0;

        while (count < n){
            if(refPtr == null)
                throw new IllegalArgumentException(n + "is greater than number of nodes in list");
            refPtr = refPtr.next;
            count++;
        }

        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public void removeDuplicates(){
        if(head == null) return;
        ListNode current = head;
        while (current != null && current.next != null){
            if(current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public ListNode removeDuplicates(int value){
        ListNode newNode = new ListNode(value);
        if(head == null) return newNode;

        ListNode current = head;
        ListNode temp = null;

        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }

        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    public void deleteNode(int key){
        ListNode current = head;
        ListNode temp = null;

        if(current != null && current.data == key){
            head = current.next;
            return;
        }

        while(current != null && current.data != key){
            temp = current;
            current = current.next;
        }

        if(current == null) return ;

        temp.next = current.next;
    }

    //Check if Linked have loop
    public boolean containsLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }

    public ListNode startNodeInALoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr)
                return getStartingNode(slowPtr);
        }
        return null;
    }

        public ListNode getStartingNode(ListNode slowPtr){
            ListNode temp = head;
            while (temp != slowPtr){
                temp = temp.next;
                slowPtr = slowPtr.next;
            }
            return temp;
        }

    public void removeLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr){
                removeLoop(slowPtr);
                return;
            }
        }
    }

        public void removeLoop(ListNode slowPtr) {
            ListNode temp = head;
            while(temp != slowPtr){
                temp = temp.next;
                slowPtr = slowPtr.next;
            }
            slowPtr.next = null;
        }

    public static ListNode merge(ListNode a, ListNode b){
        // a --> 1 --> 3 --> 5 --> null
        // b --> 2 --> 4 --> 6 --> null
        // result --> 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> null
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null){
            if (a.data <= b.data){
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a == null){
            tail.next = b;
        } else {
            tail.next = a;
        }

        return dummy.next;
    }

    public static ListNode addTwoLinkedList(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (a != null || b != null) {
            int x =(a != null) ? a.data : 0;
            int y =(b != null) ? b.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if(a != null) a = a.next;
            if(b != null) b = b.next;
        }
        if(carry > 0){
            tail.next =new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList sll = new LinkedList();
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
        sll.display();

        sll.deleteLast();
        System.out.println("deleteLast: "+ sll.length());
        sll.display();

        sll.deleteInSpecificLocation(3);
        System.out.println("deleteLast: "+ sll.length());
        sll.display();

        System.out.println("Search for key == 1");
        if(sll.findListNode(sll.head, 1))
            System.out.println("Search Key found!!!");
        else
            System.out.println("Search Key not found!!!");

        System.out.println("Reverse: ");
        //Remember to update the head of the list
        sll.head = sll.reverse(sll.head);
        sll.display();

        System.out.println("Get 2nth node from end:");
        ListNode ntnNodeFromEnd = sll.getNthNodeFromEnd(2);
        System.out.println("Nth node from end is: " + ntnNodeFromEnd.data);

        System.out.println("Delete node by key == 10:");
        sll.deleteNode(10);
        sll.display();

        // Create two dummy sorted LinkedList
        LinkedList dummyLinkedList1 = new LinkedList();
        dummyLinkedList1.insertLast(1);
        dummyLinkedList1.insertLast(4);
        dummyLinkedList1.insertLast(8);

        LinkedList dummyLinkedList2 = new LinkedList();
        dummyLinkedList2.insertLast(3);
        dummyLinkedList2.insertLast(5);
        dummyLinkedList2.insertLast(8);
        dummyLinkedList2.insertLast(9);
        dummyLinkedList2.insertLast(14);
        dummyLinkedList2.insertLast(18);

        System.out.println("Sorted LinkedList 1: ");
        dummyLinkedList1.display();
        System.out.println("Sorted LinkedList 2: ");
        dummyLinkedList2.display();

        System.out.println("Merge two sorted LinkedList:");
        LinkedList result = new LinkedList();
        result.head = merge(dummyLinkedList1.head, dummyLinkedList2.head);
        result.display();

        // sum two dummy sorted LinkedList
        LinkedList dummyLinkedList3 = new LinkedList();
        dummyLinkedList3.insertLast(1);
        dummyLinkedList3.insertLast(4);

        LinkedList dummyLinkedList4 = new LinkedList();
        dummyLinkedList4.insertLast(4);
        dummyLinkedList4.insertLast(1);
        System.out.println("Add two LinkedList :");
        result.head = addTwoLinkedList(dummyLinkedList3.head, dummyLinkedList4.head);
        result.display();
    }
}
