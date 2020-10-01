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
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        while (head == null) {
            int [] ans = new int[1];
            return ans;
        }
        ListNode root = head;
        while (head != null) {
            n ++;
            head = head.next;
        }
        int [] ans = new int[n];
        int index = 0;
        Arrays.fill(ans, 0);
        
        while (root.next != null) {
            head = root.next;
            while (head != null) {
                if (root.val < head.val) {
                    ans[index] = head.val;
                    break;
                }
                head = head.next;
            }
            root = root.next;
            index ++;
        }
        return ans;
    }
}