package Offer;

import java.util.ArrayList;
import java.util.Vector;

public class GetUglyNumber_Solution {
	
	public static int GetUglyNumber(int index) {
        if(index < 7)
            return index;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int newNum = 1;
        
        int[] arr = new int[index];
        arr[0] = 1;
       for(int i = 1;i<index;i++) {
        	newNum = Math.min(arr[p2]*2,Math.min(arr[p3]*3, arr[p5]*5));
        	if(arr[p2] * 2 == newNum) p2++;
            if(arr[p3] * 3 == newNum) p3++;
            if(arr[p5] * 5 == newNum) p5++;
            arr[i] = newNum;
        }
        return arr[index-1];
    }
	public static void main(String[] args) {
		System.err.println(GetUglyNumber(9));
		
	}
}
