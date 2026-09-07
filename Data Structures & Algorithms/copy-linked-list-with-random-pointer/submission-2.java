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
        Node next = null;
        Node start = null;
        Node current = null;
        Node random =null;

        while(head != null){
            if(!isVisited.containsKey(head)) {
                isVisited.put(head, new Node(head.val));
            }
            current = isVisited.get(head);
            if(next == null) start = current; 
            if(next != null) next.next = current;
            next = current;
            if(head.random != null){
                if(!isVisited.containsKey(head.random)){
                    isVisited.put(head.random, new Node(head.random.val));
                }
                random = isVisited.get(head.random);
            }else{
                random = null;
            }
            current.random = random;
            head = head.next;
        }
        return start;
    }
}
