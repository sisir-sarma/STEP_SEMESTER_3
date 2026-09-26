class MaximumSubarray {
    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int current = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (current + nums[i] > nums[i])
                current = current + nums[i];
            else
                current = nums[i];

            if (current > max)
                max = current;
        }

        System.out.println("Maximum sum = " + max);
    }
}