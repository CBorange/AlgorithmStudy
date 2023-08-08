package com.study.solution;
import java.util.HashMap;

public class Cloth {
    public int solution(String[][] clothes) {
        // 옷의 이름별 비트 자리수, 옷의 이름별 종류 HashMap
        HashMap<String, Integer> clothBitPlaces = new HashMap<>(30);
        HashMap<String, String> clothCategoryByName = new HashMap<>(30);
        int bitPlace_Putting = 0;
        for(int i=0; i < clothes.length; ++i){
            clothBitPlaces.put(clothes[i][0], bitPlace_Putting);
            clothCategoryByName.put(clothes[i][0], clothes[i][1]);
            bitPlace_Putting++;
        }

        // 의상 조합 HashMap
        // Key : 의상의 조합 Bit,
        HashMap<Integer, Object> clothCombination = new HashMap<Integer, Object>();

        // 의상Map 순회하면서 의상 조합 만듦, 이미 존재하는 조합은 Count 안함
        for(int i=0; i< clothes.length; ++i){
            String mainCloth = clothes[i][0];
            String mainClothCategory = clothCategoryByName.get(mainCloth);
            int mainBitPlace = clothBitPlaces.get(mainCloth);
            int mainBitValue = 1 << mainBitPlace;
            int bitCombination = mainBitValue;
            clothCombination.put(bitCombination, null);
            for(int j =0; j < clothes.length; ++j){
                String otherCloth = clothes[j][0];

                String otherClothCategory = clothCategoryByName.get(otherCloth);
                if(mainClothCategory.equals(otherClothCategory))
                    continue;

                int otherBitPlace = clothBitPlaces.get(otherCloth);
                int otherBitValue = 1 << otherBitPlace;
                int tempCombi = bitCombination | otherBitValue;
                if(!clothCombination.containsKey(tempCombi)){
                    bitCombination = tempCombi;
                    clothCombination.put(bitCombination, null);
                }
            }
        }

        int answer = clothCombination.size();
        return answer;
    }
}
