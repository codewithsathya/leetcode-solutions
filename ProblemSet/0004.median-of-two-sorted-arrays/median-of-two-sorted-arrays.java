class Solution {
    public double findMedian(int[] nums) {
        int mid = (nums.length - 1) / 2;
        if(nums.length % 2 == 0) {
            return (double)(nums[mid] + nums[mid + 1]) / 2;
        }else {
            return (double)(nums[mid]);
        }
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if((nums1 == null && nums2 == null) || (nums1.length == 0 && nums2.length == 0)) {
            throw new IllegalArgumentException();
        }else if(nums1.length == 0) {
            return findMedian(nums2);
        }else if(nums2.length == 0){
            return findMedian(nums1);
        }
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int start = 0;
        int end = len1;
        while(start <= end) {
            int partition1 = (start + end) / 2;
            int partition2 = (len1 + len2 + 1) / 2 - partition1;
            
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == len1) ? Integer.MAX_VALUE : nums1[partition1];
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == len2) ? Integer.MAX_VALUE : nums2[partition2];
            
            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if((len1 + len2) % 2 == 1) {
                    return (double)Math.max(maxLeft1, maxLeft2);
                }else {
                    return (double)(Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
                }
            }else if(maxLeft1 > minRight2) {
                end = partition1 - 1;
            }else {
                start = partition1 + 1;
            }
        }
        
        throw new IllegalArgumentException();
    }
}