import java.util.*;

class ProductExceptSelf {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int n = nums.length;

        int[] result = new int[n];

        int left = 1;

        for (int i = 0; i < n; i++) {
            result[i] = left;
            left = left * nums[i];
        }

        int right = 1;

        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }

        System.out.println(Arrays.toString(result));
    }
}