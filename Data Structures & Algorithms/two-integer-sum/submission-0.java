class Solution {
    public int[] twoSum(int[] nums, int target) {
        // maps val -> index of val
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int need = target - val;
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
            map.put(val, i);
        }
        return null;
    }
}
