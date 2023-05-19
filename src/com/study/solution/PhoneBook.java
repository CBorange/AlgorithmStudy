package com.study.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBook {
    public boolean solution(String[] phone_book) {
        ArrayList<String> list = new ArrayList<>(phone_book.length);
        list.addAll(List.of(phone_book));
        Collections.sort(list);

        boolean answer = true;
        return answer;
    }
}



