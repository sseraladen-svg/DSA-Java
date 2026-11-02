public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty");
        }

        int maximumEndingHere = nums[0];
        int minimumEndingHere = nums[0];
        int maximumProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            if (value < 0) {
                int previousMaximum = maximumEndingHere;
                maximumEndingHere = minimumEndingHere;
                minimumEndingHere = previousMaximum;
            }

            maximumEndingHere = Math.max(value, maximumEndingHere * value);
            minimumEndingHere = Math.min(value, minimumEndingHere * value);
            maximumProduct = Math.max(maximumProduct, maximumEndingHere);
        }

        return maximumProduct;
    }
}
