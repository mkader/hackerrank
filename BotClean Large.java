import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int bi= s.nextInt();
        int bj =s.nextInt();
        int mh =s.nextInt();
        int mw=s.nextInt();
        int ni=0,nj = 0;
        int min=-1;

        //String a[] = new String[mh];
        for (int i=0;i<mh;i++) {
            String a=s.next();
            for(int j=0;j<a.length();j++){
                if(a.charAt(j)==100){
                    int sd = Math.abs(bi-i)+Math.abs(bj-j);
                    if (min==-1 || sd<min){
                        min =sd;
                        ni=i;
                        nj=j;
                    }
                }
            }
        }
        if(bi==ni && bj==nj) System.out.println("CLEAN");
        else if(ni>bi) System.out.println("DOWN");
        else if(ni<bi) System.out.println("UP");
        else if(nj>bj) System.out.println("RIGHT");
        else if(nj<bj) System.out.println("LEFT");


    }
}