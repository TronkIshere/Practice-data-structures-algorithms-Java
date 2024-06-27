package Hackerrank;

import java.util.Scanner;


public class CombatWithHackerrank {
    public static void StringIntroduction(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        System.out.println(A.length() + B.length());

        int i = A.compareTo(B);
        if(i>0) System.out.println("Yes");
        else System.out.println("No");

        String resultA = A.substring(0, 1).toUpperCase() + A.substring(1);
        String resultB = B.substring(0, 1).toUpperCase() + B.substring(1);

        System.out.println(resultA + " " + resultB);
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        for(int i = 1; i <= s.length() - k; i++){
            String currStr = s.substring(i, i + k);
            if (largest.compareTo(currStr) < 0)
                largest = currStr;
            if (smallest.compareTo(currStr) > 0)
                smallest = currStr;
        }
        return smallest + "\n" + largest;
    }

    public static void StringTokens(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] splitString = (s.replaceAll("^[\\W+\\s+]", "").split("[\\s!,?._'@]+"));
        System.out.println(splitString.length);
        for (String string : splitString) {
            System.out.println(string);
        }
        scan.close();
    }

    public static void main(String[] args) {
        CombatWithHackerrank cb = new CombatWithHackerrank();
        System.out.println(getSmallestAndLargest("welcometojava", 3));
    }
}
