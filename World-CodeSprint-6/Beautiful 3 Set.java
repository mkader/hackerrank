import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int k= s.nextInt()+1;
        int ki[] = new int[k];
        for(int j=0;j<k;j++)  ki[j]=j;
       
        boolean f[] = new boolean[k];
        boolean se[] = new boolean[k];
        boolean t[] = new boolean[k];
        Arrays.fill(f,false);
        Arrays.fill(se,false);
        Arrays.fill(t,false);
        ArrayList<int[]> al = new ArrayList<int[]>();
        ArrayList<int[]> fal = new ArrayList<int[]>();
        int  max =0;
        for (int i1=0;i1<k;i1++){
            f = new boolean[k];
            se = new boolean[k];
            t = new boolean[k];
            Arrays.fill(f,false);
            Arrays.fill(se,false);
            Arrays.fill(t,false);
            al = new ArrayList<int[]>();
            ki = new int[k];
            int j1=0;
            for(int j=i1;j<k;j++)  ki[j1++]=j;
            for(int j=0;j<i1;j++)  ki[j1++]=j;
            //for(int j=0;j<k;j++) System.out.print(ki[j] + " ");
            //System.out.println("  " + i1);

            //System.out.println(i1);
            for (int i=0;i<k;i++){
                //System.out.println("i = " +i);
                if (!f[ki[i]]) {
                    for (int j=0;j<k;j++){
                        //System.out.println("j = " +j);
                        if (!f[ki[i]] && !se[j]) {
                            for (int l=0;l<k;l++){
                                //System.out.println(i + " " + j + " " + l);
                                int sum= ki[i] + j + l;
                                if(sum==k-1 && !f[ki[i]] && !se[j] && !t[l]) {
                                    //System.out.println("R = " +i + " " + j + " " + l);
                                    f[ki[i]]=true;
                                    se[j]=true;
                                    t[l]=true;
                                    al.add(new int[]{ki[i], j, l});
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            
            if (al.size()>fal.size()) fal = al;
            /*for(int i=0;i<al.size();i++){
                int[] a= al.get(i);
                System.out.println(a[0] + " " + a[1] + " " +a[2]);
            }*/   
            
        }
        
        System.out.println(fal.size());
        for(int i=0;i<fal.size();i++){
            int[] a= fal.get(i);
            System.out.println(a[0] + " " + a[1] + " " +a[2]);
        }
         
    }
}
