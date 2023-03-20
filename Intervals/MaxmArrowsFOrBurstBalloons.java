// Why this not works 
// The reason why points[i][0] <= end does not work is that it assumes that the balloons are sorted by their end position, which is not necessarily the case.

// Consider the example you gave: [[1,2],[2,3],[3,4],[4,5]]. If we sort the balloons by their start position, we get: [[1,2],[2,3],[3,4],[4,5]]. 
// If we use the condition points[i][0] <= end, the code will assume that the first balloon is the one that needs to be shot first, and will shoot 
// an arrow at position 2. However, this arrow will only hit the first balloon, and will not hit the other balloons, because they are not overlapping
// with the first balloon. So we need to shoot additional arrows to hit the other balloons.

// On the other hand, if we use the condition points[i][0] > end, the code will correctly identify that the first arrow needs to be shot at position 2 
// (the end position of the first balloon), and will continue to shoot additional arrows as needed to hit the other balloons.

// In summary, the condition points[i][0] <= end assumes that the balloons are sorted by their end position, while points[i][0] > end works regardless of
// the sorting order, as long as the balloons are sorted by their start position.
    
    
class Solution {
    // The variable end is used to keep track of the rightmost position that has been covered by the arrow so far.
    public int findMinArrowShots(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int arrows = 1;

        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            // vhi arrow use kro overlapping horai to phodte jao usi se
            // agar @----*
            //           *-----#
            // is bar equal par bhi fut jayga to consider krlo overlap me pichle m ni tha yad rkhna 
            if (intervals[i][0] <= end) {
                if (intervals[i][1] < end) {
                    end = intervals[i][1];
                }
            }
            else {
                // agar overlapping nai horai to naya arrow nikalo so inc
                arrows++;
                end = intervals[i][1]; 
            }
        }
        return arrows;
    }
}


// this will work
// // This code should correctly handle the test case you mentioned and provide the expected output of 2. The logic of the code is to sort the balloons by their start position, and then iterate through the balloons, keeping track of the end position of the previous balloon. If the start position of the current balloon is greater than the end position of the previous balloon, we need to shoot a new arrow, and update the end position. Otherwise, we can continue using the same arrow and update the end position as the minimum of the previous and current end positions.

public int findMinArrowShots(int[][] points) {
    if (points.length == 0) {
        return 0;
    }
    Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
    int arrows = 1;
    int end = points[0][1];
    for (int i = 1; i < points.length; i++) {
        if (points[i][0] > end) {
            arrows++;
            end = points[i][1];
        } else {
            end = Math.min(end, points[i][1]);
        }
    }
    return arrows;
}
