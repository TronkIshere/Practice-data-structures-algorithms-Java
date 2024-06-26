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
        String smallest = "";
        String largest = "";

        for(int i = 0; i < s.length()-k; i++){
            String temp = s.substring(i, i+k);
            if(temp.compareTo(largest) >= 0) largest = temp;
            if(temp.compareTo(smallest) < 0) smallest = temp;
        }

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        CombatWithHackerrank cb = new CombatWithHackerrank();
        getSmallestAndLargest("welcometojava", 3);
    }
}
