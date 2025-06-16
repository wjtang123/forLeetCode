package com.wjtang.huadongchuangkou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZiMuYiWeiCi {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        String key = new String(pArray);
        int i = 0, j = p.length();
        if (j <= s.length()) {
            String subString = s.substring(i, j);
            char[] array = subString.toCharArray();
            Arrays.sort(array);
            String sortedSubString = new String(array);
            if (key.equals(sortedSubString)) {
                list.add(i);
            }
            i++;
            j++;
        }
        return list;
    }
}
