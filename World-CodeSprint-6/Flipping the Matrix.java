import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int q = s.nextInt();
        for(int i=0;i<q;i++){
            int n = s.nextInt();
            
            int a[][] = new int[2*n][2*n];
            
            for(int j=0;j<2*n;j++){
                for(int k=0;k<2*n;k++){
                    a[j][k]= s.nextInt();
                }
            }
            
            int t =0;
            for(int j=0;j<2*n;j++) {
                for(int k=0;k<2*n;k++) {
                    t+=Math.max(Math.max(a[j][k],a[2*n-1-j][k]),Math.max(a[j][2*n-1-k], a[2*n-1-j][2*n-1-k]));
                    //System.out.println(a[j][k] + " " + a[2*n-1-j][k] + " " + a[j][2*n-1-k]+ " " + a[2*n-1-j][2*n-1-k]);    
                }
            }
            //System.out.println(t);
            System.out.println(t/4);
        }
    }
}
