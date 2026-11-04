public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }

        int[] products = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            products[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            products[i] *= suffix;
            suffix *= nums[i];
        }
        return products;
    }
}
