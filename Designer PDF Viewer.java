import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =26;
        int h[] = new int[n];
        for(int h_i=0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        int m= 0;
        String word = in.next();
        char[] w = word.toCharArray();
        for (int i=0;i<w.length;i++){
            int a = (int) w[i];
            if (h[a-97]>m) m = h[a-97];
            //System.out.println(a + " " + w[i] + " " + (a-97) + " " + h[a-97] + " " + m);
            //if (m==5) break;
        }
        System.out.println(m*w.length);
    }
}