package com.study;

import com.study.collection.MyHashTable;
import com.study.solution.Cloth;
import com.study.solution.Marathon;
import com.study.solution.PhoneBook;
import com.study.solution.PhoneketMon;

public class Main {

    public static void main(String[] args) {
        Cloth cloth = new Cloth();
        cloth.solution(new String[][]
                {
                        {"Aa", "A"},
                        {"Ab", "A"},
                        {"Ba", "B"}
                });
    }
}
