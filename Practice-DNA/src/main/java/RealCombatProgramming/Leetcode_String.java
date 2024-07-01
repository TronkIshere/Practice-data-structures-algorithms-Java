package RealCombatProgramming;

import java.util.*;

public class Leetcode_String {
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

    public int strStr(String haystack, String needle) {
        int index = haystack.indexOf(needle);
        return index;
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

    public boolean isPalindromeString(String s) {
        if(s == " ") return true;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }

    public void reverseString(char[] s) {
        int length = s.length -1 ;
        for(int i = 0; i <= length / 2; i ++) {
            char temp = s[i];
            s[i] = s[length - i];
            s[length - i] = temp;
        }
    }

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

    //https://codelearn.io/sharing/regular-expression-trong-java
    public boolean isMatch(String s, String p) {
        p = p.replaceAll("\\*{2}", "");
        return s.matches(p);
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

    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder result = new StringBuilder(ransomNote);
        for(int i = 0; i < magazine.length(); i++){
            if(result.indexOf(String.valueOf(magazine.charAt(i))) >= 0){
                result.deleteCharAt(result.indexOf(String.valueOf(magazine.charAt(i))));
            }
        }
        if(result.isEmpty()) return true;
        else return false;
    }

    public boolean canConstructButFaster(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] alphabets_counter = new int[26];

        for (char c : magazine.toCharArray())
            alphabets_counter[c-'a']++;

        for (char c : ransomNote.toCharArray()){
            if (alphabets_counter[c-'a'] == 0) return false;
            alphabets_counter[c-'a']--;
        }
        return true;
    }

    public char findTheDifference(String s, String t) {
        int sum = 0;
        for (int i = 0; i < t.length(); i++) sum += t.charAt(i);
        for (int i = 0; i < s.length(); i++) sum -= s.charAt(i);
        return (char) sum;
    }

    public String toLowerCase(String s) {
        s = s.toLowerCase();
        return s;
    }

    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if (n == 0) return true;

        if (word.equals(word.toUpperCase())) return true;
        if (word.equals(word.toLowerCase())) return true;
        if (Character.isUpperCase(word.charAt(0))
                && word.substring(1).equals(word.substring(1).toLowerCase())) return true;
        return false;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; //mã ASCII từ 97 đến 122
            count[t.charAt(i) - 'a']--; //trừ a để lấy giá trị mảng hiện tại
        }
        for (int i = 0; i < 26; i++)
            if (count[i] != 0) return false;

        return true;
    }

    public String reversePrefix(String word, char ch) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == ch){
                result.append(word.substring(0, i+1)).reverse();
                result.append(word.substring(i+1));
                break;
            }
        }
        if(!result.isEmpty()) return result.toString();
        else return word;
    }

    public boolean isSubsequence(String s, String t) {
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < s.length(); i++)
            queue.add(s.charAt(i));
        for(int i = 0; i < t.length(); i++){
            if(!queue.isEmpty() && t.charAt(i) == queue.peek())
                queue.poll();
            if(queue.isEmpty()) return true;
        }
        return queue.isEmpty();
    }

    public String[] divideString(String s, int k, char fill) {
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < s.length(); i += k){
            String substring;
            if (i + k <= s.length()) {
                substring = s.substring(i, i + k);
            } else {
                substring = s.substring(i);
                while (substring.length() < k) {
                    substring += fill;
                }
            }
            result.add(substring);
        }
        return result.toArray(new String[0]);
    }

    public String[] divideStringButFaster(final String s, final int k, final char fill) {
        final StringBuilder sb = new StringBuilder();
        final String[] result = new String[s.length() / k + (s.length() % k == 0 ? 0 : 1)];
        int idx = 0;
        for(int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i));
            if((i + 1) % k == 0) {
                result[idx++] = sb.toString();
                sb.setLength(0);
            }
        }

        if(sb.length() > 0 && sb.length() < k) {
            for(int i = sb.length(); i < k; ++i)
                sb.append(fill);
            result[idx] = sb.toString();
        }

        return result;
    }


    public static void main(String[] args){
        Leetcode_String lc = new Leetcode_String();
    }
}
