/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> isVisited = new HashMap<>();
        Node current = head;
        while(head != null){
            Node currNode = new Node(head.val);
            isVisited.put(head, currNode);
            head = head.next;
        }

        head = current;
        while(current != null){
            Node node = isVisited.get(current);
            node.next = isVisited.get(current.next);
            node.random = isVisited.get(current.random);
            current = current.next;
        }

        return isVisited.get(head);
    }
}
