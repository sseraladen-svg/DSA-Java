public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty");
        }

        int currentMaximum = nums[0];
        int maximum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMaximum = Math.max(nums[i], currentMaximum + nums[i]);
            maximum = Math.max(maximum, currentMaximum);
        }
        return maximum;
    }
}
