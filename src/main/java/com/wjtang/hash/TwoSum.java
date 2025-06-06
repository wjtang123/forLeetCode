package com.wjtang.hash;

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] result = {map.get(target - nums[i]), i};
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
//        System.out.println("First case of LeetCode");
        int[] nums = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
