import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.*;

public class Solution {


	public static void display(long ca[], long sum, long inc, int cou) {
		//long tot = ca[0];
		System.out.print(ca[0]);
		for (int j=1;j<ca.length;j++) {
			System.out.print(" " +ca[j]);
			//tot+=ca[j];
		}
		System.out.println("");

		//System.out.println(sum + " " + tot + " " +ca[0] + " " + ca[ca.length-1] + " " + inc + " " +  ca.length-1 + " " +cou);
		//if (sum==tot && ca[0]>0 && ca[ca.length-1]<=inc && ca.length==cou)
			//System.out.println(" Good");
	}

	public static BigInteger GetBig(long m1, long m2) {
		BigInteger bi;
		BigInteger bi1, bi2, bi3;
		bi1 = new BigInteger(Long.toString(m1));
		bi2 = new BigInteger(Long.toString(m2));
		bi = (bi1.multiply(bi2)).divide(new BigInteger("2"));
		return bi;
	}
	public static void mySolution1(long sum, long inc, int cou) {
		/*
		Test Case1 Explanation
		Sum inc  cou
		20  10 5
		inv = sum/cou => 20/5 = 4
		start from 4,5,6,7,8 => total is 30
		max = 4 + 5 - 1= 8 (start from 4 and end to 8 => total is  30)
		using formula too prove 4+5+6+7+8 = 30.
		tot = (8 * 9)/2 - (4*3)/2 = > 36 - 6 = 30
		if ((max-inv+1)==cou && tot>sum) { true
			dt = 30 - 20 /5 = 10/5 = 2
			st =change start from 4 to (4-2) 2
		start from 2, 3, 4, 5, 6 = > total 20, it is outpu1


		Test Case2 Explanation
		Sum inc  cou
		236 22   21
		inv = sum/cou => 236/21 = 11
		start from 11,12,13..31 => total is 441
		max = inv + cou- 1 => 11 + 21 - 1= 31 (start from 11 and end to 31 => total is  441)
		using formula too prove 11+12+13+..+31 = 441.
		tot = (31 * 32)/2 - (11*10)/2 = > 496 - 55 = 441
		if ((max-inv+1)==cou && tot>sum) { true
			dt = 441 - 236 /21 = 205/21 = 10
			st =change start from 4 to (11-10) 1
		start from 1, 2, 3, 5, 6.7,8,9,10,11,12,13,14,15,16,17,18,19,20,21 = > total 231
		} else if (tot<sum && (i+1)==cou) {
			231 > 236, so difference = 236-231 = 5.
			add 1 extra to from last 5 digits, so 17 => 18 , 18=> 19, 19=>20, 20=>21, 21=>22, so from 17 increase 1 up to 21.
			1, 2, 3, 5, 6.7,8,9,10,11,12,13,14,15,16,18,19,20,21,22 = > total 236 it is output.
			231 + 22(new number) - 17 (17 is gone from list)= 236.


		Test Case3 Explanation
		Sum inc  cou
		151 102  67
		inv = sum/cou => 151/67 = 2
		start from 2,12,13..68 => total is 2345
		max = inv + cou- 1 => 2 + 67 - 1= 68 (start from 2 and end to 68 => total is  2345)
		using formula too prove 2+3+4+..+68 = 2345.
		tot = (68 * 69)/2 - (2*1)/2 = > 2346 - 1 = 2345
		if ((max-inv+1)==cou && tot>sum) { true
			dt = 2345 - 151 /67 = 2194/67 = 33
			st =change start from 2 to (2-33) => -31
		if (i<0 || st<0) {
				System.out.println("-1");

		*/

		long [] ca = new long[cou];

		long inv = sum/cou;
		long st = inv;
		Arrays.fill(ca,0);
		long tot = 0;
		long max = inv+cou-1;
		//tot = ((max*(max+1))/2) - ((inv*(inv-1))/2);

		BigInteger bi1 = GetBig(max, max+1);
		BigInteger bi2 = GetBig(inv, inv-1);
		BigInteger bi3 = bi1.subtract(bi2);
		//System.out.println("2* = " + bi1 + " "  + bi2 + " " + bi3);
		//double m2=  ((double)max*((double)max+1))/2;
		//double i2=  ((double)inv*((double)inv-1))/2;
		//double t2= m2 -i2;
		//System.out.println("2* = " + m2 + "  " + i2 + " " + (long)t2);
		//tot = (long)(m2-i2);
		tot = bi3.longValue();
		//System.out.println("Start = " + inv + " " + tot + " " + max);
		if ((max-inv+1)==cou && tot>sum) {
			double dt = Math.ceil(((tot-sum)*1.0/cou*1.0));
			//System.out.println(dt);
			st=inv-(int)dt;
		}
		if (st<=0 || tot<sum || inv>inc)
			System.out.println("-1");
		else {
			tot = ((st+cou)*(st+cou-1))/2 - ((st-1)*st)/2;
			//System.out.println(tot + " " + st + " " + cou);
			long d = sum-tot;
			int i=(int)(cou-d-1);
			//System.out.println("  " +i + " " + d + " " + tot + " " + st);
			if (i<0) {
				System.out.println("-1");
			} else {
				tot=0;
				for (int j=0;j<cou;j++) {
					if (j==i+1) st++;
					ca[j]=st;
					if (st>inc) {
						System.out.println("-1");
						break;
					}
					tot+=ca[j];
					st++;
				}
				//for (int j=i+2;j<i+1;j++) tot+=ca[j];
				//System.out.println("  " +i + " " + st + " " + d + " " + tot);
				if (tot==sum) display(ca,  sum, inc, cou);
			}

		}
	}

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
		int t = s.nextInt();
        for(int i=0;i<t;i++){
			long sv= s.nextLong();
			long n = s.nextLong();
			int c = s.nextInt();
			//System.out.println(" ----- ");
			//System.out.println(i + " " + sv + " " + n + " " + c);
			mySolution1(sv, n, c);
		}

	
    }
}
