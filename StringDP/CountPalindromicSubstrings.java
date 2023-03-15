// agar n length string he to total substrings n(n + 1) / 2 milti he 
// brute force se complexity O(n2) * n means O(n3) milegi 
// n2 sari substring nikalne ki or vhi n pal dekhne ki 

// but better dp se krskte he with n2 space and n2 time 
import java.io.*;
import java.util.*;

// agar extremes true he to bich ka solve karne ki jarurat nahi he uska ans dekhlo agar true he(mtlb bich ka pal he) to overall bhi pal he agar bich ka false he(mtlb bich ka pal nhi he) to overall bhi nhi he

// agar extremes hi same nhi he to mtlb pal he hi ni 
public class Main {

    public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      String str = sc.nextLine();
      
        boolean[][] dp = new boolean[str.length()][str.length()];
      
        int count = 0;
        for(int g = 0; g < str.length(); g++){
            for(int i = 0,j = g; j < str.length(); i++,j++){
                // single char are always consider as a pal
                // 1st diagonal
                if(g == 0){
                    dp[i][j] = true;
                    count++;
                }
                // 2 length str is consider as a pal if both chars are same
                // 2nd diagonal
                else if(g == 1){
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = true;
                        count++;
                    }
                }
                // rest all the diagonals
                // if first and last char is same && the bottom substr is pal than overall str is consider as pal
                else if(str.charAt(i) == str.charAt(j)){
                    if(dp[i + 1][j - 1] == true){
                        dp[i][j] = true;
                        count++;
                    }
                }
            }  
        }
        System.out.println(count);
    }
}
