// similar to non overlapping bridges
// n - no of envelopes
// n pair of nos representing the width and height of each envelope
// print the count of maxm no. of envelopes that can be nested inside each other.

// bridge wale me 
// jab north north se chota tha to south south se chota hona chahiye tabhi  non overlapping hoga 
// yha width width se chota he to height height se choti honi chahiye tbhi envelopes nest hoskte he ek dusre 
// ke undar 

// bas ek hi difference he dono question me 
// bridge wale question me agar north north barabar ho or south bank alg ho to unko hum non overlapping
// samjhte he ye yha par nhi hoga 
// width bhi absolutely smaller honi chahiye or height bhi (no equal wla case)

// width par sort krege 
// height par LIS lgayge

// - - - - - - - - width bhi bdegi kyuki sort krdia
// -------------- height bhi bdegi kyki longest inc subseq 
// isse maxm no of envelopes which can be nested mil jayge

// jese north bhi chota ho south bhi chota ho 
// mtlb agar esa question ho ki 1st parameter bhi chota ho second parameter bhi to 
// phla wala sort krdo dusre me lis lga do 

import java.io.*;
import java.util.*;

public class Main {

    public static class Envelope implements Comparable<Envelope>{
        int w;
        int h;
        public Envelope(int w, int h){
            this.w = w;
            this.h = h;
        }
        
        public int compareTo(Envelope o){
           this.w - o.w 
        }
    }
    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       
       Envelope[] envlps = new Envelope[n];
       for(int i = 0; i < n; i++){
           String line = sc.nextLine();
           String[] parts = line.split(" ");
           int width = Integer.parseInt(parts[0]);
           int height = Integer.parseInt(parts[1]);
           envlps[i] = new Envelope(width,height);
       }
       
       // sorted on the basis of width par equal bhi hoskti he or vo chahiye nhi stricly kam honi chahiye 
       Arrays.sort(envlps);
       int[] dp = new int[n];
       int ovmax = 0;
       for(int i = 0; i < dp.length; i++){
           int max = 0;
           for(int j = 0; j < i; j++){
               if(envlps[j].h < envlps[i].h && envlps[j].w < envlps[j].w){
                   if(dp[j] > max){
                       max = dp[j];
                   }
               }
           }
           dp[i] = max + 1;
           if(dp[i] > ovmax){
               ovmax = dp[i];
           }
       }
       System.out.println(ovmax);
    }

}
