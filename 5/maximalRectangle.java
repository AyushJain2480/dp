
//  heights = [2,1,5,6,2,3]
// Let me explain this idea in the most intuitive way: intuitively, suppose that the current position is i,
// find a height smaller than height[i] before i (nearest to i), and then find a height smaller than height[i]
// (nearest to i) after i, so that all heights sandwiched in the middle (excluding both ends) are higher than height [i], 
// so you can use height [i] * interval length (excluding both ends) to calculate the maximum rectangular area.Then the
// algorithm is easy to understand.
class Solution{
public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        // for each cell with value=1, we look upward (north), the number of continuous '1' is the height of cell
        int[] heights = new int[matrix[0].length];
        int maxArea=-1;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]=='0'){
                    heights[j] = 0;
                } else {
                    heights[j] ++;
                }
            }            
            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

 public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        int[] l = new int[N], r = new int[N];

        // Closest smaller values on left and right
        for (int i = 0; i < N; i++) {
            int prev = i - 1;
            while (prev >= 0 && heights[prev] >= heights[i]) {
                 prev = l[prev];
            } 
            l[i] = prev;
        }
        
        for (int i = N - 1; i >= 0; i--) {
            int next = i + 1;
            while (next < N && heights[next] >= heights[i]){
                next = r[next];
            }   
            r[i] = next;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (r[i] - l[i] - 1));
        }
        return maxArea;
    }
}
