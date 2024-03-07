/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    void solve(TreeNode root, int row, int col, Map<Integer, TreeMap<Integer, List<Integer>>> map, int[] minColumn) {
        if (root == null) return;

        solve(root.left, row + 1, col - 1, map, minColumn); //left
        solve(root.right, row + 1, col + 1, map, minColumn); // right

        TreeMap<Integer, List<Integer>> rowValues = map.getOrDefault(col, new TreeMap<>());
        List<Integer> values = rowValues.getOrDefault(row, new ArrayList<>());
        values.add(root.val);
        rowValues.put(row, values);
        map.put(col, rowValues);
        minColumn[0] = Math.min(minColumn[0], col);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // for storing the values based on column
        Map<Integer, TreeMap<Integer, List<Integer>>> map = new HashMap<>();
        int[] minColumn = new int[1];
        minColumn[0] = Integer.MAX_VALUE;
        solve(root, 0, 0, map, minColumn);

        List<List<Integer>> res = new ArrayList<>();
        int column = minColumn[0];
        while (map.containsKey(column)) {
            // data ordered by Row
            TreeMap<Integer, List<Integer>> rowValues = map.get(column);
            List<Integer> values = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry : rowValues.entrySet()) {
                List<Integer> ele = entry.getValue();
                Collections.sort(ele);
                values.addAll(ele);
            }
            res.add(values);
            column++;
        }

        return res;
    }
}
