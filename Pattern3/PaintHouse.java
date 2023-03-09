// 4 ghar he to 4 rows 3 colour he to 3 colns 0 , 1 and 2
// dp array bnake bhi karskte he 
// har ghar par koi na koi colour lagana he magar lagatar do ghar par same colour nahi lga skte he 
// btana he ki kese colour lgay ki minm cost lage mtlb min cost return karni he 

// cost 
//     1 5 7 
//     5 8 4
//     3 2 9
//     1 2 4

//     1]  2  3  4
//  r  1]  ghar par red lgake kya min cost bna skte ho to 1 hi
//  g  5]  ghar par green lgake kya min cost bna skte ho to 5 hi 
//  b  7]  ghar par blue lgake kya min cost ban skte ho to 7 hi

//     1         2]                          3                4
//  r  1  (cost of red = 5) + min(5,7)     3 + min(9,5)    1 + min(7,18)             
//  g  5  (cost of green = 8) + min(1, 7)  2 + min(10,5)   2 + min(8,18)
//  b  7  (cost of blue = 4) + min(5,1)    9 + min(10,9)   4 + min(7,8)

// 1 2]
//  r   2nd ghar me red lgake kya min cost bana skte ho to purana red ni hona chahiye bache green and blue to unme se min lelo
// 1 2 3 4] 
//  b   4th ghar me blue lagake kya min cost bana skte ho to purana blue ni hona chahiye bache green or red to unme se min lelo
public class Main
{
	public static void main(String[] args) {
	    int[][] A = {
	        {1,5,7},
	        {5,8,4},
	        {3,2,9},
	        {1,2,4}
	    };
		System.out.println(solve(A));
	}
    public static int solve(int[][] A) {
        int n = A.length;
        int oldr = A[0][0];
        int oldb = A[0][1];
        int oldg = A[0][2];
        
        for(int i = 1; i < n; i++){
            int nr = A[i][0] + Math.min(oldb,oldg);
            int nb = A[i][1] + Math.min(oldr,oldg);
            int ng = A[i][2] + Math.min(oldr,oldb);
            
            oldr = nr;
            oldb = nb;
            oldg = ng;
        }
        return Math.min(Math.min(oldr,oldg),oldb);
    }
}
