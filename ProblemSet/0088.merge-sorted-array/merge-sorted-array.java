class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp1 = new int[m];
        for (int i = 0; i < m; i++) {
            temp1[i] = nums1[i];
        }
        int p1 = 0;
        int p2 = 0;
        int w = 0;
        while (p1 < m && p2 < n) {
            if (temp1[p1] < nums2[p2]) {
                nums1[w] = temp1[p1++];
            }else{
                nums1[w] = nums2[p2++];
            }
            w++;
        }
        while (p1 < m) {
            nums1[w++] = temp1[p1++];
        }
        while (p2 < n) {
            nums1[w++] = nums2[p2++];
        }
    }
}