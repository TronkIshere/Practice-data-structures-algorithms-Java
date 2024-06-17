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

    public static void main(String[] args){
        CombatWithLeetcode_And_I_Gonna_Die cb = new CombatWithLeetcode_And_I_Gonna_Die();

    }
}
