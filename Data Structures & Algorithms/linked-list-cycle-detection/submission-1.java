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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        ListNode cur = head;

        while(cur != null) {
            if(!set.contains(cur)) {
                set.add(cur);
            }else {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }
}
