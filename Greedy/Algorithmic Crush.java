import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        long n = s.nextLong();
        long m = s.nextLong();
        //System.out.println(n + " " + m);
        long nz[] = new long[(int)n];
        Arrays.fill(nz,0);
        //System.out.println(nz[0]);
        s.nextLine();
        long max =0l;
        //long t=2497169732l;
        int f = 0;
        int e =0;
        while(s.hasNext()) {
            f = s.nextInt();
            e = s.nextInt();
            long v = s.nextLong();
            for (int i=f-1;i<e;i++) {
                nz[i]+=v;
                if (nz[i]>max) max = nz[i];
            }
       }
       System.out.println(max);
    }
}
