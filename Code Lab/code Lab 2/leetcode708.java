/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if ( head == null) {
            Node tmp = new Node(insertVal);
            tmp.next = tmp;
            return tmp;
        }
        Node tmp = head;
        while ( true ) {
            if ( (tmp.val <= insertVal && tmp.next.val > insertVal)  || 
                 (insertVal >= tmp.val && tmp.val > tmp.next.val) || 
                 (insertVal <= tmp.next.val && tmp.val > tmp.next.val) ) {
                Node insertNode = new Node(insertVal);
                insertNode.next = tmp.next;
                tmp.next  = insertNode;
                return head;
            }
            tmp = tmp.next;
            if (tmp.equals(head)) {
                Node insertNode = new Node(insertVal);
                insertNode.next = head.next;
                head.next = insertNode;
                return head;
            }
            
        }
        //return  head;
    }
}