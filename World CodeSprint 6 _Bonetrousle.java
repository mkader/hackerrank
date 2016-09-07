import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void mySolution(long sv, long n, int c) {
        long nsq = ((n*n)+n)/2;
        if ((nsq<sv || c==0)  && nsq>0)
            System.out.println("-1");
        else if (c==1) {
            if (sv>n) System.out.println("-1");
            else System.out.println(sv);

        } else if (c==2) {
            if (sv>n) {
                if (n!=(sv-n))
                    System.out.println(n + " "+ (sv-n) );
                else
                    System.out.println("-1");
            }
            else System.out.println((sv-1) + " 1" );
        } else {
            //System.out.println(sv + " " + n + " " + c);
            long ac[]= new long[c];

            long fv = sv/c;
            long sfv = fv;
            long tot = 0;
            //System.out.println(sfv);
            Arrays.fill(ac,0);
            for (int i=0;i<c;i++) {
                //System.out.println(sfv);
                if (sfv<=0) {
                    System.out.println("-1");
                    break;
                }
                ac[i]=sfv++;
                if (sfv==n+1 && i!=c-1) {
                    fv=fv-1;
                    sfv=fv;
                    i=-1;
                    Arrays.fill(ac,0);
                } else if(i==c-1) {
                    tot = 0;
                    for (int j=0;j<c;j++) tot+=ac[j];
                    if (tot==sv) {
                        for (int j=0;j<c-1;j++)
                            System.out.print(ac[j]+ " ");
                        System.out.println(ac[c-1]);
                        i=c;
                    } else {
                        if (tot<sv) {
                            long d = sv - tot;
                            if (d<c){
                                for (int j=c-(int)d;j<c;j++) {
                                    if (ac[j]+1>n) {
                                        //System.out.println("-1");
                                        i=c;
                                        break;
                                    } else {
                                        ac[j]=ac[j]+1;
                                    }
                                }
                            }
                            tot = 0;
                            for (int j=0;j<c;j++) tot+=ac[j];
                            if (tot==sv) {
                                for (int j=0;j<c-1;j++)
                                    System.out.print(ac[j]+ " ");
                                System.out.println(ac[c-1]);
                                i=c;
                            } else {
                                System.out.println("-1");
                                i=c;
                            }
                        } else {
                            fv=fv-1;
                            sfv=fv;
                            i=-1;
                            Arrays.fill(ac,0);
                        }
                    }
                }
            }
        }
    }
    
    public static void hrSolution(long n, long K, int b) {
        	long csum = b*(b+1)/2;
			long ksum = 0;
			for(int i = 0;i < b;i++){
				ksum += K-i;
				if(ksum >= n) break;
			}
			if(n < csum || n > ksum){
				System.out.println(-1);
			}else{
				for(int i = 0;i < b;i++){
					long linf = (b-i-1)*(b-i)/2;
					long can = Math.min(K-i, n-linf);
					n -= can;
					if(i > 0)System.out.print(" ");
					System.out.print(can);
				}
				System.out.println();
			}
	
        //Editorial Code
        
        /*long csum =0, nsum=0, mxset =0;
        csum = ((c*c)+c)/2;
        for (int i=0;i<c;i++) {
            nsum+=n-i;
            if (nsum>=sv) break;
        }
        //System.out.println(csum + "  " + nsum);
        if (csum <= sv && sv <= nsum) {
            mxset = 0;
            for (int i = c; i >= 1; i--) {
                //System.out.println(csum + "  " + mxset);
                if (csum-i+(n-mxset) >= sv) {
                    System.out.print(sv-csum+i);
                    for (long j = 1; j < c-mxset; j++) System.out.print(" " + j);
                    for (long j = n-mxset; j < n; j++) System.out.print(" " + (j+1));
                    System.out.println("");
                    break;
                }
                else {
                    csum-=i;
                    csum+=(n-mxset);
                    mxset++;
                }
            }
        }
        else
            System.out.println("-1");*/        
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
		int t = s.nextInt();
        for(int ii=0;ii<t;ii++){
			long sv= s.nextLong();
			long n = s.nextLong();
			int c = s.nextInt();
			//mySolution(sv,n,c);
            
            hrSolution(sv,n,c);
		}
              
    }
}