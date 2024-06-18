package RealCombatProgramming;

import java.util.*;

public class CombatWithLeetcode_And_I_Gonna_Die {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(target - nums[i])){
                map.put(nums[i], i);
            } else{
                result[0] = i;
                result[1] = map.get(target - nums[i]);
            }
        }
        return result;
    }

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int temp = x;
        int length = 0;
        while(temp != 0){
            temp = temp / 10;
            length++;
        }

        int[] arr = new int[length];

        for(int i = 0; i < length; i++){
            arr[i] = x % 10;
            x = x / 10;
        }

        int start = 0;
        for(int i = length - 1; i >= length/2; i--){
            if(arr[start] != arr[i]) {
                return false;
            }
            start++;
        }
        return true;
    }

    public int romanToInt(String s) {
        int result = 0;
        int length = s.length();

        while(length > 0){
            if (length > 1) {
                String twoChar = s.substring(length - 2, length);
                if(twoChar.equals("IV") || twoChar.equals("IX") || twoChar.equals("XL") ||
                        twoChar.equals("XC") || twoChar.equals("CD") || twoChar.equals("CM")) {
                    switch (twoChar){
                        case "IV": result += 4; break;
                        case "IX": result += 9; break;
                        case "XL": result += 40; break;
                        case "XC": result += 90; break;
                        case "CD": result += 400; break;
                        case "CM": result += 900; break;
                    }
                    s = s.substring(0, length - 2);
                    length -= 2;
                    continue;
                }
            }
            String oneChar = s.substring(length - 1);
            s = s.substring(0, length - 1);
            length -= 1;
            switch (oneChar){
                case "I": result += 1; break;
                case "V": result += 5; break;
                case "X": result += 10; break;
                case "L": result += 50; break;
                case "C": result += 100; break;
                case "D": result += 500; break;
                case "M": result += 1000; break;
            }
        }
        return result;
    }

    //Faster way
    public int romanToIntFasterWay(String s) {
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            //Đây là cách xác định ký tự đặc biệt
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }

    public String longestCommonPrefix(String[] strs) {
        for(String str : strs)
            if(str.isEmpty())
                return "";

        String firstString = strs[0];
        strs = Arrays.copyOfRange(strs, 1, strs.length);
        int count = 0, minLength = 0, resultLength = firstString.length();

        for(String str : strs){
            if(firstString.length() > str.length())
                minLength = str.length();
            else
                minLength = firstString.length();

            for(int i = 0; i < minLength; i++){
                if(firstString.charAt(i) == str.charAt(i)) count++;
                else break;
            }
            if(count < resultLength) resultLength = count;
            count = 0;
        }
        String result = firstString.substring(0, resultLength);
        return result;
    }

    public boolean isValid(String s) {
        Stack<Character> str = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                str.push(currentChar);
                continue;
            }

            if(str.isEmpty()) return false;

            char check = str.pop();
            switch (currentChar){
                case ')':
                    if(check == '{' || check == '[')
                        return false;
                    break;
                case '}':
                    if(check == '(' || check == '[')
                        return false;
                    break;
                case ']':
                    if(check == '{' || check == '(')
                        return false;
                    break;
            }
        }
        return (str.isEmpty());
    }

    //This use ListNode structure on leetcode

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    /*public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
    }*/

    public int removeDuplicates(int[] nums) {
        int pos = 0, count = 1;
        for(int i = 1; i < nums.length; i ++)
            if(nums[i] != nums[pos]){
                nums[pos + 1] = nums[i];
                pos++;
                count++;
            }
        return count;
    }

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;

        int valid_size = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[valid_size] = nums[i];
                valid_size++;
            }
        }

        return valid_size;
    }

    public int strStr(String haystack, String needle) {
        int index = haystack.indexOf(needle);
        return index;
    }

    public int searchInsert(int[] nums, int target) {
        if(nums[0] >= target) return 0;

        int result = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == target) return i;
            if(nums[i-1] <= target && nums[i] >= target) return i;
        }
        return nums.length;
    }

    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        s = s.trim();
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' ') break;
            count++;
        }
        return count;
    }

    public int[] plusOne(int[] digits) {
        int temp = 0;

        if(digits[digits.length - 1] != 9) {
            digits[digits.length - 1] += 1;
            return digits;
        }

        if(digits[digits.length - 1] == 9){
            digits[digits.length - 1] = 0;
            temp = 1;
        }

        for(int i = digits.length - 2; i >= 0; i--){
            if(temp != 0){
                digits[i] += temp;
                temp = 0;
            }
            if(digits[i] == 10){
                digits[i] = 0;
                temp = 1;
            }
        }
        if (temp != 0){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for(int i = 1; i < result.length; i++)
                result[i] = digits[i-1];
            return result;
        } else {
            return digits;
        }
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while(i >= 0 || j >= 0) {
            int sum = carry;

            // việc - '0' biến kí tự thành số
            if (i>=0) sum += a.charAt(i) - '0';
            if (j>=0) sum += b.charAt(j) - '0';

            sb.append(sum % 2); //Nếu như sum%2 thì giá trị là 0, ngược lại là 1
            carry = sum / 2;

            i--;
            j--;
        }

        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public int mySqrt(int x) {
        int result = (int) Math.sqrt(x);
        return result;
    }

    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
    }*/

    // Terrible way
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        for (int i = 0; i < nums.length; i++){
            int count = 0;
            for (int j = 0; j < nums.length; j++){
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
            if(count == 1)
                return nums[i];
        }
        return nums[0];
    }

    //https://www.youtube.com/watch?v=eXl0HBm2RrA
    //Good and very faster way
    public int singleNumberBestWay(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++)
            result ^= nums[i];
        return result;
    }

    public boolean isPalindromeString(String s) {
        if(s == " ") return true;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }

    public int climbStairs(int n) {
        if(n == 0) return 0;
        int firstNumber = 0;
        int secondNumber = 1;
        int result = 0;
        for(int i = 0; i < n; i++){
            result = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = result;
        }
        return result;
    }

    /*public ListNode reverseList(ListNode head) {
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
    }*/

    /*public boolean hasCycle(ListNode head) {
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
    }*/

    //Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
    //
    public int reverse(int x) {
        int temp = x, length = 0, flag = 0;
        long result = 0l;
        while (temp != 0){
            length++;
            temp = temp / 10;
        }

        for(int i = 0; i < length; i++){
            result = result * 10 + (x % 10);
            x /= 10;
        }

        //Check xem số có nằm trong giá trị int theo đề không
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE){
            return 0;
        } else {
            int finalResult = (int) result;
            return finalResult;
        }
    }

    public static void main(String[] args){
        CombatWithLeetcode_And_I_Gonna_Die cb = new CombatWithLeetcode_And_I_Gonna_Die();

    }
}
