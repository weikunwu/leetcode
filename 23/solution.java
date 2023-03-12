// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

 

// Example 1:

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6
// Example 2:

// Input: lists = []
// Output: []
// Example 3:

// Input: lists = [[]]
// Output: []
 

// Constraints:

// k == lists.length
// 0 <= k <= 104
// 0 <= lists[i].length <= 500
// -104 <= lists[i][j] <= 104
// lists[i] is sorted in ascending order.
// The sum of lists[i].length will not exceed 104.

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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair<Integer, ListNode>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue().val-o2.getValue().val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(new Pair<>(i, lists[i]));
            }
        }

        ListNode head = new ListNode();
        ListNode cur = head;
        
        while (!pq.isEmpty()) {
            Pair<Integer, ListNode> pair = pq.poll();
            int i = pair.getKey();
            ListNode node = pair.getValue();

            if (lists[i].next != null) {
                lists[i] = lists[i].next;
                pq.add(new Pair<>(i, lists[i]));
            }

            cur.next = node;
            cur.next.next = null;
            cur = cur.next;
        }

        return head.next;
    }
}