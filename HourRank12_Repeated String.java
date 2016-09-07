/*
Sample Input 0

aba
10
Sample Output 0

7
Explanation 0
The first  letters of the infinite string are abaabaabaa. Because there are  a's, we print  on a new line.

Sample Input 1

a
1000000000000
Sample Output 1

1000000000000
Explanation 1
Because all of the first  letters of the infinite string are a, we print  on a new line.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
		String s = in.next();
		long n = in.nextLong();
		long sl = s.length();
		long tld = n/sl;
		double  d = n-tld*sl;
		int sc = s.split("a", -1).length - 1;
		String rs =  s.substring(0,Math.abs((int)d));
		long rc = rs.split("a", -1).length - 1;
		long ta = (sc*tld) + rc;
		System.out.println(ta);
    }
}
