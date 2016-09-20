import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        s.nextInt();
        while(s.hasNext()){
            long p=0;
            int n=s.nextInt();
            long t[] = new long[n];
            for (int i=0;i<n;i++){
                t[i]=s.nextLong();
            }
            //System.out.println("Start");
            for (int i=n-1;i>0;i--){
                int j=i-1;
                int k=i;
                for (j=i-1;j>=0;j--){
                    //System.out.println(t[i] + " i " + t[j] + " j " + p + " " + (t[i]>t[j]));
                    if (t[i]>t[j]) {
                        p+=t[i]-t[j];
                        k=j;
                    } else {
                        k=j+1;
                        break;
                    }
                }
                i=k;
                //System.out.println("   " +i+ " i " + j + " j " + p);
            }
            System.out.println(p);
        }
    }
}
