/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> isVisited = new HashMap<>();
        return explore(node, isVisited);
    }

    public Node explore(Node node, Map<Node, Node> isVisited){
        if(isVisited.containsKey(node)) return isVisited.get(node);
        Node newNode = new Node(node.val);
        isVisited.put(node, newNode);
        for(Node neighbor : node.neighbors){
            newNode.neighbors.add(explore(neighbor, isVisited));
        }
        return newNode;
    }
}