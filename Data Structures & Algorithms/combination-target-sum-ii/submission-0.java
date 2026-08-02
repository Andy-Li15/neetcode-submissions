/*
Sort array
backtrack (include and exclude)
*/
class Solution {
    List<List<Integer>> result;
    List<Integer> subset;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        subset = new ArrayList<>();

        Arrays.sort(candidates);
        generateSubsets(candidates, target, 0, 0);
        return result;
    }

    private void generateSubsets(int[] candidates, int target, int current, 
                                 int index) {
        // check index and current
        if (current == target) {
            result.add(new ArrayList<>(subset));
            return;
        }
        if (index >= candidates.length) {
            return;
        }
        int val = candidates[index];
        if (current + val > target) {
            return;
        }

        // include
        subset.add(val);
        generateSubsets(candidates, target, current + val, index + 1);

        // exclude
        subset.remove(subset.size() - 1);
        while (index + 1 < candidates.length && candidates[index + 1] == candidates[index]) {
            index++; // skip duplicates
        }
        generateSubsets(candidates, target, current, index + 1);
    }
}
