/*
prereq = [a,b], must take prereq[1] before prereq[0]

Ideas
    for each course, check that its prereqs eventually end (prereqs are possible to fulfill)
*/
class Solution {
    HashMap<Integer, List<Integer>> preMap;
    HashSet<Integer> path;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // map course to prerequisite
        preMap = new HashMap<>();
        // path to check for cycle
        path = new HashSet<>();

        // add courses to map
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            preMap.get(prereq[1]).add(prereq[0]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return false;
            }
        }
        return true;
    }

    // if there is a cycle, not possible to fulfill prereqs, return false
    // if no more prereqs, return true
    // add course to path and check course prereqs, if they are not possible return false
    // if all course prereqs possible, course is possible, no need to check its prereqs (remove them)
    private boolean dfs(int course) {
        if (path.contains(course)) {
            return false;
        }
        if (preMap.get(course).isEmpty()) {
            return true;
        }

        path.add(course);
        for (int prereq : preMap.get(course)) {
            if (!dfs(prereq)) {
                return false;
            }
        }
        path.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }
}
