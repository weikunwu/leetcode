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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        ListNode[] nodes = new ListNode[length];
        cur = head;
        for (int i = 0; i < length; i++) {
            nodes[i] = cur;
            cur = cur.next;
        }
        return sortedListToBSTHelper(nodes, 0, length);
    }

    private TreeNode sortedListToBSTHelper(ListNode[] nodes, int l, int r) {
        if (r - l == 1) {
            return new TreeNode(nodes[l].val);
        }
        if (r == l) {
            return null;
        }
        int mid = (r + l) / 2;
        TreeNode cur = new TreeNode(nodes[mid].val);
        cur.left = sortedListToBSTHelper(nodes, l, mid);
        cur.right = sortedListToBSTHelper(nodes, mid + 1, r);
        return cur;
    }
}