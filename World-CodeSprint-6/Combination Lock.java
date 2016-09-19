import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        String[] f= s.nextLine().split(" ");
	    String[] t= s.nextLine().split(" ");
        int c = 0;
        int[] a = new int[] {0,1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i=0;i<f.length;i++) {
            if (!f[i].equals(t[i])) {
                int fc=0;
                boolean fb= false;
                int fi = Integer.parseInt(f[i]);
                int ti = Integer.parseInt(t[i]);
                for (int j=0;j<a.length;j++){
                    if (a[j]== fi) fb=true;
                    if (fb){
                        if (a[j]==ti)break;
                        fc++;
                    }
                }
                int fcr=0;
                fb= false;
                for (int j=a.length-1;j>=0;j--){
                    if (a[j]== fi) fb=true;
                    if (fb){
                        if (a[j]==ti)break;
                        fcr++;
                    }
                }
                if (fc<fcr) c+=fc;
                else c+=fcr;
            }
        }
        System.out.println (c);
    }
}
