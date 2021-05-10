public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        ListNode prev = null;
        cur = head;
        length -= n;
        if (length == 0) {
            return cur.next;
        }
        while (length > 0) {
            prev = cur;
            cur = cur.next;
            length--;
        }
        prev.next = cur.next;
        return head;
    }
}
