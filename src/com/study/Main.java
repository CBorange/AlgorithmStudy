package com.study;

import com.study.collection.MyHashTable;
import com.study.solution.Marathon;
import com.study.solution.PhoneBook;
import com.study.solution.PhoneketMon;

public class Main {

    public static void main(String[] args) {
        PhoneBook sol = new PhoneBook();
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean ret = sol.solution(phone_book);
        System.out.println(ret);
    }
}
