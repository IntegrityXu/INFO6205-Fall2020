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
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode head = root;
        int n = 0;
        while ( head != null ) {
            n++;
            head = head.next;
        }
        head = root;
        int x = n / k;
        int y = n % k;
        ListNode[] result = new ListNode[k];
        int i = 0;
        while ( head != null ) {
            int x1 = 0;
            if ( y != 0 ) {
                x1 = x + 1;
                y --;
            }
            else x1 = x;
            result[i++] = head;
            while (x1 > 1) {
                head = head.next;
                x1 --;
            }
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
        }
        return result;
    }
}