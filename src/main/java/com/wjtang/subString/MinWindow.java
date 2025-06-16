package com.wjtang.subString;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    private static Map<Character, Integer> tMap = new HashMap<>();

    public static String minWindow(String s, String t) {
        String result = s;
        Map<Character, Integer> windowMap = new HashMap<>();
        boolean hasResult = false;

        // 构造 tMap
        for(int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 滑动窗口的左右边界
        int l = 0, r = 1;
        windowMap.put(s.charAt(l), 1);
        while(l < r && r <= s.length()) {
            if (check(windowMap)) {
                // 覆盖子串时，left 指针移动，缩小窗口
                hasResult = true;
                windowMap.put(s.charAt(l), windowMap.get(s.charAt(l)) - 1);
                result = r - l < result.length() ? s.substring(l,r) : result;
                l++;
            } else {
                if (r < s.length()) {
                    windowMap.put(s.charAt(r), windowMap.getOrDefault(s.charAt(r), 0) + 1);
                }
                r++;
            }
        }
        if (!hasResult) {
            return "";
        }
        return result;
    }

    private static boolean check(Map<Character, Integer> windowMap) {
        for (char ch : tMap.keySet()) {
            if (windowMap.getOrDefault(ch, 0) < tMap.get(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("a", "a"));
    }
}
