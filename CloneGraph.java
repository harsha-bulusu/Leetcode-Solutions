class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) {
            return node;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        boolean[] vis = new boolean[101];
        Map<Integer, Node> map = new HashMap<>();
        while (!queue.isEmpty()) {
            Node visNode = queue.remove();
            if (vis[visNode.val]) continue;
            Node replicaNode = null;
            if (map.containsKey(visNode.val)) {
                replicaNode = map.get(visNode.val);
            } else {
                replicaNode = new Node(visNode.val);
                map.put(visNode.val, replicaNode);
            }
            vis[visNode.val] = true;
            List<Node> visNodeNeighbors = new ArrayList<>();
            for (Node adjNode : visNode.neighbors) {
                queue.add(adjNode);
                if (map.containsKey(adjNode.val)) {
                    visNodeNeighbors.add(map.get(adjNode.val));
                } else {
                    Node newNeighbor = new Node(adjNode.val);
                    visNodeNeighbors.add(newNeighbor);
                    map.put(adjNode.val, newNeighbor);
                }
            }
            replicaNode.neighbors = visNodeNeighbors;
        }

        return map.get(node.val);
        
    }
}
