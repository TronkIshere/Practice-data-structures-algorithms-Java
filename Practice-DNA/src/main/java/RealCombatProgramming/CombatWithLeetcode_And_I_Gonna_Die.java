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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        double finalResult;
        int[] result = new int[n + m];
        int length = result.length - 1;
        while(m > 0 && n >0){
            if(nums1[m - 1] < nums2[n - 1]){
                result[length] = nums2[n - 1];
                n--;
            } else {
                result[length] = nums1[m - 1];
                m--;
            }
            length--;
        }
        while (m > 0) {
            result[length] = nums1[m - 1];
            m--; length--;
        }

        while (n > 0) {
            result[length] = nums2[n - 1];
            n--; length--;
        }
        if (result.length%2 == 0) {
            finalResult = (result[result.length / 2] + result[result.length / 2 - 1]) / 2.0;
            return finalResult;
        }
        else {
            finalResult = result[result.length/2];
            return finalResult;
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--; k--;
        }
    }

    public void myPow(double x, int n) {
        double result = Math.pow(2.1, 3);
        System.out.println(result);
    }

    public int divide(int dividend, int divisor) {
        if(dividend <= Integer.MIN_VALUE && divisor == -1)
            System.out.println((Integer.MIN_VALUE + 1) * -1);


        int result = dividend / divisor;
        System.out.println(result);
        return result;
    }

    /*public ListNode deleteDuplicates(ListNode head) {
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
    }*/

   /* public boolean isSameTree(TreeNode p, TreeNode q) {
        return identicalTrees(p, q);
    }

        public boolean identicalTrees(TreeNode a, TreeNode b){
            if (a == null && b == null) return true;
            if (a != null && b != null)
                return (a.val == b.val
                        && identicalTrees(a.left, b.left)
                        && identicalTrees(a.right, b.right));
            return false;
        }*/

    /*public int maxDepth(TreeNode root) {
        return depthCount(root);
    }
        public int depthCount(TreeNode root){
            if (root == null) return 0;
            int ldepth = depthCount(root.left);
            int rdepth = depthCount(root.right);
            if(ldepth > rdepth)
                return (ldepth + 1);
            else
                return (rdepth + 1);
        }*/

    //https://www.youtube.com/watch?v=jMpi-_NWfZM
    /*public int maxDepth(TreeNode node){
        if(node == null) ? return 0 : return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }*/

    public void isPowerOfTwo() {
        int n = 8;
        if(n == 1) System.out.println(true);
        if(Math.sqrt(n)%2 != 0) System.out.println(false);
        else System.out.println(true);
    }


    //https://www.geeksforgeeks.org/program-to-find-whether-a-given-number-is-power-of-2/
    //Bài toán này thao tác với bits để kiểm tra, khá là hay
    public boolean isPowerOfTwo(int n) {
        if(n == 0 || n <= Integer.MIN_VALUE) return false;
        if((n & (~(n - 1))) == n) return true;
        else return false;
    }

    private Set<Integer> seen = new HashSet<>();
    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (seen.contains(n)) return false;

        seen.add(n);

        int result = 0;
        while(n != 0){
            result += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return isHappy(result);
    }

    public void reverseString(char[] s) {
        int length = s.length -1 ;
        for(int i = 0; i <= length / 2; i ++) {
            char temp = s[i];
            s[i] = s[length - i];
            s[length - i] = temp;
        }
    }

    /*LinkedList sll = new LinkedList();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return sll;
        sll.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return sll;
    }*/

    /*LinkedList sll = new LinkedList();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return sll;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        sll.add(root.val);
        return sll;
    }*/

    public int titleToNumber(String columnTitle) {
        int result = 0; int loc = 1;
        int length = columnTitle.length() - 1;
        for(int i = length; i >= 0; i--){
            char temp = columnTitle.charAt(i);
            result += (temp - 'A' + 1) * loc;
            loc *= 26;
        }
        return result;
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder columnName = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
            int remainder = columnNumber % 26;
            char letter = (char) (remainder + 'A');
            columnName.insert(0, letter);
            columnNumber = columnNumber / 26;
        }
        return columnName.toString();
    }

    //https://codelearn.io/sharing/regular-expression-trong-java
    public boolean isMatch(String s, String p) {
        p = p.replaceAll("\\*{2}", "");
        return s.matches(p);
    }


    public boolean canJump(int[] nums) {
        if(nums.length == 1 && nums[0] == 1) return true;
        int length = nums.length - 1;
        int numTarget = length;
        for(int i = length - 1; i >= 0; i--){
            if(nums[i] + i >= numTarget) numTarget = i;
        }
        if(numTarget == 0) return true;
        return false;
    }

    /*public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }*/

    public int jump2() {
        int[] nums = new int[]{1,2,3};

        if(nums.length == 1) return 0;
        int count = 0, current = 0, pos = 0;
        for(int i = 0; i < nums.length; i++){
            pos = Math.max(pos, nums[i] + 1);
            if(i == current){
                System.out.println(nums[current]);
                count++;
                current = pos;
                if(current > nums.length - 1) break;
            }
        }
        return count;
    }

    public int jump(int[] nums) {
        int left = 0, right = 0, count = 0;
        while(right < nums.length - 1){
            int temp = 0;
            for(int i = left; i <= right; i++){
                temp = Math.max(temp, nums[i] + i);
            }
            left = right + 1;
            right = temp;
            ++count;
        }
        return count;
    }

    public void testing(){
        String s = " ";
        if(s.equals(" ") || s.isEmpty()) System.out.println(true);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) return 1;
        if (s.equals("")) return 0;
        Map<Character, Integer> allChar = new HashMap<>();
        int count = 0, maxCount = 0;
        for(int i = 0; i < s.length(); i++){
            if(allChar.containsKey(s.charAt(i))){
                i = allChar.get(s.charAt(i)) + 1;
                allChar.clear();
                count = 0;
            }
            allChar.put(s.charAt(i), i);
            count++;
            if(count > maxCount) maxCount = count;
        }
        return maxCount;
    }

    public int lengthOfLongestSubstringFaster(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, len = 0;
        for(int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            if(map.containsKey(c))
                if(start <= map.get(c))
                    start = map.get(c)+1;
            len = Math.max(len, end-start+1);
            map.put(c,end);
        }
        return len;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Map<Integer, Integer> array1 = new HashMap<>();
        for(int i = 0; i < nums1.length; i++)
            array1.put(nums1[i], i);
        for(int i = 0; i < nums2.length; i++)
            if(array1.containsKey(nums2[i]))
                result.add(nums2[i]);
        int[] finalResult = new int[result.size()];
        int i = 0;
        for(int num : result)
            finalResult[i++] = num;
        return finalResult;
    }

    // Thử chơi thôi, chứ tôi còn nghĩ nó chạy sai cơ
    public int addDigits(int num) {
        int result = oneDigit(num);
        return result;
    }

        public int oneDigit(int num){
            int result = 0;
            while (num!=0){
                result += num % 10;
                num /= 10;
            }
            if(result > - 10 && result < 10) return result;
            return oneDigit(result);
        }

    public String reverseVowels(String s) {
        StringBuilder result = new StringBuilder(s);
        Stack<Character> str = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (isVowel(c)) {
                str.push(c);
            }
        }
        for(int i = 0; i < result.length(); i++){
            char c = result.charAt(i);
            if (isVowel(c)) {
                result.setCharAt(i, str.pop());
            }
        }
        return result.toString();
    }
        private static boolean isVowel(char c) {
            switch (c) {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                case 'A': case 'E': case 'I': case 'O': case 'U':
                    return true;
                default:
                    return false;
            }
        }

    //Lưu ý: biểu thức chính quy sẽ chậm hơn bình thường nếu như dùng nó để so sánh
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words){
            StringBuilder reversedWord = new StringBuilder(word);
            result.append(reversedWord.reverse().toString()).append(" ");
        }
        if (result.length() > 0)
            result.setLength(result.length() - 1);
        return result.toString();
    }

    public String addStrings(String num1, String num2) {
        int maxLength = Math.max(num1.length(), num2.length());
        StringBuilder result = new StringBuilder();
        int carry = 0;

        for (int i = 0; i < maxLength; i++) {
            int digit1 = (i < num1.length()) ? Character.getNumericValue(num1.charAt(num1.length() - 1 - i)) : 0;
            int digit2 = (i < num2.length()) ? Character.getNumericValue(num2.charAt(num2.length() - 1 - i)) : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.insert(0, sum % 10);
        }
        if(carry > 0) result.insert(0, carry);

        return result.toString();
    }

    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder(s);
        for(int i = 0; i < s.length(); i += 2*k){
            int end = Math.min(i + k, s.length());
            reverse(result, i, end - 1);
        }
        return result.toString();
    }

        private static void reverse(StringBuilder result, int left, int right) {
            while (left < right) {
                char temp = result.charAt(left);
                result.setCharAt(left, result.charAt(right));
                result.setCharAt(right, temp);
                left++;
                right--;
            }
        }


    //https://www.youtube.com/watch?v=56TxHMG0qhQ
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++)
            sum += nums[i];
        int maxSum = sum;
        int startIndex = 0; int endIndex = k;
        while (endIndex < nums.length){
            sum -= nums[startIndex]; startIndex++;
            sum += nums[endIndex]; endIndex++;
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int num : nums) System.out.println(num + " ");
        for(int i = 1; i < nums.length - 1; i++){
            int low = nums[i-1];
            int height = nums[i+1];
            if(low + height + nums[i] == 0){
                result.add(Arrays.asList(low, nums[i], height));
            }
        }
        return result;
    }

    public int singleNumberII(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int result = 0;
        int[] bits = new int[32];

        for(int i=0; i<32; i++){
            for(int j=0; j<nums.length; j++){
                bits[i] += nums[j] >> i & 1;
                bits[i] %= 3;
            }
            result |= (bits[i] << i);
        }
        return result;
    }

    public void moveZeroes(int[] nums) {
        if(nums.length == 1) return;
        int countZero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[countZero] = nums[i];
                countZero++;
            }
        }
        while(countZero < nums.length){
            nums[countZero] = 0;
            countZero++;
        }
    }

    public String reverseWordsMedium(String s) {
        StringBuilder result = new StringBuilder();
        s = s.replaceAll("\\s+", " ").trim();
        System.out.print(s);
        String[] words = s.split(" ");
        for (String word : words){
            result.insert(0, word.toString()+ " ");
        }
        if (result.length() > 0)
            result.setLength(result.length() - 1);

        return result.toString();
    }

    /*public static ListNode merge(ListNode left, ListNode right){
        ListNode head=new ListNode(0);
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
    }*/

    public int[][] modifiedMatrix(int[][] matrix) {
        int rows = matrix[0].length;
        int cols = matrix.length;
        for(int i = rows - 1; i >= 0; i--){
            int max = 0;
            for(int j = cols - 1; j >= 0; j--)
                if(matrix[j][i] > max) max = matrix[j][i];
            for(int j = cols - 1; j >= 0; j--)
                if(matrix[j][i] == -1) matrix[j][i] = max;
        }
        return matrix;
    }

    public boolean isValid3136(String word) {
        if(word.length() < 3) return false;
        String specialCharacters = "!@#$%^&*()_+[]{}|;:',.<>?/~`-=\\\"";
        String Vowel = "AEIOUaeiou"; int vowelCount = 0, consonantCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (specialCharacters.indexOf(ch) != -1) return false;
            if (Vowel.indexOf(ch) != -1) vowelCount++;
            else if (Character.isLetter(ch)) consonantCount++;
        }
        if (vowelCount > 0 && consonantCount > 0) return true;
        else return false;
    }

    public String triangleType(int[] nums) {
        if (nums[0] + nums[1] <= nums[2]
                || nums[0] + nums[2] <= nums[1]
                || nums[1] + nums[2] <= nums[0])
            return "none";
        int count = 0; int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    count++;
            }
            if(count > result) result = count;
            count = 0;
        }
        switch (result) {
            case 0: return "scalene";
            case 1: return "isosceles";
            case 2: return "equilateral";
        }
        return "none";
    }

    public List<Integer> findPeaks(int[] mountain) {
        List list = new ArrayList<>();
        if (mountain.length < 3) return list;
        for(int i = 1; i < mountain.length-1; i++){
            if(mountain[i] > mountain[i-1] && mountain[i] > mountain[i+1])
                list.add(i);
        }
        return list;
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length) return new int[0][0];
        int index = 0;
        int[][] result = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = original[index];
                index++;
            }
        }
        return result;
    }

    public boolean divideArray(int[] nums) {
        int pairs = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
                pairs++;
            } else set.add(nums[i]);
        }
        if(pairs == nums.length/2) return true;
        else return false;
    }

    public int findClosestNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int index = binarySearchToZero(nums, 0);
        if (index + 1 < nums.length) {
            if(Math.abs(nums[index + 1]) <= Math.abs(nums[index])) return nums[index + 1];
            return nums[index];
        }
        return nums[index];
    }

        int binarySearchToZero(int arr[], int x)
        {
            int low = 0, high = arr.length - 1;
            int mid = 0;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (arr[mid] == x)
                    return mid;
                if (arr[mid] < x)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            if (low >= arr.length) return high;
            if (high < 0) return low;
            return (Math.abs(arr[low]) < Math.abs(arr[high])) ? low : high;
        }

    public int findClosestNumberFaster(int[] nums) {
        int m = Integer.MAX_VALUE, closestNum = 0;
        for(int num : nums){
            if(Math.abs(num) < m){
                m = Math.abs(num);
                closestNum = num;
            } else if (Math.abs(num) == m && num > closestNum) {
                closestNum = num;
            }
        }
        return closestNum;
    }

    // bài được tối ưu của devanshrwat
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int res[] = new int[nums.length];
        int freq[] = new int[101];
        // frequency stored
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        //running sum
        for(int i=1;i<101;i++){
            freq[i] += freq[i-1];
        }
        // store answer
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                res[i] =0;
            }else{
                res[i] = freq[nums[i]-1];
            }
        }
        return res;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        for(String word : dictionary) set.add(word);
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");

        for(int j = 0; j < words.length; j++){
            String word  = words[j];
            for(int i = 0; i < word.length(); i++){
                if(set.contains(word.substring(0,i))){
                    words[j] = word.substring(0, i);
                    break;
                }
            }
        }
        for (String word : words){
            result.append(word).append(" ");
        }
        if (result.length() > 0)
            result.setLength(result.length() - 1);
        return result.toString();
    }

    //By chicm
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i <= n - 1; i++){
            for(int j = i + 1; j <= n; j++){
                result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }

    /*public ListNode removeNthFromEnd(ListNode head, int n) {

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
    }*/

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for(int i = 1; i <=n; i++){
            if(i%3==0 && i%5==0) result.add("FizzBuzz");
            else if(i%3==0) result.add("Fizz");
            else if(i%5==0) result.add("Buzz");
            else result.add(String.valueOf(i));
        }

        return result;
    }

    public char findTheDifference(String s, String t) {
        int S = s.length();
        int T = t.length();
        int n = Math.min(S, T);
        int i;
        for(i = 0; i < n; i++){
            if(s.charAt(i) != t.charAt(i))
                return s.charAt(i);
        }
        if(S > T) return s.charAt(s.length()-1);
        else return t.charAt(t.length()-1);
    }

    public int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        int count = 0; int majority = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(count == 0) majority = nums[i];
            if(nums[i] == majority) count++;
            else count -= 1;
        }
        return majority;
    }

    public static void main(String[] args){
        CombatWithLeetcode_And_I_Gonna_Die cb = new CombatWithLeetcode_And_I_Gonna_Die();
        cb.fizzBuzz(15);
    }
}
