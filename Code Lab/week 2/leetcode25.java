/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        int [] list = new int[k];
        ListNode root = head;
        while (head != null) {
            ListNode tmp = head;
            for (int i = 0; i < k; i ++) {
                if (head.next == null && i < k -1) {
                    return root;
                }
                list[i] = head.val;
                head = head.next;
                System.out.println(i);
            }
            for (int i = k - 1; i >= 0; i--) {
                tmp.val = list[i];
                tmp = tmp.next;
            }
        }
        return root;
    }
}