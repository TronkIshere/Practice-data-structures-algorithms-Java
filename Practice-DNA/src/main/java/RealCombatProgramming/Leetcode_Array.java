package RealCombatProgramming;

import java.util.*;

public class Leetcode_Array {
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

    public int searchInsert(int[] nums, int target) {
        if(nums[0] >= target) return 0;

        int result = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == target) return i;
            if(nums[i-1] <= target && nums[i] >= target) return i;
        }
        return nums.length;
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

    public int mySqrt(int x) {
        int result = (int) Math.sqrt(x);
        return result;
    }

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

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i <= n - 1; i++){
            for(int j = i + 1; j <= n; j++){
                result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }

    public int[] twoSumII(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            if(!map.containsKey(target - numbers[i])){
                map.put(numbers[i], i + 1);
            } else{
                result[0] = map.get(target - numbers[i]);
                result[1] = i + 1;
            }
        }
        for(int i : result) System.out.println(i);
        return result;
    }

    public int[] twoSumIIButFaster(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while(left < right){
            int total = numbers[left] + numbers[right];
            if(total == target) return new int[] {left+1, right+1};
            if(total < target) left++;
            else right--;
        }
        return new int[] {-1, -1};
    }


    //nums[i] == nums[j]
    //abs(i - j) <= k
    public boolean containsNearbyDuplicateII(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public int getSum(int a, int b) {
        while(b!=0){
            int carry = (a & b); // Carry is and of two bits
            a = a^b; //Sum of two bits is A XOR B
            b = carry << 1; //Shifts carry to 1 bit to calculate sum
        }
        return a;
    }

    //Sử dụng counting sort
    public void sortColors(int[] nums) {
        int N = nums.length;
        int M = 0;

        for (int i = 0; i < N; i++) M = Math.max(M, nums[i]);

        int[] countArray = new int[M + 1];

        for (int i = 0; i < N; i++) countArray[nums[i]]++;
        for (int i = 1; i <= M; i++) countArray[i] += countArray[i - 1];

        int[] outputArray = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[nums[i]] - 1] = nums[i];
            countArray[nums[i]]--;
        }
        for (int i = 0; i < N; i++) {
            nums[i] = outputArray[i];
        }
    }

    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int halflength = candyType.length/2;
        for(int n : candyType){
            set.add(n);
        }
        if(set.size() >= halflength) return halflength;
        else return set.size();
    }


}
