class Solution {
    List<List<Integer>> result;
    List<Integer> subset;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        subset = new ArrayList<>();
        Arrays.sort(nums);
        getSubsets(nums, 0);
        return result;
    }

    private void getSubsets(int[] nums, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        // include
        subset.add(nums[i]);
        getSubsets(nums, i + 1);
        // exclude and skip duplicates
        subset.remove(subset.size() - 1);
        while (((i + 1) < nums.length) && (nums[i + 1] == nums[i])) {
            i++;
        }
        getSubsets(nums, i + 1);
    }
}
