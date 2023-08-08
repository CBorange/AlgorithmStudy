package com.study.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    public boolean solution(String[] phone_book) {
        //원본값 hashmap 만듦
        HashMap<String, Boolean> masterMap = new HashMap<>(phone_book.length);
        for(int i=0; i < phone_book.length; ++i){
            masterMap.put(phone_book[i], false);
        }
        
        // 조회
        for(int i=0; i< phone_book.length; ++i){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j < phone_book[i].length() - 1; ++j){
                sb.append(phone_book[i].charAt(j));
                String target = sb.toString();

                if(masterMap.containsKey(target)){
                    return false;
                }
            }
        }
        return true;
    }
}



