Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 

Follow up: Squaring each element and sorting t

  Solution:
class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = j;

        int[] newL = new int[nums.length];

        while (i < j) {
            int iSquare = nums[i] * nums[i];
            int jSquare = nums[j] * nums[j];

            if (iSquare > jSquare) {
                newL[k--] = iSquare;
                i++;
            } else {
                newL[k--] = jSquare;
                j--;
            }
        }

        newL[0] = nums[i] * nums[i];
        return newL;
        
    }
}
