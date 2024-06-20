package RealCombatProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Tips {
    //Use hashset to remove all the duplicates element
    public void merge() {
        int[] nums1 = new int[]{1,3,4}; int m = 3;
        int[] nums2 = new int[]{2,1,5}; int n = 3;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            set.add(nums2[i]);
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {
            result[i] = num;
            i++;
        }
        Arrays.sort(result);
    }
}
