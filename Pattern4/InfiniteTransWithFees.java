// Infinite transactions he par sell karne ke time fees bhi lgegi ab isme batana he ki maxm profit kese nikal skte ho 
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
            nbsp = Math.max(ssp - arr[i], bsp);
            nssp = Math.max(arr[i] + bsp - charge, ssp);
            bsp = nbsp;
            ssp = nssp;
        }
        System.out.println(ssp);
    }
}
