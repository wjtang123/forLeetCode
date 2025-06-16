package com.wjtang;

import java.util.*;
import java.util.stream.Collectors;

public class CommonSkillsOfJava {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        // int[] 转 List， Set；
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        // 打印 int[], list, set
        System.out.println(Arrays.toString(nums));
        System.out.println(list);
        System.out.println(set);

        // List, Set 转 int[]
        int[] nums2 = list.stream().mapToInt(Integer::intValue).toArray();
        int[] nums3 = set.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));

        String str = "test";
        // String转 char[],然后排序
        char[] array = str.toCharArray();
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        // char[] 转 String
        String str2 = new String(array);
        System.out.println(str2);

        // Collections的最大值
        System.out.println(Collections.max(list));
        System.out.println(Collections.max(set));
//        System.out.println(Collections.max(map.values));


        // 大顶堆
        // 放入大顶堆的时间复杂度是 log(n)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a1, a2) -> a2 - a1);
        PriorityQueue<int[]> maxHeapOfArray = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[0] == a2[0] ? a2[0] - a1[0] : a2[1] - a1[1];
            }
        });
        PriorityQueue<int[]> maxHeapOfArrayLambda = new PriorityQueue<>((a1, a2) -> a1[0] != a2[0] ? a2[0] - a1[0] : a2[1] - a1[1]);

        // [5, 10], [7, 8], [5, 12]
        int[] a1 = new int[]{5, 10};
        int[] a2 = new int[]{7, 8};
        int[] a3 = new int[]{5, 12};
        maxHeapOfArrayLambda.offer(a1);
        maxHeapOfArrayLambda.offer(a2);
        maxHeapOfArrayLambda.offer(a3);

        while(!maxHeapOfArrayLambda.isEmpty()) {
            System.out.println(Arrays.toString(maxHeapOfArrayLambda.poll()));
        }
    }
}
