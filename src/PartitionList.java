/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smaller = null;
        ListNode smaller_tail = null;
        ListNode bigger = null;
        ListNode bigger_tail = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                if (smaller == null) {
                    smaller = cur;
                    smaller_tail = smaller;
                } else {
                    smaller_tail.next = cur;
                    smaller_tail = smaller_tail.next;
                }
            } else {
                if (bigger == null) {
                    bigger = cur;
                    bigger_tail = bigger;
                } else {
                    bigger_tail.next = cur;
                    bigger_tail = bigger_tail.next;
                }
            }
            cur = cur.next;
        }
        if (bigger != null) {
            bigger_tail.next = null;
        }
        if (smaller != null) {
            smaller_tail.next = bigger;
            return smaller;
        }
        return bigger;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionList().partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3));
    }
}