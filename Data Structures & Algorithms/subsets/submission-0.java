class Solution {
    
    List<List<Integer>> result;
    List<Integer> subset;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        subset = new ArrayList<>();
        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int i) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        // include
        subset.add(nums[i]);
        dfs(nums, i + 1);

        // exclude
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1);
    }
}
