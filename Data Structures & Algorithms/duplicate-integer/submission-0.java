class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> vals = new HashSet<>();
        for (int val : nums) {
            vals.add(val);
        }
        return vals.size() != nums.length;
    }
}