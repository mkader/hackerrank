import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n =s.nextInt();
        String a[] = new String[n];
        int mv[] = new int[2];
        int mp[] = new int[2];
        for (int i=0;i<n;i++){
            a[i]=s.next();
            if (a[i].contains("m")) {
                mv[0]=i;
                mv[1]=a[i].indexOf("m");
            } else if (a[i].contains("p")) {
                mp[0]=i;
                mp[1]=a[i].indexOf("p");
            }
        }
        if (mp[0]>mv[0]) {
            for (int i=0;i<mp[0]-mv[0];i++)
                System.out.println("DOWN");
        } else if (mp[0]<mv[0]) {
            for (int i=0;i<mv[0]-mp[0];i++)
                System.out.println("UP");
        }
        if (mp[1]>mv[1]) {
            for (int i=0;i<mp[1]-mv[1];i++)
                System.out.println("RIGHT");
        } else if (mp[1]<mv[1]) {
            for (int i=0;i<mv[1]-mp[1];i++)
                System.out.println("LEFT");
        }
    }
}
