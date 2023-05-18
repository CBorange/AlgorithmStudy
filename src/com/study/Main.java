package com.study;

public class Main {

    public static void main(String[] args) {
        String a = "asfasf";
        String b = "wqrqwrwq";

        int hashA = a.hashCode();
        int hashB = b.hashCode();

	    System.out.println("hashA Integer : " + hashA);
        System.out.println("hashA Binary : " + Integer.toBinaryString(hashA));
        System.out.println("hashB Integer : " + hashB);
        System.out.println("hashB Binary : " + Integer.toBinaryString(hashB));

        hashA = hashA & 0x7FFFFFFF;
        hashB = hashB & 0x7FFFFFFF;

        System.out.println("hashA Positive Integer : " + hashA);
        System.out.println("hashA Positive Binary : " + Integer.toBinaryString(hashA));

        System.out.println("hashB Positive Integer : " + hashB);
        System.out.println("hashB Positive Binary : " + Integer.toBinaryString(hashB));
    }
}
