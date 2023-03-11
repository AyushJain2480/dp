import java.io.*;
import java.util.*;
// jitni marzi buy kro jitni marzi sell kro 
// BBSS not allowed BS BS allowed no overlapping 
// jitni bar lgatar upar jara he utni bar profit collect karo
// rate upar ja rhe to selling upar karo 
// jab tak dip chlra he buy sell niche sarka do 
// jab fir increment he sell fir upar bdao
// decrement me na buy krege na sell karege kyuki ghate me he n
// jab niche girta jayga to bd and sd bhi sath me giregi uska profit 0 hoga 
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        
        int bd = 0; // buying date 
        int sd = 0; // selling date 
        int profit = 0; // profit
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] >= arr[i - 1]){
                sd++;
            }
            else{
                profit += arr[sd] - arr[bd];
                sd = bd = i;
            }
        }
        // last me dip aaya hi ni to alg se collect kroge
        profit += arr[sd] - arr[bd];
        System.out.println(profit);
    }
}
/// wow we just need to calculate the profit for every node if there is an increment
class Solution {
    public int maxProfit(int[] arr) {
        int profit = 0;
        int n = arr.length;
        for(int i = 1; i < n; i++){
            if(arr[i] > arr[i - 1]){
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }
}
