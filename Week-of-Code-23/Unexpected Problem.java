import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void S1(String sv, long m) {
		long t=1;
		String isv = "";
		long isvl =0;
		boolean found =false;
		String f =sv.substring(0,1);
		long fd = sv.split(f, -1).length - 1;
		if (fd==sv.length()) {
			//System.out.println(fd);
			t = m;
		} else {
			for (long i=0;i<=sv.length()/2;i++) {
				isv = sv.substring(0,(int)i+1);
				isvl = isv.length();
				//System.out.println(i + " " + isv);
				found =false;
				for (long j=i+1;j<=sv.length()-isvl;j=j+isvl) {
					String jsv = sv.substring((int)j,(int)(j+i+1));
					//System.out.println(" " + j + " " + (j+i+1) + " "+ jsv + " " + found + " " + (!jsv.equals(isv)));
					if (!jsv.equals(isv)) {
						found = false;
						break;
					} else {
						found = true;
					}

				}

				if (found) {
					//System.out.println(((sv+""+isv).equals(isv+""+sv)));
					i=sv.length();
					break;
				}
			}
			if (!found) {
				isvl = sv.length();
			}
			if (isvl>m) isvl = m;
			t = m/isvl;
		}


        long p7 =(long)Math.pow(10,9)+7;
        //System.out.println(isv + " " + isvl   +" " +  t + " " + (t%(10^9 +7)));
        System.out.println(t%p7);

    }

    public static void S2(String sv, long m) {
		int svl = sv.length();
		long t=1;
		String f =sv.substring(0,1);
		long fd = sv.split(f, -1).length - 1;
		long msd = 0;
		if (fd==svl) t = m;
		else {
			if (m>=svl) {
				for (int i=0;i<svl/2;i++) {
					String fsv = sv.substring(0,i+1);
					String bsv = sv.substring(svl-i-1,svl);
					if (fsv.equals(bsv)) msd = fsv.length();
					//System.out.println(fsv+ " " + bsv +  m " + msd);
				}
				//if (msd==0 || msd==1) msd = svl;
                if (msd==1) msd = svl;
			} else if (m<svl) {
				for (int i = 0,j=svl-1; i < svl/2-1 || j>=0; i++,j--) {
					String fsv = sv.substring(0,i+1);
					if (fsv.length()>m) break;
					String bsv = sv.substring(svl-i-1,svl);
					if (fsv.equals(bsv)) msd = fsv.length();
					//System.out.println(i+ " " + j +  " " + fsv + " " +  bsv+  " " +  msd );
				}
				//if (msd==0 || msd==1) msd = m;
                if (msd==1) msd = m;
			}
            if (msd>0)
		      t = m/msd;
            else t=0;
		}
		//System.out.println( msd + " " + t + " " + (t%(10^9 +7)));
		System.out.println((long)t%(10^9 +7));
         System.out.println(2*10^9);
         System.out.println((10^9+7) + " " + (long)(Math.pow(10,9)+7));
        System.out.println(2*10^9 % (10^9+7));
     }

    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
		String sv = s.next();
		long m = s.nextLong();
		S1(sv,m);
		//S2(sv,m);
    }
}


/*
aabbaabb
10

aba
4
1

aaaa
8

abc 6

*/
