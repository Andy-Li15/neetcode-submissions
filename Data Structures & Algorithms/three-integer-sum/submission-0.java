class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates
            int left = i + 1;
            int right = n - 1;
            
            int target = -1 * nums[i];
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < target) left++;
                else if (sum > target) right--;
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }
        return result;
    }
}
