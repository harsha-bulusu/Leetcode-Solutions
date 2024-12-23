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

    private void swap(int i, int j, List<Integer> elements) {
        int temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    private int countSwapsRequired(List<Integer> elements) {
        // Sort the elements to know the right indexes
        List<Integer> sortedElements = new ArrayList<>(elements);
        Collections.sort(sortedElements);

        // Preprocessing elements to store their index values as reference Map{ele, index}
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < elements.size(); i++) {
            indexMap.put(elements.get(i), i);
        }


        int swaps = 0;
        for (int i = 0; i < elements.size(); i++) { // iterating over sorted indexes
            if(!elements.get(i).equals(sortedElements.get(i))) { // element is not in correct position
                swaps++;
                int j = indexMap.get(sortedElements.get(i));
                swap(i, j, elements);
                indexMap.put(elements.get(i), i);
                indexMap.put(elements.get(j), j);
            }
        }

        return swaps;
    }

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int cnt = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> elements = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.remove();
                elements.add(node.val);
                if (node.left != null) {
                queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            cnt += countSwapsRequired(elements);
        }

        return cnt;
    }
}
