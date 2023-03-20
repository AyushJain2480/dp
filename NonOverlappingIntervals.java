// we try to remove the larger interval because larger interval might be overlapping with some other intervals
// sort by start 
// Take the first interval just take its end value and keep track of it beacause since this is the 1st interval
// there is nothing that comes before left
// Now we gonna iterate through the intervals that come after 1__2
// 1_________3
//      2____3
// 1____2    3____4

// First sorting which takes logn and than traversal of O(N) total = O(nlogn)
// 1______2 save its end value 2 so that we can compare with following interval

// 1______2 end
// 1____________3
// 1 of (13) is < end that means they are overlapping so we will neglect the big one i.e 13 so end kaha rhega 
// jaha tha 2 par hi mtlb is case me end update ni krna he jaha he vhi rehne do 


// 1______3 assume this is end
// 1___2 new end
// let say this is one case so here 1 is less than 3 that means they are overlapping so we will neglect 
// the bigger 13 in this case we will change the end to 2 becz 13 is removed.

// 1_____2 end is 2
//       2_____3 these are non overapping intervals we will change the end to 3 
// this is the else case 


class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort the intervals by their starting time
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        // Initialize the count of overlapping intervals to 0
        int count = 0;
        
        // Initialize the ending time of the first interval as the ending time of the first interval
        int end = intervals[0][1];
        
        // Loop through the remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval overlaps with the previous one
            if (intervals[i][0] < end) {
                // Increment the count of overlapping intervals
                count++;   
                // If the ending time of the current interval is earlier than the ending time of the previous interval
                if (intervals[i][1] < end) {
                    // Set the ending time of the current interval as the new ending time
                    end = intervals[i][1];
                }
            }
            else {
                // If the current interval does not overlap with the previous one, set its ending time as the new ending time
                end = intervals[i][1]; 
            }
        }
        // Return the count of overlapping intervals
        return count;
    }
}
