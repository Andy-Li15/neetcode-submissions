class Solution {
    List<List<Integer>> result;
    List<Integer> subset;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        subset = new ArrayList<>();
        dfs(nums, 0, target, 0);
        return result;
    }

    private void dfs(int[] nums, int index, int target, int cur) {
        if (cur == target) {
            result.add(new ArrayList<>(subset));
            return;
        }
        if (cur > target) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            // include
            subset.add(nums[i]);
            dfs(nums, i, target, cur + nums[i]);
            // exclude
            subset.remove(subset.size() - 1);
        }
    }
}
