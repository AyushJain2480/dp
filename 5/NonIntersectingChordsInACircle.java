// we are calculating for 2n points thats why it is same as catalan
// but if we have to calculate for n points than ans will be c(n/2)
// ye bhi vesa hi he ki ek chord bnalo fir uske clockwise me kitne he * uske anti clockwise me kitne he
// agar clockwise me 0 to C0 agar anticlockwise me 4 he to C2
// agar anticlock me 2 he to C0 lenge 
// jese clockwise me 0 points he uska mtlb he ki 0 points ko kitne tarike se connect krskte he C0
// jese anticlockwise me 4 points he uska mtlb he ki 4 points ko kitne tarike se connect krskte he C2

import java.io.*;
import java.util.*;

public class Main {

    public static long NumberOfChords(int n){
    
        long[] dp = new long[n + 1];
    
        dp[0] = 1;
        dp[1] = 1;
    
        for(int i = 2; i < dp.length; i++){
          for(int j = 0; j < i; j++){
           dp[i] += dp[j] * dp[i - j - 1];
          }
        }
        return dp[n];
    }
  public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NumberOfChords(n));
	}
}      
