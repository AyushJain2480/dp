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
        
        int bsp = -arr[0];
        int ssp = 0;
        int csp = 0;
        
        // selling ke upar buy nhi karskte is bar buy sell cool ke bad buy krskte he bsc
        
        // b --> b <-- c
        // b --> s <-- s
        // s --> c <-- c 
        for(int i = 1; i < arr.length; i++){
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0; // bs kia hi ni kya hi cool down kre
            
            // ya to purana bsp uthalo ya naya cool k bad 
            nbsp = Math.max(csp - arr[i] , bsp);
            
            nssp = Math.max(arr[i] + bsp , ssp);
            
            ncsp = Math.max(ssp,csp);
            
            bsp = nbsp;
            ssp = nssp;
            csp = ncsp;
        }
        
        System.out.println(ssp);
        
    }

}
