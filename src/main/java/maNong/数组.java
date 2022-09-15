package maNong;

import java.util.Arrays;

public class 数组 {
    public static void main(String[] args) {
        int[] a = {111,23,5,1,734,2,9,0};
        Arrays.sort(a,0,3);
        for (int i : a){
            System.out.println(i);
        }
    }
}
