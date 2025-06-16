package com.wjtang.dp;

public class JieYuShui {
    public static int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[len-1] = height[len-1];
        for(int j = len-2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j+1], height[j]);
        }

        int result = 0;
        for(int i = 0; i<len; i++) {
            result += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
