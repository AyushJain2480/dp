// Infinite transactions he par sell karne ke time fees bhi lgegi ab isme batana he ki maxm profit kese nikal skte ho 



// (1) buy status:
// buy[i] represents the max profit at day i in buy status, given that the last action you took is a buy action at day K, where K<=i. And you have the right to sell at day i+1, or do nothing.
// (2) sell status:
// sell[i] represents the max profit at day i in sell status, given that the last action you took is a sell action at day K, where K<=i. And you have the right to buy at day i+1, or do nothing.

// Let's walk through from base case.

// Base case:
// We can start from buy status, which means we buy stock at day 0.
// buy[0]=-prices[0];
// Or we can start from sell status, which means we sell stock at day 0.
// Given that we don't have any stock at hand in day 0, we set sell status to be 0.
// sell[0]=0;

// Status transformation:
// At day i, we may buy stock (from previous sell status) or do nothing (from previous buy status):
// buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
// Or
// At day i, we may sell stock (from previous buy status) or keep holding (from previous sell status):
// sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);

// Finally:
// We will return sell[last_day] as our result, which represents the max profit at the last day, given that you took sell action at any day before the last day.
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
    
        int charge = sc.nextInt();
        
        int bsp = -arr[0]; // pehla buy kroge to -ve loan chdega hi with 0 rupees in your bank
        int ssp = 0; // you are not selling it initially
        for(int i = 1; i < arr.length; i++){
            int nbsp = 0;
            int nssp = 0;
            nbsp = Math.max(ssp - arr[i], bsp); // // keep the same as day i-1, or buy from sell status at day i-1
            nssp = Math.max(arr[i] + bsp - charge, ssp);// // keep the same as day i-1, or sell from buy status at day i-1
            bsp = nbsp;
            ssp = nssp;
        }
        System.out.println(ssp);
    }
}
