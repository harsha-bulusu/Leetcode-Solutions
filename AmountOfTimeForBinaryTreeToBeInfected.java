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

class Pair {
    TreeNode node;
    TreeNode parent;

    public Pair(TreeNode node, TreeNode parent) {
        this.node = node;
        this.parent = parent;
    }
}

class Data {
    int node;
    int min;

    public Data(int node, int min) {
        this.node = node;
        this.min = min;
    }

    public String toString() {
        return "[" + this.node + ", " + this.min + "]";
    }
}

class Solution {

    Map<Integer, List<Integer>> convertTreeToGraph(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, null));
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            TreeNode currNode = pair.node;
            TreeNode parent = pair.parent;

            List<Integer> adjNodes = new ArrayList<>();
            if (parent != null) adjNodes.add(parent.val);

            if (currNode.left != null) {
                TreeNode leftNode = currNode.left;
                queue.add(new Pair(leftNode, currNode));
                adjNodes.add(leftNode.val);
            }
            if (currNode.right != null) {
                TreeNode rightNode = currNode.right;
                queue.add(new Pair(rightNode, currNode));
                adjNodes.add(rightNode.val);
            }
            
            adjList.put(currNode.val, adjNodes);
        }
        return adjList;
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = convertTreeToGraph(root);
        Set<Integer> set = new HashSet<>();
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(start, 0));

        int res = -1;
        while(!queue.isEmpty()) {
            Data data = queue.remove();
            int node = data.node;
            if (!set.add(node)) continue;
            int val = data.min;
            res = val;

            for (int adjNode : graph.get(node)) {
                queue.add(new Data(adjNode, val + 1));
            }

        }

        return res;
    }
}
