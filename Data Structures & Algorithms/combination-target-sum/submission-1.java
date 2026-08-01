/*
dfs(nums, index, target, cur)

if (target == cur) solution found, add to result and return
if (target > cur)  not a solution, return
for all i >= index, 
    attempt to include nums[i] and run dfs(nums, i, target, cur + nums[i])
    then revert (backtrack and exclude nums[i] )

*/
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
        if (cur > target || index >= nums.length) {
            return;
        }
        if (cur == target) {
            result.add(new ArrayList<>(subset));
            return;
        }
        // include
        subset.add(nums[index]);
        dfs(nums, index, target, cur + nums[index]);
        // exclude
        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, target, cur);
    }
}
