package cn.edu.nju;

import java.math.*;
public class Caculator {
    public static void main(String[] args){
        int a = 12;
        int b = 5;
        int c = a++;
        System.out.println("a+b="+(a+b));
        System.out.println("a-b="+(a-b));
        System.out.println("a*b="+(a*b));
        System.out.println("a/b="+(a/b));
        System.out.println("a%b"+(a%b));
        System.out.println("c="+c);
        System.out.println("a++==++a:"+(a++==++a));
        System.out.println("a++<=++a:"+(a++<=++a));
        System.out.println("a*4="+(a*4));
        System.out.println("a*4="+Math.multiplyExact(a,4));
    }
}
