package com.study.solution;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 폰켓못 문제
 */
public class PhoneketMon {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int type : nums)
        {
            set.add(type);
        }
        int max = nums.length / 2;
        int setCnt = (int)set.stream().count();
        if(setCnt > max)
            setCnt = max;
        return setCnt;
    }
}
