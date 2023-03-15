// Total subsequences of n length string is 2 ^ n
// agar brute force se kare to overall tc is (2 ^ n) * n
// n sari subseq traverse krke pal check krne ki or exponential vali sari subseq nikalne ki 

// but there is better option 
// tabulation
// space - O(n2) and time - O(n2) 
// we are moving diagonally here with the help of gap method

// str = c1 + m + c2
// sq(str) = _sq(m)_ + _sq(m)c2 + c1sq(m)_ + c1sq(m)c2

// sq(c1m) = c1sq(m) + _sq(m)
// sq(mc2) = sq(m)c2 + sq(m)_

// c(c1mc2)
// c1 == c2 ---> c(str) = c(c1m) + c(mc2) + 1
// c1 != c2 ---> c(c1m) + c(mc2) - c(m)
import java.io.*;

import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    int[][] dp = new int[str.length()][str.length()];
    for (int g = 0; g < dp.length; g++) {
      for (int i = 0, j = g; j < dp[0].length; i++, j++) {
        // first diagonal single chars are pal
        if (g == 0) {
          dp[i][j] = 1;
        }
        // second diagonal
        else if (g == 1) {
          dp[i][j] = str.charAt(i) == str.charAt(j) ? 3 : 2;
        }
        // rest of the diagonals
        else {
          if (str.charAt(i) == str.charAt(j)) {
            dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
          } else {
            dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
          }
        }
      }
    }

    System.out.println(dp[0][dp[0].length - 1]);
  }
}
