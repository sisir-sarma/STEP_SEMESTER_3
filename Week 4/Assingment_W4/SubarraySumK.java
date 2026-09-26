import java.util.*;

class SubarraySumK {
    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            sum = sum + nums[i];

            int needed = sum - k;

            if (map.containsKey(needed)) {
                count = count + map.get(needed);
            }

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            }
            else {
                map.put(sum, 1);
            }
        }

        System.out.println("Count = " + count);
    }
}