import java.io.*;
import java.util.*;

public class Main {
  
  // can solve it in O(n2) by calculating the sum of each subarray with 2 loops 
  // Har element decision ispe karta he ki piche se jo train ari he vo +ve ari he to chdlo or -ve ari he to apni start krdo
  // for explanation check notes but above line is enough to understand kadane's algorithm
  public static int solution(int[] arr) {
       int curs = arr[0];
       int osum = arr[0];
       
       // arr[i] decide krta he ki pichli train me chadu ya na chadu
       for(int i = 1; i < arr.length; i++){
           if(curs >= 0){
               curs += arr[i]; // chadlo piche me 
           }else{
               curs = arr[i]; // apni start krdo
           }
           if(curs > osum){
               osum = curs;
           }
       }
       return osum;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }
}
