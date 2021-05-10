import java.util.Deque;
import java.util.LinkedList;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode head2 = reverse(slow);
        ListNode head1 = head;
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        PalindromeLinkedList p = new PalindromeLinkedList();
//        p.isPalindrome(new ListNode(1, new ListNode(0, new ListNode(0))));
        p.isPalindrome(new ListNode(1));
    }
}
