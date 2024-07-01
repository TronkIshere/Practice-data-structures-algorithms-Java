package RealCombatProgramming;

import java.util.ArrayList;

public class Leetcode_ListNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 == null){
            tail.next = list2;
        } else {
            tail.next = list1;
        }

        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x =(l1 != null) ? l1.val : 0;
            int y =(l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry > 0){
            tail.next =new ListNode(carry);
        }
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return head;

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

    public boolean hasCycle(ListNode head) {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode current = head.next;
        ListNode pos = head;
        while(current != null) {
            if(current.val == pos.val){
                current = current.next;
            } else {
                pos.next = current;
                pos = pos.next;
                current = current.next;
            }
        }
        pos.next = null;
        return head;
    }

    //https://www.youtube.com/watch?v=56TxHMG0qhQ
    public ListNode merge(ListNode left, ListNode right){
        ListNode head= new ListNode(0);
        ListNode temp=head;
        while(left!=null && right!=null){
            if(left.val<right.val){
                temp.next=left;
                left=left.next;
            }else{
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }
        if(left!=null){
            temp.next=left;
        }
        if(right!=null){
            temp.next=right;
        }
        return head.next;
    }

    public static ListNode findMid(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        if(head==null||head.next==null){
            return head;
        }
        fast=fast.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        return mid;
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }


        ListNode mid=findMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);


        ListNode newHead =merge(left,right);
        return newHead;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode mainPtr = dummy;
        ListNode refPtr = dummy;

        for (int i = 0; i <= n; i++)
            refPtr = refPtr.next;

        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        mainPtr.next = mainPtr.next.next;
        return dummy.next;
    }

    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        int length = 0;
        while(head != null){
            list.add(head);
            head = head.next;
            length++;
        }
        return list.get(length/2);
    }
}
