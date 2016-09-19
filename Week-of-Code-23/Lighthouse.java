import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static String[] g;
    public static int[] c;
    public static ArrayList<int[]> dots = new ArrayList<int[]>();
    public static void cubes(int radius){
		int totalPoints = 0;
        c = new int[radius+1];
        int sum = 0;
        for(int i = 0; i <=radius; i++) {
            double p = Math.sqrt(radius * radius - i * i);
            sum+=p;
            c[i] = (int)Math.floor(p+1);
            //System.out.println(i+ " " + sum + " " + p  + " "+ c[i]);

        }
        totalPoints = (sum * 4 + 1);
        //System.out.println(totalPoints);
    }

	public static int[] findMaxDot() {
		int md =0;
		int[] dotInfo;
		int mi =0;
		for (int i=0;i<dots.size();i++) {
			dotInfo = dots.get(i);
			if (dotInfo[4]==0) {
				if (dotInfo[3]>md) {
					md = dotInfo[3];
					mi = i;
				}
			}
	   }
	   dotInfo = dots.get(mi);
	   dotInfo[4]=1;
	   dots.set(mi, dotInfo);
	   return dotInfo;
	}

	public static void dotInfo(int i, String s[]) {
		int[] dotInfo;
		for (int j=0;j<s.length;j++){
			dotInfo= new int[5];
			if (s[j].equals(".")){
				int k=j+1;
				for (;k<s.length;k++){
					if (!s[k].equals(".")){
						break;
					}
				}
				dotInfo[0]=i;
				dotInfo[1]=j;
				dotInfo[2]=k;
				dotInfo[3]=k-j;
				dotInfo[4]=0;
				dots.add(dotInfo);
				//System.out.println(i + " " +j + " " + k);
				j=k;
			}
    	}
	}

    public static void findDots() {
		for (int i=g.length/2,j=g.length/2;i<g.length;i++,j--) {
			String[] si = g[i].split("");
            String[] sj = g[j].split("");
            //System.out.println(i + " " +j + " " + g[i] + " " +g[j]);
            if (i!=j)
	            dotInfo(i, si);
            dotInfo(j, sj);
        }
    }


    //version 2
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n= s.nextInt();
		int md = 0;
		g = new String[n];
		for (int i=0;i<n;i++) {
			g[i] = s.next();
		}

		/*int n = 6;
		int i1 = 0;
		g = new String[n];
		g[i1++]= "123456";
		g[i1++]= "234561";
		g[i1++]= "345612";
		g[i1++]= "456123";
		g[i1++]= "561234";
		g[i1++]= "612345";

		n = 7;
		i1 = 0;
		g = new String[n];
		g[i1++]= "1234567";
		g[i1++]= "2345671";
		g[i1++]= "3456712";
		g[i1++]= "4567123";
		g[i1++]= "5671234";
		g[i1++]= "6712345";
		g[i1++]= "7123456";

		n = 7;
		i1 = 0;
		g = new String[n];
		g[i1++]= "...x...";
		g[i1++]= ".......";
		g[i1++]= ".......";
		g[i1++]= ".......";
		g[i1++]= ".......";
		g[i1++]= ".......";
		g[i1++]= ".......";*/

		//System.out.println(Arrays.toString(g));
		boolean found = false;
		for (int r=n/2;r>=1;r--) {
			cubes(r);
			int m = c[0]+c[0]-1;
			if (m<=n) {
				//System.out.println(r + " " + Arrays.toString(c) + " " + m);
				for (int i=0;i<n;i++) {
					for (int j1=0;j1<n;j1++) {
						int j =j1;
						//System.out.println(" " + i + " " + j1 + " " + c.length + " " + (j+c.length+r-1));
						if (j+c.length+r-1<n) {
							boolean first  = true;
							boolean second  = false;
							for (int cl=c.length-1;cl>=0;cl--,j++) {
								if ((i-c[cl]>-1) && (c[cl]+i-1)<=n ) {
									int sp = c[cl]+c[cl]-1;
									String gs =g[j].substring(i-c[cl],c[cl]+i-1);
									int gsd = gs.split("\\.", -1).length - 1;
									if (sp!=gsd) {
										first  = false;
										second = false;
										break;
									}
									//System.out.println("  f " +cl +" " + c[cl] + " " + sp + " " + j + " " + g[j] + " " + (i-c[cl]) + " " + (c[cl]+i-1) + " " + gs + " " + gsd);
								} else {
									first  = false;
									second = false;
									break;
								}
							}
							if (first) {
								second = true;
								j=j-1;
								for (int cl=0;cl<c.length;cl++,j++) {
									if ((i-c[cl]>-1) && (c[cl]+i-1)<=n ) {
										int sp = c[cl]+c[cl]-1;
										String gs =g[j].substring(i-c[cl],c[cl]+i-1);
										int gsd = gs.split("\\.", -1).length - 1;
										if (sp!=gsd) {
											second = false;
											break;
										}
										//System.out.println("  s " +cl +" " + c[cl] + " " + sp + " " + j + " " + g[j] + " " + (i-c[cl]) + " " + (c[cl]+i-1) + " " + gs + " " + gsd);
									} else {
										second  = false;
										break;
									}
								}
							}
							//System.out.println("     " + first  + " " + second);
							if (first && second) {
								//System.out.println("Result     " + r);
								System.out.println(r);
								found = true;
								j1=n;
								i=n;
								r=0;
								break;
							}
						}
					}
				}
			}
		}
		if (!found)
			System.out.println("0");
	}
}
/*

http://mathworld.wolfram.com/GausssCircleProblem.html
	10
0	10	19 = 10+(10-1)
1	10	38 = (10+(10-1)) *2
2	10	38 = (10+(10-1)) *2
3	10	38 = (10+(10-1)) *2
4	10	38 = (10+(10-1)) *2
5	9	34 = (9+(9-1)) *2
6	9	34 = (9+(9-1)) *2
7	8	30 = (8+(8-1)) *2
8	7	26 = (7+(7-1)) *2
9	5	18 = (5+(5-1)) *2
10	0	0  = 0
11	4	4  = 4
		317
        */
/*
9
.........
.........
.........
.........
.........
.........
.........
.........
.........

9
*********
****.****
**.....**
**.....**
*.......*
**.....**
**.....**
****.****
*********
Sample Output 0

3
Explanation 0
Build a lighthouse with radius  at the center of the grid. Note that it will fill ALL free cells.

Sample Input 1

5
.*.*.
*...*
.....
*...*
.*.*.
Sample Output 1

2
Explanation 1
Build a lighthouse with radius  at the center of the grid.

Sample Input 2

5
***.*
**..*
***.*
*****
*****
Sample Output 2

0
*/
