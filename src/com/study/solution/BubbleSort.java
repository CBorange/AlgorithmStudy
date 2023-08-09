package com.study.solution;

import java.io.*;
import java.util.StringTokenizer;

public class BubbleSort {
    private int[] targetData;
    public void solution() throws IOException {
        makeTargetData();
        solve();
    }
    private void makeTargetData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int nCnt = Integer.parseInt(bufferedReader.readLine());
        targetData = new int[nCnt];

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i < nCnt; ++i){
            targetData[i] = Integer.parseInt(st.nextToken());
        }

        bufferedReader.close();
    }
    private void solve(){
        int swapCnt = 0;
        for(int mainSequence = targetData.length - 1; mainSequence > 0; mainSequence--){
            for(int subSequence = 0; subSequence < mainSequence; ++subSequence){
                if(targetData[subSequence] > targetData[subSequence + 1]){
                    int temp = targetData[subSequence];
                    targetData[subSequence] = targetData[subSequence + 1];
                    targetData[subSequence + 1] = temp;
                    swapCnt++;
                }
            }
        }
        System.out.println(swapCnt);
    }
}
