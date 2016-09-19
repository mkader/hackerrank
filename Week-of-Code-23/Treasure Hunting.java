import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s  = new Scanner(System.in);
        double x = s.nextDouble();
        double y = s.nextDouble();
        double a = s.nextDouble();
        double b = s.nextDouble();
       
        DecimalFormat df = new DecimalFormat("#.000000000000");
        double dp = x*a + y*b;
        double el =Math.sqrt(a*a + b*b);
        //double mel = dp/Double.valueOf(df.format(el*el));
        double mel = dp/(el*el);
        double as = mel*a;
        double bs = mel*b;
        double n = (x-mel*a)/(-1*b);
        //System.out.println(dp + " " + el + " " + mel + " " + as + " " + bs + " " + n);
        System.out.println(mel);
        System.out.println(n);
    }
}
