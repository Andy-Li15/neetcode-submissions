class Solution {
    List<List<Integer>> result;
    List<Integer> include;
    List<Integer> exclude;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        include = new ArrayList<>();
        exclude = new ArrayList<>();
        for (int i : nums) exclude.add(i);
        getSubsets(nums);
        return result;
    }

    private void getSubsets(int[] nums) {
        if (include.size() == nums.length) {
            result.add(new ArrayList<>(include));
            return;
        }
        // choose 1 from exclude and add it to include, then undo
        for (int i = 0; i < exclude.size(); i++) {
            // include
            include.add(exclude.remove(0));
            getSubsets(nums);
            exclude.add(include.remove(include.size() - 1));
        }
    }
}
