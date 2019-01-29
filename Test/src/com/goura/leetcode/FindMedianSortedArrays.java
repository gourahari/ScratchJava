package com.goura.leetcode;

/**
 * 4. Median of Two Sorted Arrays
 *
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 * 
 * @author Gourahari Das
 *
 */
public class FindMedianSortedArrays {

	public static void main(String[] args) {
		assert findMedianSortedArrays(new int[] {1, 80, 90, 100}, new int[] {2, 3}) == 41.5 : "Fail";
		assert findMedianSortedArrays(new int[] {1, 3}, new int[] {2}) == 2.0 : "Fail";
		assert findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}) == 2.5 : "Fail";
		assert findMedianSortedArrays(new int[] {1, 3, 5, 100}, new int[] {2, 3, 4, 5, 6}) == 4 : "Fail";
		assert findMedianSortedArrays(new int[] {1, 3, 5, 12, 100}, new int[] {1, 2, 3, 4, 5}) == 3.5 : "Fail";
		assert findMedianSortedArrays(new int[] {1, 3, 5, 12, 100}, new int[] {1, 2, 3, 4, 5, 6}) == 4 : "Fail";
	}

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	double index = (nums1.length + nums2.length)/2.0;

    	int m = 0, n = 0;
    	double value = 0, returnVal = 0;
    	
    	for (int i = 0; i <= index; i++) {
    		if (m >= nums1.length) {
    			value = nums2[n++];
    		} else if (n >= nums2.length) {
    			value = nums1[m++];
    		} else if (nums1[m] < nums2[n]) {
    			value = nums1[m++];
    		} else {
    			value = nums2[n++];
    		}
    		if (index - i > 0) {
    			returnVal = value;
    		} else if (index - i == 0) {
    			returnVal = (returnVal + value)/2.0;
    		}
		}

        return returnVal;
    }
}
