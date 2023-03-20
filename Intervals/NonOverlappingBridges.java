// Really this question is asked in contest for Mtech IIT bombay cse contests

// Approach
// The solution to this problem is simple if you know the LIS concept. LIS plays an important factor in solving the building
// bridges problem. Try to understand the LIS to understand the explanation for building bridges.

// We know the coordinates will be given to us in the north and south directions. We also know that these coordinates will be present in any order 
// across the river on each side. You must understand that if you do not want the bridges to overlap, the coordinates must be in increasing order on each side of the river.

// This means we need to sort each side of the river in increasing order to avoid overlapping. But, we cannot individually
// sort the coordinates because they will be given to use in the form pair. 

// We can sort one side of the river concerning another and then apply the LIS on the non-sorted side. For example, if you 
// have sorted the north coordinates, you can calculate the LIS on the south coordinates.

// As we have mentioned avoiding overlapping the order must be increased. We have sorted the one coordinate, and then if we
// look for the LIS in the non-sorted coordinates, we will only find the pairs of coordinates which cannot be overlapped.

// The number of elements present in the LIS will be the maximum number of bridges we can from across the river,

import java.io.*;
import java.util.*;

// North pe sort karke south me LIS nikalne par milege jo vo non overlapping hi milege 
// agar north equal he to south ke basis pr sort karlo
// or LIS to ratlo bilkul pr smjke

public class Main {

    public static class Bridge implements Comparable<Bridge> {
        int n;
        int s;
        
        Bridge(int n, int s){
            this.n = n;
            this.s = s;
        }
        
        public int compareTo(Bridge o){
            if(this.n != o.n){
                return this.n - o.n;
            }else{
                return this.s - o.s;    
            }
        }
    }
    public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      int n = Integer.parseInt(sc.nextLine());
      
      Bridge[] bdgs = new Bridge[n];
      for(int i = 0; i < n; i++){
          String line = sc.nextLine();
          String[] parts = line.split(" ");
          int n = Integer.parseInt(parts[0]);
          int s = Integer.parseInt(parts[1]);
          bdgs[i] = new Bridge(n,s);
      }
      
      Arrays.sort(bdgs);
      
      int[] dp = new int[bdgs.length];
      Arrays.fill(dp , 1);

      int ans = 1 ;
      for(int i = 1; i < bdgs.length; i++){
        for(int j = 0; j < i; j++){
           if(bdgs[i].s >= bdgs[j].s){
               dp[i] = Math.max(dp[i] , dp[j] + 1);
           }
           ans = Math.max(ans , dp[i]);
        }
      }
      System.out.println(ans);
    }
}



// Java Program for maximizing the no. of bridges
// such that none of them cross each other

import java.util.*;

class CityPairs // Create user-defined class
{
	int north, south;
	CityPairs(int north, int south) // Constructor
	{
		this.north = north;
		this.south = south;
	}
}
// Use Comparator for manual sorting
class MyCmp implements Comparator<CityPairs>
{
	public int compare(CityPairs cp1, CityPairs cp2)
	{
		// If 2 cities have same north coordinates
		// then sort them in increasing order
		// according to south coordinates.
		if (cp1.north == cp2.north)
			return cp1.south - cp2.south;

		// Sort in increasing order of
		// north coordinates.
		return cp1.north - cp2.north;
	}
}
public class BuildingBridges {
	// function to find the max. number of bridges
	// that can be built
	public static int maxBridges(CityPairs[] pairs, int n)
	{
		int[] LIS = new int[n];
		// By default single city has LIS = 1.
		Arrays.fill(LIS, 1);

		Arrays.sort(pairs, new MyCmp()); // Sorting->
										// calling
		// our self made comparator

		// Logic for Longest increasing subsequence
		// applied on south coordinates.
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (pairs[i].south >= pairs[j].south)
					LIS[i] = Math.max(LIS[i], LIS[j] + 1);
			}
		}
		int max = LIS[0];
		for (int i = 1; i < n; i++) {
			max = Math.max(max, LIS[i]);
		}

		// Return the max number of bridges that can be
		// built.
		return max;
	}

	// Driver Program to test above
	public static void main(String[] args)
	{
		int n = 4;
		CityPairs[] pairs = new CityPairs[n];
		pairs[0] = new CityPairs(6, 2);
		pairs[1] = new CityPairs(4, 3);
		pairs[2] = new CityPairs(2, 6);
		pairs[3] = new CityPairs(1, 5);
		System.out.println("Maximum number of bridges = "
						+ maxBridges(pairs, n));
	}
}
