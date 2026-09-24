package backtracking;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int start, int[] candidates, int remaining,
                           List<Integer> path,
                           List<List<Integer>> ans) {
        if (remaining == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) continue;

            path.add(candidates[i]);
            // Use i again because a candidate may be reused.
            backtrack(i, candidates, remaining - candidates[i], path, ans);
            path.remove(path.size() - 1);
        }
    }
}