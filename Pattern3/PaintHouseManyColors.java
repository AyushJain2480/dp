// this is O(N3)
// 4 ghar or 6 colour he unko kis tarike se paint kare ki cost min aaye such that no two conseq houses are painted 
// with same color minm cost batani he 
// same he previous ques paint house with 3 colors ki tarah bas thodi implementation tricky he 
// pehli row me cost ki pehli row daldo because ek house he to ek hi row bnegi agar c1 se paint hoga to c1 ki cost lgegi
// c2 se hoga to c2 ki cost lgegi and so on last me minm calculate hona hi h vo return hojayga 
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        
        int[][] arr = new int[n][c];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        int[][] dp = new int[arr.length][arr[0].length];
        
        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = arr[0][j];
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < dp[0].length; k++){
                    if(k != j){
                        if(dp[i - 1][k] < min){
                            min = dp[i - 1][k];
                        }
                    }
                }
                dp[i][j] = arr[i][j] + min;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int k = 0; k < dp[0].length; k++){
            if(dp[n - 1][k] < min){
                min = dp[n - 1][k];
            }
        }
        System.out.println(min);
    }
}


// O(n2)
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        
        int[][] arr = new int[n][c];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        int[][] dp = new int[arr.length][arr[0].length];
        
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        
        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = arr[0][j];
            
            //  x 7(l) x  12(sL)  x  agar dp[0][j] sL se jyada aya to koi chng ni hoga agar sirf sL se kam hua to sL chng hoga 
            // or agar L se bhi chota hua to l and sl dono chng honge 
            if(dp[0][j] <= least){
                sleast = least;
                least = dp[0][j];
            }
            else if(dp[0][j] <= sleast){
                sleast = dp[0][j];
            }
        }
        
        for(int i = 1; i < dp.length; i++){
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for(int j = 0; j < dp[0].length; j++){
               if(least == dp[i - 1][j]){
                   dp[i][j] = arr[i][j] + sleast;
               }else{
                   dp[i][j] = arr[i][j] + least;
               }
               
               if(dp[i][j] <= nleast){
                nsleast = nleast;
                nleast = dp[i][j];
                }
                else if(dp[i][j] <= nsleast){
                    nsleast = dp[i][j];
                }
            }
            least = nleast;
            sleast = nsleast;
        }
        System.out.println(least); // akhri row ka least 
    }
}
